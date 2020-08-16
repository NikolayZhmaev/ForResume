package net.thumbtack.school.sunday.threads;

import java.util.concurrent.Semaphore;

// 8. Система читатель-писатель.

class Book {
    private int n;

    static Semaphore semReader = new Semaphore(0);
    static Semaphore semWriter = new Semaphore(1);

    public void get() {
        try {
            semReader.acquire();
            System.out.println("The reader took the book: " + n);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semWriter.release();
        }
    }

    public void put(int n) {
        try {
            semWriter.acquire();
            this.n = n;
            System.out.println("The writer put down the book: " + n);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semReader.release();
        }
    }
}

class Reader extends Thread {
    private Book q;

    public Reader(Book q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 20; i++)
            q.put(i);
    }
}

class Writer extends Thread {
    private Book q;

    public Writer(Book q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 20; i++)
            q.get();
    }
}

public class WriterReader {
    public static void main(String[] args) {
        Book book = new Book();
        new Writer(book).start();
        new Reader(book).start();
    }
}
