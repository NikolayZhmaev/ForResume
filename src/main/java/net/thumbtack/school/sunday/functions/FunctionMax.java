package net.thumbtack.school.sunday.functions;

//6. Реализуйте функцию max, используя method reference к Math.max. Какой интерфейс из java.util.function подойдет для функции с двумя параметрами?
// Возможно подойдет BiFunction <T, U, R>
@FunctionalInterface
interface Formula {
    double f(double x, double y);
}

class Max {
    public double max(int x, int y, Formula formula) {
        return formula.f(x, y);
    }
}

public class FunctionMax {

    public static double funtionMax(final int x, final int y) {
        Max max = new Max();
        return max.max(x, y, (a, b) -> Math.max(x, y));
    }

    public static double funtionMaxReference(final int x, final int y) {
        Max max = new Max();
        return max.max(x, y, Math::max);
    }

}
