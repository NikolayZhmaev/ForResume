package net.geekbrains.marathon.v2.Obstacle;

import net.geekbrains.marathon.v2.Competitor.Competitor;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}