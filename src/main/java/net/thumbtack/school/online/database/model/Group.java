package net.thumbtack.school.online.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private int idGroup;
    private String nameGroup;
    private String room;
    private List<Trainee> trainees;
    private List<Subject> subjects;

    public Group() {
    }

    public Group(int id, String name, String room, List<Trainee> trainees, List<Subject> subjects) {
        setId(id);
        setName(name);
        setRoom(room);
        setTrainees(trainees);
        setSubjects(subjects);
    }

    public Group(int id, String name, String room) {
        this (id, name, room, new ArrayList<Trainee>(), new ArrayList<Subject>());
    }

    public Group(String name, String room) {
        this (0, name, room, new ArrayList<Trainee>(), new ArrayList<Subject>());
    }

    public void addTrainee (Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee (Trainee trainee) {
        trainees.remove(trainee);
    }

    public void addSubject (Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject (Subject subject) {
        subjects.remove(subject);
    }

    public int getId() {
        return idGroup;
    }

    public void setId(int id) {
        this.idGroup = id;
    }

    public String getName() {
        return nameGroup;
    }

    public void setName(String name) {
        this.nameGroup = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "(" + idGroup + ",'" + nameGroup + "','" + room + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getId() == group.getId() &&
                Objects.equals(getName(), group.getName()) &&
                Objects.equals(getRoom(), group.getRoom()) &&
                Objects.equals(getTrainees(), group.getTrainees()) &&
                Objects.equals(getSubjects(), group.getSubjects());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getRoom(), getTrainees(), getSubjects());
    }
}
