package net.thumbtack.school.online.windows.v4.managers;


import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;


public class Manager<T extends Window> {

    private T window;

    public void checWindow(Window window) throws WindowException {
        if (window == null) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
    }

    public Manager(T window) throws WindowException {
        setWindow(window);
    }

    public T getWindow() {
        return window;
    }

    public void setWindow(T window) throws WindowException {
        checWindow(window);
        this.window = window;
    }

    public void moveTo(int x, int y) {
        window.moveTo(x, y);
    }

    public void moveTo(Point point) {
        window.moveTo(point);
    }

}
