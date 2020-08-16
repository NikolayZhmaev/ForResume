package net.thumbtack.school.online.database.mybatis;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestSchoolGroupsOperations extends TestBase {

    @Test
    public void testInsertSchoolWithGroups() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            List<Group> groups = insertSchoolGroups(school2018, 2018);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testUpdateSchoolGroup() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Group groupFrontEnd = insertGroup(school2018,  "FrontEnd", 2018);
            Group groupBackEnd = insertGroup(school2018,  "BackEnd", 2018);
            groupFrontEnd.setRoom("100");
            groupFrontEnd.setName("web");
            groupDao.update(groupFrontEnd);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testInsertGroupWithoutSchool() {
        Group group = new Group("frontend2018", "11");
        groupDao.insert(null, group);
    }


    @Test(expected = RuntimeException.class)
    public void testInsertGroupBeforeInsertingSchool() {
        School school = new School("TTSchool", 2018);
        Set<Group> groups = new HashSet<>();
        Group group = new Group("frontend2018", "11");
        groupDao.insert(school, group);

    }

}
