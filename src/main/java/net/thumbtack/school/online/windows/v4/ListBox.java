package net.thumbtack.school.online.windows.v4;

import net.thumbtack.school.online.base.StringOperations;
import net.thumbtack.school.online.windows.v4.base.Point;
import net.thumbtack.school.online.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.online.windows.v4.base.WindowException;
import net.thumbtack.school.online.windows.v4.base.WindowState;

import java.util.ArrayList;

public class ListBox extends RectButton {

    String[] lines;

    public ListBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines) throws WindowException {
        super(xLeft, yTop, width, height, state, null);
        setLines(lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String state, String[] lines) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.fromString(state), lines);
    }

    public ListBox(Point topLeft, Point bottomRight, WindowState state, String[] lines) throws WindowException {
        super(topLeft.getX(), topLeft.getY(), (bottomRight.getX() - topLeft.getX() + 1),
                (bottomRight.getY() - topLeft.getY() + 1), state, null);
        setLines(lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String state, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, lines);
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        if (lines == null) {
            this.lines = null;
        } else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    private void checkIndex(int index) throws WindowException { // для удобства, выделим проверку в отдельный метод.
        if (lines == null) {
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        } else if (index < 0 || index > lines.length - 1) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
    }

    public String getLine(int index) throws WindowException {
        checkIndex(index);
        return lines[index];
    }

    public void setLine(int index, String line) throws WindowException {
        checkIndex(index);
        lines[index] = line;

    }

    public String[] getLinesSlice(int from, int to) throws WindowException {
        checkIndex(from); // здесь можем запустить метод checkIndex дважды, чтобы проверить оба значения
        if (to <= from || to > lines.length) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
        int num = to - from;
        String[] result = new String[num];
        System.arraycopy(this.lines, from, result, 0, num);
        return result;
    }

    public Integer findLine(String line) {
        if (lines != null) {
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].equals(line)) {
                    return i;
                }
            }
        }
        return null;
    }

    public void reverseLineOrder() {
        if (lines != null) {
            String copy;
            for (int i = 0; (lines.length - 1 - i) != i; i++) {
                if ((lines.length - 1 - i) < i) {
                    break;
                } else {
                    copy = lines[lines.length - 1 - i];
                    lines[lines.length - 1 - i] = lines[i];
                    lines[i] = copy;
                }
            }
        }
    }

    public void reverseLines() {
        if (lines != null) {
            for (int i = 0; i < lines.length; i++) {
                lines[i] = StringOperations.reverse(lines[i]); // обратимся к созданному ранее методу
            }
        }
    }

    public void duplicateLines() {
        if (lines != null) {
            String[] duplicate = new String[lines.length * 2];
            for (int i = 0; i < lines.length; i++) {
                duplicate[i + i] = lines[i];
                duplicate[i + i + 1] = lines[i];
            }
            setLines(duplicate);
        }
    }

    public void removeOddLines() {
        if (lines != null && lines.length > 1) {
            ArrayList<String> remove = new <String>ArrayList(); // для удобства воспользуемся ArrayList
            for (int i = 0; i < lines.length; i++) {
                if (i % 2 == 0) {
                    remove.add(lines[i]);
                }
            }
            setLines(remove.toArray(new String[0]));
        }
    }

    public boolean isSortedDescendant() {
        if (lines != null) {
            for (int i = 1; i < lines.length; i++) {
                return !(lines[i].compareTo(lines[i - 1]) >= 0);
            }
        }
        return true;
    }
}









