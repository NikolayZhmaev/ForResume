package net.thumbtack.school.online.windows.v2;

import java.util.Objects;

public class RectButton3D extends RectButton{

    private int ZHeight; // создадим приватное поле для координаты я

    public int getZHeight() {
        return ZHeight;
    }

    public void setZHeight(int ZHeight) {
        this.ZHeight = ZHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int ZHeight) {
        super(topLeft, bottomRight, active, text);
        this.ZHeight = ZHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int ZHeight) {
        super(xLeft, yTop, width, height, active, text);
        this.ZHeight = ZHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int ZHeight) {
        super(topLeft, bottomRight, text);
        this.ZHeight = ZHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int ZHeight) {
        super(xLeft, yTop, width, height, text);
        this.ZHeight = ZHeight;
    }


    public boolean isInside(RectButton3D rectButton3D) {
        RectButton rectButton = rectButton3D;

        if (super.isInside(rectButton)) {
            if (rectButton3D.getZHeight()<=ZHeight) {
                return true;
            }
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
