package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRadioButton {

    @Test
    public void testRadioButton1() throws WindowException {
        Point center = new Point(10, 20);
        RadioButton radioButton = new RadioButton(center, 10, WindowState.INACTIVE, "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.INACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testRadioButton2() throws WindowException {
        Point center = new Point(10, 20);
        RadioButton radioButton = new RadioButton(center, 10, "INACTIVE", "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.INACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testRadioButton3() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 10, WindowState.INACTIVE, "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.INACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testRadioButton4() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 10, "INACTIVE", "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.INACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testRadioButton5() throws WindowException {
        Point center = new Point(10, 20);
        RadioButton radioButton = new RadioButton(center, 10, "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.ACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testRadioButton6() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 10, "Radio1", true);
        assertEquals(10, radioButton.getCenter().getX());
        assertEquals(20, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
        assertEquals(WindowState.ACTIVE, radioButton.getState());
        assertEquals("Radio1", radioButton.getText());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testState() throws WindowException {
        Window window = new RadioButton(10, 20, 10, "Radio1", true);
        assertEquals(WindowState.ACTIVE, window.getState());
        window.setState(WindowState.INACTIVE);
        assertEquals(WindowState.INACTIVE, window.getState());
        window.setState(WindowState.DESTROYED);
        assertEquals(WindowState.DESTROYED, window.getState());
    }

    @SuppressWarnings("unused")
    @Test
    public void testWrongState() {
        boolean failed = false;
        try {
            Window window = new RadioButton(10, 20, 10, (WindowState) null, "Radio1", true);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        try {
            Window window = new RadioButton(10, 20, 10, (String) null, "Radio1", true);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        try {
            Window window = new RadioButton(10, 20, 10, "Radio1", "ENABLED", true);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        try {
            Window window = new RadioButton(10, 20, 10, "Radio1", true);
            window.setState(WindowState.DESTROYED);
            window.setState((WindowState.ACTIVE));
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        try {
            Window window = new ComboBox(10, 20, 30, 40, WindowState.DESTROYED, null, null);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        try {
            Window window = new ComboBox(10, 20, 30, 40, "DESTROYED", null, null);
            failed = true;
        } catch (WindowException ex) {
            assertEquals(WindowErrorCode.WRONG_STATE, ex.getWindowErrorCode());
        }
        if (failed) {
            fail();
        }
    }

    @Test
    public void testSetRadioButton() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 10, "Radio1", true);
        radioButton.setCenter(30, 40);
        radioButton.setRadius(20);
        radioButton.setState(WindowState.INACTIVE);
        radioButton.setChecked(false);
        assertEquals(30, radioButton.getCenter().getX());
        assertEquals(40, radioButton.getCenter().getY());
        assertEquals(20, radioButton.getRadius());
        assertEquals(WindowState.INACTIVE, radioButton.getState());
        assertFalse(radioButton.isChecked());
    }

    @Test
    public void testMoveToRadioButton1() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 30, "Radio1", true);
        radioButton.moveTo(100, 50);
        assertEquals(100, radioButton.getCenter().getX());
        assertEquals(50, radioButton.getCenter().getY());
        assertEquals(30, radioButton.getRadius());
        assertEquals(WindowState.ACTIVE, radioButton.getState());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testMoveToRadioButton2() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 30, "Radio1", true);
        radioButton.moveTo(new Point(100, 50));
        assertEquals(100, radioButton.getCenter().getX());
        assertEquals(50, radioButton.getCenter().getY());
        assertEquals(30, radioButton.getRadius());
        assertEquals(WindowState.ACTIVE, radioButton.getState());
        assertTrue(radioButton.isChecked());
    }

    @Test
    public void testMoveRelRadioButton() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 20, 10, "Radio1", true);
        radioButton.moveRel(100, 50);
        assertEquals(110, radioButton.getCenter().getX());
        assertEquals(70, radioButton.getCenter().getY());
        assertEquals(10, radioButton.getRadius());
    }

    @Test
    public void testResizeRadioButton() throws WindowException {
        RadioButton radioButton1 = new RadioButton(10, 20, 10, "Radio1", true);
        radioButton1.resize(2);
        assertEquals(10, radioButton1.getCenter().getX());
        assertEquals(20, radioButton1.getCenter().getY());
        assertEquals(20, radioButton1.getRadius());
        RadioButton radioButton2 = new RadioButton(10, 20, 10, "Radio1", true);
        radioButton2.resize(0.5);
        assertEquals(10, radioButton2.getCenter().getX());
        assertEquals(20, radioButton2.getCenter().getY());
        assertEquals(5, radioButton2.getRadius());
        RadioButton radioButton3 = new RadioButton(10, 20, 10, "Radio1", true);
        radioButton3.resize(0.01);
        assertEquals(10, radioButton3.getCenter().getX());
        assertEquals(20, radioButton3.getCenter().getY());
        assertEquals(1, radioButton3.getRadius());
    }

    @Test
    public void testIsPointInsideRadioButton1() throws WindowException {
        RadioButton radioButton = new RadioButton(10, 10, 10, "Radio1", true);
        assertTrue(radioButton.isInside(10, 10));
        assertTrue(radioButton.isInside(20, 10));
        assertTrue(radioButton.isInside(10, 20));
        assertTrue(radioButton.isInside(15, 15));
        assertFalse(radioButton.isInside(18, 18));
    }

    @Test
    public void testIsPointInsideRadioButton2() throws WindowException {
        RadioButton radioButton = new RadioButton(new Point(10, 10), 10, "Radio1", true);
        assertTrue(radioButton.isInside(new Point(10, 10)));
        assertTrue(radioButton.isInside(new Point(20, 10)));
        assertTrue(radioButton.isInside(new Point(10, 20)));
        assertTrue(radioButton.isInside(new Point(15, 15)));
        assertFalse(radioButton.isInside(new Point(18, 18)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() throws WindowException {
        Desktop desktop = new Desktop();
        assertTrue(new RadioButton(100, 100, 100, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RadioButton(100, 100, 101, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RadioButton(539, 100, 100, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RadioButton(539, 100, 101, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RadioButton(539, 379, 100, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RadioButton(539, 379, 101, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertTrue(new RadioButton(100, 379, 100, "Radio1", true).isFullyVisibleOnDesktop(desktop));
        assertFalse(new RadioButton(539, 379, 101, "Radio1", true).isFullyVisibleOnDesktop(desktop));
    }


    @Test
    public void testRadioButtonsAreEquals() throws WindowException {
        RadioButton radioButton1 = new RadioButton(new Point(10, 10), 10, "Radio1", true);
        RadioButton radioButton2 = new RadioButton(new Point(10, 10), 10, "Radio1", true);
        RadioButton radioButton3 = new RadioButton(new Point(10, 10), 20, "Radio3", true);
        RadioButton radioButton4 = new RadioButton(new Point(0, 0), 10, "Radio4", true);
        RadioButton radioButton5 = new RadioButton(new Point(10, 10), 10, "Radio5", true);
        RadioButton radioButton6 = new RadioButton(new Point(10, 10), 10, "Radio5", false);
        assertNotEquals(radioButton1, null);
        assertEquals(radioButton1, radioButton2);
        assertNotEquals(radioButton1, radioButton3);
        assertNotEquals(radioButton1, radioButton4);
        assertNotEquals(radioButton1, radioButton5);
        assertNotEquals(radioButton1, radioButton6);
    }

    @Test
    public void testRadioButtonSetText() throws WindowException {
        RadioButton radioButton = new RadioButton(new Point(10, 10), 10, "Radio1", true);
        radioButton.setText("Cancel");
        assertEquals("Cancel", radioButton.getText());
    }

}
