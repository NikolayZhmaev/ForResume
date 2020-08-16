package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.RectWindow;
import net.thumbtack.school.online.windows.v4.base.RoundWindow;
import net.thumbtack.school.online.windows.v4.base.Window;
import net.thumbtack.school.online.windows.v4.cursors.Cursor;
import net.thumbtack.school.online.windows.v4.iface.Movable;
import net.thumbtack.school.online.windows.v4.iface.Resizable;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TestTypes {

    private boolean isAbstract(Class clazz) {
        return (clazz.getModifiers() & Modifier.ABSTRACT) != 0;
    }

    private boolean isAbstract(Method method) {
        return (method.getModifiers() & Modifier.ABSTRACT) != 0;
    }

    @Test
    public void testTypes() throws NoSuchMethodException {
        assertTrue(Movable.class.isInterface());
        assertTrue(Resizable.class.isInterface());

        assertTrue(Movable.class.isAssignableFrom(Window.class));
        assertTrue(Resizable.class.isAssignableFrom(Window.class));
        assertTrue(Movable.class.isAssignableFrom(Cursor.class));

        assertTrue(isAbstract(Window.class));
        assertTrue(isAbstract(RectWindow.class));
        assertTrue(isAbstract(RoundWindow.class));

        assertTrue(Window.class.isAssignableFrom(RectWindow.class));
        assertTrue(Window.class.isAssignableFrom(RoundWindow.class));
        assertTrue(RectWindow.class.isAssignableFrom(RectButton.class));
        assertTrue(RoundWindow.class.isAssignableFrom(RoundButton.class));
        assertTrue(RectButton.class.isAssignableFrom(RectButton3D.class));
        assertTrue(RoundButton.class.isAssignableFrom(RadioButton.class));
        assertTrue(RectWindow.class.isAssignableFrom(ListBox.class));
        assertTrue(ListBox.class.isAssignableFrom(ComboBox.class));

        assertFalse(Cursor.class.isAssignableFrom(Window.class));
        assertFalse(Desktop.class.isAssignableFrom(Window.class));
        assertFalse(Point.class.isAssignableFrom(Window.class));
        assertFalse(WindowFactory.class.isAssignableFrom(Window.class));

        assertFalse(isAbstract(Movable.class.getMethod("moveTo", Point.class)));
        assertTrue(isAbstract(Movable.class.getMethod("moveTo", int.class, int.class)));
        assertTrue(isAbstract(Movable.class.getMethod("moveRel", int.class, int.class)));
        assertTrue(isAbstract(Resizable.class.getMethod("resize", double.class)));

    }
}
