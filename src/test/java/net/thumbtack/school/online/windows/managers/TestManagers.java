package net.thumbtack.school.online.windows.managers;

import net.thumbtack.school.online.windows.v4.ComboBox;
import net.thumbtack.school.online.windows.v4.Desktop;
import net.thumbtack.school.online.windows.v4.ListBox;
//import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.RadioButton;
import net.thumbtack.school.online.windows.v4.RectButton;
import net.thumbtack.school.online.windows.v4.base.RectWindow;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowState;
import net.thumbtack.school.online.windows.v4.cursors.Cursor;
import net.thumbtack.school.online.windows.v4.cursors.CursorForm;
import net.thumbtack.school.online.windows.v4.managers.Manager;
import net.thumbtack.school.online.windows.v4.managers.ArrayManager;
import net.thumbtack.school.online.windows.v4.managers.NamedManager;
import net.thumbtack.school.online.windows.v4.managers.PairManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestManagers {

    @Test
    public void testRectButtonManager() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, "OK");
        Manager<RectButton> rectButtonManager = new Manager<>(rectButton);
        assertEquals(10, rectButtonManager.getWindow().getTopLeft().getX());
        assertEquals(20, rectButtonManager.getWindow().getTopLeft().getY());
        assertEquals(30, rectButtonManager.getWindow().getBottomRight().getX());
        assertEquals(40, rectButtonManager.getWindow().getBottomRight().getY());
        assertEquals(WindowState.ACTIVE, rectButtonManager.getWindow().getState());
    }

    @Test
    public void testRectButtonManagerMoveTo1() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, "OK");
        Manager<RectButton> rectButtonManager = new Manager<>(rectButton);
        rectButtonManager.moveTo(100, 200);
        assertEquals(WindowState.ACTIVE, rectButtonManager.getWindow().getState());
        assertEquals(100, rectButtonManager.getWindow().getTopLeft().getX());
        assertEquals(200, rectButtonManager.getWindow().getTopLeft().getY());
        assertEquals(120, rectButtonManager.getWindow().getBottomRight().getX());
        assertEquals(220, rectButtonManager.getWindow().getBottomRight().getY());
        assertEquals(21, rectButtonManager.getWindow().getHeight());
        assertEquals(21, rectButtonManager.getWindow().getWidth());
    }

    @Test
    public void testRectButtonManagerMoveTo2() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, "OK");
        Manager<RectButton> rectButtonManager = new Manager<>(rectButton);
        rectButtonManager.moveTo(new Point(100, 200));
        assertEquals(WindowState.ACTIVE, rectButtonManager.getWindow().getState());
        assertEquals(100, rectButtonManager.getWindow().getTopLeft().getX());
        assertEquals(200, rectButtonManager.getWindow().getTopLeft().getY());
        assertEquals(120, rectButtonManager.getWindow().getBottomRight().getX());
        assertEquals(220, rectButtonManager.getWindow().getBottomRight().getY());
        assertEquals(21, rectButtonManager.getWindow().getHeight());
        assertEquals(21, rectButtonManager.getWindow().getWidth());
    }

    @Test
    public void testRadioButtonManager() throws WindowException {
        Point center = new Point(10, 20);
        RadioButton radioButton = new RadioButton(center, 10, WindowState.ACTIVE, "Radio1", true);
        Manager<RadioButton> radioButtonManager = new Manager<>(radioButton);
        assertEquals(WindowState.ACTIVE, radioButtonManager.getWindow().getState());
        assertEquals(10, radioButtonManager.getWindow().getCenter().getX());
        assertEquals(20, radioButtonManager.getWindow().getCenter().getY());
        assertEquals(10, radioButtonManager.getWindow().getRadius());
        assertTrue(radioButtonManager.getWindow().isChecked());
    }

    @Test
    public void testRadioButtonManagerMoveTo() throws WindowException {
        Point center = new Point(10, 20);
        RadioButton radioButton = new RadioButton(center, 10, WindowState.ACTIVE, "Radio1", true);
        Manager<RadioButton> radioButtonManager = new Manager<>(radioButton);
        radioButtonManager.moveTo(100, 200);
        assertEquals(WindowState.ACTIVE, radioButtonManager.getWindow().getState());
        assertEquals(100, radioButtonManager.getWindow().getCenter().getX());
        assertEquals(200, radioButtonManager.getWindow().getCenter().getY());
        assertEquals(10, radioButtonManager.getWindow().getRadius());
        assertTrue(radioButtonManager.getWindow().isChecked());
    }

    @Test
    public void testWindowManager() throws WindowException {
        Point center = new Point(10, 20);
        Window window = new RadioButton(center, 10, WindowState.ACTIVE, "Radio1", true);
        Manager<Window> windowManager = new Manager<>(window);
        assertEquals(WindowState.ACTIVE, windowManager.getWindow().getState());
    }

    @Test
    public void testNullWindowManager() {
        try {
            Manager<Window> windowManager = new Manager<>(null);
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.NULL_WINDOW, ex.getWindowErrorCode());
        }
    }

    @Test
    public void testRectButtonArrayManager() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point topLeft2 = new Point(20, 10);
        Point bottomRight2 = new Point(60, 30);
        RectButton rectButton2 = new RectButton(topLeft2, bottomRight2, "OK");
        RectButton[] rects1 = new RectButton[]{rectButton1, rectButton2};
        ArrayManager<RectButton> rectButtonArrayManager1 = new ArrayManager<>(rects1);
        RectButton[] rects2 = new RectButton[]{rectButton2, rectButton1};
        ArrayManager<RectButton> rectButtonArrayManager2 = new ArrayManager<>(rects2);
        assertTrue(rectButtonArrayManager1.isSameSize(rectButtonArrayManager2));
        assertEquals(rectButton1, rectButtonArrayManager1.getWindow(0));
        assertEquals(rectButton2, rectButtonArrayManager1.getWindow(1));
        assertEquals(rectButton2, rectButtonArrayManager2.getWindow(0));
        assertEquals(rectButton1, rectButtonArrayManager2.getWindow(1));
        rectButtonArrayManager2.setWindow(rectButton1, 0);
        rectButtonArrayManager2.setWindow(rectButton2, 1);
        assertEquals(rectButton1, rectButtonArrayManager2.getWindow(0));
        assertEquals(rectButton2, rectButtonArrayManager2.getWindow(1));
    }

    @SuppressWarnings("unused")
    @Test
    public void testNullWindowArrayManager() throws WindowException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 60);
        RectButton rectButton = new RectButton(topLeft, bottomRight, "OK");
        RectButton[] rects2 = new RectButton[]{rectButton, null};
        try {
            ArrayManager<RectButton> rectButtonArrayManager2 = new ArrayManager<>(rects2);
            fail();
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.NULL_WINDOW, ex.getWindowErrorCode());
        }
    }

    @Test
    public void testRectButtonRadioButtonArrayManager() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        RectButton rectButton2 = new RectButton(topLeft2, bottomRight2, "OK");
        RectButton[] rects = new RectButton[]{rectButton1, rectButton2};
        ArrayManager<RectButton> rectButtonArrayManager = new ArrayManager<>(rects);
        Point center1 = new Point(10, 20);
        RadioButton radioButton1 = new RadioButton(center1, 10, WindowState.ACTIVE, "Radio1", true);
        Point center2 = new Point(110, 120);
        RadioButton radioButton2 = new RadioButton(center2, 10, WindowState.ACTIVE, "Radio1", true);
        RadioButton[] radios = new RadioButton[]{radioButton1, radioButton2};
        ArrayManager<RadioButton> radioButtonArrayManager = new ArrayManager<>(radios);
        assertTrue(rectButtonArrayManager.isSameSize(radioButtonArrayManager));
    }

    @Test
    public void testMixedWindowsArrayManager() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        Window rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        Window rectButton2 = new RectButton(topLeft2, bottomRight2, "OK");
        Point center1 = new Point(10, 20);
        Window radioButton1 = new RadioButton(center1, 10, WindowState.ACTIVE, "Radio1", true);
        Point center2 = new Point(1000, 120);
        Window radioButton2 = new RadioButton(center2, 10, WindowState.ACTIVE, "Radio1", true);
        Window[] windows1 = new Window[]{rectButton1, radioButton1};
        Window[] windows2 = new Window[]{rectButton2, radioButton2};
        ArrayManager<Window> arrayManager1 = new ArrayManager<>(windows1);
        ArrayManager<Window> arrayManager2 = new ArrayManager<>(windows2);
        assertTrue(arrayManager1.isSameSize(arrayManager2));
        Desktop desktop = new Desktop();
        assertTrue(arrayManager1.allWindowsFullyVisibleOnDesktop(desktop));
        assertFalse(arrayManager2.allWindowsFullyVisibleOnDesktop(desktop));
        assertTrue(arrayManager2.anyWindowFullyVisibleOnDesktop(desktop));
        assertEquals(radioButton1, arrayManager1.getFirstWindowFromCursor(new Cursor(3, 13, CursorForm.ARROW)));
        assertNull(arrayManager1.getFirstWindowFromCursor(new Cursor(-10, 20, CursorForm.ARROW)));
    }

    @Test
    public void testPairManager1() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point center1 = new Point(10, 20);
        RadioButton radioButton1 = new RadioButton(center1, 10, WindowState.ACTIVE, "Radio1", true);
        PairManager<RectButton, RadioButton> pairManager1 = new PairManager<>(rectButton1, radioButton1);
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        RectButton rectButton2 = new RectButton(topLeft2, bottomRight2, "OK");
        Point center2 = new Point(110, 120);
        RadioButton radioButton2 = new RadioButton(center2, 10, WindowState.ACTIVE, "Radio1", true);
        PairManager<RectButton, RadioButton> pairManager2 = new PairManager<>(rectButton2, radioButton2);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allWindowsFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allWindowsFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testPairManager2() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        Window rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point center1 = new Point(10, 20);
        Window radioButton1 = new RadioButton(center1, 10, WindowState.ACTIVE, "Radio1", true);
        PairManager<Window, Window> pairManager1 = new PairManager<>(rectButton1, radioButton1);
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        Window rectButton2 = new RectButton(topLeft2, bottomRight2, "OK");
        Point center2 = new Point(110, 120);
        Window radioButton2 = new RadioButton(center2, 10, WindowState.ACTIVE, "Radio1", true);
        PairManager<Window, Window> pairManager2 = new PairManager<>(rectButton2, radioButton2);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allWindowsFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allWindowsFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testPairManager3() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        Point center1 = new Point(10, 20);
        RadioButton radioButton1 = new RadioButton(center1, 10, WindowState.ACTIVE, "Radio1", true);
        PairManager<RectButton, RadioButton> pairManager1 = new PairManager<>(rectButton1, radioButton1);
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        ListBox listBox = new ListBox(topLeft2, bottomRight2, null);
        Point topLeft3 = new Point(210, 220);
        Point bottomRight3 = new Point(230, 240);
        ComboBox comboBox = new ComboBox(topLeft3, bottomRight3, null, null);
        PairManager<ListBox, ComboBox> pairManager2 = new PairManager<>(listBox, comboBox);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allWindowsFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allWindowsFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testNullWindowPairManager() throws WindowException {
        boolean failed = false;
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Window rectButton = new RectButton(topLeft, bottomRight, "OK");
        try {
            PairManager<Window, Window> windowPairManager = new PairManager<>(rectButton, null);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.NULL_WINDOW, ex.getWindowErrorCode());
        }
        try {
            PairManager<Window, Window> windowPairManager = new PairManager<>(null, rectButton);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.NULL_WINDOW, ex.getWindowErrorCode());
        }
        if (failed) {
            fail();
        }

    }

    @Test
    public void testRectWindowNamedManager1() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        NamedManager<RectWindow> rectWindowNamedManager = new NamedManager<>(rectButton1, "Manager1");
        assertEquals("Manager1", rectWindowNamedManager.getName());
    }

    @Test
    public void testRectWindowNamedManager2() throws WindowException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectButton rectButton1 = new RectButton(topLeft1, bottomRight1, "OK");
        NamedManager<Window> rectWindowNamedManager = new NamedManager<>(rectButton1, "Manager1");
        assertEquals("Manager1", rectWindowNamedManager.getName());
    }

    @Test
    public void testNullWindowNamedManager() {
        try {
            NamedManager<Window> windowManager = new NamedManager<>(null, "OK");
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.NULL_WINDOW, ex.getWindowErrorCode());
        }
    }

/* 	@Test
	public void testMustNotBeCompiled() {
		Manager<String> stringManager = new Manager<String>("My String");
	}
*/
}


