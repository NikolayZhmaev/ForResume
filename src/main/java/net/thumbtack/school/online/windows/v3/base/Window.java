package net.thumbtack.school.online.windows.v3.base;

import net.thumbtack.school.online.windows.v3.Desktop;
import net.thumbtack.school.online.windows.v3.Point;
import net.thumbtack.school.online.windows.v3.iface.Movable;
import net.thumbtack.school.online.windows.v3.iface.Resizable;

import java.util.Objects;

abstract public class Window implements Movable, Resizable {

    private int x, y;
    private boolean active = true;
    private String text;

    public Window(int x, int y, boolean active, String text) {
        this.x = x;
        this.y = y;
        this.active = active;
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void moveRel(int dx, int dy);

    public abstract void resize(double ratio);

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return x == window.x &&
                y == window.y &&
                active == window.active &&
                Objects.equals(text, window.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, active, text);
    }
}