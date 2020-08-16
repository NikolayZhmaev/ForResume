package net.geekbrains.marathon.v2.Obstacle;

import net.geekbrains.marathon.v2.Competitor.Competitor;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
