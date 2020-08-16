package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.RoundWindow;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

public class RoundButton extends RoundWindow {

   /* Нажимная круглая кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
    (серого цвета, нажать нельзя).*/

    public RoundButton(Point center, int radius, WindowState state, String txt) throws WindowException {
        super(center, radius, state, txt);
    }

    public RoundButton(Point center, int radius, String state, String txt) throws WindowException {
        this(center, radius, WindowState.fromString(state), txt);
    }

    public RoundButton(int xCenter, int yCenter, int radius, WindowState state, String txt) throws WindowException {
        super(xCenter, yCenter, radius, state, txt);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String state, String txt) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.fromString(state), txt);
    }

    public RoundButton(Point center, int radius, String text) throws WindowException {
        this(center.getX(), center.getY(), radius, WindowState.ACTIVE, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.ACTIVE, text);
    }
}
