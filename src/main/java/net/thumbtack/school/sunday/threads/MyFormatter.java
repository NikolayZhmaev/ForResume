package net.thumbtack.school.sunday.threads;

/* 13. Написать класс Formatter, с методом format(Date date), форматирующим дату-время. Для форматирования возьмите
       класс SimpleDateFormat. В основном потоке создать единственный экземпляр класса Formatter и 5 потоков, каждому
       потоку передается при инициализации этот экземпляр. Потоки должны корректно форматировать дату-время,
       синхронизация не разрешается. Использовать ThreadLocal.
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Formatter {
    private static final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    private static DateFormat getFormat() {
        DateFormat format = threadLocal.get();
        if (format == null) {
            format = new SimpleDateFormat("y-M-d H:m:s.S");
            threadLocal.set(format);
        }
        return format;
    }

    public void setFormat(String pattern) {
        threadLocal.set(new SimpleDateFormat(pattern));
    }

    public String formate(Date date) {
        return getFormat().format(date);
    }
}

public class MyFormatter {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();//

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread id: " + Thread.currentThread().getId() + " date: " + formatter.formate(new Date()));
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                formatter.setFormat("d-M-y H:m:s.S");
                System.out.println("Thread id: " + Thread.currentThread().getId() + " date: " + formatter.formate(new Date()));
            }
        };

        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);
        Thread thread3 = new Thread(run2);
        Thread thread4 = new Thread(run2);
        Thread thread5 = new Thread(run);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread id: " + Thread.currentThread().getId() + " date: " + formatter.formate(new Date()));
    }
}