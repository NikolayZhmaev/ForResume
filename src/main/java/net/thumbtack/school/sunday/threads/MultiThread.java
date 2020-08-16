package net.thumbtack.school.sunday.threads;

/*
   3. Создать 3 новых потока и дождаться окончания их всех в первичном потоке. Для каждого потока создать свой
      собственный экземпляр класса.
*/

class MyThread extends Thread {
    private String nameTread;

    public MyThread(String nameTread) {
        this.nameTread = nameTread;
    }

    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(nameTread + ": " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(nameTread + "Interrupted");
        }
        System.out.println("Exiting" + nameTread + " thread.");
    }
}

public class MultiThread {

    public static void main(String[] args) {

        MyThread oneThread = new MyThread("One thread");
        MyThread twoThread = new MyThread("Two thread");
        MyThread threeThread = new MyThread("Three thread");

        oneThread.start();
        twoThread.start();
        threeThread.start();

        try {
            oneThread.join();
            twoThread.join();
            threeThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
