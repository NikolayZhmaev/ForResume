package net.thumbtack.school.sunday.functions;

//5. Напишите функцию create, принимающую в качестве аргумента строку и возвращающую Person с именем равным переданной строке. Перепишите при помощи method reference.

import java.util.Optional;
import java.util.function.Function;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

public class PersonReturns {

    public static <T, R> R transform(T value, Function<T, R> f) {
        return f.apply(value);
    }

    public static Person create(String firstName) {
        PersonFactory<Person> personFactory = Person::new;
        return personFactory.create(firstName, "null");
    }

    public static Person createReference(String firstName) {
        return transform(firstName, PersonReturns::create);
    }

    public static Person getMothersMotherFather(Person person) {

        return getFatherPerson(getMothersMotherPerson(person));
    }

    private static Person getMothersMotherPerson(Person person) throws NullPointerException {
        try {
            MyFunction<Person, Person> personMyFunction = (Person::getMother);
            return personMyFunction.apply(person).getMother();
        } catch (Exception e) {
            return null;
        }
    }

    private static Person getFatherPerson(Person person) throws NullPointerException {
        try {
            MyFunction<Person, Person> personMyFunction = (Person::getFather);
            return personMyFunction.apply(person);
        } catch (Exception e) {
            return null;
        }
    }

    static Optional<newPerson> getMothersMotherFatherOptional(newPerson person) {
        Optional<newPerson> father = Optional.ofNullable(person.getMother().flatMap(newPerson::getMother)
                .flatMap(newPerson::getFather).orElse(null));
        return father;
    }
}
