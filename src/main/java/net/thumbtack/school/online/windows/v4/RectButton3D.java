package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

import java.util.Objects;

public class RectButton3D extends RectButton {

    private int ZHeight; // создадим приватное поле для координаты я

    public int getZHeight() {
        return ZHeight;
    }

    public void setZHeight(int ZHeight) {
        this.ZHeight = ZHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, WindowState state, String text, int ZHeight) throws WindowException {
        super(topLeft, bottomRight, state, text);
        setZHeight(ZHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String state, String text, int ZHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text, ZHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, WindowState state, String text, int ZHeight) throws WindowException {
        super(xLeft, yTop, width, height, state, text);
        setZHeight(ZHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String state, String text, int ZHeight) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.fromString(state), text, ZHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int ZHeight) throws WindowException {
        super(topLeft, bottomRight, text);
        setZHeight(ZHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int ZHeight) throws WindowException {
        super(xLeft, yTop, width, height, text);
        setZHeight(ZHeight);
    }

    public boolean isInside(RectButton3D rectButton3D) {
        RectButton rectButton = rectButton3D;
        if (super.isInside(rectButton)) {
            return (rectButton3D.getZHeight() <= ZHeight);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton3D that = (RectButton3D) o;
        return ZHeight == that.ZHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ZHeight);
    }
}
