package net.thumbtack.school.online.windows.v2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPoint {

    @Test
    public void testPoint1() {
        Point point = new Point(100, 200);
        assertEquals(100, point.getX());
        assertEquals(200, point.getY());
    }

    @Test
    public void testPoint2() {
        Point point = new Point(100, 200);
        point.moveTo(300, 400);
        assertEquals(300, point.getX());
        assertEquals(400, point.getY());
    }

    @Test
    public void testPoint3() {
        Point point = new Point(100, 200);
        point.moveRel(300, 400);
        assertEquals(400, point.getX());
        assertEquals(600, point.getY());
    }

    @Test
    public void testPoint4() {
        Point point = new Point();
        point.moveRel(300, 400);
        assertEquals(300, point.getX());
        assertEquals(400, point.getY());
    }

    @Test
    public void testPoint5() {
        Point point = new Point();
        point.setX(300);
        point.setY(400);
        assertEquals(300, point.getX());
        assertEquals(400, point.getY());
    }

    @Test
    public void testPoint6() {
        Point point = new Point();
        point.moveTo(300, 400);
        assertEquals(300, point.getX());
        assertEquals(400, point.getY());
    }

    @Test
    public void testPointsAreEqual1() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point(100, 100);
        assertEquals(point1, point2);
    }

    @Test
    public void testPointsAreEqual2() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point();
        assertNotEquals(point1, point2);
        point2.moveRel(100, 100);
        assertEquals(point1, point2);
    }

    @Test
    public void testPointsAreEqual3() {
        Point point1 = new Point(100, 100);
        Point point2 = new Point(point1);
        assertEquals(point1, point2);
    }

    @Test
    public void testPointVisibility() {
        Desktop desktop = new Desktop();
        Point point = new Point(100, 100);
        assertTrue(point.isVisibleOnDesktop(desktop));
        assertFalse(point.isNotVisibleOnDesktop(desktop));
        point.moveTo(-1, 100);
        assertFalse(point.isVisibleOnDesktop(desktop));
        assertTrue(point.isNotVisibleOnDesktop(desktop));
        point.moveTo(0, 640);
        assertFalse(point.isVisibleOnDesktop(desktop));
        assertTrue(point.isNotVisibleOnDesktop(desktop));
        point.moveTo(0, -1);
        assertFalse(point.isVisibleOnDesktop(desktop));
        assertTrue(point.isNotVisibleOnDesktop(desktop));
        point.moveTo(0, 480);
        assertFalse(point.isVisibleOnDesktop(desktop));
        assertTrue(point.isNotVisibleOnDesktop(desktop));
    }

}
