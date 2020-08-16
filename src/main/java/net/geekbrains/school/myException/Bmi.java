package net.geekbrains.myException;

/*
 Необходимо рассчитать Индекс Массы Тела (Body Mass Index = BMI). Определяется она как вес делённый на рост в квадрате:
 BMI = вес / рост^2
 Здесь вес берется в килограммах, а рост в метрах.
 На основании этого показателя выделяют четыре категории:
 Underweight     -           BMI < 18.5      (недостаточная масса)
 Normal weight   -   18.5 <= BMI < 25.0      (норма)
 Overweight      -   25.0 <= BMI < 30.0      (избыточная масса)
 Obesity         -   30.0 <= BMI             (ожирение)
 Например, если я вешу 80 кг а мой рост 173 см то можно вычислить:
 BMI = 80 / (1.73)^2 = 26.7
 т.е. присутствует избыточный вес.
 вес в килограммах и рост в метрах.
 Ответ должен содержать одно из слов under, normal, over, obese, через пробел.
 Данные:
 118 2.05 // 106 1.77 // 87 1.83 // 45 1.12 // 70 1.87 // 54 1.57 // 105 1.76 // 50 1.96 // 114 1.76 // 72 2.45 //
 53 2.10 // 66 2.25 // 54 1.50 // 95 1.62 // 86 1.72 // 62 1.57 // 65 2.24 // 72 1.43 // 93 2.01 // 109 3.01 //
 106 2.97 // 77 1.69 // 114 2.09 // 98 1.72 // 85 2.46 // 113 1.94 // 53 1.77 // 106 2.30
*/

public class Bmi {
    static int weight; // вес
    static  float height; // рост
    static double bmi; // индекс массы тела
    static String rez; // наш результат

    public static void main(String[] args) {

        //Представим исходные данные в виде массива String
        String [] data = new String[27];
        data[0] = "118 2.05";
        data[1] = "106 1.77";
        data[2] = "87 1.83";
        data[3] = "45 1.12";
        data[4] = "70 1.87";
        data[5] = "54 1.57";
        data[6] = "105 1.76";
        data[7] = "50 1.96";
        data[8] = "114 1.76";
        data[9] = "53 2.10";
        data[10] = "66 2.25";
        data[11] = "54 1.50";
        data[12] = "95 1.62";
        data[13] = "86 1.72";
        data[14] = "62 1.57";
        data[15] = "65 2.24";
        data[16] = "72 1.43";
        data[17] = "93 2.01";
        data[18] = "109 3.01";
        data[19] = "106 2.97";
        data[20] = "77 1.69";
        data[21] = "114 2.09";
        data[22] = "98 1.72";
        data[23] = "85 2.46";
        data[24] = "113 1.94";
        data[25] = "53 1.77";
        data[26] = "106 2.30";

        for (int i = 0; i < data.length; i++) {
            String [] dataNew = data[i].split(" "); /* в каждом элементе массива два значения (вес и рост).
                                                           Используем метод split для разбивки по пробелу. И далее
                                                          каждый получившийся элемент, преобразовывая его либо к типу
                                                          int, либо float */
            for (int j = 0; j <dataNew.length ; j++) {
                if (j==0 || j%2==0){
                    try {
                        weight= Integer.parseInt(dataNew[j]);
                    }
                    catch (Exception e) {
                        System.out.println("Не верно указан вес" + dataNew[j]);
                    }
                }
                else {
                    try {
                        height=Float.parseFloat(dataNew[j]);
                    }
                    catch (Exception e1) {
                        System.out.println("Не верно указан рост" + dataNew[j]);
                    }
                }
            }
            calculation(weight, height); // подсчет результата и вывод венесем в отдельный метод.
        }
    }

    static void calculation (int weight, float height) {
        bmi = weight/(height*height);
        if (bmi<18.5) {rez = "under";}
        else if (18.5<= bmi && bmi<25) {rez = "normal";}
        else if (bmi>=25 && bmi<30){rez = "over";}
        else {rez = "obese";}
        System.out.print(rez + " "); // выводим результат через пробел, согласно условию задачи
    }
}

