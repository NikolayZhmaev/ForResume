package net.thumbtack.school.sunday.threads;

// 10. Переписать упражнение 4, используя ReentrantLock

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;


class AddAndRemoveListLock extends Thread {

    private WorkWithList workWithList;
    private Method method;
    private Lock lock;

    public AddAndRemoveListLock(Lock lock, WorkWithList workWithList, Method method) {
        this.lock = lock;
        this.workWithList = workWithList;
        this.method = method;
    }

    public void run() {
        int element;
        switch (method) {
            case ADD:
                for (int i = 0; i < 10000; i++) {
                    element = (int) (Math.random() * 10001);
                    try {
                        lock.lock();
                        workWithList.addElement(element);
                    } finally {
                        lock.unlock();
                    }
                }
            case REMOVE:
                for (int i = 0; i < 10000; i++) {
                    int size = workWithList.getList().size();
                    int index = (int) (Math.random() * (size - 1));
                    try {
                        lock.lock();
                        workWithList.removeElement(index);
                    } catch (IndexOutOfBoundsException e) {
                        interrupt();
                    } finally {
                        lock.unlock();
                    }
                }

        }
    }
}

public class AddAndGetIntegerReentrantLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        List<Integer> list = new ArrayList<>();
        WorkWithList workWithList = new WorkWithList(list);

        new AddAndRemoveListLock(lock, workWithList, Method.ADD).start();
        new AddAndRemoveListLock(lock, workWithList, Method.REMOVE).start();
    }
}

