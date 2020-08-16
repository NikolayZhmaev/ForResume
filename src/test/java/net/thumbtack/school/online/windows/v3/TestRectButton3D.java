package net.thumbtack.school.online.windows.v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRectButton3D {

    @Test
    public void testRectButton3D1() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton3D rectButton3D = new RectButton3D(topLeft, bottomRight, false, "OK", 10);
        assertEquals(10, rectButton3D.getTopLeft().getX());
        assertEquals(20, rectButton3D.getTopLeft().getY());
        assertEquals(30, rectButton3D.getBottomRight().getX());
        assertEquals(40, rectButton3D.getBottomRight().getY());
        assertEquals(21, rectButton3D.getWidth());
        assertEquals(21, rectButton3D.getHeight());
        assertFalse(rectButton3D.isActive());
        assertEquals("OK", rectButton3D.getText());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testRectButton3D2() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, false, "OK", 10);
        assertEquals(10, rectButton3D.getTopLeft().getX());
        assertEquals(20, rectButton3D.getTopLeft().getY());
        assertEquals(39, rectButton3D.getBottomRight().getX());
        assertEquals(59, rectButton3D.getBottomRight().getY());
        assertEquals(30, rectButton3D.getWidth());
        assertEquals(40, rectButton3D.getHeight());
        assertFalse(rectButton3D.isActive());
        assertEquals("OK", rectButton3D.getText());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testRectButton3D3() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectButton3D rectButton3D = new RectButton3D(topLeft, bottomRight, "OK", 10);
        assertEquals(10, rectButton3D.getTopLeft().getX());
        assertEquals(20, rectButton3D.getTopLeft().getY());
        assertEquals(30, rectButton3D.getBottomRight().getX());
        assertEquals(40, rectButton3D.getBottomRight().getY());
        assertEquals(21, rectButton3D.getWidth());
        assertEquals(21, rectButton3D.getHeight());
        assertTrue(rectButton3D.isActive());
        assertEquals("OK", rectButton3D.getText());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testRectButton3D4() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertEquals(10, rectButton3D.getTopLeft().getX());
        assertEquals(20, rectButton3D.getTopLeft().getY());
        assertEquals(39, rectButton3D.getBottomRight().getX());
        assertEquals(59, rectButton3D.getBottomRight().getY());
        assertEquals(30, rectButton3D.getWidth());
        assertEquals(40, rectButton3D.getHeight());
        assertTrue(rectButton3D.isActive());
        assertEquals("OK", rectButton3D.getText());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testSetRectButton3D() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D.setTopLeft(new Point(0, 0));
        rectButton3D.setBottomRight(new Point(200, 100));
        rectButton3D.setZHeight(20);
        rectButton3D.setActive(false);
        assertEquals(0, rectButton3D.getTopLeft().getX());
        assertEquals(0, rectButton3D.getTopLeft().getY());
        assertEquals(200, rectButton3D.getBottomRight().getX());
        assertEquals(100, rectButton3D.getBottomRight().getY());
        assertEquals(201, rectButton3D.getWidth());
        assertEquals(101, rectButton3D.getHeight());
        assertFalse(rectButton3D.isActive());
        assertEquals("OK", rectButton3D.getText());
        assertEquals(20, rectButton3D.getZHeight());
    }

    @Test
    public void testMoveToRectButton3D1() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D.moveTo(100, 50);
        assertEquals(100, rectButton3D.getTopLeft().getX());
        assertEquals(50, rectButton3D.getTopLeft().getY());
        assertEquals(129, rectButton3D.getBottomRight().getX());
        assertEquals(89, rectButton3D.getBottomRight().getY());
        assertEquals(30, rectButton3D.getWidth());
        assertEquals(40, rectButton3D.getHeight());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testMoveToRectButton3D2() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D.moveTo(new Point(100, 50));
        assertEquals(100, rectButton3D.getTopLeft().getX());
        assertEquals(50, rectButton3D.getTopLeft().getY());
        assertEquals(129, rectButton3D.getBottomRight().getX());
        assertEquals(89, rectButton3D.getBottomRight().getY());
        assertEquals(30, rectButton3D.getWidth());
        assertEquals(40, rectButton3D.getHeight());
        assertEquals(10, rectButton3D.getZHeight());
    }

    @Test
    public void testMoveRelRectButton3D() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D.moveRel(100, 50);
        assertEquals(110, rectButton3D.getTopLeft().getX());
        assertEquals(70, rectButton3D.getTopLeft().getY());
        assertEquals(139, rectButton3D.getBottomRight().getX());
        assertEquals(109, rectButton3D.getBottomRight().getY());
        assertEquals(30, rectButton3D.getWidth());
        assertEquals(40, rectButton3D.getHeight());
    }

    @Test
    public void testResizeRectButton3D() {
        RectButton3D rectButton3D1 = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D1.resize(2);
        assertEquals(10, rectButton3D1.getTopLeft().getX());
        assertEquals(20, rectButton3D1.getTopLeft().getY());
        assertEquals(69, rectButton3D1.getBottomRight().getX());
        assertEquals(99, rectButton3D1.getBottomRight().getY());
        assertEquals(60, rectButton3D1.getWidth());
        assertEquals(80, rectButton3D1.getHeight());
        RectButton3D rectButton3D2 = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D2.resize(0.5);
        assertEquals(10, rectButton3D2.getTopLeft().getX());
        assertEquals(20, rectButton3D2.getTopLeft().getY());
        assertEquals(24, rectButton3D2.getBottomRight().getX());
        assertEquals(39, rectButton3D2.getBottomRight().getY());
        assertEquals(15, rectButton3D2.getWidth());
        assertEquals(20, rectButton3D2.getHeight());
        RectButton3D rectButton3D3 = new RectButton3D(10, 20, 4, 4, "OK", 10);
        rectButton3D3.resize(0.5);
        assertEquals(10, rectButton3D3.getTopLeft().getX());
        assertEquals(20, rectButton3D3.getTopLeft().getY());
        assertEquals(11, rectButton3D3.getBottomRight().getX());
        assertEquals(21, rectButton3D3.getBottomRight().getY());
        assertEquals(2, rectButton3D3.getWidth());
        assertEquals(2, rectButton3D3.getHeight());
        RectButton3D rectButton3D4 = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D4.resize(0.01);
        assertEquals(10, rectButton3D4.getTopLeft().getX());
        assertEquals(20, rectButton3D4.getTopLeft().getY());
        assertEquals(10, rectButton3D4.getBottomRight().getX());
        assertEquals(20, rectButton3D4.getBottomRight().getY());
        assertEquals(1, rectButton3D4.getWidth());
        assertEquals(1, rectButton3D4.getHeight());
    }

    @Test
    public void testIsPointInsideRectButton3D1() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isInside(20, 30));
        assertTrue(rectButton3D.isInside(10, 30));
        assertTrue(rectButton3D.isInside(30, 30));
        assertTrue(rectButton3D.isInside(10, 59));
        assertFalse(rectButton3D.isInside(10, 60));
        assertFalse(rectButton3D.isInside(0, 0));
        assertFalse(rectButton3D.isInside(10, 100));
        assertFalse(rectButton3D.isInside(-10, 20));
        assertFalse(rectButton3D.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideRectButton3D2() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isInside(new Point(20, 30)));
        assertTrue(rectButton3D.isInside(new Point(10, 30)));
        assertTrue(rectButton3D.isInside(new Point(30, 30)));
        assertTrue(rectButton3D.isInside(new Point(10, 59)));
        assertFalse(rectButton3D.isInside(new Point(10, 60)));
        assertFalse(rectButton3D.isInside(new Point(0, 0)));
        assertFalse(rectButton3D.isInside(new Point(10, 100)));
        assertFalse(rectButton3D.isInside(new Point(-10, 20)));
        assertFalse(rectButton3D.isInside(new Point(10, -20)));
    }

    @Test
    public void testIsIntersectsRectButton() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isIntersects(new RectButton(15, 25, 25, 35, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(-10, 20, 30, 40, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(10, 20, 50, 40, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(-10, 20, 50, 40, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(10, -20, 30, 41, "OK")));
        assertFalse(rectButton3D.isIntersects(new RectButton(10, -20, 30, 40, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(10, 20, 30, 60, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(-10, -20, 50, 60, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(0, 10, 20, 30, "OK")));
        assertTrue(rectButton3D.isIntersects(new RectButton(20, 30, 40, 50, "OK")));
        assertFalse(rectButton3D.isIntersects(new RectButton(-40, 20, -30, 40, "OK")));
        assertFalse(rectButton3D.isIntersects(new RectButton(110, 120, 30, 40, "OK")));
        assertFalse(rectButton3D.isIntersects(new RectButton(10, 120, 30, 40, "OK")));
        assertFalse(rectButton3D.isIntersects(new RectButton(10, -40, 30, 20, "OK")));
    }

    @Test
    public void testIsIntersectsRectButton3D() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isIntersects(new RectButton3D(15, 25, 25, 35, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(-10, 20, 30, 40, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(10, 20, 50, 40, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(-10, 20, 50, 40, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(10, -20, 30, 41, "OK", 10)));
        assertFalse(rectButton3D.isIntersects(new RectButton3D(10, -20, 30, 40, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(10, 20, 30, 60, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(-10, -20, 50, 60, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(0, 10, 20, 30, "OK", 10)));
        assertTrue(rectButton3D.isIntersects(new RectButton3D(20, 30, 40, 50, "OK", 10)));
        assertFalse(rectButton3D.isIntersects(new RectButton3D(-40, 20, -30, 40, "OK", 10)));
        assertFalse(rectButton3D.isIntersects(new RectButton3D(110, 120, 30, 40, "OK", 10)));
        assertFalse(rectButton3D.isIntersects(new RectButton3D(10, 120, 30, 40, "OK", 10)));
        assertFalse(rectButton3D.isIntersects(new RectButton3D(10, -40, 30, 20, "OK", 10)));
    }

    @Test
    public void testIsRectButtonInsideRectButton3D() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isInside(new RectButton(15, 25, 25, 35, "OK")));
        assertFalse(rectButton3D.isInside(new RectButton(-40, 20, 30, 40, "OK")));
        assertFalse(rectButton3D.isInside(new RectButton(110, 120, 130, 140, "OK")));
        assertFalse(rectButton3D.isInside(new RectButton(10, 120, 30, 40, "OK")));
        assertFalse(rectButton3D.isInside(new RectButton(10, -40, 30, 20, "OK")));
        assertTrue(rectButton3D.isInside(new RectButton(15, 25, 25, 35, "OK")));
    }

    @Test
    public void testIsRectButton3DInsideRectButton3D() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        assertTrue(rectButton3D.isInside(new RectButton3D(15, 25, 25, 35, "OK", 10)));
        assertFalse(rectButton3D.isInside(new RectButton3D(-40, 20, 30, 40, "OK", 10)));
        assertFalse(rectButton3D.isInside(new RectButton3D(110, 120, 130, 140, "OK", 10)));
        assertFalse(rectButton3D.isInside(new RectButton3D(10, 120, 30, 40, "OK", 10)));
        assertFalse(rectButton3D.isInside(new RectButton3D(10, -40, 30, 20, "OK", 10)));
        assertFalse(rectButton3D.isInside(new RectButton3D(15, 25, 25, 35, "OK", 11)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertTrue(new RectButton3D(15, 25, 25, 35, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RectButton3D(0, 0, 639, 479, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton3D(200, 200, 640, 480, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton3D(-200, -200, 640, 480, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton3D(-1200, 700, 1199, 480, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton3D(200, -200, 100, 100, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RectButton3D(200, 300, 100, 100, "OK", 10).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RectButton3D(200, 700, 100, 100, "OK", 10).isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testRectButton3DAreEqual() {
        RectButton3D rectButton3D1 = new RectButton3D(10, 20, 30, 40, "OK", 10);
        RectButton3D rectButton3D2 = new RectButton3D(10, 20, 30, 40, "OK", 10);
        RectButton3D rectButton3D3 = new RectButton3D(20, 30, 40, 50, "OK", 10);
        RectButton3D rectButton3D4 = new RectButton3D(20, 30, 40, 50, "Cancel", 10);
        RectButton3D rectButton3D5 = new RectButton3D(20, 30, 40, 50, "OK", 20);
        assertNotEquals(rectButton3D1, null);
        assertEquals(rectButton3D1, rectButton3D1);
        assertNotEquals(rectButton3D1, null);
        assertEquals(rectButton3D1, rectButton3D2);
        assertNotEquals(rectButton3D1, rectButton3D3);
        assertNotEquals(rectButton3D1, rectButton3D4);
        assertNotEquals(rectButton3D1, rectButton3D5);
    }

    @Test
    public void testRectButton3DSetText() {
        RectButton3D rectButton3D = new RectButton3D(10, 20, 30, 40, "OK", 10);
        rectButton3D.setText("Cancel");
        assertEquals("Cancel", rectButton3D.getText());
    }

}
