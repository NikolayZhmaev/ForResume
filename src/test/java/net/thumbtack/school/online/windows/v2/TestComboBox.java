package net.thumbtack.school.online.windows.v2;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestComboBox {

    @Test
    public void testComboBox1() {

        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ComboBox comboBox = new ComboBox(topLeft, bottomRight, false, lines, 1);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(30, comboBox.getBottomRight().getX());
        assertEquals(40, comboBox.getBottomRight().getY());
        assertEquals(21, comboBox.getWidth());
        assertEquals(21, comboBox.getHeight());
        assertFalse(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertEquals(1, (int) comboBox.getSelected());
    }

    @Test
    public void testComboBox2() {

        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ComboBox comboBox = new ComboBox(topLeft, bottomRight, false, lines, null);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(30, comboBox.getBottomRight().getX());
        assertEquals(40, comboBox.getBottomRight().getY());
        assertEquals(21, comboBox.getWidth());
        assertEquals(21, comboBox.getHeight());
        assertFalse(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testComboBox3() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, false, lines, 1);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(39, comboBox.getBottomRight().getX());
        assertEquals(59, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
        assertFalse(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertEquals(1, (int) comboBox.getSelected());
    }

    @Test
    public void testComboBox4() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, false, lines, null);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(39, comboBox.getBottomRight().getX());
        assertEquals(59, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
        assertFalse(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testComboBox5() {
        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ComboBox comboBox = new ComboBox(topLeft, bottomRight, lines, 1);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(30, comboBox.getBottomRight().getX());
        assertEquals(40, comboBox.getBottomRight().getY());
        assertEquals(21, comboBox.getWidth());
        assertEquals(21, comboBox.getHeight());
        assertTrue(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertEquals(1, (int) comboBox.getSelected());
    }

    @Test
    public void testComboBox6() {
        String[] lines = {"line1", "line2", "line3"};
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        ComboBox comboBox = new ComboBox(topLeft, bottomRight, lines, null);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(30, comboBox.getBottomRight().getX());
        assertEquals(40, comboBox.getBottomRight().getY());
        assertEquals(21, comboBox.getWidth());
        assertEquals(21, comboBox.getHeight());
        assertTrue(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testComboBox7() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(39, comboBox.getBottomRight().getX());
        assertEquals(59, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
        assertTrue(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertEquals(1, (int) comboBox.getSelected());
    }

    @Test
    public void testComboBox8() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, null);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(39, comboBox.getBottomRight().getX());
        assertEquals(59, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
        assertTrue(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testComboBox9() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        assertEquals(10, comboBox.getTopLeft().getX());
        assertEquals(20, comboBox.getTopLeft().getY());
        assertEquals(39, comboBox.getBottomRight().getX());
        assertEquals(59, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
        assertTrue(comboBox.isActive());
        assertNull(comboBox.getLines());
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testSetComboBox() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.setTopLeft(new Point(0, 0));
        comboBox.setBottomRight(new Point(200, 100));
        comboBox.setActive(false);
        comboBox.setSelected(2);
        assertEquals(0, comboBox.getTopLeft().getX());
        assertEquals(0, comboBox.getTopLeft().getY());
        assertEquals(200, comboBox.getBottomRight().getX());
        assertEquals(100, comboBox.getBottomRight().getY());
        assertEquals(201, comboBox.getWidth());
        assertEquals(101, comboBox.getHeight());
        assertFalse(comboBox.isActive());
        assertNotSame(lines, comboBox.getLines());
        assertArrayEquals(lines, comboBox.getLines());
        assertEquals(2, (int) comboBox.getSelected());
        comboBox.setSelected(null);
        assertNull(comboBox.getSelected());
    }

    @Test
    public void testSliceComboBox1() {
        String[] lines = {"line1", "line2", "line3", "line4"};
        String[] lines02 = {"line1", "line2"};
        String[] lines03 = {"line1", "line2", "line3"};
        String[] lines14 = {"line2", "line3", "line4"};
        String[] lines01 = {"line1"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertArrayEquals(lines02, comboBox.getLinesSlice(0, 2));
        assertArrayEquals(lines03, comboBox.getLinesSlice(0, 3));
        assertArrayEquals(lines14, comboBox.getLinesSlice(1, 4));
        assertArrayEquals(lines01, comboBox.getLinesSlice(0, 1));
        assertArrayEquals(lines, comboBox.getLinesSlice(0, 4));
        assertArrayEquals(lines, comboBox.getLinesSlice(0, 10));
    }


    @Test
    public void testSliceComboBox2() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, 1);
        assertNull(comboBox.getLinesSlice(0, 2));
        assertNull(comboBox.getLinesSlice(1, 10));
    }

    @Test
    public void testMoveToComboBox1() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.moveTo(100, 50);
        assertEquals(100, comboBox.getTopLeft().getX());
        assertEquals(50, comboBox.getTopLeft().getY());
        assertEquals(129, comboBox.getBottomRight().getX());
        assertEquals(89, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
    }

    @Test
    public void testMoveToComboBox2() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.moveTo(new Point(100, 50));
        assertEquals(100, comboBox.getTopLeft().getX());
        assertEquals(50, comboBox.getTopLeft().getY());
        assertEquals(129, comboBox.getBottomRight().getX());
        assertEquals(89, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
    }

    @Test
    public void testMoveRelComboBox() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.moveRel(100, 50);
        assertEquals(110, comboBox.getTopLeft().getX());
        assertEquals(70, comboBox.getTopLeft().getY());
        assertEquals(139, comboBox.getBottomRight().getX());
        assertEquals(109, comboBox.getBottomRight().getY());
        assertEquals(30, comboBox.getWidth());
        assertEquals(40, comboBox.getHeight());
    }

    @Test
    public void testResizeComboBox() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox1 = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox1.resize(2);
        assertEquals(10, comboBox1.getTopLeft().getX());
        assertEquals(20, comboBox1.getTopLeft().getY());
        assertEquals(69, comboBox1.getBottomRight().getX());
        assertEquals(99, comboBox1.getBottomRight().getY());
        assertEquals(60, comboBox1.getWidth());
        assertEquals(80, comboBox1.getHeight());
        ComboBox comboBox2 = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox2.resize(0.5);
        assertEquals(10, comboBox2.getTopLeft().getX());
        assertEquals(20, comboBox2.getTopLeft().getY());
        assertEquals(24, comboBox2.getBottomRight().getX());
        assertEquals(39, comboBox2.getBottomRight().getY());
        assertEquals(15, comboBox2.getWidth());
        assertEquals(20, comboBox2.getHeight());
        ComboBox comboBox3 = new ComboBox(10, 20, 4, 4, lines, 1);
        comboBox3.resize(0.5);
        assertEquals(10, comboBox3.getTopLeft().getX());
        assertEquals(20, comboBox3.getTopLeft().getY());
        assertEquals(11, comboBox3.getBottomRight().getX());
        assertEquals(21, comboBox3.getBottomRight().getY());
        assertEquals(2, comboBox3.getWidth());
        assertEquals(2, comboBox3.getHeight());
        ComboBox comboBox4 = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox4.resize(0.01);
        assertEquals(10, comboBox4.getTopLeft().getX());
        assertEquals(20, comboBox4.getTopLeft().getY());
        assertEquals(10, comboBox4.getBottomRight().getX());
        assertEquals(20, comboBox4.getBottomRight().getY());
        assertEquals(1, comboBox4.getWidth());
        assertEquals(1, comboBox4.getHeight());
    }

    @Test
    public void testIsPointInsideComboBox1() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertTrue(comboBox.isInside(20, 30));
        assertTrue(comboBox.isInside(10, 30));
        assertTrue(comboBox.isInside(30, 30));
        assertTrue(comboBox.isInside(10, 59));
        assertFalse(comboBox.isInside(10, 60));
        assertFalse(comboBox.isInside(0, 0));
        assertFalse(comboBox.isInside(10, 100));
        assertFalse(comboBox.isInside(-10, 20));
        assertFalse(comboBox.isInside(10, -20));
    }

    @Test
    public void testIsPointInsideComboBox2() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertTrue(comboBox.isInside(new Point(20, 30)));
        assertTrue(comboBox.isInside(new Point(10, 30)));
        assertTrue(comboBox.isInside(new Point(30, 30)));
        assertTrue(comboBox.isInside(new Point(10, 59)));
        assertFalse(comboBox.isInside(new Point(10, 60)));
        assertFalse(comboBox.isInside(new Point(0, 0)));
        assertFalse(comboBox.isInside(new Point(10, 100)));
        assertFalse(comboBox.isInside(new Point(-10, 20)));
        assertFalse(comboBox.isInside(new Point(10, -20)));
    }

    @Test
    public void testIsIntersectsComboBox() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertTrue(comboBox.isIntersects(new ComboBox(15, 25, 25, 35, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(-10, 20, 30, 40, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(10, 20, 50, 40, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(-10, 20, 50, 40, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(10, -20, 30, 41, lines, 1)));
        assertFalse(comboBox.isIntersects(new ComboBox(10, -20, 30, 40, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(10, 20, 30, 60, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(-10, -20, 50, 60, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(0, 10, 20, 30, lines, 1)));
        assertTrue(comboBox.isIntersects(new ComboBox(20, 30, 40, 50, lines, 1)));
        assertFalse(comboBox.isIntersects(new ComboBox(-40, 20, -30, 40, lines, 1)));
        assertFalse(comboBox.isIntersects(new ComboBox(110, 120, 30, 40, lines, 1)));
        assertFalse(comboBox.isIntersects(new ComboBox(10, 120, 30, 40, lines, 1)));
        assertFalse(comboBox.isIntersects(new ComboBox(10, -40, 30, 20, lines, 1)));
    }

    @Test
    public void testIsComboBoxInsideComboBox() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertTrue(comboBox.isInside(new ComboBox(15, 25, 25, 35, lines, 1)));
        assertFalse(comboBox.isInside(new ComboBox(-40, 20, 30, 40, lines, 1)));
        assertFalse(comboBox.isInside(new ComboBox(110, 120, 130, 140, lines, 1)));
        assertFalse(comboBox.isInside(new ComboBox(10, 120, 30, 40, lines, 1)));
        assertFalse(comboBox.isInside(new ComboBox(10, -40, 30, 20, lines, 1)));
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        String[] lines = {"line1", "line2", "line3"};
        Desktop desktop = new Desktop();
        assertTrue(new ComboBox(15, 25, 25, 35, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertTrue(new ComboBox(0, 0, 639, 479, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ComboBox(200, 200, 640, 480, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ComboBox(-200, -200, 640, 480, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ComboBox(-1200, 700, 1199, 480, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ComboBox(200, -200, 100, 100, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertTrue(new ComboBox(200, 300, 100, 100, lines, 1).isFullyVisibleOnDesktop(desktop));
        assertFalse(new ComboBox(200, 700, 100, 100, lines, 1).isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testComboBoxesAreEqual() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox1 = new ComboBox(10, 20, 30, 40, lines, 1);
        ComboBox comboBox2 = new ComboBox(10, 20, 30, 40, lines, 1);
        ComboBox comboBox3 = new ComboBox(20, 30, 40, 50, lines, 1);
        assertNotEquals(comboBox1, null);
        assertEquals(comboBox1, comboBox1);
        assertNotEquals(comboBox1, null);
        assertEquals(comboBox1, comboBox2);
        assertNotEquals(comboBox1, comboBox3);
    }

    @Test
    public void testComboBoxSetLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line4", "line5", "line6"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        assertNotSame(lines1, comboBox.getLines());
        comboBox.setLines(lines2);
        assertNotSame(lines2, comboBox.getLines());
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxSetLines2() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.setLines(null);
        assertNull(comboBox.getLines());
    }


    @Test
    public void testComboBoxGetLine1() {
        String[] lines1 = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        assertEquals("line3", comboBox.getLine(2));
    }

    @Test
    public void testComboBoxGetLine2() {
        String[] lines1 = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        assertNull(comboBox.getLine(3));
    }

    @Test
    public void testComboBoxSetLine() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        comboBox.setLine(1, "newline");
        assertThat(lines, IsNot.not(IsEqual.equalTo(comboBox.getLines())));
    }

    @Test
    public void testComboBoxFindLine() {
        String[] lines = {"line1", "line2", "line3"};
        ComboBox comboBox1 = new ComboBox(10, 20, 30, 40, lines, 1);
        assertEquals(1, (int) comboBox1.findLine("line2"));
        assertNull(comboBox1.findLine("line4"));
        ComboBox comboBox2 = new ComboBox(10, 20, 30, 40, null, null);
        assertNull(comboBox2.findLine("line4"));
    }

    @Test
    public void testComboBoxReverseLineOrder1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line3", "line2", "line1"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.reverseLineOrder();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxReverseLineOrder2() {
        String[] lines1 = {"line1", "line2", "line3", "line4"};
        String[] lines2 = {"line4", "line3", "line2", "line1"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.reverseLineOrder();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxReverseLineOrder3() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        comboBox.reverseLineOrder();
        assertNull(comboBox.getLines());
    }

    @Test
    public void testComboBoxReverseLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"1enil", "2enil", "3enil"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.reverseLines();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxReverseLines2() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        comboBox.reverseLines();
        assertNull(comboBox.getLines());
    }

    @Test
    public void testComboBoxDuplicateLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line1", "line1", "line2", "line2", "line3", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.duplicateLines();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxDuplicateLines2() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        comboBox.duplicateLines();
        assertNull(comboBox.getLines());
    }

    @Test
    public void testComboBoxRemoveLines1() {
        String[] lines1 = {"line1", "line2", "line3"};
        String[] lines2 = {"line1", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.removeOddLines();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxRemoveLines2() {
        String[] lines1 = {"line1", "line2", "line3", "line4"};
        String[] lines2 = {"line1", "line3"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 1);
        comboBox.removeOddLines();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxRemoveLines3() {
        String[] lines1 = {"line1"};
        String[] lines2 = {"line1"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines1, 0);
        comboBox.removeOddLines();
        assertArrayEquals(lines2, comboBox.getLines());
    }

    @Test
    public void testComboBoxRemoveLines4() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        comboBox.removeOddLines();
        assertNull(comboBox.getLines());
    }

    @Test
    public void testComboBoxSortedDescendant1() {
        String[] lines = {"line1", "line1", "line3", "line4"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertFalse(comboBox.isSortedDescendant());
    }

    @Test
    public void testComboBoxSortedDescendant2() {
        String[] lines = {"line4", "line3", "line2", "line1"};
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, lines, 1);
        assertTrue(comboBox.isSortedDescendant());
    }

    @Test
    public void testComboBoxSortedDescendant3() {
        ComboBox comboBox = new ComboBox(10, 20, 30, 40, null, null);
        assertTrue(comboBox.isSortedDescendant());
    }
}
