package net.geekbrains.marathon.v1;

import java.util.Scanner;

/*
   1. Создать классы Собака и Кот с наследованием от класса Животное.
   2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу
      передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
   3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
      плавание: кот не умеет плавать, собака 10 м.).
   4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
      (Например, dog1.run(150); -> результат: run: true)
*/

public class Marathon {

    public static Scanner sc = new Scanner(System.in);
    static int userSel, task, num;
    static String name;
    static float hurdle;

    public static void main(String[] args) {

        /* Предложим пользователю самому выбрать количество животных. После этого запустим цикл, который позволит
         пользователу создать животных и задачи которые они должны выполнить.*/
        System.out.println("Выберите количество животных: ");
        num = sc.nextInt();

        for (int i = 1; i <= num; i++) {

            System.out.println("Выберите животное:\n " + "1-собака/2-кот");
            userSel = sc.nextInt();
            choiceAnimal(userSel);
            System.out.println("Введите размер препятствия, которое нужно преодолеть в метрах :");
            hurdle = sc.nextFloat();

        /* Запустим цикл, который на основании заданных действий, создаст нужный объект (животных, каждый из которых
         будет обладать индивидуальными качествами), и проверим смогут ли они выполнить поставленные пользователем
          задачи */

            switch (userSel) {
                case 1:
                    Dog dog = new Dog();
                    dog.dogInfo(task, hurdle, name);
                    break;
                case 2:
                    Cat cat = new Cat();
                    cat.catInfo(task, hurdle, name);
                    break;
            }
        }
    }

    public static void choiceAnimal(int userSel) {
        switch (userSel) {

            case 1:
                System.out.println("Введите имя собаки: ");
                name = sc.next();
                System.out.printf("Выберите какое действие выполнит %S:\n 1-бежать/2-плыть/3-перепрыгивать препятствие", name);
                System.out.println("");
                task = sc.nextInt();
                break;

            case 2:
                System.out.println("Введите имя кошки: ");
                name = sc.next();
                System.out.printf("Выберите какое действие выполнит %S:\n 1-бежать/2-плыть/3-перепрыгивать препятствие", name);
                System.out.println("");
                task = sc.nextInt();
                break;
        }
    }
}
