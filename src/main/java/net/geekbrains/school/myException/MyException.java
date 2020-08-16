package net.geekbrains.myException;

import static java.lang.Integer.parseInt;

/*
  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
     размера необходимо бросить исключение MyArraySizeException.
  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
     элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
     брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
  3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
     и вывести результат расчета.
*/



public class MyException {

    public static void main(String[] args)  {
        String[][] array = {{"3", "4"}, {"5","8"}, {"9", "6"}, {"12","3"}};
        SumArray sumArray = new SumArray();
        try {
            sumArray.NumArray(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace(); }

        try {
            System.out.println("Сумма всех элементов массива равна: " + sumArray.SumArray(array));
        } catch (MyArrayDataException e) {
            e.printStackTrace(); }
    }
}

class SumArray {

    // Создаем метод для проверки правильности размера массива.
    public  void NumArray (String [][] array) throws MyArraySizeException {
        if (array.length!=4 && array[0].length!=4)
            throw new MyArraySizeException("Размер массива не соответствует требованиям");
    }

    // Создаем метод для подсчета суммы элементов массива.
    public int SumArray (String [][] array) throws MyArrayDataException {
        int[][] arrayNew = new int[4][4];
        int rez=0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[0].length ; j++) {
                // Обработем исключение NumberFormatException, заменим на наше и пробросим его обработку в min
                try {
                    arrayNew[i][j] = parseInt(array[i][j]);
                    rez += arrayNew[i][j];
                } catch (NumberFormatException e)
                { throw new  MyArrayDataException("Не удалось преобразовать элемент массива: array"+"["+i+"]"+"["+j+"]");}
            }
        }
        return rez;
    }
}

// Создаем наши классы исключений
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message); }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message); }
}

