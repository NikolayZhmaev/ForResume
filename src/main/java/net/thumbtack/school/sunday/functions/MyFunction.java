package net.thumbtack.school.sunday.functions;

/* 11.	Предположим вы решили использовать функцию с двумя аргументами. Что произойдет когда вы добавите K apply(T arg1, T arg2)?
        Задекларируйте MyFunction как функциональный интерфейс. Попробуйте скомпилировать.
Ответ: Error:(39, 38) java: method apply in interface net.thumbtack.school.functions.MyFunction<T,K> cannot be applied to given types;
       required: java.lang.String,java.lang.String
       found: java.lang.String
       reason: actual and formal argument lists differ in length
 */


@FunctionalInterface
interface MyFunction<T, K> {
    K apply(T arg);
//    K apply (T arg1, T arg2);
}
