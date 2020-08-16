package net.thumbtack.school.online.database.model;

import java.util.Objects;

public class Subject {

    private int idSubject;
    private String nameSubject;

    public Subject() {
    }

    public Subject(int id, String name) {
        setId(id);
        setName(name);
    }

    public Subject(String name) {
        this (0, name);
    }

    public int getId() {
        return idSubject;
    }

    public void setId(int id) {
        this.idSubject = id;
    }

    public String getName() {
        return nameSubject;
    }

    public void setName(String name) {
        this.nameSubject = name;
    }

    @Override
    public String toString() {
        return "(" + idSubject + ",'" + nameSubject + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return getId() == subject.getId() &&
                Objects.equals(getName(), subject.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }
}
