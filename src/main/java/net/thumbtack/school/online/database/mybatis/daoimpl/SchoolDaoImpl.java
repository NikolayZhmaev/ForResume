package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.model.Trainee;
import net.thumbtack.school.online.database.mybatis.dao.SchoolDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SchoolDaoImpl extends DaoImplBase implements SchoolDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolDaoImpl.class);

    @Override
    public School insert(School school) {
        LOGGER.debug("DAO insert school {}", school);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).insert(school);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert school {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return school;
    }

    @Override
    public School getById(int id) {
        LOGGER.debug("DAO get School by Id {}", id);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSchoolMapper(sqlSession).getById(id);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get School {}", ex);
                throw ex;
            }
        }

    }

    @Override
    public List<School> getAllLazy() {
        LOGGER.debug("DAO get all Schools using LAZY");
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSchoolMapper(sqlSession).getAllLazy();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get all Schools using LAZY {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public List<School> getAllUsingJoin() {
        LOGGER.debug("DAO get all Schools using JOIN");
        try (SqlSession sqlSession = getSession()) {
            return sqlSession.selectList("net.thumbtack.school.online.database.mybatis.mappers.SchoolMapper.getAllUsingJoin");
        } catch (RuntimeException ex) {
            LOGGER.debug("Can't get all Schools using JOIN {}", ex);
            throw ex;
        }
    }

    @Override
    public void update(School school) {
        LOGGER.debug("DAO update School {}", school);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).update(school);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can,t update School {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void delete(School school) {
        LOGGER.debug("DAO delete School {}", school);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).delete(school);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete School {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO delete all Schools {}");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).deleteAll();

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Schools {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public School insertSchoolTransactional(School school2018) {
        LOGGER.debug("Transactional DAO insert {}", school2018);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).insert(school2018);
                for (Group group : school2018.getGroups()) {
                    getGroupMapper(sqlSession).insert(school2018, group);
                    for (Trainee trainee : group.getTrainees()) {
                        getTraineeMapper(sqlSession).insert(group, trainee);
                    }
                    for (Subject subject : group.getSubjects()) {
                        getGroupMapper(sqlSession).addSubjectToGroup(group, subject);
                    }
                }
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert School {} {}", school2018, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return null;
    }
}
