package net.thumbtack.school.online.windows.v2;

import net.thumbtack.school.online.base.StringOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ListBox {

    private boolean active = true; // создадим поле для хранения состояния окна (по умолчанию активно)
    private  int xLeft, yTop, width, height; //создадим поля для хранения параметров окна.
    String [] lines = null;


    public void setActive(boolean active) {
        this.active = active;
    }

    public int getxLeft() {
        return xLeft;
    }

    public void setxLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public int getyTop() {
        return yTop;
    }

    public void setyTop(int yTop) {
        this.yTop = yTop;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = active;
        if (lines != null ) {
            this.lines = lines.clone();
        }

    }

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - xLeft + 1;
        this.height = bottomRight.getY() - yTop + 1;
        this.active = active;
        if (lines != null) {
            this.lines = lines.clone();
        }
    }

    public ListBox(Point topLeft, Point bottomRight,  String[] lines) {
        this (topLeft, bottomRight, true, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this (xLeft, yTop, width, height, true, lines);
    }

    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    public Point getBottomRight() {
        return new Point(xLeft+width-1,yTop+height-1);
    }

    public boolean isActive() {
        return active;
    }

    public void setTopLeft(Point topLeft) {
        this.yTop = topLeft.getY();
        this.xLeft = topLeft.getX();
    }

    public void setBottomRight(Point bottomRight) {
        this.width = bottomRight.getX() - xLeft + 1;
        this.height = bottomRight.getY() - yTop + 1;
    }

    public String[] getLines() {
      if (lines != null) {
            return lines;
      }
        return null;
    }

    public void setLines(String[] lines) {
        if ( lines == null) {
            this.lines = null;
        }
        else {
            this.lines = lines.clone();
        }
    }

    public String[] getLinesSlice(int from, int to) {
        int num = to - from;
        if ( lines != null) {
            if (to <= lines.length) {
                String[] result = new String[num];
                System.arraycopy(this.lines, from, result, 0, num);
                return result;
            }
            else {
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
           if ( lines != null && index <= lines.length) {
              lines [index] = line;
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
               for (int i = 0; (lines.length-1-i) != i; i++) {
                   if ((lines.length-1-i) < i) {
                       break;
                   }
                   else {
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
                String [] duplicate = new String[lines.length*2];
                for (int i = 0; i < lines.length; i++) {
                    duplicate[i+i] = lines[i];
                    duplicate[i+i+1] = lines[i];
                }
                this.lines=duplicate;
            }
        }

        public void removeOddLines() {
            if (lines != null && lines.length >1) {
                ArrayList <String> remove = new <String> ArrayList(); // для удобства воспользуемся ArrayList
                for (int i = 0; i < lines.length; i++) {
                    if (i%2 == 0) {
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

    public void moveTo(int x, int y) {
        xLeft = x;
        yTop = y;
    }

    public void moveTo(Point point) {
        xLeft = point.getX();
        yTop = point.getY();
    }

    public void moveRel(int dx, int dy) {
        xLeft+=dx;
        yTop+=dy;
    }

    public void resize(double ratio) {
        width = (int) (width*ratio);
        height = (int) (height*ratio);
        if (width<1) {
            width = 1;
        }
        if (height<1) {
            height = 1;
        }
    }

    public boolean isInside(int x, int y) {
            return checkProvisions(x, y); // для избежания копирования кода вынесем проверку в отдельный метод
    }

    private boolean checkProvisions(int x, int y) {
        if (x>=xLeft && x<=xLeft+width-1) {
            if (y>=yTop && y<=yTop+height-1) {
                return true;
            }
        }
        return false;
    }

    public boolean isInside(Point point) {
        return checkProvisions(point.getX(), point.getY());
    }

    public boolean isIntersects(ListBox listBox) {
        // прежде всего сравним кнопки на равентство, ведь в этом случае они пересекаются

        if (this.equals(listBox)) {
            return true;
        }
        else {
            // далее выполним сравнение по координатам x,y (если х не пересекается, то y можно и не сравнивать)
            for (int i = listBox.getxLeft(); i <= (listBox.getxLeft() + listBox.getWidth()); i++) {
                if (i >= xLeft && i <= xLeft+width) {
                    for (int j = listBox.getyTop(); j < (listBox.getyTop()+listBox.getHeight()) ; j++) {
                        if (j >= yTop && j <= yTop + height) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isInside(ListBox listBox) {
           // прежде всего сравним кнопки на равентство, ведь в этом случае условие проверки истинно
            if (this.equals(listBox)) {
                return true;
            }
            else {
                // Если первое условие не сработало сравним начальные координаты и длины сторон.
                if (listBox.getxLeft() > xLeft && listBox.getWidth() < width) {
                    if (listBox.getyTop() > yTop && listBox.getHeight() < height) {
                        return true;
                    }
                }
            }
            return false;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (xLeft >=0 && yTop >= 0) {
            if (width <= (desktop.getWidth() - xLeft) && height <= (desktop.getHeight() - yTop)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListBox listBox = (ListBox) o;
        return active == listBox.active &&
                xLeft == listBox.xLeft &&
                yTop == listBox.yTop &&
                width == listBox.width &&
                height == listBox.height &&
                Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(active, xLeft, yTop, width, height);
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}









