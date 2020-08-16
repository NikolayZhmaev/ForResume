package net.thumbtack.school.sunday.functions;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/*
1.	Используя функциональный интерфейс java.util.function.Function и лямбда-выражения, создайте:
        ●	функцию split (String s) -> List<String>, разбивающую строку по пробелам
        ●	функцию count (List<?> list) -> Integer, считающую количество элементов в любом списке
    Примените split к строке, содержащей пробелы, а после этого примените count к ее результату.
2.	Попробуйте избавиться от декларации типов в параметрах функций из пункта 1. Почему это возможно?
3.	Попробуйте заменить лямбда-выражение на method reference, в каких случаях это возможно и почему?
4.	Перепишите решение из п. 1, композируя функции split и count при помощи default-методов интерфейса Function, в новую функцию splitAndCount:
        a.	используйте andThen
        b.	используйте compose
    Чем данный подход отличается от count.apply(split.apply(str)) ?
*/

public class Functions {

    public static <T, R> R transform(T value, Function<T, R> f) {
        return f.apply(value);
    }

    public static List<?> split(String str) {
        List<String> list = Arrays.asList(str.split("\\s+"));
        return list;
    }

    public static Integer count(List<?> list) {
        return list.size();
    }

    public static Integer itemsInStringLambda(String str) {
        MyFunction<String, List> transform = list -> split(list);
        MyFunction<List, Integer> counts = result -> count(result);
        return counts.apply(transform.apply(str));
    }

    public static Integer itemsInString(String str) {
        return transform(transform(str, Functions::split), Functions::count);
    }

    public static Integer splitAndCount(String str) {
        Function<String, List> transform = list -> split(list);
        Function<String, Integer> counts = transform.andThen(Functions::count);
        return counts.apply(str);
    }

    public static Integer splitAndCountСompose(String str) {
        Function<List, Integer> counts = result -> count(result);
        Function<String, Integer> transform = counts.compose(Functions::split);
        return transform.apply(str);
    }

    //8. Реализуйте функцию isEven (Integer a) -> Boolean. Какой интерфейс из java.util.function для этого подойдет?
    public static boolean isEven(Integer a) {
        Predicate<Integer> check = x -> x % 2 == 0;
        return check.test(a);
    }

/*
  13. Напишите метод IntStream transform(IntStream stream, IntUnaryOperator op), трансформирующий каждый элемент при
      помощи операции op. Выведите результат на консоль.
  14. Задача аналогичная предыдущей, только теперь нужно трансформировать входящий Stream в параллельный, обратите
      внимание на изменившийся вывод на консоль.
*/

    public static void transform(IntStream stream, IntUnaryOperator op) {
        stream.map(op).forEach(System.out::println);
    }

    public static void transformParallelStream(IntStream stream, IntUnaryOperator op) {
        stream.map(op).parallel().forEach(System.out::println);
    }

/*
  15. Реализуйте класс Person(String name, int age). Имея список List<Person>, при помощи Stream API необходимо вернуть
      уникальные имена для всех людей старше 30 лет, отсортированные по длине имени.
  16. Имея список List<Person>, при помощи Stream API необходимо вернуть уникальные имена для всех людей старше 30 лет,
      отсортированные по количеству людей с одинаковым именем. Используйте Collectors.groupingBy
  17. Реализуйте sum(List<Integer> list) и product(List<Integer> list) через Stream.reduce
*/

    static List<AgePerson> getPersonSortUniqNameOld(List<AgePerson> personList) {
        return personList.stream().sorted(Comparator.comparing(x -> x.getName().length())).distinct()
                .filter(a -> a.getAge() > 30).collect(toList());
    }

    static List<String> getPersonSortUniqEqualName(List<AgePerson> personList) {

        return personList.stream().filter(a -> a.getAge() > 30)
                .collect(collectingAndThen(groupingBy(AgePerson::getName, Collectors.counting()),
                        m -> m.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                                .collect(mapping(Map.Entry::getKey, toList()))));


//        // REVU зачем Вам Collectors.toMap, если в итоге нужен List ?
//        // REVU все должно быть в одну строчку
//        // return personList.stream().m1().m2()...;
//        // создавать самому что-то с помощью new нельзя
    }

    private static Map<String, Long> getCollect(List<AgePerson> personList) {
        return personList.stream().filter(a -> a.getAge() > 30)
                .collect(Collectors.groupingBy(AgePerson::getName, Collectors.counting()));
    }

    static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    static int product(List<Integer> list) {
        Optional<Integer> sum = list.stream().reduce((a, b) -> a * b);
        return sum.get();
    }
}
