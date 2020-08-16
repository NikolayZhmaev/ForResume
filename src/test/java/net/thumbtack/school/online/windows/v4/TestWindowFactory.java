package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWindowFactory {

    @Test
    @SuppressWarnings("unused")
    public void testWindowFactory() throws WindowException {
        RectButton rectButton1 = WindowFactory.createRectButton(new Point(10, 20), new Point(30, 40), WindowState.ACTIVE, "OK");
        RectButton rectButton2 = WindowFactory.createRectButton(new Point(110, 120), new Point(130, 140), WindowState.ACTIVE, "OK");
        RoundButton roundButton1 = WindowFactory.createRoundButton(new Point(10, 20), 10, WindowState.ACTIVE, "OK");
        RoundButton roundButton2 = WindowFactory.createRoundButton(new Point(110, 120), 10, WindowState.ACTIVE, "OK");
        RoundButton roundButton3 = WindowFactory.createRoundButton(new Point(210, 220), 10, WindowState.ACTIVE, "OK");
        assertEquals(2, WindowFactory.getRectButtonCount());
        assertEquals(3, WindowFactory.getRoundButtonCount());
        assertEquals(5, WindowFactory.getWindowCount());
        WindowFactory.reset();
        assertEquals(0, WindowFactory.getWindowCount());
    }

}
