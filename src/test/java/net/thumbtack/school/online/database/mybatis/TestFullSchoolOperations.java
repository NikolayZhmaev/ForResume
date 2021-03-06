package net.thumbtack.school.online.database.mybatis;

import static org.junit.Assert.*;

import java.util.*;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.model.Trainee;
import org.junit.Test;


public class TestFullSchoolOperations extends TestBase {


    @Test
    public void testInsertSchoolWithGroupsAndTrainees() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Group groupFrontEnd = insertGroup(school2018, "BackEnd", 2018);
            Group groupBackEnd = insertGroup(school2018, "FrontEnd", 2018);
            insertFrontEndTrainees(groupFrontEnd);
            insertBackendTrainees(groupBackEnd);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            for(Group group : schoolFromDB.getGroups()) {
                Collections.sort(group.getTrainees(), (p1,p2) -> Integer.compare(p1.getId(), p2.getId()));
            }
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }


    @Test
    public void testInsertSchoolWithGroupsAndSubjectsAndTrainees() {
        try {
            School school2018 = insertTTSchool("TTSchool", 2018);
            Map<String, Subject> subjects = insertSubjects("Linux", "MySQL", "NodeJS");
            Group groupFrontEnd = insertFrontEndGroupWithSubjects(school2018, 2018, subjects);
            Group groupBackEnd = insertBackEndGroupWithSubjects(school2018, 2018, subjects);
            insertFrontEndTrainees(groupFrontEnd);
            insertBackendTrainees(groupBackEnd);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            for(Group group : schoolFromDB.getGroups()) {
                Collections.sort(group.getTrainees(), (p1,p2) -> Integer.compare(p1.getId(), p2.getId()));
            }

            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testInsertSchoolWithGroupsAndTraineesTransactionally() {
        try {
            Map<String, Subject> subjects = insertSubjects("Linux", "MySQL", "NodeJS");
            School school2018 = new School("TTSchool", 2018);
            Group groupFrontEnd = new Group("Frontend 2018", "11");
            groupFrontEnd.addSubject(subjects.get("Linux"));
            groupFrontEnd.addSubject(subjects.get("NodeJS"));
            Group groupBackEnd = new Group("Backend 2018" , "12");
            groupBackEnd.addSubject(subjects.get("Linux"));
            groupBackEnd.addSubject(subjects.get("MySQL"));
            Trainee traineeIvanov = new Trainee("Иван", "Иванов", 5);
            Trainee traineePetrov = new Trainee("Петр", "Петров", 4);
            groupFrontEnd.addTrainee(traineeIvanov);
            groupFrontEnd.addTrainee(traineePetrov);
            Trainee traineeSidorov = new Trainee("Сидор", "Сидоров", 2);
            Trainee traineeSmirnov = new Trainee("Николай", "Смирнов", 3);
            groupBackEnd.addTrainee(traineeSidorov);
            groupBackEnd.addTrainee(traineeSmirnov);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school2018.setGroups(groups);
            schoolDao.insertSchoolTransactional(school2018);
            School schoolFromDB = schoolDao.getById(school2018.getId());
            assertEquals(school2018, schoolFromDB);
        } catch (RuntimeException e) {
            fail();
        }
    }
}
