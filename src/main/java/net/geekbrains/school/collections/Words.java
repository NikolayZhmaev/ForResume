package net.geekbrains.collections;

/*
  Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
  из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Words {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<String>();
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("banana");
        words.add("apple");
        words.add("mango");
        words.add("kiwi");
        words.add("peach");
        words.add("orange");
        words.add("grape");
        words.add("grape");
        words.add("banana");
        words.add("peach");
        words.add("plum");
        words.add("grape");
        words.add("plum");

        //Для подсчета слов будем использовать HashMap
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Integer num;
        //Переносим слова в HashMap как ключ.
        for (String wrd : words) {
            num=hashMap.get(wrd);
            if (num==null) {hashMap.put(wrd, 1);}// если в списке нет, то добавить со значением 1
            else hashMap.put(wrd, num+1); //если есть такое слово, то увеличиваем счетчик
        }
        //выводим результат
        System.out.println("Всего слов с списке: " + words.size());
        System.out.println("Уникальных слов: " + hashMap.size());
        System.out.println("Повторяющиеся слова:");
        System.out.println(hashMap);
    }

}
