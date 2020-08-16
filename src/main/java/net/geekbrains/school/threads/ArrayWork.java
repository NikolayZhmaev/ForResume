package net.geekbrains.threads;

/*
   Необходимо написать два метода, которые делают следующее:
   1) Создают одномерный длинный массив, например:

            static final int size = 10000000;
            static final int h = size / 2;
            float[] arr = new float[size];

   2) Заполняют этот массив единицами;
   3) Засекают время выполнения: long a = System.currentTimeMillis();
   4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
           arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
   5) Проверяется время окончания метода System.currentTimeMillis();
   6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
   Отличие первого метода от второго:
   Первый просто бежит по массиву и вычисляет значения. Второй разбивает массив на два массива, в двух потоках
   высчитывает новые значения и потом склеивает эти массивы обратно в один.
*/

public class ArrayWork {

    static final int SIZE = 1000000;


    public static void main(String[] args) {
        //Вся логика будет происходить в двух методах. В main мы их только вызовем
        System.out.println(OneThread());
        System.out.println(MultipleThreads(2));

    }

    // Первый метод будет однопоточным и будет просто пробегаться по массиву.
    public static long OneThread() {
        long start, stop;
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Выполнение кода одним потоком: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        stop = System.currentTimeMillis();
        return (stop - start);
    }

    /*Второй метод будет разбивать массив на два и два потока будут пробегаться по этим массивам.
     После оба массива склеиваем. */
    public static long MultipleThreads(int N) {
        long start, stop;
        float[] arr = new float[SIZE];
        int newSize = SIZE / N;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Выполнение кода " + N + " потоками: ");
        start = System.currentTimeMillis();

        float[] arr1 = new float[newSize];
        float[] arr2 = new float[newSize];
        System.arraycopy(arr, 0, arr1, 0, newSize);
        System.arraycopy(arr, newSize + 1, arr2, 0, newSize - 1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, newSize, arr2, 0, arr2.length);

        stop = System.currentTimeMillis();
        return (stop - start);
    }
}