package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.windows.v3.cursors.Cursor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCursor {

    @Test
    public void testCursor1() {
        int x = 10;
        int y = 20;
        Cursor cursor = new Cursor(x, y, 1);
        assertEquals(10, cursor.getX());
        assertEquals(20, cursor.getY());
        assertEquals(1, cursor.getCursorForm());
    }

    @Test
    public void testCursor2() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, 1);
        assertEquals(10, cursor.getX());
        assertEquals(20, cursor.getY());
        assertEquals(1, cursor.getCursorForm());
    }

    @Test
    public void testSetCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, 1);
        cursor.setX(100);
        cursor.setY(200);
        cursor.setCursorForm(2);
        assertEquals(100, cursor.getX());
        assertEquals(200, cursor.getY());
        assertEquals(2, cursor.getCursorForm());
    }

    @Test
    public void testMoveCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, 1);
        cursor.moveTo(100, 200);
        assertEquals(100, cursor.getX());
        assertEquals(200, cursor.getY());
        assertEquals(1, cursor.getCursorForm());
        cursor.moveTo(point);
        assertEquals(10, cursor.getX());
        assertEquals(20, cursor.getY());
        cursor.moveRel(10, 10);
        assertEquals(20, cursor.getX());
        assertEquals(30, cursor.getY());

    }
}
