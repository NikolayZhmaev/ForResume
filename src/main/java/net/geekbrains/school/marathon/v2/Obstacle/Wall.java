package net.geekbrains.marathon.v2.Obstacle;

import net.geekbrains.marathon.v2.Competitor.Competitor;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
