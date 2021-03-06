package net.thumbtack.school.online.windows.v3.base;

import net.thumbtack.school.online.windows.v3.Desktop;
import net.thumbtack.school.online.windows.v3.Point;

import java.util.Objects;

abstract public class RoundWindow extends Window {

    private int radius;    // создадим поля для хранения координат окна и его размеров.

    public int getxCenter() {
        return getX();
    }

    public void setxCenter(int xCenter) {
        setX(xCenter);
    }

    public int getyCenter() {
        return getY();
    }

    public void setyCenter(int yCenter) {
        setY(yCenter);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public RoundWindow(Point center, int radius, boolean active, String txt) {
        super(center.getX(), center.getY(), active, txt);
        this.radius = radius;

    }

    public RoundWindow(int xCenter, int yCenter, int radius, boolean active, String txt) {
        super(xCenter, yCenter, active, txt);
        this.radius = radius;

    }

    public RoundWindow(Point center, int radius, String text) {
        this(center.getX(), center.getY(), radius, true, text);
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String text) {
        this(xCenter, yCenter, radius, true, text);
    }

    public Point getCenter() {
        return new Point(getX(), getY());
    }

    public void setCenter(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        int xNew = getX() + dx;
        setX(xNew);
        int yNew = getY() + dy;
        setY(yNew);
    }

    @Override
    public void resize(double ratio) {
        radius = (int) (radius * ratio);
        if (radius < 1) {
            radius = 1;
        }
    }

    @Override
    public boolean isInside(int x, int y) {
        return checkProvisions(x, y); // вынесем проверку в отдельный метод.
    }

    private boolean checkProvisions(int x, int y) {   /* если расстояние от точки до центра окружности меньше (равно)
		                                               радиуса, то точка лежит внутри окружности*/
        double rez = (Math.pow((x - getX()), 2) + Math.pow((y - getY()), 2));

        if (Math.pow(radius, 2) >= rez) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInside(Point point) {
        return checkProvisions(point.getX(), point.getY()); // воспользуемся созданным ранее методом
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if ((getX() - radius) >= 0 && (getY() - radius) >= 0) {
            if ((getX() + radius) < desktop.getWidth() && (getY() + radius) < desktop.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return radius == that.radius;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), radius);
    }
}
