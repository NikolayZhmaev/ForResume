package net.thumbtack.school.online.windows.v3.iface;

import net.thumbtack.school.online.windows.v3.Point;

public interface Movable {

    void moveTo(int x, int y); /* Передвигает окно так,  так, чтобы его базовая точка (левый верхний угол или центр
                                  соответственно)  оказалась в точке (x,y) */

    default void moveTo(Point point) { /* Передвигает окно так,  так, чтобы его базовая точка (левый верхний угол или
                                          центр соответственно)  оказалась в точке point */
        moveTo(point.getX(), point.getY());
    }

    void moveRel(int dx, int dy); // Передвигает окно на (dx, dy)
}
