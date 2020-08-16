package net.thumbtack.school.online.windows.v1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRectButton {

    @Test
    public void testRectButton1() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight, false);
        assertEquals(10, rectButton.getTopLeft().getX());
        assertEquals(20, rectButton.getTopLeft().getY());
        assertEquals(30, rectButton.getBottomRight().getX());
        assertEquals(40, rectButton.getBottomRight().getY());
        assertEquals(21, rectButton.getWidth());
        assertEquals(21, rectButton.getHeight());
        assertFalse(rectButton.isActive());
    }

    @Test
    public void testRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40, false);
        assertEquals(10, rectButton.getTopLeft().getX());
        assertEquals(20, rectButton.getTopLeft().getY());
        assertEquals(39, rectButton.getBottomRight().getX());
        assertEquals(59, rectButton.getBottomRight().getY());
        assertEquals(30, rectButton.getWidth());
        assertEquals(40, rectButton.getHeight());
        assertFalse(rectButton.isActive());
    }

    @Test
    public void testRectButton3() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton rectButton = new RectButton(topLeft, bottomRight);
        assertEquals(10, rectButton.getTopLeft().getX());
        assertEquals(20, rectButton.getTopLeft().getY());
        assertEquals(30, rectButton.getBottomRight().getX());
        assertEquals(40, rectButton.getBottomRight().getY());
        assertEquals(21, rectButton.getWidth());
        assertEquals(21, rectButton.getHeight());
        assertTrue(rectButton.isActive());
    }

    @Test
    public void testRectButton4() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        assertEquals(10, rectButton.getTopLeft().getX());
        assertEquals(20, rectButton.getTopLeft().getY());
        assertEquals(39, rectButton.getBottomRight().getX());
        assertEquals(59, rectButton.getBottomRight().getY());
        assertEquals(30, rectButton.getWidth());
        assertEquals(40, rectButton.getHeight());
        assertTrue(rectButton.isActive());
    }

    @Test
    public void testSetRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        rectButton.setTopLeft(new Point(0, 0));
        rectButton.setBottomRight(new Point(200, 100));
        rectButton.setActive(false);
        assertEquals(0, rectButton.getTopLeft().getX());
        assertEquals(0, rectButton.getTopLeft().getY());
        assertEquals(200, rectButton.getBottomRight().getX());
        assertEquals(100, rectButton.getBottomRight().getY());
        assertEquals(201, rectButton.getWidth());
        assertEquals(101, rectButton.getHeight());
        assertFalse(rectButton.isActive());
    }

    @Test
    public void testMoveToRectButton1() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        rectButton.moveTo(100, 50);
        assertEquals(100, rectButton.getTopLeft().getX());
        assertEquals(50, rectButton.getTopLeft().getY());
        assertEquals(129, rectButton.getBottomRight().getX());
        assertEquals(89, rectButton.getBottomRight().getY());
        assertEquals(30, rectButton.getWidth());
        assertEquals(40, rectButton.getHeight());
    }

    @Test
    public void testMoveToRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        rectButton.moveTo(new Point(100, 50));
        assertEquals(100, rectButton.getTopLeft().getX());
        assertEquals(50, rectButton.getTopLeft().getY());
        assertEquals(129, rectButton.getBottomRight().getX());
        assertEquals(89, rectButton.getBottomRight().getY());
        assertEquals(30, rectButton.getWidth());
        assertEquals(40, rectButton.getHeight());
    }

    @Test
    public void testMoveRelRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        rectButton.moveRel(100, 50);
        assertEquals(110, rectButton.getTopLeft().getX());
        assertEquals(70, rectButton.getTopLeft().getY());
        assertEquals(139, rectButton.getBottomRight().getX());
        assertEquals(109, rectButton.getBottomRight().getY());
        assertEquals(30, rectButton.getWidth());
        assertEquals(40, rectButton.getHeight());
    }

    @Test
    public void testResizeRectButton() {
        RectButton rectButton1 = new RectButton(10, 20, 30, 40);
        rectButton1.resize(2);
        assertEquals(10, rectButton1.getTopLeft().getX());
        assertEquals(20, rectButton1.getTopLeft().getY());
        assertEquals(69, rectButton1.getBottomRight().getX());
        assertEquals(99, rectButton1.getBottomRight().getY());
        assertEquals(60, rectButton1.getWidth());
        assertEquals(80, rectButton1.getHeight());
        RectButton rectButton2 = new RectButton(10, 20, 30, 40);
        rectButton2.resize(0.5);
        assertEquals(10, rectButton2.getTopLeft().getX());
        assertEquals(20, rectButton2.getTopLeft().getY());
        assertEquals(24, rectButton2.getBottomRight().getX());
        assertEquals(39, rectButton2.getBottomRight().getY());
        assertEquals(15, rectButton2.getWidth());
        assertEquals(20, rectButton2.getHeight());
        RectButton rectButton3 = new RectButton(10, 20, 4, 4);
        rectButton3.resize(0.5);
        assertEquals(10, rectButton3.getTopLeft().getX());
        assertEquals(20, rectButton3.getTopLeft().getY());
        assertEquals(11, rectButton3.getBottomRight().getX());
        assertEquals(21, rectButton3.getBottomRight().getY());
        assertEquals(2, rectButton3.getWidth());
        assertEquals(2, rectButton3.getHeight());
        RectButton rectButton4 = new RectButton(10, 20, 30, 40);
        rectButton4.resize(0.01);
        assertEquals(10, rectButton4.getTopLeft().getX());
        assertEquals(20, rectButton4.getTopLeft().getY());
        assertEquals(10, rectButton4.getBottomRight().getX());
        assertEquals(20, rectButton4.getBottomRight().getY());
        assertEquals(1, rectButton4.getWidth());
        assertEquals(1, rectButton4.getHeight());
    }

    @Test
    public void testIsPointInsideRectButton1() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        assertTrue(rectButton.isInside(20, 30));
        assertTrue(rectButton.isInside(10, 30));
        assertTrue(rectButton.isInside(30, 30));
        assertTrue(rectButton.isInside(10, 59));
        assertFalse(rectButton.isInside(10, 60));
        assertFalse(rectButton.isInside(0, 0));
        assertFalse(rectButton.isInside(10, 100));
        assertFalse(rectButton.isInside(-10, 20));
        assertFalse(rectButton.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideRectButton2() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        assertTrue(rectButton.isInside(new Point(20, 30)));
        assertTrue(rectButton.isInside(new Point(10, 30)));
        assertTrue(rectButton.isInside(new Point(30, 30)));
        assertTrue(rectButton.isInside(new Point(10, 59)));
        assertFalse(rectButton.isInside(new Point(10, 60)));
        assertFalse(rectButton.isInside(new Point(0, 0)));
        assertFalse(rectButton.isInside(new Point(10, 100)));
        assertFalse(rectButton.isInside(new Point(-10, 20)));
        assertFalse(rectButton.isInside(new Point(10, -20)));
    }

    @Test
    public void testIsIntersectsRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        assertTrue(rectButton.isIntersects(new RectButton(15, 25, 25, 35)));
        assertTrue(rectButton.isIntersects(new RectButton(-10, 20, 30, 40)));
        assertTrue(rectButton.isIntersects(new RectButton(10, 20, 50, 40)));
        assertTrue(rectButton.isIntersects(new RectButton(-10, 20, 50, 40)));
        assertTrue(rectButton.isIntersects(new RectButton(10, -20, 30, 41)));
        assertFalse(rectButton.isIntersects(new RectButton(10, -20, 30, 40)));
        assertTrue(rectButton.isIntersects(new RectButton(10, 20, 30, 60)));
        assertTrue(rectButton.isIntersects(new RectButton(-10, -20, 50, 60)));
        assertTrue(rectButton.isIntersects(new RectButton(0, 10, 20, 30)));
        assertTrue(rectButton.isIntersects(new RectButton(20, 30, 40, 50)));
        assertFalse(rectButton.isIntersects(new RectButton(-40, 20, -30, 40)));
        assertFalse(rectButton.isIntersects(new RectButton(110, 120, 30, 40)));
        assertFalse(rectButton.isIntersects(new RectButton(10, 120, 30, 40)));
        assertFalse(rectButton.isIntersects(new RectButton(10, -40, 30, 20)));
        assertTrue(rectButton.isIntersects(new RectButton(15, 15, 25, 50)));
    }

    @Test
    public void testIsRectButtonInsideRectButton() {
        RectButton rectButton = new RectButton(10, 20, 30, 40);
        assertTrue(rectButton.isInside(new RectButton(15, 25, 25, 35)));
        assertFalse(rectButton.isInside(new RectButton(-40, 20, 30, 40)));
        assertFalse(rectButton.isInside(new RectButton(110, 120, 130, 140)));
        assertFalse(rectButton.isInside(new RectButton(10, 120, 30, 40)));
        assertFalse(rectButton.isInside(new RectButton(10, -40, 30, 20)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertTrue(new RectButton(15, 25, 25, 35).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RectButton(0, 0, 639, 479).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton(200, 200, 640, 480).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton(-200, -200, 640, 480).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton(-1200, 700, 1199, 480).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton(200, -200, 100, 100).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RectButton(200, 300, 100, 100).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton(200, 700, 100, 100).isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testRectButtonsAreEqual() {
        RectButton rect1 = new RectButton(10, 20, 30, 40);
        RectButton rect2 = new RectButton(10, 20, 30, 40);
        RectButton rect3 = new RectButton(20, 30, 40, 50);
        assertNotEquals(rect1, null);
        assertEquals(rect1, rect1);
        assertNotEquals(rect1, null);
        assertEquals(rect1, rect2);
        assertNotEquals(rect1, rect3);
    }

}
