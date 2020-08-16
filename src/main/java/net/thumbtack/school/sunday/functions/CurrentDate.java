package net.thumbtack.school.sunday.functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

// 7. Реализуйте функцию getCurrentDate, возвращающую текущую дату () -> java.util.Date. Какой интерфейс из java.util.function подойдет для функции без параметров?

public class CurrentDate {
    public static String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Supplier<Date> date = () -> new Date();
        return dateFormat.format(date.get());
    }
}
