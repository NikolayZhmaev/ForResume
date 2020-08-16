package net.thumbtack.school.online.database.model;

import java.util.Objects;

public class Trainee {

    private int idTrainee;
    private String firstName;
    private String lastName;
    private int rating;

    public Trainee() {
    }

    public Trainee(int id, String firstName, String lastName, int rating) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }

    public Trainee(String firstName, String lastName, int rating) {
        this (0, firstName, lastName, rating);
    }

    public int getId() {
        return idTrainee;
    }

    public void setId(int id) {
        this.idTrainee = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "(" + idTrainee + ",'" + firstName + "','" + lastName + "','" + rating + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainee)) return false;
        Trainee trainee = (Trainee) o;
        return getId() == trainee.getId() &&
                getRating() == trainee.getRating() &&
                Objects.equals(getFirstName(), trainee.getFirstName()) &&
                Objects.equals(getLastName(), trainee.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getRating());
    }
}
