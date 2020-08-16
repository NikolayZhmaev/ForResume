package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.windows.v3.base.RectWindow;

public class RectButton extends RectWindow {

  /*  Нажимная прямоугольная кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
   (серого цвета, нажать нельзя). Предполагается, что всегда будут передаваться допустимые координаты,
    то есть при создании или изменении всегда будет выполняться : левая точка не правее правой, верхняя
     точка не ниже нижней. */

    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        super(topLeft, bottomRight, active, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active, String text) {
        super(xLeft, yTop, width, height, active, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) {
        this(topLeft, bottomRight, true, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) {
        this(xLeft, yTop, width, height, true, text);
    }
}
