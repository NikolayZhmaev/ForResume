package net.geekbrains.myException;

/*
  Если у нас есть три отрезка с длинами A B C - мы либо можем построить из них треугольник (например из 3 4 5) - или это
  оказывается невозможно (например, со сторонами 1 2 4).
  Даны несколько троек чисел, представляющих длины отрезков. Требуется ответить, из каких троек можно построить
  треугольник, а из каких нет.

  696 507 1102 // 989 2932 1359 // 1294 876 2162 // 735 1006 820 // 898 595 1341 // 1304 1739 985 // 1303 2598 860 //
  237 290 592 // 313 560 780 // 586 814 1885 // 1466 911 733 // 733 496 504 // 1802 953 632 // 3176 922 1297 //
  1681 1428 774 // 1381 890 3283 // 1215 2100 833 // 861 518 1519 // 1927 856 629 // 619 700 678 // 985 418 540 //
  228 169 521 // 630 188 341 // 151 323 158 // 135 117 171 // 814 1165 1923
*/

public class Triangle {
    public static void main(String[] args) {

        String[] inputData = new String[26];
        inputData[0] = "696 507 1102";
        inputData[1] = "989 2932 1359";
        inputData[2] = "1294 876 2162";
        inputData[3] = "735 1006 820";
        inputData[4] = "898 595 1341";
        inputData[5] = "1304 1739 985";
        inputData[6] = "1303 2598 860";
        inputData[7] = "237 290 592";
        inputData[8] = "313 560 780";
        inputData[9] = "586 814 1885";
        inputData[10] = "1466 911 733";
        inputData[11] = "733 496 504";
        inputData[12] = "1802 953 632";
        inputData[13] = "3176 922 1297";
        inputData[14] = "1681 1428 774";
        inputData[15] = "1381 890 3283";
        inputData[16] = "1215 2100 833";
        inputData[17] = "861 518 1519";
        inputData[18] = "1927 856 629";
        inputData[19] = "619 700 678";
        inputData[20] = "985 418 540";
        inputData[21] = "228 169 521";
        inputData[22] = "630 188 341";
        inputData[23] = "151 323 158";
        inputData[24] = "1135 117 171";
        inputData[25] = "814 1165 1923";

        for (int i = 0; i < inputData.length; i++) {
            String[] sideTriangle = inputData[i].split(" ");
            try {
                System.out.println("Построение треугольника из элементов: " + inputData[i] + " - "
                        + constructTriangle(sideTriangle));
            } catch (IncorrectValue incorrectValue) {
                incorrectValue.printStackTrace();
            }
        }
    }

    //Вынесем проверку в отдельный метод. Для проверки будем использовать теорему "Неравенства треугольника".

    public static boolean constructTriangle(String[] sideTriangle) throws IncorrectValue {
        int a, b, c; // для читабельности кода, создадим три переменные (стороны треугольника).
        int i = 0;
        try {
            a = Integer.parseInt(sideTriangle[i]);
            b = Integer.parseInt(sideTriangle[i + 1]);
            c = Integer.parseInt(sideTriangle[i + 2]);
        } catch (NumberFormatException e) {
            throw new IncorrectValue("Не верно указаны значения сторон");
        }

        if (a < (b + c) && a > (-(b - c))) {
            return true;
        }
        return false;
    }
}

//Создадим свою ошибку на случай не верного значения сторон.
class IncorrectValue extends Exception {
    public IncorrectValue(String message) {
        super(message);
    }
}