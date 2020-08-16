package net.thumbtack.school.sunday.threads;

/* 17. Реализовать очередь многостадийных  задач. Многостадийная задача - экземпляр класса Task, имеющего список из
       стадий - List<Executable>, где Executable - интерфейс из задания 16. Потоки - разработчики ставят в очередь
       экземпляры Task, потоки - исполнители берут из очереди задачу, исполняют очередную ее стадию, после чего, если
       это не последняя стадия, ставят задачу обратно в очередь. Количество тех и других потоков может быть любым и
       определяется в main.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Tasks {
    private List<Executable> stages = new ArrayList<>();

    public Tasks() {
    }

    public Tasks(List<Executable> stages) {
        this.stages = Collections.synchronizedList(stages);
    }

    boolean get() {
        return true;
    }

    List<Executable> getStages() {
        return stages;
    }

    synchronized Executable doneTask() {
        return stages.remove(0);
    }

    synchronized void setTasks(List<Executable> tasks) {
        this.stages = tasks;
    }
}

class DeveloperTasks implements Runnable {
    private BlockingQueue<Tasks> queue;
    private List<Executable> stages = new ArrayList<>();
    protected List<Tasks> tasks = new ArrayList<>();
    private int numTasks;

    public DeveloperTasks(BlockingQueue<Tasks> queue, int numThread, int numTasks) {
        this.queue = queue;
        this.numTasks = numTasks;
        for (int i = 0; i < numTasks; i++) {
            stages.add(new Task());
        }
        for (int i = 0; i < numThread; i++) {
            tasks.add(new Tasks(stages));
        }
    }

    @Override
    public void run() {
        System.out.println("Developer Started");
        try {
            for (Tasks task : tasks) {
                queue.put(task);
                System.out.println("Developer added Tasks. With " + (task.getStages().size()) + " stages.");
            }
            System.out.println("Developer finished");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class ExecutorTasks implements Runnable {

    private int maxTasks;
    private BlockingQueue<Tasks> queue;
    private AtomicInteger counter;

    public ExecutorTasks(BlockingQueue<Tasks> queue, AtomicInteger counter, int maxTasks) {
        this.queue = queue;
        this.maxTasks = maxTasks;
        this.counter = counter;
    }

    public void run() {
        System.out.println("Executor Started");
        while (true) {
            try {
                Tasks task = queue.take();
                if (!task.get()) {
                    queue.put(task);
                    System.out.println("Executor finished");
                    break;
                }
                if (task.getStages().size() > 1) {
                    task.doneTask().execute();
                    queue.put(task);
                    counter.incrementAndGet();

                    System.out.println("returned an item to the queue: " + task.getStages().size() + ". counter: " + counter.get());
                } else if (task.getStages().size() == 1) {
                    task.doneTask().execute();
                    counter.incrementAndGet();
                    System.out.println("counter: " + counter.get());

                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

public class QueueMultitasking {

    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger();

        BlockingQueue<Tasks> queue = new LinkedBlockingQueue<>();
        int numTasks = 2;
        int numThread = 1; // ВОТ ТУТ ПРОБЛЕМА!!!!! ПОКА 1 ВСЕ ОТЛИЧНО, СТОИТ ИЗМЕНИТЬ И ВСЕ ЛОМАЕТСЯ
        int numDeveloper = 20;
        int numExecutor = 10;
        int maxTasks = numDeveloper * numThread * numTasks;

        List<Thread> threadsDeveloper = new ArrayList<>();
        List<Thread> threadsExecutor = new ArrayList<>();


        for (int i = 0; i < numDeveloper; i++) {
            Thread thread = new Thread(new DeveloperTasks(queue, numThread, numTasks));
            thread.start();
            threadsDeveloper.add(thread);
        }

        for (int i = 0; i < numExecutor; i++) {
            Thread thread = new Thread(new ExecutorTasks(queue, counter, maxTasks));
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


        Thread threadBane = new Thread(new DeveloperTasks(queue, 0, 0) {
            @Override
            public void run() {
                try {
                    queue.put(new Tasks() {
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


        for(Thread thread:threadsExecutor){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        System.out.println("The programme was successfully completed");
}
}
