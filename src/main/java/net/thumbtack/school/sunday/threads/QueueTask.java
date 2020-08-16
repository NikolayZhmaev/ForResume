package net.thumbtack.school.sunday.threads;

/* 16. Реализовать очередь задач. Задача - экземпляр класса Task или его наследника, имплементирующего Executable - свой
       интерфейс с единственным методом void execute(). Потоки - разработчики ставят в очередь экземпляры Task, потоки -
       исполнители берут их из очереди и исполняют. Количество тех и других потоков может быть любым и определяется
       в main.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

interface Executable {
    void execute();
}

class Task implements Executable  {
    @Override
    public void execute() {
        System.out.println("Class Task completed the job");
    }

    public boolean get () {
        return true;
    }
}

class Developer implements Runnable {
    private BlockingQueue<Task> queue;
    private int count;


    public Developer(BlockingQueue<Task> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public void run() {
        System.out.println("Developer Started");
        try {
            for (int i = 0; i < count; i++) {
                queue.put(new Task());
                System.out.println("Developer added Task. Totally elements in queue = " + queue.size());
                Thread.sleep(300);
            }
            System.out.println("Developer finished");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Executor implements Runnable {

    private BlockingQueue<Task> queue;

    public Executor(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("Executor Started");

        while (true) {
            try {
                Task task = queue.take();
                if (!task.get()) {
                    queue.put(task);
                    System.out.println("Executor finished");
                    break;
                }
                task.execute();
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

public class QueueTask {

    public static void main(String[] args) {

        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();
        int count = 6;
        int numDeveloper = 4;
        int numExecutor = 3;

        List<Thread> threadsDeveloper = new ArrayList<>();
        List<Thread> threadsExecutor = new ArrayList<>();

        for (int i = 0; i < numDeveloper; i++) {
            Thread thread = new Thread(new Developer(queue, count));
            thread.start();
            threadsDeveloper.add(thread);
        }

        for (int i = 0; i < numExecutor; i++) {
            Thread thread = new Thread(new Executor(queue));
            thread.start();
            threadsExecutor.add(thread);
        }

        for (Thread thread : threadsDeveloper) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread threadBane = new Thread(new Developer(queue, 0) {
            @Override
            public void run() {
                try {
                    queue.put(new Task() {
                        @Override
                        public boolean get() {
                            return false;
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

        for (Thread thread : threadsExecutor) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The programme was successfully completed");
    }
}