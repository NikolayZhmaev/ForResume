package net.thumbtack.school.sunday.threads;

/* 15. Реализовать очередь данных. Данные - экземпляр класса  Data с единственным методом int[] get(). Потоки-писатели
       ставят в очередь экземпляры Data, потоки - читатели берут их из очереди и распечатывают. Количество тех и других
       потоков может быть любым и определяется в main.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Data {
    int[] data = {1, 2, 3, 4, 5};

    public int[] get() {
        return data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}

class Producer implements Runnable {
    private BlockingQueue<Data> queue;
    private int count;


    public Producer(BlockingQueue<Data> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public void run() {
        System.out.println("Producer Started");
        try {
            for (int i = 0; i < count; i++) {
                queue.put(new Data());
                System.out.println("Producer added Data. Totally elements in queue = " + queue.size());
                Thread.sleep(100);
            }
            System.out.println("Producer finished");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Data> queue;

    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("Consumer Started");

        while (true) {
            try {
                Data data = queue.take();
                if (data.get() == null) {
                    queue.put(data);
                    System.out.println("Consumer finished");
                    break;
                }
                System.out.println("Consumer retrieved: " + data.toString());
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

public class QueueData {

    public static void main(String[] args) {

        BlockingQueue<Data> queue = new LinkedBlockingQueue<>();
        int count = 10;
        int numProducer = 20;
        int numConsumer = 10;

        List<Thread> threadsProducer = new ArrayList<>();
        List<Thread> threadsConsumer = new ArrayList<>();


        for (int i = 0; i < numProducer; i++) {
            Thread thread = new Thread(new Producer(queue, count));
            thread.start();
            threadsProducer.add(thread);
        }

        for (int i = 0; i < numConsumer; i++) {
            Thread thread = new Thread(new Consumer(queue));
            thread.start();
            threadsConsumer.add(thread);
        }

        for (Thread thread : threadsProducer) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread threadBane = new Thread(new Producer(queue, 0) {
            @Override
            public void run() {
                try {
                    queue.put(new Data() {
                        @Override
                        public int[] get() {
                            return null;
                        }
                    });
                    System.out.println("bane");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadBane.start();

        try {
            threadBane.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Thread thread : threadsConsumer) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The programme was successfully completed");
    }
}