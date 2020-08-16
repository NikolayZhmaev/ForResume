package net.thumbtack.school.online.introduction;

public class FirstSteps {

    public int sum (int x, int y) {
        return x+y;
    }

    public int mul (int x, int y) {
        return x*y;
    }

    public int div (int x, int y) {
        return ( y!=0 )? x/y : 0; // в случае попытки деления на ноль, будет кидаться 0
    }

    public int mod (int x, int y) {
        return ( y!=0 )? x%y : 0;
    }

    public boolean isEqual (int x, int y) {
        return x==y;
    }

    public boolean isGreater (int x, int y){
        return x>y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
       /* для того чтобы точка лежала в пределах прямоигольника она должна попадать в данный диапазон*/
       return  (xLeft < xRight && yTop < yBottom) &&
               (x>=xLeft && x<=xRight && y>=yTop && y<=yBottom);
    }

    public int sum (int [] array ) {
        int sum=0;
        if (array.length!=0) {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
        }
        return sum;
    }

    public int mul (int[] array) {
        int sum=0;
        if (array.length!=0) {
            sum++;
            for (int i = 0; i < array.length; i++) {
                sum *= array[i];
            }
        }
        return sum;
    }

    public int min(int[] array) {
        int minValue = Integer.MAX_VALUE;
        if (array.length!=0) {
            minValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
            }
        }
        return minValue;
    }

    public int max (int[] array) {
        int maxValue = Integer.MIN_VALUE;
        if (array.length!=0) {
            maxValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
        }
        return maxValue;
    }

    public double average (int[] array) {
        double mediumValue = 0;
        if (array.length!=0) {
            mediumValue=array[0];
            for (int i = 1; i <array.length ; i++) {
                mediumValue+=array[i];
            }
            mediumValue = mediumValue/array.length;
        }
        return mediumValue;
    }

    public boolean isSortedDescendant (int[] array) {
        boolean rez = true;
        if (array.length!=0) {
            int value = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] >= value) {
                    rez = false; break;
                }
                value = array[i];
            }
        }
        return rez;
    }

    public void cube (int[]array) {
        for (int i = 0; i < array.length; i++) {
          array[i] = (int) Math.pow (array[i], 3); /* так как в задании не указаны пожелания по решению, для
                                                     простоты, воспользуемся классам Math пакета java.lang*/

        }
    }

    public boolean find (int[]array, int value) {
        boolean rez = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                rez = true; break;
            }
        }
        return rez;
    }

    public void reverse(int[]array) {
        int var; // создадим переменную для хранения элементов массива
        for (int i = 0; i < array.length/2; i++) {
            var = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = var;
        }
    }

    public boolean isPalindrome(int[]array) {
        boolean rez = true;
        if (array.length!=0) {
            for (int i = 0; i <= ((array.length -1) - i); i++) {
                if (array[i] != array[(array.length - 1) - i]) {
                    rez = false; break;
                }
            }
        }
        return rez;
    }

    public int sum (int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += sum(matrix[i]);
        }
        return sum;
    }

    public int max (int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        if (matrix.length!=0) {
            for (int i = 0; i < matrix.length; i++) {
               if (maxValue < max(matrix[i])) {
                maxValue = max(matrix[i]);
               }
            }
        }
        return maxValue;
    }

    public int diagonalMax (int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        if ( matrix.length!=0) {
            maxValue = matrix [0][0];
            for (int i = 0; i < matrix.length; i++) {
                if (maxValue < matrix[i][i]) {
                    maxValue = matrix[i][i];
                }
            }
        }
        return maxValue;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean rez = true;
        for (int i = 0; i < matrix.length; i++) {
            int []array = new int [matrix[i].length]; // создадим массив для записи в него строк.
            for (int j = 0; j < matrix[i].length; j++) {
                array[j] = matrix[i][j];
            }
            if (!isSortedDescendant(array)) { // вызовем созданный ранее метод и проверим его результат.
                return false;
            }
        }
        return rez;
    }
}
