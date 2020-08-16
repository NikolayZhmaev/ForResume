package net.thumbtack.school.online.database.jdbc;


import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.model.Trainee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdbcService {

    public static void insertTrainee(Trainee trainee) throws SQLException {
        String insertTrainee = "insert into trainee values (?, ?, ?, ?, null)";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertTrainee, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, trainee.getId());
            stmt.setString(2, trainee.getFirstName());
            stmt.setString(3, trainee.getLastName());
            stmt.setInt(4, trainee.getRating());
            int result = stmt.executeUpdate();
            if (result > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    trainee.setId(generatedId);
                }
            }
        }
    }

    public static void updateTrainee(Trainee trainee) throws SQLException {
        String updateQuery = "update trainee set firstName=?, lastName=?, rating=? where idTrainee=?";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(updateQuery)) {
            stmt.setString(1, trainee.getFirstName());
            stmt.setString(2, trainee.getLastName());
            stmt.setInt(3, trainee.getRating());
            stmt.setInt(4, trainee.getId());
            stmt.executeUpdate();
        }
    }

    public static Trainee getTraineeByIdUsingColNames(int traineeId) throws SQLException {
        String getQuery = "select * from trainee WHERE idTrainee =?";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery)) {
            stmt.setInt(1, traineeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idTrainee");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int rating = rs.getInt("rating");
                return new Trainee(id, firstName, lastName, rating);
            }
        }
        return null;
    }

    public static Trainee getTraineeByIdUsingColNumbers(int traineeId) throws SQLException {
        String getQuery = "select * from trainee";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getInt(1) == traineeId) {
                    return new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getInt(4));
                }
            }
        }
        return null;
    }

    public static List<Trainee> getTraineesUsingColNames() throws SQLException {
        String getQuery = "select * from trainee";
        List<Trainee> trainees = new ArrayList<Trainee>();
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                trainees.add(new Trainee(rs.getInt("idTrainee"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getInt("rating")));
            }
        }
        return trainees;
    }

    public static List<Trainee> getTraineesUsingColNumbers() throws SQLException {
        String getQuery = "select * from trainee";
        List<Trainee> trainees = new ArrayList<Trainee>();
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                trainees.add(new Trainee(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4)));
            }
        }
        return trainees;
    }

    public static void deleteTrainee(Trainee trainee) throws SQLException {
        String deleteQuery = "delete from trainee where idTrainee=?";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            stmt.setInt(1, trainee.getId());
            stmt.executeUpdate();
        }
    }

    public static void deleteTrainees() throws SQLException {
        String deleteQuery = "delete from trainee";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            stmt.executeUpdate();
        }
    }

    public static void insertSubject(Subject subject) throws SQLException {
        String insertSubject = "insert into subject values (?,?)";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertSubject, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, subject.getId());
            stmt.setString(2, subject.getName());
            int result = stmt.executeUpdate();
            if (result > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    subject.setId(generatedId);
                }
            }
        }
    }

    public static Subject getSubjectByIdUsingColNames(int subjectId) throws SQLException {
        String getQuery = "select * from subject";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getInt("idSubject") == subjectId) {
                    return new Subject(rs.getInt("idSubject"), rs.getString("nameSubject"));
                }
            }
        }
        return null;
    }

    public static Subject getSubjectByIdUsingColNumbers(int subjectId) throws SQLException {
        String getQuery = "select * from subject";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getInt(1) == subjectId) {
                    return new Subject(rs.getInt(1), rs.getString(2));
                }
            }
        }
        return null;
    }

    public static void deleteSubjects() throws SQLException {
        String deleteQuery = "delete from subject";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            stmt.executeUpdate();
        }
    }

    public static void insertSchool(School school) throws SQLException {
        String insertSubject = "insert into school values (?,?,?)";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertSubject, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, school.getId());
            stmt.setString(2, school.getName());
            stmt.setInt(3, school.getYear());
            int result = stmt.executeUpdate();
            if (result > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    school.setId(generatedId);
                }
            }
        }
    }

    public static School getSchoolByIdUsingColNames(int schoolId) throws SQLException {
        String getQuery = "select * from school";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getInt("idSchool") == schoolId) {
                    return new School(rs.getInt("idSchool"), rs.getString("nameSchool"), rs.getInt("year"));
                }
            }
        }
        return null;
    }

    public static School getSchoolByIdUsingColNumbers(int schoolId) throws SQLException {
        String getQuery = "select * from school";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getInt(1) == schoolId) {
                    return new School(rs.getInt(1), rs.getString(2), rs.getInt(3));
                }
            }
        }
        return null;
    }

    public static void deleteSchools() throws SQLException {
        String deleteQuery = "delete school from school left join `group` on school.idSchool = `group`.schoolid;";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(deleteQuery)) {
            stmt.executeUpdate();
        }
    }

    public static void insertGroup(School school, Group group) throws SQLException {
        String insertSubject = "insert into `group` values (?,?,?,?)";
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(insertSubject, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, group.getId());
            stmt.setString(2, group.getName());
            stmt.setString(3, group.getRoom());
            stmt.setInt(4, school.getId());
            int result = stmt.executeUpdate();
            if (result > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    group.setId(generatedId);
                }
            }
        }
    }

    public static School getSchoolByIdWithGroups(int id) throws SQLException {

        String getSchoolWithGroups = "select idSchool, nameSchool, year, idGroup,  nameGroup, room from school, `group` where idSchool=?";
        School school = new School();
        List<Group> groups = new ArrayList<>();
        int idSchool = 0;
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSchoolWithGroups)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("idSchool") != idSchool) {
                    idSchool = rs.getInt("idSchool");
                    String nameSchool = rs.getString("nameSchool");
                    int year = rs.getInt("year");
                    school.setId(idSchool);
                    school.setName(nameSchool);
                    school.setYear(year);
                }
                int idGroup = rs.getInt("idGroup");
                String nameGroup = rs.getString("nameGroup");
                String room = rs.getString("room");
                groups.add(new Group(idGroup, nameGroup, room));
            }
        }
        school.setGroups(groups);
        return school;
    }

    public static List<School> getSchoolsWithGroups() throws SQLException {
        String getSchool = "select idSchool, nameSchool, year, idGroup, nameGroup, room from school left join `group` on schoolid=school.idSchool";
        School newSchool;
        Group group;
        List<School> schools = new ArrayList<>();
        try (PreparedStatement stmt = JdbcUtils.getConnection().prepareStatement(getSchool)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean flag = true;
                int idSchool = rs.getInt("idSchool");
                String nameSchool = rs.getString("nameSchool");
                int year = rs.getInt("year");
                int idGroup = rs.getInt("idGroup");
                String nameGroup = rs.getString("nameGroup");
                String room = rs.getString("room");
                newSchool = new School(idSchool, nameSchool, year);
                group = new Group(idGroup, nameGroup, room);
                for (School school : schools) {
                    if (school.getId() == newSchool.getId()) {
                        school.addGroup(group);
                        flag = false;
                    }
                }
                if (flag) {
                    newSchool.addGroup(group);
                    schools.add(newSchool);
                }
            }
        }
        return schools;
    }
}
