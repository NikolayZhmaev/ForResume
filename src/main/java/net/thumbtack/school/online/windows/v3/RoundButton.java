package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.windows.v3.base.RoundWindow;

public class RoundButton extends RoundWindow {

   /* Нажимная круглая кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
    (серого цвета, нажать нельзя).*/

    public RoundButton(Point center, int radius, boolean active, String txt) {
        super(center, radius, active, txt);
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active, String txt) {
        super(xCenter, yCenter, radius, active, txt);
    }

    public RoundButton(Point center, int radius, String text) {
        this(center.getX(), center.getY(), radius, true, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) {
        this(xCenter, yCenter, radius, true, text);
    }
}
