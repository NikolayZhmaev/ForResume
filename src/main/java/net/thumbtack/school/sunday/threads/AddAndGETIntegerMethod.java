package net.thumbtack.school.sunday.threads;

import java.util.ArrayList;
import java.util.List;

/* 5. То же самое, но оба потока на базе одного и того же класса, использовать synchronized методы. В конструктор класса
      потока передается параметр типа enum, указывающий, что должен делать этот поток.
*/

class WorkWithListMethod {

    private List<Integer> list;


    public WorkWithListMethod(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    synchronized void addElement(int element) {
        list.add(element);
        System.out.println("element add:" + element);
    }

    synchronized void removeElement(int element) {
        System.out.println("element remove " + list.get(element));
        list.remove(element);
    }
}

class AddAndRemoveList extends Thread {

    private WorkWithListMethod workWithList;
    private Method method;

    public AddAndRemoveList(WorkWithListMethod workWithList, Method method) {
        this.workWithList = workWithList;
        this.method = method;
    }

    public void run() {
        int element;
        switch (method) {
            case ADD:
                for (int i = 0; i < 10000; i++) {
                    element = (int) (Math.random() * 10001);
                    workWithList.addElement(element);
                }
            case REMOVE:
                for (int i = 0; i < 10000; i++) {
                    int size = workWithList.getList().size();
                    int index = (int) (Math.random() * (size - 1));
                    try {
                        workWithList.removeElement(index);
                    } catch (IndexOutOfBoundsException e) {
                        interrupt();
                    }
                }
        }
    }
}

enum Method {
    ADD,
    REMOVE
}


public class AddAndGETIntegerMethod {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        WorkWithListMethod workWithList = new WorkWithListMethod(list);

        new AddAndRemoveList(workWithList, Method.ADD).start();
        new AddAndRemoveList(workWithList, Method.REMOVE).start();
    }
}
