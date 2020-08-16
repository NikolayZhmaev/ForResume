package net.thumbtack.school.sunday.functions;

import net.thumbtack.school.sunday.functions.CurrentDate;
import net.thumbtack.school.sunday.functions.FunctionMax;
import net.thumbtack.school.sunday.functions.Functions;
import net.thumbtack.school.sunday.functions.Person;
import net.thumbtack.school.sunday.functions.PersonReturns;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class testFunctions {

    @Test
    public void testsplit() {
        String str = "one two three four";

        Functions functions = new Functions();
        assertEquals(functions.split(str).size(), 4);
    }

    @Test
    public void testcount() {
        String str = "one two three four";

        Functions functions = new Functions();
        List<?> strings = functions.split(str);
        int result = functions.count(strings);
        assertEquals(result, 4);
    }

    @Test
    public void testItemsInStringLambda() {
        String str = "one two three four";

        Functions functions = new Functions();
        int result = functions.itemsInStringLambda(str);
        assertEquals(result, 4);
    }

    @Test
    public void tesritemsInString() {
        String str = "one two three four";

        Functions functions = new Functions();
        int result = functions.itemsInString(str);
        assertEquals(result, 4);
    }

    @Test
    public void testsplitAndCount() {
        String str = "one two three four";

        Functions functions = new Functions();
        int result = functions.splitAndCount(str);
        assertEquals(result, 4);
    }

    @Test
    public void testsplitAndCountСompose() {
        String str = "one two three four";

        Functions functions = new Functions();
        int result = functions.splitAndCountСompose(str);
        assertEquals(result, 4);
    }

    @Test
    public void testCreate() {
        String name = "Алексей";

        PersonReturns personReturns = new PersonReturns();
        Person person = personReturns.create(name);
        assertEquals(person.getFirstName(), name);
    }

    @Test
    public void testCreateReference() {
        String name = "Виктор";

        PersonReturns personReturns = new PersonReturns();
        Person person = personReturns.createReference(name);
        assertEquals(person.getFirstName(), name);
    }

    @Test
    public void testFunctionMax() {
        FunctionMax functionMax = new FunctionMax();
        double result = functionMax.funtionMax(10, 20);
        assertEquals(result, 20, 1);
    }

    @Test
    public void testFunctionMaxReference() {
        FunctionMax functionMax = new FunctionMax();
        double result = functionMax.funtionMaxReference(10, 20);
        assertEquals(result, 20, 1);
    }

    @Test
    public void testCurrentDate() {
        CurrentDate currentDate = new CurrentDate();
        String date = currentDate.currentDate();
        assertTrue(date.contains("/2020"));

    }

    @Test
    public void testsIsEven() {
        Functions functions = new Functions();
        assertTrue(functions.isEven(12));
        assertFalse(functions.isEven(13));
    }

    @Test
    public void testsAreEqual() {
        CheckEqual checkEqual = new CheckEqual();
        assertTrue(checkEqual.areEqual(12, 12));
        assertFalse(checkEqual.areEqual(12, 11));
    }

    public Person personFactory() {
        Person person1 = new Person("Иван", "Иванов");
        Person person2 = new Person("Иван", "Петров");
        Person person3 = new Person("Мария", "Иванова");
        Person person4 = new Person("Анна", "Петровна");

        person4.setFather(person1);
        person3.setMother(person4);
        person2.setMother(person3);
        return person2;
    }

    @Test
    public void getMothersMotherFather() {
        Person person = personFactory();

        PersonReturns personReturns = new PersonReturns();
        Person newPerson = personReturns.getMothersMotherFather(person);
        assertEquals(newPerson.getFirstName(), "Иван");
    }

    @Test
    public void getMothersMotherFatherNull() {
        Person person = new Person("Иван", "Иванов");

        PersonReturns personReturns = new PersonReturns();
        Person newPerson = personReturns.getMothersMotherFather(person);
        assertNull(newPerson);
    }

    public newPerson newPersonFactory() {
        newPerson person1 = new newPerson("Иван", "Иванов");
        newPerson person2 = new newPerson("Иван", "Петров");
        newPerson person3 = new newPerson("Мария", "Иванова");
        newPerson person4 = new newPerson("Анна", "Петровна");

        person4.setFather(person1);
        person3.setMother(person4);
        person2.setMother(person3);
        return person2;
    }

    @Test
    public void getMothersMotherFatherOptional() {
        newPerson person = newPersonFactory();

        PersonReturns personReturns = new PersonReturns();
        Optional<newPerson> newPerson = personReturns.getMothersMotherFatherOptional(person);
        assertTrue(newPerson.isPresent());
        assertEquals(newPerson.get().getFirstName(), "Иван");
    }

    @Test
    public void getMothersMotherFatherNullOptional() {
        newPerson person = new newPerson("Иван", "Иванов");
        newPerson personMather = new newPerson("Мария", "Иванова");
        person.setMother(personMather);

        PersonReturns personReturns = new PersonReturns();
        Optional<newPerson> newPerson = personReturns.getMothersMotherFatherOptional(person);
        assertFalse(newPerson.isPresent());
    }

    @Test
    public void testTransform() {
        Functions functions = new Functions();
        IntStream stream1 = IntStream.of(4, 5, 6, 7);
        IntUnaryOperator op = num -> (num * num);
        functions.transform(stream1, op);
    }

    @Test
    public void testTransformParallelStream() {
        Functions functions = new Functions();
        IntStream stream1 = IntStream.of(4, 5, 6, 7);
        IntUnaryOperator op = num -> (num * num);
        functions.transformParallelStream(stream1, op);

        /*
         Ответ: IntStream parallel () — при каждом запуске разная очередность. может возвращать сам себя либо потому,
                что поток уже присутствовал, либо потому, что основное состояние потока было изменено, чтобы быть параллельным.
        */
    }

    @Test
    public void testGetPersonSortUniqNameOld() {
        List<AgePerson> agePeople = new ArrayList<>();
        agePeople.add(new AgePerson("Николай", 33));
        agePeople.add(new AgePerson("Алексей", 30));
        agePeople.add(new AgePerson("Михаил", 42));
        agePeople.add(new AgePerson("Анатолий", 53));
        agePeople.add(new AgePerson("Иван", 18));
        agePeople.add(new AgePerson("Егор", 33));
        agePeople.add(new AgePerson("Николай", 40));

        List<AgePerson> actualList = new ArrayList<>();
        actualList.add(new AgePerson("Егор", 33));
        actualList.add(new AgePerson("Михаил", 42));
        actualList.add(new AgePerson("Николай", 33));
        actualList.add(new AgePerson("Анатолий", 53));

        Functions functions = new Functions();
        List<AgePerson> agePeopleSort = functions.getPersonSortUniqNameOld(agePeople);
        assertEquals(agePeopleSort.size(), 4);
        assertEquals(agePeopleSort, actualList);
    }

    @Test
    public void testGetPersonSortUniqEqualName() {
        List<AgePerson> agePeople = new ArrayList<>();
        agePeople.add(new AgePerson("Николай", 33));
        agePeople.add(new AgePerson("Николай", 32));
        agePeople.add(new AgePerson("Михаил", 42));
        agePeople.add(new AgePerson("Анатолий", 53));
        agePeople.add(new AgePerson("Анатолий", 43));
        agePeople.add(new AgePerson("Егор", 33));
        agePeople.add(new AgePerson("Николай", 40));

        List <String> expectedList = new ArrayList<String>();
        expectedList.add("Михаил");
        expectedList.add("Егор");
        expectedList.add("Анатолий");
        expectedList.add("Николай");

        Functions functions = new Functions();
        List<String> agePeopleSort = functions.getPersonSortUniqEqualName(agePeople);
        assertEquals(agePeopleSort.size(), 4);
        assertEquals(agePeopleSort, expectedList);
    }

    @Test
    public void testSum() {
        Functions functions = new Functions();
        List<Integer> request = new ArrayList<Integer>();
        request.add(2); request.add(10);
        assertEquals(functions.sum(request), 12);
    }

    @Test
    public void testProduct() {
        Functions functions = new Functions();
        List<Integer> request = new ArrayList<Integer>();
        request.add(2); request.add(10);
        assertEquals(functions.product(request), 20);
    }
}
