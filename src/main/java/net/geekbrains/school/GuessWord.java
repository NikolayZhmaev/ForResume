package net.geekbrains;

import java.util.Random;
import java.util.Scanner;

/* Создать массив из слов
   String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                     "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                     "pepper", "pineapple", "pumpkin", "potato"};

    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом
    и сообщает правильно ли ответил пользователь.
    Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)

    Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы
*/

public class GuessWord {

    private static void guessWord () {

    String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    Scanner sc = new Scanner(System.in); // нам понадобится Scanner для взаимодействия с пользователем
    Random random = new Random();

    StringBuilder sb = new StringBuilder();

    int rand = random.nextInt(24); // выбирать слово из массива будем случайным образом
    String answer;  // переменная, которая будет содержать вариант пользователя
    Boolean win = false; // это будет флаг: true - если пользователь угадал

        System.out.println("Угадайте слово загаданное программой.");

        do {
        System.out.println("Введите ваше слово.");

        answer = sc.next();

        if(words[rand].equals(answer.toLowerCase()))    {
            win = true;
        }

        if(!win) {
            System.out.println("Не угадали, попробуйте ещё раз.");

            /* если символ совпал с тем что ввел пользователь и мы не вышли за предел дилны то добаляем символ
               если нет добавляем решетку */

            for (int i = 0; i < words[rand].length(); i++) {

                if (answer.length() > i && answer.charAt(i) == words[rand].charAt(i)) {
                    sb.append("(" +answer.charAt(i) + ")");
                } else sb.append("#");
            }

            System.out.println("Буквы которые вы угадали: " + "#####" + sb.toString() + "#####");
            sb.delete(0, sb.length());
            System.out.println();
        }

    } while (!words[rand].equals(answer.toLowerCase())); {
        System.out.println("Вы угадали слово!");
    }
}

    public static void main(String[] args) {
        guessWord();
    }
}
