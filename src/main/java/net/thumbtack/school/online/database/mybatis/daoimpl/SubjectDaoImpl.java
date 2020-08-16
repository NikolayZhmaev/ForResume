package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.mybatis.dao.SubjectDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


public class SubjectDaoImpl extends DaoImplBase implements SubjectDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImpl.class);

    @Override
    public Subject insert(Subject subject) {
        LOGGER.debug("DAO insert Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).insert(subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Subject {}, {}", subject, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return subject;
    }

    @Override
    public Subject getById(int id) {
        LOGGER.debug("DAO get Subject by Id {}", id);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSubjectMapper(sqlSession).getById(id);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get Subject {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public List<Subject> getAll() {
        LOGGER.debug("DAO get all Subjects");
        try (SqlSession sqlSession = getSession()) {
            try {
                return getSubjectMapper(sqlSession).getAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get all Subjects {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public Subject update(Subject subject) {
        LOGGER.debug("DAO update Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).update(subject);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can,t update Subject {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return subject;
    }

    @Override
    public void delete(Subject subject) {
        LOGGER.debug("DAO delete Subject {}", subject);
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).delete(subject);

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Subject {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO delete all Subjects {}");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSubjectMapper(sqlSession).deleteAll();

            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete all Subjects {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
