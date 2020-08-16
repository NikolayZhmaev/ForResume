package net.thumbtack.school.online.windows.v3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWindowFactory {

    @Test
    @SuppressWarnings("unused")
    public void testWindowFactory() {
        RectButton rectButton1 = WindowFactory.createRectButton(new Point(10, 20), new Point(30, 40), true, "OK");
        RectButton rectButton2 = WindowFactory.createRectButton(new Point(110, 120), new Point(130, 140), true, "OK");
        RoundButton roundButton1 = WindowFactory.createRoundButton(new Point(10, 20), 10, true, "OK");
        RoundButton roundButton2 = WindowFactory.createRoundButton(new Point(110, 120), 10, true, "OK");
        RoundButton roundButton3 = WindowFactory.createRoundButton(new Point(210, 220), 10, true, "OK");
        assertEquals(2, WindowFactory.getRectButtonCount());
        assertEquals(3, WindowFactory.getRoundButtonCount());
        assertEquals(5, WindowFactory.getWindowCount());
        WindowFactory.reset();
        assertEquals(0, WindowFactory.getWindowCount());
    }

}
