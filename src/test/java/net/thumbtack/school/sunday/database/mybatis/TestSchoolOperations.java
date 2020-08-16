package net.thumbtack.school.sunday.database.mybatis;

import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.mybatis.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class TestSchoolOperations extends TestBase {
    @Test
    public void testInsertSchool() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException ex) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testInsertSchoolWithNullName() {
        School school = new School(null, 2018);
        schoolDao.insert(school);
    }


    @Test
    public void testUpdateSchool() {
        try {
            School school = insertTTSchool("TTSchool", 2018);
            School schoolFromDB = schoolDao.getById(school.getId());
            assertEquals(school, schoolFromDB);
            school.setName("Школа ТТ");
            school.setYear(2019);
            schoolDao.update(school);
            schoolFromDB = schoolDao.getById(school.getId());
            assertEquals(school, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testChangeSchoolNameToNull() {
        School school2018 = insertTTSchool("TTSchool", 2018);
        assertNotEquals(0, school2018.getId());
        School schoolFromDB = schoolDao.getById(school2018.getId());
        assertEquals(school2018, schoolFromDB);
        school2018.setName(null);
        schoolDao.update(school2018);
    }

    @Test
    public void testDeleteSchool() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
            schoolDao.delete(school2018);
            schoolFromDB = schoolDao.getById(school2018.getId());
            assertNull(schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testInsertTwoSchools() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            School school2019 = insertTTSchool("TTSchool", 2019);
            List<School> schoolsFromDB = schoolDao.getAllLazy();
            assertEquals(2, schoolsFromDB.size());
            Collections.sort(schoolsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
            assertEquals(school2018, schoolsFromDB.get(0));
            assertEquals(school2019, schoolsFromDB.get(1));
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testInsertTwoSchoolsWithSameNameAndYear() {
        School school20181 = insertTTSchool("TTSchool", 2018);
        School school20182 = insertTTSchool("TTSchool", 2018);
    }


}
