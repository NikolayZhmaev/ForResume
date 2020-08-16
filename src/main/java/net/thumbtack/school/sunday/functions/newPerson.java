package net.thumbtack.school.sunday.functions;

import java.util.Optional;

public class newPerson {
    private String firstName;
    private String lastName;
    private Optional<newPerson> father;
    private Optional<newPerson> mother;

    public newPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.father = Optional.ofNullable(null);
        this.mother = Optional.ofNullable(null);

    }

    public newPerson(String firstName, String lastName, newPerson father, newPerson mother) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.father = Optional.ofNullable(father);
        this.mother = Optional.ofNullable(mother);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<newPerson> getFather() {
        return father;
    }

    public void setFather(newPerson father) {
        this.father = Optional.ofNullable(father);
    }

    public Optional<newPerson> getMother() {
        return mother;
    }

    public void setMother(newPerson mother) {
        this.mother = Optional.ofNullable(mother);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "newPerson [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof newPerson)) return false;
        newPerson newPerson = (newPerson) o;
        return firstName.equals(newPerson.firstName) &&
                lastName.equals(newPerson.lastName) &&
                father.equals(newPerson.father) &&
                mother.equals(newPerson.mother);
    }
}


