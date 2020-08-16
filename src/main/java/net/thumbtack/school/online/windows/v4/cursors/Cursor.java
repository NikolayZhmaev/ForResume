package net.thumbtack.school.online.windows.v4.cursors;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.iface.Movable;

import java.util.Objects;

public class Cursor extends Point implements Movable {


   private CursorForm cursorForm;

    public Cursor(int x, int y, CursorForm cursorForm) {
        super(x, y);
        setCursorForm(cursorForm);
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this(point.getX(), point.getY(), cursorForm);
    }

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
        this.cursorForm = cursorForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cursor cursor = (Cursor) o;
        return cursorForm == cursor.cursorForm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cursorForm);
    }
}
