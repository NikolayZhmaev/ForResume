package net.thumbtack.school.sunday.functions;

import java.util.function.Predicate;

public class CheckEqual {

    public static boolean areEqual(Integer a, Integer b) {
        Predicate<Integer> check = x -> a == b;
        return check.test(a);
    }

}
