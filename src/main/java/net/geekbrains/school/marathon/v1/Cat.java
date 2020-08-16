package net.geekbrains.marathon.v1;

public class Cat extends Animal {

    public void catInfo(int task, float length, String name){
        super.maxFlee = (rand.nextInt((250-200))+200);
        super.maxSail = 0;
        super.maxJump = (1.8 + (Math.random()*(0.7-0.4)));
        switch (task) {
            case 1: flee(length, name); break;
            case 2: sail(length, name); break;
            case 3: jump(length, name); break;
        }
    }

    public void flee (float length, String name) {
        if (length <= maxFlee) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
    private void sail (float length, String name) {
        if (length!=maxSail) {
            System.out.printf("%s отказывается плыть", name);
            System.out.println("");}
    }
    private void jump (float height, String name) {
        if (height <= maxJump) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");
    }
}
