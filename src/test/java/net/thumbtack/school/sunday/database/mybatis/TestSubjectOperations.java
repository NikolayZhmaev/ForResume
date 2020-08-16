package net.thumbtack.school.sunday.database.mybatis;

import net.thumbtack.school.online.database.model.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class TestSubjectOperations extends TestBase {

    @Test
    public void testInsertSubject() {
        try {
            Subject subject = insertSubject("Linux");
            Subject subjectFromDB = subjectDao.getById(subject.getId());
            assertEquals(subject, subjectFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testInsertSubjectWithNullName() {
        Subject subject = new Subject(null);
        subjectDao.insert(subject);
    }

    @Test
    public void testUpdateSubject() {
        try {
            Subject subject = insertSubject("Linux");
            Subject subjectFromDB = subjectDao.getById(subject.getId());
            assertEquals(subject, subjectFromDB);
            subject.setName("Windows");
            subjectDao.update(subject);
            subjectFromDB = subjectDao.getById(subject.getId());
            assertEquals(subject, subjectFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateSubjectSetNullName() {
        Subject subject = insertSubject("Linux");
        Subject subjectFromDB = subjectDao.getById(subject.getId());
        assertEquals(subject, subjectFromDB);
        subject.setName(null);
        subjectDao.update(subject);
    }

    @Test
    public void testDeleteSubject() {
        try {
            Subject subject = insertSubject("Linux");
            Subject subjectFromDB = subjectDao.getById(subject.getId());
            assertEquals(subject, subjectFromDB);
            subjectDao.delete(subject);
            subjectFromDB = subjectDao.getById(subject.getId());
            assertNull(subjectFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }
    @Test
    public void testInsertTwoSubjects() {
        try {
            Subject subjectLinux = insertSubject("Linux");
            Subject subjectMySQL = insertSubject("MySQL");
            List<Subject> subjects = new ArrayList<>();
            subjects.add(subjectLinux);
            subjects.add(subjectMySQL);
            List<Subject> subjectsFromDB = subjectDao.getAll();
            assertEquals(subjects, subjectsFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

}
