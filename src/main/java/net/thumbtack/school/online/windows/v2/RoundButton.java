package net.thumbtack.school.online.windows.v2;

import java.util.Objects;

public class RoundButton {

   /* Нажимная круглая кнопка. Для кнопки определено 2 состояния - активна (можно нажать) и пассивна
    (серого цвета, нажать нельзя).*/

	private int xCenter, yCenter, radius; // создадим поля для хранения координат кнопки и ее размеров.
	private boolean active = true; // создадим поле для хранения состояния кнопки (по умолчанию активна)
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String txt) {
		this.text = txt;
	}

	public RoundButton(Point center, int radius, boolean active, String txt) {
   	this.xCenter = center.getX();
   	this.yCenter = center.getY();
   	this.radius = radius;
   	this.active = active;
   	this.text = txt;
   }

	public RoundButton(int xCenter, int yCenter, int radius, boolean active, String txt) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radius = radius;
		this.active = active;
		this.text = txt;
	}

	public RoundButton(Point center, int radius, String text) {
    	this (center.getX(), center.getY(), radius, true, text);
	}

	public RoundButton(int xCenter, int yCenter, int radius, String text) {
      	this (xCenter, yCenter, radius, true, text);
	}

	public Point getCenter() {
    	return new Point(xCenter, yCenter);
	}


	public int getRadius() {
    	return radius;
	}


	public boolean isActive() {
    	return active;
	}

    public void moveTo(int x, int y) {
    	this.xCenter = x;
    	this.yCenter = y;
	}

    public void moveTo(Point point) {
    	  this.xCenter = point.getX();
    	  this.yCenter = point.getY();
	}

	public void setCenter(int x, int y) {
    	this.xCenter = x;
    	this.yCenter = y;
	}

	public void setRadius(int radius) {
    	this.radius = radius;
	}

	public void setActive(boolean active) {
    	this.active = active;
	}

    public void moveRel(int dx, int dy) {
   	  xCenter += dx;
   	  yCenter += dy;
	}

    public void resize(double ratio) {
       radius = (int) (radius * ratio);
       if (radius < 1) {
       	radius = 1;
	   }
	}

    public boolean isInside(int x, int y) {
		return checkProvisions(x, y); // вынесем проверку в отдельный метод.
	}

	private boolean checkProvisions(int x, int y) {   /* если расстояние от точки до центра окружности меньше (равно)
		                                               радиуса, то точка лежит внутри окружности*/
		double rez = (Math.pow((x - xCenter), 2) + Math.pow((y - yCenter), 2));

		if ( Math.pow(radius, 2) >= rez) {
             return true;
        }
		return false;
	}

	public boolean isInside(Point point) {
    	return checkProvisions(point.getX(), point.getY()); // воспользуемся созданным ранее методом
	}

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
    	if ((xCenter - radius) >= 0 && (yCenter - radius) >= 0) {
			if ((xCenter + radius) < desktop.getWidth() && (yCenter + radius) < desktop.getHeight()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RoundButton that = (RoundButton) o;
		return xCenter == that.xCenter &&
				yCenter == that.yCenter &&
				radius == that.radius &&
				active == that.active &&
				Objects.equals(text, that.text);
	}

	@Override
	public int hashCode() {

		return Objects.hash(xCenter, yCenter, radius, active, text);
	}
}
