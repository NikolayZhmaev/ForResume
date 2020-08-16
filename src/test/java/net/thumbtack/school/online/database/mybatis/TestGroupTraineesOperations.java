package net.thumbtack.school.online.database.mybatis;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Trainee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class TestGroupTraineesOperations extends TestBase {

    @Test
    public void testInsertTraineeAndAddToGroup() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Group groupFrontEnd1018 = insertGroup(school2018,"Frontend2018", 2018);
            Trainee traineeIvanov = new Trainee("Иван", "Иванов", 5);
            traineeDao.insert(null, traineeIvanov);
            assertNotEquals(0, traineeIvanov.getId());
            Trainee traineeIvanovFromDB = traineeDao.getById(traineeIvanov.getId());
            assertEquals(traineeIvanov, traineeIvanovFromDB);
            groupDao.moveTraineeToGroup(groupFrontEnd1018, traineeIvanov);
            groupFrontEnd1018.addTrainee(traineeIvanov);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd1018);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testInsertTraineeAndMoveToAnotherGroup() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Group groupFrontEnd = insertGroup(school2018, "Frontend", 2018);
            Group groupBackEnd = insertGroup(school2018, "Backend", 2018);
            Trainee traineeIvanov = new Trainee("Иван", "Иванов", 5);
            traineeDao.insert(groupFrontEnd, traineeIvanov);
            assertNotEquals(0, traineeIvanov.getId());
            Trainee traineeeIvanovFromDB = traineeDao.getById(traineeIvanov.getId());
            assertEquals(traineeIvanov, traineeeIvanovFromDB);

            List<Group> groups = new ArrayList<>();
            groupFrontEnd.addTrainee(traineeIvanov);
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);

            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);

            groupDao.moveTraineeToGroup(groupBackEnd, traineeIvanov);

            groups.clear();
            groupFrontEnd.removeTrainee(traineeIvanov);
            groupBackEnd.addTrainee(traineeIvanov);
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);

            schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);

        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testRemoveTraineeFromGroup() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Group groupFrontEnd = insertGroup(school2018, "Frontend", 2018);
            Trainee traineeIvanov = new Trainee("Иван", "Иванов", 5);
            traineeDao.insert(groupFrontEnd, traineeIvanov);
            assertNotEquals(0, traineeIvanov.getId());
            Trainee traineeIvanovFromDB = traineeDao.getById(traineeIvanov.getId());
            assertEquals(traineeIvanov, traineeIvanovFromDB);

            List<Group> groups = new ArrayList<>();
            groupFrontEnd.addTrainee(traineeIvanov);
            groups.add(groupFrontEnd);
            school2018.setGroups(groups);

            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);

            groupDao.deleteTraineeFromGroup(traineeIvanov);

            groups.clear();
            groupFrontEnd.removeTrainee(traineeIvanov);
            groups.add(groupFrontEnd);
            school2018.setGroups(groups);

            schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);

        } catch (RuntimeException e) {
            fail();
        }
    }

}
