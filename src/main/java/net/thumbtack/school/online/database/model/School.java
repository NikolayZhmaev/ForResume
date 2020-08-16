package net.thumbtack.school.online.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {
    private int idSchool;
    private String nameSchool;
    private int year;
    private List<Group> groups;

    public School() {
    }

    public School(int id, String name, int year, List<Group> groups) {
        setId(id);
        setName(name);
        setYear(year);
        setGroups(groups);
    }

    public School(int id, String name, int year) {
        this (id, name, year, new ArrayList<Group>());
    }

    public School(String name, int year) {
        this (0, name, year, new ArrayList<Group>());
    }

    public void addGroup (Group group) {
        groups.add(group);
    }

    public void removeGroup (Group group) {
        groups.remove(group);
    }

    public int getId() {
        return idSchool;
    }

    public void setId(int id) {
        this.idSchool = id;
    }

    public String getName() {
        return nameSchool;
    }

    public void setName(String name) {
        this.nameSchool = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "(" + idSchool + ",'" + nameSchool + "','" + year + "')";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return idSchool == school.idSchool &&
                getYear() == school.getYear() &&
                Objects.equals(nameSchool, school.nameSchool) &&
                Objects.equals(getGroups(), school.getGroups());
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSchool, nameSchool, getYear(), getGroups());
    }
}
