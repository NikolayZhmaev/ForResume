package net.thumbtack.school.sunday.functions;

import java.util.Objects;

public class AgePerson {
    private String name;
    private int age;

    public AgePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgePerson agePerson = (AgePerson) o;
        return name.equals(agePerson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
