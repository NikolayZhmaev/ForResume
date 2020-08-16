package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.iface.Movable;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.iface.Resizable;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWindow {

    @Test
    public void testIsPointInsideWindow1() throws WindowException {
        Window window = new RectButton(10, 20, 30, 40, "OK");
        assertTrue(window.isInside(20, 30));
        assertTrue(window.isInside(10, 30));
        assertTrue(window.isInside(30, 30));
        assertTrue(window.isInside(10, 59));
        assertFalse(window.isInside(10, 60));
        assertFalse(window.isInside(0, 0));
        assertFalse(window.isInside(10, 100));
        assertFalse(window.isInside(-10, 20));
        assertFalse(window.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideWindow2() throws WindowException {
        Window window = new RectButton(10, 20, 30, 40, "OK");
        assertTrue(window.isInside(new Point(20, 30)));
        assertTrue(window.isInside(new Point(10, 30)));
        assertTrue(window.isInside(new Point(30, 30)));
        assertTrue(window.isInside(new Point(10, 59)));
        assertFalse(window.isInside(new Point(10, 60)));
        assertFalse(window.isInside(new Point(0, 0)));
        assertFalse(window.isInside(new Point(10, 100)));
        assertFalse(window.isInside(new Point(-10, 20)));
        assertFalse(window.isInside(new Point(10, -20)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() throws WindowException {
        Desktop desktop = new Desktop();
        Window window = new RectButton(15, 25, 25, 35, "OK");
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(0, 0, 639, 479, "OK");
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(200, 200, 640, 480, "OK");
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(-200, -200, 640, 480, "OK");
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(-1200, 700, 1199, 480, "OK");
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(200, -200, 100, 100, "OK");
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(200, 300, 100, 100, "OK");
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        window = new RectButton(200, 700, 100, 100, "OK");
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testMoveWindow() throws WindowException {
        Desktop desktop = new Desktop();
        Window window = new RectButton(0, 0, 639, 479, "OK");
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        window.moveTo(-100, 100);
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        Movable movable = window;
        movable.moveTo(739, 479);
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        movable.moveTo(0, 479);
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        movable.moveTo(739, 0);
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
        movable.moveRel(-739, 0);
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testResizeWindow() throws WindowException {
        Desktop desktop = new Desktop();
        Window window = new RectButton(0, 0, 320, 240, "OK");
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        Resizable resizable = window;
        resizable.resize(2);
        assertTrue(window.isFullyVisibleOnDesktop(desktop));
        resizable.resize(2);
        assertFalse(window.isFullyVisibleOnDesktop(desktop));
    }
}
