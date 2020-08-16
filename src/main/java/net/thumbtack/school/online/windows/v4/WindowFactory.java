package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

public class WindowFactory {
    // Класс, создающий окна (фабрика окон)

    private static int rectButtonNum; // создадим два счетчика для хранения количества созданных круглых и квадратных кнопок
    private static int roundButtonNum;

    public static int getRectButtonNum() {
        return rectButtonNum;
    }

    public static void setRectButtonNum(int rectButtonNum) {
        WindowFactory.rectButtonNum = rectButtonNum;
    }

    public static int getRoundButtonNum() {
        return roundButtonNum;
    }

    public static void setRoundButtonNum(int roundButtonNum) {
        WindowFactory.roundButtonNum = roundButtonNum;
    }

    public static RectButton createRectButton(Point leftTop, Point rightBottom, WindowState state, String txt) throws WindowException {
        rectButtonNum++;
        return new RectButton(leftTop, rightBottom, state, txt);
    }

    public static RoundButton createRoundButton(Point center, int radius, WindowState state, String txt) throws WindowException {
        roundButtonNum++;
        return new RoundButton(center, radius, state, txt);
    }

    public static int getRectButtonCount() {
        return rectButtonNum;
    }

    public static int getRoundButtonCount() {
        return roundButtonNum;
    }

    public static int getWindowCount() {
        return (rectButtonNum + roundButtonNum);
    }

    public static void reset() {
        setRectButtonNum(0);
        setRoundButtonNum(0);
    }
}
