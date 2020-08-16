package net.thumbtack.school.online.windows.v2;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestListBox {

    @Test
    public void testListBox1() {

        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ListBox listBox = new ListBox(topLeft, bottomRight, false, lines);
        assertEquals(10, listBox.getTopLeft().getX());
        assertEquals(20, listBox.getTopLeft().getY());
        assertEquals(30, listBox.getBottomRight().getX());
        assertEquals(40, listBox.getBottomRight().getY());
        assertEquals(21, listBox.getWidth());
        assertEquals(21, listBox.getHeight());
        assertFalse(listBox.isActive());
        assertNotSame(lines, listBox.getLines());
        assertArrayEquals(lines, listBox.getLines());
    }

    @Test
    public void testListBox2() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, false, lines);
        assertEquals(10, listBox.getTopLeft().getX());
        assertEquals(20, listBox.getTopLeft().getY());
        assertEquals(39, listBox.getBottomRight().getX());
        assertEquals(59, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
        assertFalse(listBox.isActive());
        assertNotSame(lines, listBox.getLines());
        assertArrayEquals(lines, listBox.getLines());
    }

    @Test
    public void testListBox3() {
        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ListBox listBox = new ListBox(topLeft, bottomRight, lines);
        assertEquals(10, listBox.getTopLeft().getX());
        assertEquals(20, listBox.getTopLeft().getY());
        assertEquals(30, listBox.getBottomRight().getX());
        assertEquals(40, listBox.getBottomRight().getY());
        assertEquals(21, listBox.getWidth());
        assertEquals(21, listBox.getHeight());
        assertTrue(listBox.isActive());
        assertNotSame(lines, listBox.getLines());
        assertArrayEquals(lines, listBox.getLines());
    }

    @Test
    public void testListBox4() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertEquals(10, listBox.getTopLeft().getX());
        assertEquals(20, listBox.getTopLeft().getY());
        assertEquals(39, listBox.getBottomRight().getX());
        assertEquals(59, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
        assertTrue(listBox.isActive());
        assertNotSame(lines, listBox.getLines());
        assertArrayEquals(lines, listBox.getLines());
    }

    @Test
    public void testListBox5() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        assertEquals(10, listBox.getTopLeft().getX());
        assertEquals(20, listBox.getTopLeft().getY());
        assertEquals(39, listBox.getBottomRight().getX());
        assertEquals(59, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
        assertTrue(listBox.isActive());
        assertNull(listBox.getLines());
    }

    @Test
    public void testSetListBox() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        listBox.setTopLeft(new Point(0, 0));
        listBox.setBottomRight(new Point(200, 100));
        listBox.setActive(false);
        assertEquals(0, listBox.getTopLeft().getX());
        assertEquals(0, listBox.getTopLeft().getY());
        assertEquals(200, listBox.getBottomRight().getX());
        assertEquals(100, listBox.getBottomRight().getY());
        assertEquals(201, listBox.getWidth());
        assertEquals(101, listBox.getHeight());
        assertFalse(listBox.isActive());
        assertNotSame(lines, listBox.getLines());
        assertArrayEquals(lines, listBox.getLines());
    }

    @Test
    public void testSliceListBox1() {
        String[] lines = {"line1", "line2", "line3", "line4"};
        String[] lines02 = {"line1", "line2"};
        String[] lines03 = {"line1", "line2", "line3"};
        String[] lines14 = {"line2", "line3", "line4"};
        String[] lines01 = {"line1"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertArrayEquals(lines02, listBox.getLinesSlice(0, 2));
        assertArrayEquals(lines03, listBox.getLinesSlice(0, 3));
        assertArrayEquals(lines14, listBox.getLinesSlice(1, 4));
        assertArrayEquals(lines01, listBox.getLinesSlice(0, 1));
        assertArrayEquals(lines, listBox.getLinesSlice(0, 4));
        assertArrayEquals(lines, listBox.getLinesSlice(0, 10));
    }

    @Test
    public void testSliceListBox2() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        assertNull(listBox.getLinesSlice(0, 2));
        assertNull(listBox.getLinesSlice(1, 10));
    }

    @Test
    public void testMoveToListBox1() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        listBox.moveTo(100, 50);
        assertEquals(100, listBox.getTopLeft().getX());
        assertEquals(50, listBox.getTopLeft().getY());
        assertEquals(129, listBox.getBottomRight().getX());
        assertEquals(89, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
    }

    @Test
    public void testMoveToListBox2() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        listBox.moveTo(new Point(100, 50));
        assertEquals(100, listBox.getTopLeft().getX());
        assertEquals(50, listBox.getTopLeft().getY());
        assertEquals(129, listBox.getBottomRight().getX());
        assertEquals(89, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
    }

    @Test
    public void testMoveRelListBox() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        listBox.moveRel(100, 50);
        assertEquals(110, listBox.getTopLeft().getX());
        assertEquals(70, listBox.getTopLeft().getY());
        assertEquals(139, listBox.getBottomRight().getX());
        assertEquals(109, listBox.getBottomRight().getY());
        assertEquals(30, listBox.getWidth());
        assertEquals(40, listBox.getHeight());
    }

    @Test
    public void testResizeListBox() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox1 = new ListBox(10, 20, 30, 40, lines);
        listBox1.resize(2);
        assertEquals(10, listBox1.getTopLeft().getX());
        assertEquals(20, listBox1.getTopLeft().getY());
        assertEquals(69, listBox1.getBottomRight().getX());
        assertEquals(99, listBox1.getBottomRight().getY());
        assertEquals(60, listBox1.getWidth());
        assertEquals(80, listBox1.getHeight());
        ListBox listBox2 = new ListBox(10, 20, 30, 40, lines);
        listBox2.resize(0.5);
        assertEquals(10, listBox2.getTopLeft().getX());
        assertEquals(20, listBox2.getTopLeft().getY());
        assertEquals(24, listBox2.getBottomRight().getX());
        assertEquals(39, listBox2.getBottomRight().getY());
        assertEquals(15, listBox2.getWidth());
        assertEquals(20, listBox2.getHeight());
        ListBox listBox3 = new ListBox(10, 20, 4, 4, lines);
        listBox3.resize(0.5);
        assertEquals(10, listBox3.getTopLeft().getX());
        assertEquals(20, listBox3.getTopLeft().getY());
        assertEquals(11, listBox3.getBottomRight().getX());
        assertEquals(21, listBox3.getBottomRight().getY());
        assertEquals(2, listBox3.getWidth());
        assertEquals(2, listBox3.getHeight());
        ListBox listBox4 = new ListBox(10, 20, 30, 40, lines);
        listBox4.resize(0.01);
        assertEquals(10, listBox4.getTopLeft().getX());
        assertEquals(20, listBox4.getTopLeft().getY());
        assertEquals(10, listBox4.getBottomRight().getX());
        assertEquals(20, listBox4.getBottomRight().getY());
        assertEquals(1, listBox4.getWidth());
        assertEquals(1, listBox4.getHeight());
    }

    @Test
    public void testIsPointInsideListBox1() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertTrue(listBox.isInside(20, 30));
        assertTrue(listBox.isInside(10, 30));
        assertTrue(listBox.isInside(30, 30));
        assertTrue(listBox.isInside(10, 59));
        assertFalse(listBox.isInside(10, 60));
        assertFalse(listBox.isInside(0, 0));
        assertFalse(listBox.isInside(10, 100));
        assertFalse(listBox.isInside(-10, 20));
        assertFalse(listBox.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideListBox2() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertTrue(listBox.isInside(new Point(20, 30)));
        assertTrue(listBox.isInside(new Point(10, 30)));
        assertTrue(listBox.isInside(new Point(30, 30)));
        assertTrue(listBox.isInside(new Point(10, 59)));
        assertFalse(listBox.isInside(new Point(10, 60)));
        assertFalse(listBox.isInside(new Point(0, 0)));
        assertFalse(listBox.isInside(new Point(10, 100)));
        assertFalse(listBox.isInside(new Point(-10, 20)));
        assertFalse(listBox.isInside(new Point(10, -20)));
    }

    @Test
    public void testIsIntersectsListBox() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertTrue(listBox.isIntersects(new ListBox(15, 25, 25, 35, lines)));
        assertTrue(listBox.isIntersects(new ListBox(-10, 20, 30, 40, lines)));
        assertTrue(listBox.isIntersects(new ListBox(10, 20, 50, 40, lines)));
        assertTrue(listBox.isIntersects(new ListBox(-10, 20, 50, 40, lines)));
        assertTrue(listBox.isIntersects(new ListBox(10, -20, 30, 41, lines)));
        assertFalse(listBox.isIntersects(new ListBox(10, -20, 30, 40, lines)));
        assertTrue(listBox.isIntersects(new ListBox(10, 20, 30, 60, lines)));
        assertTrue(listBox.isIntersects(new ListBox(-10, -20, 50, 60, lines)));
        assertTrue(listBox.isIntersects(new ListBox(0, 10, 20, 30, lines)));
        assertTrue(listBox.isIntersects(new ListBox(20, 30, 40, 50, lines)));
        assertFalse(listBox.isIntersects(new ListBox(-40, 20, -30, 40, lines)));
        assertFalse(listBox.isIntersects(new ListBox(110, 120, 30, 40, lines)));
        assertFalse(listBox.isIntersects(new ListBox(10, 120, 30, 40, lines)));
        assertFalse(listBox.isIntersects(new ListBox(10, -40, 30, 20, lines)));
    }

    @Test
    public void testIsListBoxInsideListBox() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertTrue(listBox.isInside(new ListBox(15, 25, 25, 35, lines)));
        assertFalse(listBox.isInside(new ListBox(-40, 20, 30, 40, lines)));
        assertFalse(listBox.isInside(new ListBox(110, 120, 130, 140, lines)));
        assertFalse(listBox.isInside(new ListBox(10, 120, 30, 40, lines)));
        assertFalse(listBox.isInside(new ListBox(10, -40, 30, 20, lines)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        String[] lines = {"line1", "line2", "line3"};
        Desktop desktop = new Desktop();
        assertTrue(new ListBox(15, 25, 25, 35, lines).isFullyVisibleOnDesktop(desktop));
        assertTrue(new ListBox(0, 0, 639, 479, lines).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ListBox(200, 200, 640, 480, lines).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ListBox(-200, -200, 640, 480, lines).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ListBox(-1200, 700, 1199, 480, lines).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ListBox(200, -200, 100, 100, lines).isFullyVisibleOnDesktop(desktop));
        assertTrue(new ListBox(200, 300, 100, 100, lines).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ListBox(200, 700, 100, 100, lines).isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testListBoxesAreEqual() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox1 = new ListBox(10, 20, 30, 40, lines);
        ListBox listBox2 = new ListBox(10, 20, 30, 40, lines);
        ListBox listBox3 = new ListBox(20, 30, 40, 50, lines);
        assertNotEquals(listBox1, null);
        assertEquals(listBox1, listBox1);
        assertNotEquals(listBox1, null);
        assertEquals(listBox1, listBox2);
        assertNotEquals(listBox1, listBox3);
    }

    @Test
    public void testListBoxSetLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line4", "line5", "line6"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        assertNotSame(lines1, listBox.getLines());
        listBox.setLines(lines2);
        assertNotSame(lines2, listBox.getLines());
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxSetLines2() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        listBox.setLines(null);
        assertNull(listBox.getLines());
    }


    @Test
    public void testListBoxGetLine1() {
        String[] lines1 = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        assertEquals("line3", listBox.getLine(2));
    }

    @Test
    public void testListBoxGetLine2() {
        String[] lines1 = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        assertNull(listBox.getLine(3));
    }

    @Test
    public void testListBoxSetLine() {
        String[] lines1 = {"line1", "line2", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.setLine(1, "newline");
        assertThat(lines1, IsNot.not(IsEqual.equalTo(listBox.getLines())));
    }

    @Test
    public void testListBoxFindLine() {
        String[] lines = {"line1", "line2", "line3"};
        ListBox listBox1 = new ListBox(10, 20, 30, 40, lines);
        assertEquals(1, (int) listBox1.findLine("line2"));
        assertNull(listBox1.findLine("line4"));
        ListBox listBox2 = new ListBox(10, 20, 30, 40, null);
        assertNull(listBox2.findLine("line"));
    }

    @Test
    public void testListBoxReverseLineOrder1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line3", "line2", "line1"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.reverseLineOrder();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxReverseLineOrder2() {
        String[] lines1 = {"line1", "line2", "line3", "line4"};
        String[] lines2 = {"line4", "line3", "line2", "line1"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.reverseLineOrder();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxReverseLineOrder3() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        listBox.reverseLineOrder();
        assertNull(listBox.getLines());
    }

    @Test
    public void testListBoxReverseLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"1enil", "2enil", "3enil"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.reverseLines();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxReverseLines2() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        listBox.reverseLines();
        assertNull(listBox.getLines());
    }

    @Test
    public void testListBoxDuplicateLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line1", "line1", "line2", "line2", "line3", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.duplicateLines();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxDuplicateLines2() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        listBox.duplicateLines();
        assertNull(listBox.getLines());
    }

    @Test
    public void testListBoxRemoveLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line1", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.removeOddLines();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxRemoveLines2() {
        String[] lines1 = {"line1", "line2", "line3", "line4"};
        String[] lines2 = {"line1", "line3"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.removeOddLines();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxRemoveLines3() {
        String[] lines1 = {"line1"};
        String[] lines2 = {"line1"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines1);
        listBox.removeOddLines();
        assertArrayEquals(lines2, listBox.getLines());
    }

    @Test
    public void testListBoxRemoveLines4() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        listBox.removeOddLines();
        assertNull(listBox.getLines());
    }

    @Test
    public void testListBoxSortedDescendant1() {
        String[] lines = {"line1", "line1", "line3", "line4"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertFalse(listBox.isSortedDescendant());
    }

    @Test
    public void testListBoxSortedDescendant2() {
        String[] lines = {"line4", "line3", "line2", "line1"};
        ListBox listBox = new ListBox(10, 20, 30, 40, lines);
        assertTrue(listBox.isSortedDescendant());
    }

    @Test
    public void testListBoxSortedDescendant3() {
        ListBox listBox = new ListBox(10, 20, 30, 40, null);
        assertTrue(listBox.isSortedDescendant());
    }
}
