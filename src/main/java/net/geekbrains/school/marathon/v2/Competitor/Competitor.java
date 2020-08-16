package net.geekbrains.marathon.v2.Competitor;

public interface Competitor {

    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();
}
