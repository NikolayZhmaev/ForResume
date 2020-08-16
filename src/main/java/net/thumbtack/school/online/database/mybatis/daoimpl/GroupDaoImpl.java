package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.model.Trainee;
import net.thumbtack.school.online.database.mybatis.dao.GroupDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GroupDaoImpl extends DaoImplBase implements GroupDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Override
    public Group insert(School school, Group group) {
        LOGGER.debug("DAO insert GROUP binding it to School {}", school);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).insert(school, group);

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert GROUP {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return group;
    }

    @Override
    public Group update(Group group) {
        LOGGER.debug("DAO update Group {}", group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).update(group);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't update Group {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return group;
    }

    @Override
    public List<Group> getAll() {
        LOGGER.debug("DAO get all groups");
        try (SqlSession sqlSession = getSession()) {
            try {
                return getGroupMapper(sqlSession).getAll();

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get all groups {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public void delete(Group group) {
        LOGGER.debug("DAO delete Group {}", group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).delete(group);

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Group {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public Trainee moveTraineeToGroup(Group group, Trainee trainee) {
        LOGGER.debug("DAO move Trainee to Group {}", group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).moveTraineeToGroup(group, trainee);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't move Trainee to Group {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return trainee;
    }

    @Override
    public void deleteTraineeFromGroup(Trainee trainee) {
        LOGGER.debug("DAO delete trainee from group {} ", trainee);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).deleteTraineeFromGroup(trainee);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete trainee from group {} ", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void addSubjectToGroup(Group group, Subject subject) {
        LOGGER.debug("DAO add Subject to Group {}", group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).addSubjectToGroup(group, subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't add Subject to Group {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
