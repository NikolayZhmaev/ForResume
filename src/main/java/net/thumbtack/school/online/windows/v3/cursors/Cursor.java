package net.thumbtack.school.online.windows.v3.cursors;

import net.thumbtack.school.online.windows.v3.Point;
import net.thumbtack.school.online.windows.v3.iface.Movable;

import java.util.Objects;

public class Cursor implements Movable {

    private int x, y, cursorForm; // создадим поля для хранения координат курсора и его формы

    public Cursor(int x, int y, int cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, int cursorForm) {
        this(point.getX(), point.getY(), cursorForm);
    }

    public int getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(int cursorForm) {
        this.cursorForm = cursorForm;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursor cursor = (Cursor) o;
        return x == cursor.x &&
                y == cursor.y &&
                cursorForm == cursor.cursorForm;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, cursorForm);
    }
}
