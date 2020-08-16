package net.thumbtack.school.sunday.threads;

// 11. “Ping Pong” на базе ReentrantLock и Conditional переменной.

import java.util.concurrent.locks.*;

class PrintPingPong {

    private Lock lock = new ReentrantLock();
    private Condition ping = lock.newCondition();
    private Condition pong = lock.newCondition();


    public void printPing() throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(500);
            System.out.println("PING");
            pong.signal();
            ping.await();
        } finally {
            lock.unlock();
        }
    }

    public void printPong() throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(500);
            System.out.println("PONG");
            ping.signal();
            pong.await();
        } finally {
            lock.unlock();
        }
    }
}

class PrintPingReentThread extends Thread {

    private PrintPingPong print;

    public PrintPingReentThread(PrintPingPong print) {
        this.print = print;
    }

    public void run() {
        while (true) {
            try {
                print.printPing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintPongReentThread extends Thread {

    private PrintPingPong print;

    public PrintPongReentThread(PrintPingPong print) {
        this.print = print;
    }

    public void run() {
        while (true) {
            try {
                print.printPong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PingPongReentrantLock {
    public static void main(String args[]) {
        System.out.println("Press Control-C to stop.");

        PrintPingPong print = new PrintPingPong();

        new PrintPingReentThread(print).start();
        new PrintPongReentThread(print).start();
    }
}
