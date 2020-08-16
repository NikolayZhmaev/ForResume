package net.geekbrains.marathon.v1;

public class Dog extends Animal {
    public void dogInfo(int task, float length, String name){
        /* Делее реализуем задачу номер 5. Логика следующая: смысла разбивать собак (кошек) на породы не вижу,
         по причине того, что даже собаки одной породы имеют разные показатели, зависяшие от прочих условий (разная
         физ. подготовка, разные условия выполнения задания и пр.). Поэтому, требуемый разброс реализуем рандомно,
         так как если бы он был разным для каждой конкретной собаки в каждой конкретной попытке */

        super.maxFlee = (rand.nextInt((600-400))+400);
        super.maxSail = (rand.nextInt((10-8))+8);
        super.maxJump = (0.4 + (Math.random()*(0.6-0.4)));

        switch (task) {
            case 1: flee(length, name); break;
            case 2: sail(length, name); break;
            case 3: jump(length, name); break;
        }
    }
    private void flee (float length, String name) {
        if (length <= maxFlee) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
    public void sail (float length, String name) {
        if (length <= maxSail) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
    public void jump (float height, String name) {
        if (height <= maxJump) {
            System.out.printf("%s успешно преодолел препятствие", name);
            System.out.println("");}
        else
            System.out.printf("%s не смог преодолеть препятствие", name);
        System.out.println("");}
}
