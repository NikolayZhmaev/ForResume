package net.thumbtack.school.online.windows.v4.base;

import net.thumbtack.school.online.windows.v4.Desktop;
import net.thumbtack.school.online.windows.v4.iface.Movable;
import net.thumbtack.school.online.windows.v4.iface.Resizable;

import java.util.Objects;

abstract public class Window implements Movable, Resizable {

    Point point;
    private WindowState state;
    private String text;

    // напишем метод для проверки состояния окон.
    public void checkState(WindowState state) throws WindowException {
        if (this.state == WindowState.DESTROYED) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
        if (this.state == null && state == WindowState.DESTROYED) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
        if (state == null) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }

    public Window(int x, int y, WindowState state, String text) throws WindowException {
        point = new Point(x, y);
        setState(state);
        setText(text);
    }

    public Window(int x, int y, String state, String text) throws WindowException {
        this(x, y, WindowState.fromString(state), text);
    }

    public int getX() {
        return point.getX();
    }

    public void setX(int x) {
        point.setX(x);
    }

    public int getY() {
        return point.getY();
    }

    public void setY(int y) {
        point.setY(y);
    }

    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) throws WindowException {
        checkState(state);
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void moveTo(int x, int y) {
        point.moveTo(x, y);
    }

    public void moveRel(int dx, int dy) {
        point.moveRel(dx, dy);
    }

    public abstract void resize(double ratio);

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return Objects.equals(point, window.point) &&
                state == window.state &&
                Objects.equals(text, window.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, state, text);
    }
}