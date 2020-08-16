package net.thumbtack.school.online.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {

    private String name;
    private int year;
    private Set<Group> groups;

    private void checkName(String name) throws TrainingException {
        if (name == null || name.length() == 0 || name.equals(" ")) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
    }

    // по заданию нет, но все же проверим передаваемый год
    private void checkYear(int year) throws TrainingException {
        if (year <= 0) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        checkName(name);
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws TrainingException {
        checkYear(year);
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        this.groups = new HashSet<Group>();
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group gr : groups) {
            if (gr.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
        groups.remove(group);
    }

    public void removeGroup(String name) throws TrainingException {
        boolean rez = false;
        for (Group gr : groups) {
            if (gr.getName().equals(name)) {
                rez = groups.remove(gr);
                break;
            }
        }
        if (!rez) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }

    }

    public boolean containsGroup(Group group) throws TrainingException {
        for (Group gr : groups) {
            if (gr.getName().equals(group.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, year, groups);
    }
}
