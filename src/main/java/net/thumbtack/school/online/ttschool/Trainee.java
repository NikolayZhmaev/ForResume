package net.thumbtack.school.online.ttschool;

import java.io.Serializable;
import java.util.Objects;

public class Trainee implements Serializable {

    private static final long serialVersionUID = 803745049487892458L;

    private String firstName, lastName;
    private int rating;

    public void checkFirstName(String firstName) throws TrainingException {
        if (firstName == null || firstName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        }
    }

    public void checkLastName(String lastName) throws TrainingException {
        if (lastName == null || lastName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        }
    }

    public void checkRating(int rating) throws TrainingException {
        if (rating <= 0 || rating > 5) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TrainingException {
        checkFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws TrainingException {
        checkLastName(lastName);
        this.lastName = lastName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws TrainingException {
        checkRating(rating);
        this.rating = rating;
    }

    public Trainee(String firstName, String lastName, int rating) throws TrainingException {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }

    public String getFullName() {
        return getFirstName().concat(" ").concat(getLastName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return rating == trainee.rating &&
                Objects.equals(firstName, trainee.firstName) &&
                Objects.equals(lastName, trainee.lastName) &&
                Objects.equals(rating, trainee.rating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, rating);
    }
}
