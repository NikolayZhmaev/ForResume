package net.thumbtack.school.online.windows.v3;

import net.thumbtack.school.online.base.StringOperations;

import java.util.ArrayList;

public class ListBox extends RectButton {

    String[] lines = null;

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        super(xLeft, yTop, width, height, active, null);
        if (lines != null) {
           this.lines = lines.clone();
        }
    }

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        super(topLeft.getX(), topLeft.getY(), (bottomRight.getX() - topLeft.getX() + 1),
                (bottomRight.getY() - topLeft.getY() + 1), active, null);

        if (lines != null) {
            this.lines = lines.clone();
        }
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        this(topLeft, bottomRight, true, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this(xLeft, yTop, width, height, true, lines);
    }

    public String[] getLines() {
        if (lines != null) {
            return lines;
        }
        return null;
    }

    public void setLines(String[] lines) {
        if (lines == null) {
            this.lines = null;
        } else {
            this.lines = lines.clone();
        }
    }

    public String[] getLinesSlice(int from, int to) {
        int num = to - from;
        if (lines != null) {
            if (to <= lines.length) {
                String[] result = new String[num];
                System.arraycopy(this.lines, from, result, 0, num);
                return result;
            } else {
                String[] result = new String[lines.length];
                System.arraycopy(this.lines, from, result, 0, lines.length);
                return result;
            }
        }
        return null;
    }

    public String getLine(int index) {

        if (lines.length != 0 && index <= lines.length - 1) {
            return lines[index];
        } else {
            return null;
        }
    }

    public void setLine(int index, String line) {
        if (lines != null && index <= lines.length) {
            lines[index] = line;
        }
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
            this.lines = duplicate;
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
            this.lines = remove.toArray(new String[0]);
        }
    }

    public boolean isSortedDescendant() {
        boolean res = true;
        if (lines != null) {
            for (int i = 1; i < lines.length; i++) {
                if (lines[i].compareTo(lines[i - 1]) >= 0) {
                    return false;
                }
            }
        }
        return res;
    }
}









