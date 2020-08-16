package net.thumbtack.school.online.windows.v2;

import java.util.Objects;

public class Point {


    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
       this (0,0);
    }

    public Point(Point point) {
        x = point.getX();
        y = point.getY();
    }

	public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }


	public void moveRel(int dx, int dy) {
        y+=dy;
        x+=dx;
    }

    public boolean isVisibleOnDesktop(Desktop desktop) {
        return checkCoordinate(desktop); /* для удобства выделим проверку в отдельный метод
                                          и будем его использовать далее*/
    }

    private boolean checkCoordinate(Desktop desktop) {
        boolean rez = false; // создадим меременную для хранения результата проверки
        int yMax = desktop.getHeight(); // получим максимальное значение координаты y
        int xMax = desktop.getWidth(); // получим максимальное значение координаты x
        if (y>0 && y<yMax) {
            if (x>0 && x<xMax) {
                return rez=true;
            }
            return rez;
        }
        return rez;
    }

    public boolean isNotVisibleOnDesktop(Desktop desktop) {
       if (!checkCoordinate(desktop)) { /*самое время для созданного ранее метода. Ведь по сути,
                                                 isVisibleOnDesktop и isNotVisibleOnDesktop делают одно и тоже,
                                                 только с обратным результатом*/
           return true;
       }
       return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
