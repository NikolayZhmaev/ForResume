package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

import java.util.Objects;

public class ComboBox extends ListBox {

    private Integer selected;

    // для проверки передаваемых в конструктор параметров выделим отдельный метод.
    public void checkConstructor(String[] lines, Integer selected) throws WindowException {
        if (lines == null && selected != null) {
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (lines != null && selected != null && selected < 0) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
        if (lines != null && selected != null && selected > lines.length - 1) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
    }

    public ComboBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, state, lines);
        checkConstructor(lines, selected);
        setSelected(selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String state, String[] lines, Integer selected) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.fromString(state), lines, selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, WindowState state, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, state, lines);
        checkConstructor(lines, selected);
        setSelected(selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, String state, String[] lines, Integer selected) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), lines, selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, lines);
        checkConstructor(lines, selected);
        setSelected(selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, lines);
        checkConstructor(lines, selected);
        setSelected(selected);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) throws WindowException {
        checkConstructor(lines, selected);
        this.selected = selected;
    }

    @Override
    public void setLines(String[] lines) {
        if (lines == null) {
            this.lines = null;
            selected = null;
        } else {
            this.lines = lines.clone();
            selected = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboBox comboBox = (ComboBox) o;
        return Objects.equals(selected, comboBox.selected);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), selected);
    }
}
