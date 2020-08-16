package net.thumbtack.school.sunday.threads;

/* 6. Можно ли корректно решить задачу 4, используя Collections.synchronizedList и не используя synchronized явно?
      Если да - напишите программу.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WorkWithListSynchronized {
   private List <Integer> listSynch;

    public WorkWithListSynchronized(List<Integer> list) {
        this.listSynch = Collections.synchronizedList(list);
    }

    public List<Integer> getListSynch() {
        return listSynch;
    }
}

class AddAndRemoveListNew extends Thread {

    private WorkWithListSynchronized workWithList;
    private Method method;

    public AddAndRemoveListNew(WorkWithListSynchronized workWithList, Method method) {
        this.workWithList = workWithList;
        this.method = method;
    }

    public void run() {
        int element;
        switch (method) {
            case ADD:
                for (int i = 0; i < 10000; i++) {
                    element = (int) (Math.random() * 10001);
                    workWithList.getListSynch().add(element);
                    System.out.println("element add:" + element);
                }
            case REMOVE:
                for (int i = 0; i < 10000; i++) {
                    int size = workWithList.getListSynch().size();
                    int index = (int) (Math.random() * (size - 1));
                    try {
                        System.out.println("element remove " + workWithList.getListSynch().get(index));
                        workWithList.getListSynch().remove(index);
                    } catch (IndexOutOfBoundsException e) {
                        interrupt();
                    }
                }
        }
    }
}

public class AddAndGetIntegerSynchronizedList {

    public static void main(String[] args) {

        List <Integer> list = new ArrayList<>();
        WorkWithListSynchronized workWithList = new WorkWithListSynchronized(list);

        new AddAndRemoveListNew(workWithList, Method.ADD).start();
        new AddAndRemoveListNew(workWithList, Method.REMOVE).start();
    }
}
