package net.thumbtack.school.sunday.threads;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* 12. Написать свой класс, аналогичный ConcurrentHashMap , используя  ReadWriteLock. Будет ли эта реализация хуже
       ConcurrentHashMap, и если да, то почему?
*/

class MyConcurrentHashMap {
    private Map <String, String> map = new HashMap();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MyConcurrentHashMap() {
    }

    public String get (String key){
        readWriteLock.readLock().lock();
        try {
           return map.get(key);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public String put(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            return map.put(key, value);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public boolean isEmpty() {
        readWriteLock.readLock().lock();
        try {
            return map.isEmpty();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public Collection<String> values() {
        readWriteLock.readLock().lock();
        try {
            return map.values();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}

public class MyMap {

    public static void main(String[] args) {
        MyConcurrentHashMap myMap = new MyConcurrentHashMap();

        Runnable writer1 = () -> {
            System.out.println("Writer id: " + Thread.currentThread().getId() + ", previous value: " + myMap.put("1", "A"));
        };
        Runnable writer2 = () -> {
            System.out.println("Writer id: " + Thread.currentThread().getId() + ", previous value: " + myMap.put("2", "B"));
        };
        Runnable writer3 = () -> {
            System.out.println("Writer id: " + Thread.currentThread().getId() + ", previous value: " + myMap.put("1", "C"));
        };
        Runnable reader1 = () -> {
            System.out.println("Reader id: " + Thread.currentThread().getId() + ", get the value: " + myMap.get("1"));
        };
        Runnable reader2 = () -> {
            System.out.println("Reader id: " + Thread.currentThread().getId() + ", get the value: " + myMap.get("2"));
        };
        Runnable reader3 = () -> {
            System.out.println("Reader id: " + Thread.currentThread().getId() + ", get the value: " + myMap.get("3"));
        };
        Runnable reader4 = () -> {
            System.out.println("Reader id: " + Thread.currentThread().getId() + ", get isEmpty: " + myMap.isEmpty());
        };

        Runnable reader5 = () -> {
            System.out.println("Reader id: " + Thread.currentThread().getId() + ", get Collection: " + myMap.values());
        };

        new Thread(writer1).start();
        new Thread(writer2).start();
        new Thread(writer3).start();
        new Thread(reader1).start();
        new Thread(reader2).start();
        new Thread(reader3).start();
        new Thread(reader4).start();
        new Thread(reader5).start();
    }
}
