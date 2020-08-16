package net.thumbtack.school.sunday.threads;

import java.util.ArrayList;
import java.util.List;

/* 4. В основном потоке создать ArrayList<Integer>. Запустить 2 потока на базе разных классов, один поток 10000 раз
      добавляет в список случайное целое число, другой 10000 раз удаляет элемент по случайному индексу (если при удалении
      выясняется, что список пуст, ничего не делать). Использовать внешний synchronized блок. Потоки должны работать
      конкурентно, то есть одновременно должно идти и добавление, и удаление.
*/

class WorkWithList {
    private List<Integer> list;

    public WorkWithList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void addElement(int element) {
        list.add(element);
        System.out.println("element add:" + element);
    }

    public void removeElement(int index) {
        System.out.println("element remove " + list.get(index));
        list.remove(index);
    }
}

class AddToList extends Thread {

    private WorkWithList workWithList;

    public AddToList(WorkWithList workWithList) {
        this.workWithList = workWithList;
    }

    public void run() {
        int element;
        for (int i = 0; i < 10000; i++) {
            element = (int) (Math.random() * 10001);
            synchronized (workWithList){
            workWithList.addElement(element);
            }
        }
    }
}

class RemoveFromList extends Thread {

    private WorkWithList workWithList;

    public RemoveFromList(WorkWithList workWithList) {
        this.workWithList = workWithList;
    }

    public void run() {
        int index;
        for (int i = 0; i < 10000; i++) {
            int size = workWithList.getList().size();
            index = (int) (Math.random() * (size - 1));
            synchronized (workWithList) {
                try {
                    workWithList.removeElement(index);
                } catch (IndexOutOfBoundsException e) {
                    interrupt();
                }
            }
        }
    }
}

public class AddAndGETIntegerBlock {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        WorkWithList workWithList = new WorkWithList(list);
        new AddToList(workWithList).start();
        new RemoveFromList(workWithList).start();
    }
}
