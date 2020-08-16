package net.geekbrains.collections;

import java.util.HashMap;
import java.util.HashSet;

/*
   Написать простой класс Телефонный справочник, который хранит в себе список фамилий и телефонных номеров. В этот
   телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
   фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
   запросе такой фамилии должны выводиться все телефоны.

   Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
   дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль
   желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
*/

public class PhoneBox {
    HashMap<String, HashSet<String>> hm;

    public PhoneBox() {
        this.hm = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        hm.put(name, hs);
    }

    public void findString(String name) {
        if (hm.containsKey(name)) {
            System.out.println(hm.get(name));
        } else {
            System.out.println("такой фамилии нет");
        }
    }

    public static void main(String[] args) {

        PhoneBox book = new PhoneBox();
        book.add("Ivanov", "123");
        book.add("Ivanov", "124");
        book.add("Ivanov", "125");
        book.add("Petrov", "444");
        book.add("Petrov", "445");
        book.add("Petrov", "446");

        book.findString("Ivanov");
        book.findString("Petrov");
        book.findString("Petrasdov");

    }
}
