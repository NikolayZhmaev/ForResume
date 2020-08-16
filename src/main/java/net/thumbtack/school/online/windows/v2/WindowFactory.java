package net.thumbtack.school.online.windows.v2;

public class WindowFactory {

   // Класс, создающий окна (фабрика окон)

	static int rectButtonNum; // создадим два счетчика для хранения количества созданных круглых и квадратных кнопок
	static int roundButtonNum;


	public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active, String txt) {
		rectButtonNum++;
		return new RectButton(leftTop, rightBottom, active, txt);
	}

    public static RoundButton createRoundButton(Point center, int radius, boolean active, String txt) {
		roundButtonNum++;
		return new RoundButton(center, radius, active, txt);
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
		rectButtonNum = 0;
		roundButtonNum = 0;
	}
 }
