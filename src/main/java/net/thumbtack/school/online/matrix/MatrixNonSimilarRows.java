package net.thumbtack.school.online.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixNonSimilarRows {

     /*
     Задумка следующая: так как строки похожи (согласно задания), вне зависимости от количества повторящихся
     в них элементов, воспользуемся Set. Это позволит нам сразу исключить дубликаты, и работать с проверкой уникальных
     значений. Номера строк новой и старой матриц будут совпадать.
     После получения матрицы без дубликатов, сравним размеры строк, если есть не равные, то они уже не похожи.
     После этого сравним равные строки. Для этого опять же воспользуемся Set: будем добавлять в строки элементы
     и отслеживать изменение длинны Set. Если длинна осталась та же, значит элементы в обоих строках одни и теже.
     */

    private int[][] matrix; // поле с исходной матрицей
    private int[][] newMatrix; // создадим поле для обработанной матрицы
    private Set<Integer> numLine = new HashSet<>(); // поле для хранения номеров найденных строк


    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
        this.newMatrix = new int[matrix.length][];
    }


    // вот наш метод для получения новой матрицы
    private void getNewMatrix() {
        Set<Integer> line = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                line.add(matrix[i][j]);
            }

            if (line.size() == 0) { // если элементов нет, то значит страка пуста, и переносим ее как есть
                newMatrix[i] = matrix[i];
                line.clear();
                continue;
            }
            int j = 0;
            int[] newLine = new int[line.size()]; // новый массив для передачи элементов из line
            for (Integer val : line) {
                newLine[j++] = val;
            }
            line.clear();
            newMatrix[i] = newLine; // перенесли очищенный массив в соответствующую строку новой матрицы.
        }
    }

    public List<int[]> getNonSimilarRows() {
        List<int[]> rez = new ArrayList<int[]>();
        getNewMatrix(); // очищаем матрицу от дубликатов в строках
        getIines(); // теперь когда мы получили номера нужных нам строк мы просто добавим их в List из исходного массива
        for (Integer num : numLine) {
            rez.add(matrix[num]);
        }
        return rez;
    }

    // А это метод для сравнения строк в новой матрице и получения номеров уникальных строк
    private void getIines() {
        Set<Integer> line = new HashSet<Integer>();
        int sizLine; // переменная для хранеия длинны Set
        for (int i = 0; i < newMatrix.length - 1; i++) {
            int num = i;
            for (int j = 0; j < newMatrix[i].length; j++) {
                line.add(newMatrix[i][j]);  // добавляем элементы из строки в Set
            }
            Set<Integer> line2 = new HashSet<Integer>(line); // создатим line2, дальше он нам понадобится
            sizLine = line2.size();
            // далеее пробегаемся по остальным строкам.
            for (int j = i + 1; j < newMatrix.length; j++) {
                if (sizLine == newMatrix[j].length) { // если строки не равны, нет смысла их сравнивать
                    for (int k = 0; k < newMatrix[j].length; k++) {
                        line2.add(newMatrix[j][k]);
                    }
                    if (line2.size() == sizLine) {
                        num = j;
                        continue;
                    }
                }
                line2.clear();
                line2.addAll(line); // для этого и нужен был line2
            }
            line.clear();
            numLine.add(num);
        }
        numLine.add(newMatrix.length - 1); // последний элемент будет всегда
    }
}



