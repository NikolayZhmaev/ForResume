package net.thumbtack.school.sunday.threads;
/* 7. “Ping Pong”, задача заключается в том чтобы бесконечно выводить на консоль сообщения “ping” или “pong” из двух
       разных потоков. При этом сообщения обязаны чередоваться, т.е. не может быть ситуации когда ping или pong появляется
       в консоли более одного раза подряд. Первым должно быть сообщение “ping”.
*/

import java.util.concurrent.Semaphore;

class Print {

    //  private boolean valueSet = false;
    static Semaphore semPing = new Semaphore(1);
    static Semaphore semPong = new Semaphore(0);

    public Print() {
    }

    public void printPing() {
        try {
            semPing.acquire();
            Thread.sleep(500);
            System.out.println("PING");

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semPong.release();
        }
    }

    public void printPong() {
        try {
            semPong.acquire();
            Thread.sleep(500);
            System.out.println("PONG");

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semPing.release();
        }
    }
}

class PrintPingThread extends Thread {

    private Print print;

    public PrintPingThread(Print print) {
        this.print = print;
    }



    public void run() {
        while (true)
            print.printPing();
    }
}

class PrintPongThread extends Thread {

    private Print print;

    public PrintPongThread(Print print) {
        this.print = print;
    }

    public void run() {
        while (true)
            print.printPong();
    }
}


public class PingPong {

    public static void main(String args[]) {
        System.out.println("Press Control-C to stop.");

        Print print = new Print();
        new PrintPingThread(print).start();
        new PrintPongThread(print).start();
    }
}
