package net.thumbtack.school.online.windows.v4.managers;

import net.thumbtack.school.online.windows.v4.Desktop;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;

public class PairManager<T extends Window, V extends Window> {
    private T firstWindow;
    private V secondWindow;


    public T getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(T firstWindow) {
        this.firstWindow = firstWindow;
    }

    public V getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(V secondWindow) {
        this.secondWindow = secondWindow;
    }

    public void checWindow(Window window) throws WindowException {
        if (window == null) {
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
    }

    public PairManager(T firstWindow, V secondWindow) throws WindowException {

        checWindow(firstWindow);
        checWindow(secondWindow);
        setFirstWindow(firstWindow);
        setSecondWindow(secondWindow);
    }


    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        return (getFirstWindow().isFullyVisibleOnDesktop(desktop) && getSecondWindow().isFullyVisibleOnDesktop(desktop));
    }


    public boolean allWindowsFullyVisibleOnDesktop(PairManager pairManager, Desktop desktop) {
        return (allWindowsFullyVisibleOnDesktop(desktop)
                && pairManager.allWindowsFullyVisibleOnDesktop(desktop));
    }

    public static boolean allWindowsFullyVisibleOnDesktop(PairManager pairManager, PairManager pairManager2, Desktop desktop) {
        return (pairManager.allWindowsFullyVisibleOnDesktop(desktop))
                && pairManager2.allWindowsFullyVisibleOnDesktop(desktop);
    }


}
