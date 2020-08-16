package net.geekbrains.marathon.v1;

import java.util.Random;

public abstract class Animal {
    Random rand = new Random();
    protected double maxFlee, maxSail, maxJump;

    // Создадаим конструктор в котором и будем осуществлять все требуемые действия, в зависимости от выбора пользователя

    public void animalInfo(int task, float length, String name){

        switch (task) {
            case 1: flee(length, name); break;
            case 2: sail(length, name); break;
            case 3: jump(length, name); break;
        }
    }
    private void flee (float length, String name) {    // животное может бежать (параметры длина забега, имя)
        if (length <= maxFlee) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println(""); }
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
    private void sail (float length, String name) {   // животное может плыть (параметры длина заплыва, имя)
        if (length <= maxSail) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println(""); }
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}

    private void jump (float height, String name) { /* животное может перепрыгивать препятствие
                                                                   (параметры высота прыжка, имя) */
        if (height <= maxJump) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
}
