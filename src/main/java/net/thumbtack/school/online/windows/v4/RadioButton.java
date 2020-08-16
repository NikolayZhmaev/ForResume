package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

import java.util.Objects;

public class RadioButton extends RoundButton {

    private boolean checked;

    public RadioButton(Point center, int radius, WindowState state, String txt, boolean checked) throws WindowException {
        this(center.getX(), center.getY(), radius, state, txt, checked);
    }

    public RadioButton(Point center, int radius, String state, String txt, boolean checked) throws WindowException {
        this(center, radius, WindowState.fromString(state), txt, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, WindowState state, String txt, boolean checked) throws WindowException {
        super(xCenter, yCenter, radius, state, txt);
        setChecked(checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String state, String txt, boolean checked) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.fromString(state), txt, checked);
    }

    public RadioButton(Point center, int radius, String text, boolean checked) throws WindowException {
        this(center.getX(), center.getY(), radius, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) throws WindowException {
        super(xCenter, yCenter, radius, text);
        setChecked(checked);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RadioButton that = (RadioButton) o;
        return checked == that.checked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), checked);
    }
}
