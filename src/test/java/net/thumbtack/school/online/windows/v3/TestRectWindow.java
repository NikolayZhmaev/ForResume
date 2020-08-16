package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.windows.v3.base.RectWindow;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRectWindow {
    @Test
    public void testRectWindow() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectWindow rectWindow = new RectButton(topLeft, bottomRight, false, "OK");
        assertEquals(10, rectWindow.getTopLeft().getX());
        assertEquals(20, rectWindow.getTopLeft().getY());
        assertEquals(30, rectWindow.getBottomRight().getX());
        assertEquals(40, rectWindow.getBottomRight().getY());
        assertEquals(21, rectWindow.getWidth());
        assertEquals(21, rectWindow.getHeight());
    }

    @Test
    public void testSetRectWindow() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.setTopLeft(new Point(0, 0));
        rectWindow.setBottomRight(new Point(200, 100));
        rectWindow.setActive(false);
        assertEquals(0, rectWindow.getTopLeft().getX());
        assertEquals(0, rectWindow.getTopLeft().getY());
        assertEquals(200, rectWindow.getBottomRight().getX());
        assertEquals(100, rectWindow.getBottomRight().getY());
        assertEquals(201, rectWindow.getWidth());
        assertEquals(101, rectWindow.getHeight());
    }

    @Test
    public void testMoveToRectWindow1() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveTo(100, 50);
        assertEquals(100, rectWindow.getTopLeft().getX());
        assertEquals(50, rectWindow.getTopLeft().getY());
        assertEquals(129, rectWindow.getBottomRight().getX());
        assertEquals(89, rectWindow.getBottomRight().getY());
        assertEquals(30, rectWindow.getWidth());
        assertEquals(40, rectWindow.getHeight());
    }

    @Test
    public void testMoveToRectWindow2() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveTo(new Point(100, 50));
        assertEquals(100, rectWindow.getTopLeft().getX());
        assertEquals(50, rectWindow.getTopLeft().getY());
        assertEquals(129, rectWindow.getBottomRight().getX());
        assertEquals(89, rectWindow.getBottomRight().getY());
        assertEquals(30, rectWindow.getWidth());
        assertEquals(40, rectWindow.getHeight());
    }

    @Test
    public void testMoveRelRectWindow() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        rectWindow.moveRel(100, 50);
        assertEquals(110, rectWindow.getTopLeft().getX());
        assertEquals(70, rectWindow.getTopLeft().getY());
        assertEquals(139, rectWindow.getBottomRight().getX());
        assertEquals(109, rectWindow.getBottomRight().getY());
        assertEquals(30, rectWindow.getWidth());
        assertEquals(40, rectWindow.getHeight());
    }

    @Test
    public void testIsPointInsideRectWindow1() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        assertTrue(rectWindow.isInside(20, 30));
        assertTrue(rectWindow.isInside(10, 30));
        assertTrue(rectWindow.isInside(30, 30));
        assertTrue(rectWindow.isInside(10, 59));
        assertFalse(rectWindow.isInside(10, 60));
        assertFalse(rectWindow.isInside(0, 0));
        assertFalse(rectWindow.isInside(10, 100));
        assertFalse(rectWindow.isInside(-10, 20));
        assertFalse(rectWindow.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideRectWindow2() {
        RectWindow rectWindow = new RectButton(10, 20, 30, 40, "OK");
        assertTrue(rectWindow.isInside(new Point(20, 30)));
        assertTrue(rectWindow.isInside(new Point(10, 30)));
        assertTrue(rectWindow.isInside(new Point(30, 30)));
        assertTrue(rectWindow.isInside(new Point(10, 59)));
        assertFalse(rectWindow.isInside(new Point(10, 60)));
        assertFalse(rectWindow.isInside(new Point(0, 0)));
        assertFalse(rectWindow.isInside(new Point(10, 100)));
        assertFalse(rectWindow.isInside(new Point(-10, 20)));
        assertFalse(rectWindow.isInside(new Point(10, -20)));
    }

    @Test
    public void testResizeRectWindow() {
        RectWindow rectWindow1 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow1.resize(2);
        assertEquals(10, rectWindow1.getTopLeft().getX());
        assertEquals(20, rectWindow1.getTopLeft().getY());
        assertEquals(69, rectWindow1.getBottomRight().getX());
        assertEquals(99, rectWindow1.getBottomRight().getY());
        assertEquals(60, rectWindow1.getWidth());
        assertEquals(80, rectWindow1.getHeight());
        RectWindow rectWindow2 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow2.resize(0.5);
        assertEquals(10, rectWindow2.getTopLeft().getX());
        assertEquals(20, rectWindow2.getTopLeft().getY());
        assertEquals(24, rectWindow2.getBottomRight().getX());
        assertEquals(39, rectWindow2.getBottomRight().getY());
        assertEquals(15, rectWindow2.getWidth());
        assertEquals(20, rectWindow2.getHeight());
        RectWindow rectWindow3 = new RectButton(10, 20, 4, 4, "OK");
        rectWindow3.resize(0.5);
        assertEquals(10, rectWindow3.getTopLeft().getX());
        assertEquals(20, rectWindow3.getTopLeft().getY());
        assertEquals(11, rectWindow3.getBottomRight().getX());
        assertEquals(21, rectWindow3.getBottomRight().getY());
        assertEquals(2, rectWindow3.getWidth());
        assertEquals(2, rectWindow3.getHeight());
        RectWindow rectWindow4 = new RectButton(10, 20, 30, 40, "OK");
        rectWindow4.resize(0.01);
        assertEquals(10, rectWindow4.getTopLeft().getX());
        assertEquals(20, rectWindow4.getTopLeft().getY());
        assertEquals(10, rectWindow4.getBottomRight().getX());
        assertEquals(20, rectWindow4.getBottomRight().getY());
        assertEquals(1, rectWindow4.getWidth());
        assertEquals(1, rectWindow4.getHeight());
    }

}
