package net.thumbtack.school.online.database.mybatis;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestSchoolGroupSubjectsOperations extends  TestBase {

    @Test
    public void testInsertSchoolWithGroupsAndSubjects() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Map<String, Subject> subjects = insertSubjects("Linux", "MySQL", "NodeJS");
            List<Group> groups = insertSchoolGroupsWithSubjects(school2018, 2018, subjects);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testInsertTwoSchoolsWithGroupsAndSubjectsGetAllLazy() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            School school2019 = insertTTSchool("TTSchool", 2019);
            Map<String, Subject> subjects = insertSubjects("Linux", "MySQL", "NodeJS");
            List<Group> groups2018 = insertSchoolGroupsWithSubjects(school2018, 2018, subjects);
            List<Group> groups2019 = insertSchoolGroupsWithSubjects(school2019, 2019, subjects);
            school2018.setGroups(groups2018);
            school2019.setGroups(groups2019);
            List<School> schoolsFromDB = schoolDao.getAllLazy();
            assertEquals(2, schoolsFromDB.size());
            Collections.sort(schoolsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
            assertEquals(school2018, schoolsFromDB.get(0));
            assertEquals(school2019, schoolsFromDB.get(1));

        } catch (RuntimeException e) {
            fail();
        }
    }
    @Test
    public void testInsertTwoSchoolsWithGroupsAndSubjectsGetAllUsingJoin() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            School school2019 = insertTTSchool("TTSchool", 2019);
            Map<String, Subject> subjects = insertSubjects("Linux", "MySQL", "NodeJS");
            List<Group> groups2018 = insertSchoolGroupsWithSubjects(school2018, 2018, subjects);
            List<Group> groups2019 = insertSchoolGroupsWithSubjects(school2019, 2019, subjects);
            school2018.setGroups(groups2018);
            school2019.setGroups(groups2019);
            List<School> schoolsFromDB = schoolDao.getAllUsingJoin();
            assertEquals(2, schoolsFromDB.size());
            Collections.sort(schoolsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
            assertEquals(school2018, schoolsFromDB.get(0));
            assertEquals(school2019, schoolsFromDB.get(1));

        } catch (RuntimeException e) {
            fail();
        }
    }

}
