package net.thumbtack.school.online.windows.v2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRoundButton {

    @Test
    public void testRoundButton1() {
        Point center = new Point(10, 20);
        RoundButton roundButton = new RoundButton(center, 10, false, "OK");
        assertEquals(10, roundButton.getCenter().getX());
        assertEquals(20, roundButton.getCenter().getY());
        assertEquals(10, roundButton.getRadius());
        assertFalse(roundButton.isActive());
        assertEquals("OK", roundButton.getText());
    }

    @Test
    public void testRoundButton2() {
        RoundButton roundButton = new RoundButton(10, 20, 10, false, "OK");
        assertEquals(10, roundButton.getCenter().getX());
        assertEquals(20, roundButton.getCenter().getY());
        assertEquals(10, roundButton.getRadius());
        assertFalse(roundButton.isActive());
        assertEquals("OK", roundButton.getText());
    }

    @Test
    public void testRoundButton3() {
        Point center = new Point(10, 20);
        RoundButton roundButton = new RoundButton(center, 10, "OK");
        assertEquals(10, roundButton.getCenter().getX());
        assertEquals(20, roundButton.getCenter().getY());
        assertEquals(10, roundButton.getRadius());
        assertTrue(roundButton.isActive());
        assertEquals("OK", roundButton.getText());
    }

    @Test
    public void testRoundButton4() {
        RoundButton roundButton = new RoundButton(10, 20, 10, "OK");
        assertEquals(10, roundButton.getCenter().getX());
        assertEquals(20, roundButton.getCenter().getY());
        assertEquals(10, roundButton.getRadius());
        assertTrue(roundButton.isActive());
        assertEquals("OK", roundButton.getText());
    }

    @Test
    public void testSetRoundButton() {
        RoundButton roundButton = new RoundButton(10, 20, 10, "OK");
        roundButton.setCenter(30, 40);
        roundButton.setRadius(20);
        roundButton.setActive(false);
        assertEquals(30, roundButton.getCenter().getX());
        assertEquals(40, roundButton.getCenter().getY());
        assertEquals(20, roundButton.getRadius());
        assertFalse(roundButton.isActive());
    }

    @Test
    public void testMoveToRoundButton1() {
        RoundButton roundButton = new RoundButton(10, 20, 30, "OK");
        roundButton.moveTo(100, 50);
        assertEquals(100, roundButton.getCenter().getX());
        assertEquals(50, roundButton.getCenter().getY());
        assertEquals(30, roundButton.getRadius());
        assertTrue(roundButton.isActive());
    }

    @Test
    public void testMoveToRoundButton2() {
        RoundButton roundButton = new RoundButton(10, 20, 30, "OK");
        roundButton.moveTo(new Point(100, 50));
        assertEquals(100, roundButton.getCenter().getX());
        assertEquals(50, roundButton.getCenter().getY());
        assertEquals(30, roundButton.getRadius());
        assertTrue(roundButton.isActive());
    }

    @Test
    public void testMoveRelRoundButton() {
        RoundButton roundButton = new RoundButton(10, 20, 10, "OK");
        roundButton.moveRel(100, 50);
        assertEquals(110, roundButton.getCenter().getX());
        assertEquals(70, roundButton.getCenter().getY());
        assertEquals(10, roundButton.getRadius());
    }

    @Test
    public void testResizeRoundButton() {
        RoundButton roundButton1 = new RoundButton(10, 20, 10, "OK");
        roundButton1.resize(2);
        assertEquals(10, roundButton1.getCenter().getX());
        assertEquals(20, roundButton1.getCenter().getY());
        assertEquals(20, roundButton1.getRadius());
        RoundButton roundButton2 = new RoundButton(10, 20, 10, "OK");
        roundButton2.resize(0.5);
        assertEquals(10, roundButton2.getCenter().getX());
        assertEquals(20, roundButton2.getCenter().getY());
        assertEquals(5, roundButton2.getRadius());
        RoundButton roundButton3 = new RoundButton(10, 20, 10, "OK");
        roundButton3.resize(0.01);
        assertEquals(10, roundButton3.getCenter().getX());
        assertEquals(20, roundButton3.getCenter().getY());
        assertEquals(1, roundButton3.getRadius());
    }

    @Test
    public void testIsPointInsideRoundButton1() {
        RoundButton roundButton = new RoundButton(10, 10, 10, "OK");
        assertTrue(roundButton.isInside(10, 10));
        assertTrue(roundButton.isInside(20, 10));
        assertTrue(roundButton.isInside(10, 20));
        assertTrue(roundButton.isInside(15, 15));
        assertFalse(roundButton.isInside(18, 18));
    }

    @Test
    public void testIsPointInsideRoundButton2() {
        RoundButton roundButton = new RoundButton(new Point(10, 10), 10, "OK");
        assertTrue(roundButton.isInside(new Point(10, 10)));
        assertTrue(roundButton.isInside(new Point(20, 10)));
        assertTrue(roundButton.isInside(new Point(10, 20)));
        assertTrue(roundButton.isInside(new Point(15, 15)));
        assertFalse(roundButton.isInside(new Point(18, 18)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertTrue(new RoundButton(100, 100, 100, "OK").isFullyVisibleOnDesktop(desktop));
        assertFalse(new RoundButton(100, 100, 101, "OK").isFullyVisibleOnDesktop(desktop));
        assertTrue(new RoundButton(539, 100, 100, "OK").isFullyVisibleOnDesktop(desktop));
        assertFalse(new RoundButton(539, 100, 101, "OK").isFullyVisibleOnDesktop(desktop));
        assertTrue(new RoundButton(539, 379, 100, "OK").isFullyVisibleOnDesktop(desktop));
        assertFalse(new RoundButton(539, 379, 101, "OK").isFullyVisibleOnDesktop(desktop));
        assertTrue(new RoundButton(100, 379, 100, "OK").isFullyVisibleOnDesktop(desktop));
        assertFalse(new RoundButton(539, 379, 101, "OK").isFullyVisibleOnDesktop(desktop));
    }


    @Test
    public void testRoundButtonsAreEqual() {
        RoundButton roundButton1 = new RoundButton(new Point(10, 10), 10, "OK");
        RoundButton roundButton2 = new RoundButton(new Point(10, 10), 10, "OK");
        RoundButton roundButton3 = new RoundButton(new Point(10, 10), 20, "OK");
        RoundButton roundButton4 = new RoundButton(new Point(0, 0), 10, "OK");
        RoundButton roundButton5 = new RoundButton(new Point(10, 10), 10, "Cancel");
        assertNotEquals(roundButton1, null);
        assertEquals(roundButton1, roundButton2);
        assertNotEquals(roundButton1, roundButton3);
        assertNotEquals(roundButton1, roundButton4);
        assertNotEquals(roundButton1, roundButton5);
    }

    @Test
    public void testRoundButtonSetText() {
        RoundButton roundButton = new RoundButton(new Point(10, 10), 10, "OK");
        roundButton.setText("Cancel");
        assertEquals("Cancel", roundButton.getText());
    }

}
