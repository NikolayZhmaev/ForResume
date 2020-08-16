package net.thumbtack.school.sunday.threads;

// 2. Создать новый поток и дождаться его окончания в первичном потоке.

class ChildThread implements Runnable {

    public ChildThread() {

        System.out.println("Child thread start");
    }

    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread");

    }
}

public class MainThread {

    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        Thread thread = new Thread(childThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }




}
