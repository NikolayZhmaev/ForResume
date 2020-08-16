package net.thumbtack.school.online.windows.v3;

import java.util.Objects;

public class RadioButton extends RoundButton {

    private boolean checked;

    public RadioButton(Point center, int radius, boolean active, String txt, boolean checked) {
        super(center, radius, active, txt);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, boolean active, String txt, boolean checked) {
        super(xCenter, yCenter, radius, active, txt);
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String text, boolean checked) {
        super(center, radius, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) {
        super(xCenter, yCenter, radius, text);
        this.checked = checked;
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
