package net.thumbtack.school.online.windows.v1;

import java.util.Objects;

public class RectButton {

  /*  Нажимная прямоугольная кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
   (серого цвета, нажать нельзя). Предполагается, что всегда будут передаваться допустимые координаты,
    то есть при создании или изменении всегда будет выполняться : левая точка не правее правой, верхняя
     точка не ниже нижней. */

  private int xLeft, yTop, width, height; // создадим поля для хранения координат кнопки и ее размеров.
  private boolean active = true; // создадим поле для хранения состояния кнопки (по умолчанию активна)

    public int getxLeft() {
        return xLeft;
    }

    public void setxLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public int getyTop() {
        return yTop;
    }

    public boolean getactive() {
        return active;
    }

    public void setyTop(int yTop) {
        this.yTop = yTop;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public RectButton(Point topLeft, Point bottomRight, boolean active) {
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.width = bottomRight.getX() - xLeft + 1;
        this.height = bottomRight.getY() - yTop + 1;
        this.active = active;

    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.width = width;
        this.height = height;
        this.active = active;
    }

    public RectButton(Point topLeft, Point bottomRight) {
        this (topLeft, bottomRight, true);
    }

	public RectButton(int xLeft, int yTop, int width, int height) {
        this (xLeft, yTop, width, height, true);
    }


    public Point getTopLeft() {
        return new  Point (xLeft, yTop);
    }

	public Point getBottomRight() {
        return new Point(xLeft+width-1,yTop+height-1);
    }

	public boolean isActive() {
        return active; // возвращает состояние кнопки (true, если кнопка активна, иначе false.)
    }

    public void setTopLeft(Point topLeft) {
        this.yTop = topLeft.getY();
        this.xLeft = topLeft.getX();
    }


	public void setBottomRight(Point bottomRight) {
        /* у нашей кнопки нет такого поля, как правая нижняя точка. Значит будем через этот метод задавать
        нужную ширину и высоту, так, чтобы правый нижний угол был в точке bottomRight */

        this.width = bottomRight.getX() - xLeft + 1;
        this.height = bottomRight.getY() - yTop + 1;
    }

	public void setActive(boolean active) {
        this.active = active;
    }

    public int getWidth() {
        return width;
    }

	public int getHeight() {
        return height;
    }

	public void moveTo(int x, int y){
        xLeft = x;
        yTop = y;

    }

    public void moveTo(Point point) {
        xLeft = point.getX();
        yTop = point.getY();
    }

	public void moveRel(int dx, int dy) {
        xLeft += dx;
        yTop += dy;
    }

    public void resize(double ratio) {
        width = (int) (width * ratio);
        height = (int) (height * ratio);
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


    public boolean isIntersects(RectButton rectButton) {

        // прежде всего сравним кнопки на равентство, ведь в этом случае они пересекаются

       if (this.equals(rectButton)) {
           return true;
       }
       else {
     // далее выполним сравнение по координатам x,y (если х не пересекается, то y можно и не сравнивать)
           for (int i = rectButton.getxLeft(); i <= (rectButton.getxLeft() + rectButton.getWidth()); i++) {
               if (i >= xLeft && i <= xLeft+width) {
                   for (int j = rectButton.getyTop(); j < (rectButton.getyTop()+rectButton.getHeight()) ; j++) {
                       if (j >= yTop && j <= yTop + height) {
                           return true;
                       }
                   }
               }
           }
       }
       return false;
    }

    public boolean isInside(RectButton rectButton) {
        // прежде всего сравним кнопки на равентство, ведь в этом случае условие проверки истинно
        if (this.equals(rectButton)) {
            return true;
        }
        else {
     // Если первое условие не сработало сравним начальные координаты и длины сторон.
            if (rectButton.getxLeft() > xLeft && rectButton.getWidth() < width) {
              if ( rectButton.getyTop() > yTop && rectButton.getHeight() < height) {
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
        RectButton that = (RectButton) o;
        return  xLeft == that.xLeft &&
                yTop == that.yTop &&
                width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, width, height, active);
    }
}
