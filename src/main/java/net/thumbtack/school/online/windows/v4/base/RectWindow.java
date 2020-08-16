package net.thumbtack.school.online.windows.v4.base;

import net.thumbtack.school.online.windows.v4.Desktop;
import net.thumbtack.school.online.windows.v4.RectButton;

import java.util.Objects;

abstract public class RectWindow extends Window {

    private int width, height; // создадим поля для хранения координат окна и его размеров.

    public int getxLeft() {
        return getX();
    }

    public void setxLeft(int xLeft) {
        setX(xLeft);
    }

    public int getyTop() {
        return getY();
    }

    public void setyTop(int yTop) {
        setY(yTop);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public RectWindow(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        super(topLeft.getX(), topLeft.getY(), state, text);
        setBottomRight(bottomRight);
    }

    public RectWindow(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        super(xLeft, yTop, state, text);
        setWidth(width);
        setHeight(height);
    }

    public RectWindow(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text);
    }

    public RectWindow(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.fromString(state), text);
    }

    public RectWindow(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text);
    }

    public RectWindow(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, text);
    }

    public Point getTopLeft() {
        return new Point(getX(), getY());
    }

    public Point getBottomRight() {
        return new Point(getX() + width - 1, getY() + height - 1);
    }

    public void setTopLeft(Point topLeft) {
        setY(topLeft.getY());
        setX(topLeft.getX());
    }

    public void setBottomRight(Point bottomRight) {
        /* у нашего окна нет такого поля, как правая нижняя точка. Значит будем через этот метод задавать
        нужную ширину и высоту, так, чтобы правый нижний угол был в точке bottomRight */
        setWidth(bottomRight.getX() - getX() + 1);
        setHeight(bottomRight.getY() - getY() + 1);
    }

    @Override
    public void resize(double ratio) {
        width = (int) (width * ratio);
        height = (int) (height * ratio);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
    }

    @Override
    public boolean isInside(int x, int y) {
        return checkProvisions(x, y); // для избежания копирования кода вынесем проверку в отдельный метод
    }

    private boolean checkProvisions(int x, int y) {
        return ((x >= getX() && x <= getX() + width - 1) && (y >= getY() && y <= getY() + height - 1));
    }

    @Override
    public boolean isInside(Point point) {
        return checkProvisions(point.getX(), point.getY());
    }

    public boolean isIntersects(RectButton rectButton) {
        // прежде всего сравним окна на равентство, ведь в этом случае они пересекаются
        if (this.equals(rectButton)) {
            return true;
        } else
            return (rectButton.getX() > getX() - rectButton.getWidth() && rectButton.getX() < getX() + getWidth()) &&
                    (rectButton.getY() > getY() - rectButton.getHeight() && rectButton.getY() < getY() + getHeight());
    }

    public boolean isInside(RectButton rectButton) {
        // прежде всего сравним окна на равентство, ведь в этом случае условие проверки истинно
        if (this.equals(rectButton)) {
            return true;
        } else
            // Если первое условие не сработало сравним начальные координаты и длины сторон.
            return (rectButton.getxLeft() > getX() && rectButton.getWidth() < width) &&
                    (rectButton.getyTop() > getY() && rectButton.getHeight() < height);
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return (getX() >= 0 && getY() >= 0) &&
                (width <= (desktop.getWidth() - getX()) && height <= (desktop.getHeight() - getY()));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectWindow that = (RectWindow) o;
        return getX() == that.getX() &&
                getY() == that.getY() &&
                width == that.width &&
                height == that.height &&
                getState() == that.getState() &&
                Objects.equals(getText(), that.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
