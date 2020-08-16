package net.geekbrains.marathon.v2;

import net.geekbrains.marathon.v2.Competitor.Cat;
import net.geekbrains.marathon.v2.Competitor.Competitor;
import net.geekbrains.marathon.v2.Competitor.Dog;
import net.geekbrains.marathon.v2.Competitor.Human;
import net.geekbrains.marathon.v2.Obstacle.Cross;
import net.geekbrains.marathon.v2.Obstacle.Obstacle;
import net.geekbrains.marathon.v2.Obstacle.Wall;

public class Main {

    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
        for (Competitor c : competitors) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }
    }

}