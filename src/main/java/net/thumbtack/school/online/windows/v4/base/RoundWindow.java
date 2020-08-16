package net.thumbtack.school.online.windows.v4.base;

import net.thumbtack.school.online.windows.v4.Desktop;

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

    public RoundWindow(Point center, int radius, WindowState state, String txt) throws WindowException {
        super(center.getX(), center.getY(), state, txt);
        setRadius(radius);
    }

    public RoundWindow(int xCenter, int yCenter, int radius, WindowState state, String txt) throws WindowException {
        super(xCenter, yCenter, state, txt);
        setRadius(radius);
    }

    public RoundWindow(Point center, int radius, String state, String txt) throws WindowException {
        this(center, radius, WindowState.fromString(state), txt);
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String state, String txt) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.fromString(state), txt);
    }

    public RoundWindow(Point center, int radius, String text) throws WindowException {
        this(center.getX(), center.getY(), radius, WindowState.ACTIVE, text);
    }

    public RoundWindow(int xCenter, int yCenter, int radius, String text) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.ACTIVE, text);
    }

    public Point getCenter() {
        return new Point(getX(), getY());
    }

    public void setCenter(int x, int y) {
        setX(x);
        setY(y);
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
        return (Math.pow(radius, 2) >= rez);
    }

    @Override
    public boolean isInside(Point point) {
        return checkProvisions(point.getX(), point.getY()); // воспользуемся созданным ранее методом
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return ((getX() - radius) >= 0 && (getY() - radius) >= 0) &&
                ((getX() + radius) < desktop.getWidth() && (getY() + radius) < desktop.getHeight());
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
