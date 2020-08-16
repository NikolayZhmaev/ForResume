package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.RectWindow;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

public class RectButton extends RectWindow {

  /*  Нажимная прямоугольная кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
   (серого цвета, нажать нельзя). Предполагается, что всегда будут передаваться допустимые координаты,
    то есть при создании или изменении всегда будет выполняться : левая точка не правее правой, верхняя
     точка не ниже нижней. */

    public RectButton(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        super(topLeft, bottomRight, state, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        super(xLeft, yTop, width, height, state, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.fromString(state), text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, text);
    }
}
