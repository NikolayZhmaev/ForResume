package net.thumbtack.school.online.windows.v1;

import java.util.Objects;

public class Desktop {

   private int width, height; // создаем приватные поля для хранения значений ширины и высоты экрана.

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Desktop (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Desktop() {
        this (640,480);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desktop desktop = (Desktop) o;
        return width == desktop.width &&
                height == desktop.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(width, height);
    }


}
