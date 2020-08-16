package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.windows.v3.base.RectWindow;
import net.thumbtack.school.online.windows.v3.base.RoundWindow;
import net.thumbtack.school.online.windows.v3.base.Window;
import net.thumbtack.school.online.windows.v3.cursors.Cursor;
import net.thumbtack.school.online.windows.v3.iface.Movable;
import net.thumbtack.school.online.windows.v3.iface.Resizable;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TestTypes {

    private boolean isAbstract(Class clazz) {
        return (clazz.getModifiers() & Modifier.ABSTRACT) != 0;
    }

    @Test
    public void testTypes() throws NoSuchMethodException {
        assertTrue(Movable.class.isInterface());
        assertTrue(Resizable.class.isInterface());
        assertTrue(Movable.class.isAssignableFrom(Window.class));
        assertTrue(Resizable.class.isAssignableFrom(Window.class));
        assertTrue(Movable.class.isAssignableFrom(Cursor.class));
        assertEquals(0, (Movable.class.getMethod("moveTo", Point.class).getModifiers() & Modifier.ABSTRACT));
        assertTrue(isAbstract(Window.class));
        assertTrue(isAbstract(RectWindow.class));
        assertTrue(isAbstract(RoundWindow.class));
    }
}
