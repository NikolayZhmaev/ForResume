package net.thumbtack.school.online.windows.v4.managers;

import net.thumbtack.school.online.windows.v4.Desktop;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.cursors.Cursor;


public class ArrayManager<T extends Window> {
    private T[] windows;

    public T[] getWindows() {
        return windows;
    }

    public void setWindows(T[] windows) {
        this.windows = windows;
    }

    public ArrayManager(T[] windows) throws WindowException {
        checkArrayWindows(windows);
        setWindows(windows);
    }

    private void checkNum(int num) throws WindowException { // напишем метод для проверки передаваемого индекса
        if (num < 0 || num >= windows.length) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
    }

    private void checkArrayWindows(T[] windows) throws WindowException {
        for (T window : windows) {
            if (window == null) {
                throw new WindowException(WindowErrorCode.NULL_WINDOW);
            }
        }
    }

    public void setWindow(T window, int num) throws WindowException {
        checkNum(num);
        windows[num] = window;
    }

    public T getWindow(int num) throws WindowException {
        checkNum(num);
        return windows[num];
    }

    public boolean isSameSize(ArrayManager arrayManager) {
        return this.windows.length == arrayManager.getWindows().length;
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : windows) {
            if (!window.isFullyVisibleOnDesktop(desktop)) {
                return false;
            }
        }
        return true;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop) {
        for (T window : this.windows) {
            if (window.isFullyVisibleOnDesktop(desktop)) {
                return true;
            }
        }
        return false;
    }


    public Window getFirstWindowFromCursor(Cursor cursor) {
        for (T window : this.windows) {
            if (window.isInside(cursor)) {
                return window;
            }
        }
        return null;
    }
}
