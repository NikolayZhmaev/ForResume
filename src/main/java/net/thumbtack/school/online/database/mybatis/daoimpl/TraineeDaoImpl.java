package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.Trainee;
import net.thumbtack.school.online.database.mybatis.dao.TraineeDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TraineeDaoImpl extends DaoImplBase implements TraineeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraineeDaoImpl.class);

    @Override
    public Trainee insert(Group group, Trainee trainee) {
        LOGGER.debug("Insert Trainee {} with a Group {}", trainee, group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getTraineeMapper(sqlSession).insert(group, trainee);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Trainee {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return trainee;
    }

    @Override
    public Trainee getById(int id) {
        LOGGER.debug("DAO get Trainee by Id {}", id);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getTraineeMapper(sqlSession).getById(id);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can,t get Trainee {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public List<Trainee> getAll() {
        LOGGER.debug("DAO get all Trainees");
        try (SqlSession sqlSession = getSession()) {
            try {
                return getTraineeMapper(sqlSession).getAll();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get all Trainees {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public Trainee update(Trainee trainee) {
        LOGGER.debug("DAO update Trainee {}", trainee);
        try (SqlSession sqlSession = getSession()) {
            try {
                getTraineeMapper(sqlSession).update(trainee);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't update Trainee {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return trainee;
    }

    @Override
    public List<Trainee> getAllWithParams(String firstName, String lastName, Integer rating) {
        LOGGER.debug("DAO get all Trainees with params firstName: {}, lastName: {}, rating: {} ", firstName, lastName, rating);
        try (SqlSession sqlSession = getSession()) {
            try {
                return getTraineeMapper(sqlSession).getAllWithParams(firstName, lastName, rating);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't get Trainees {}", ex);
                throw ex;
            }
        }
    }

    @Override
    public void batchInsert(List<Trainee> trainees) {
        LOGGER.debug("DAO insert Trainees {}", trainees);
        try (SqlSession sqlSession = getSession()) {
            try {
                for (Trainee trainee : trainees) {
                    getTraineeMapper(sqlSession).insert(null, trainee);
                }
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't insert Trainees {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Trainee trainee) {
        LOGGER.debug("DAO delete Trainee {}", trainee);
        try (SqlSession sqlSession = getSession()) {
            try {
                getTraineeMapper(sqlSession).delete(trainee);
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't delete Trainee {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("DAO delete all Trainees");
        try (SqlSession sqlSession = getSession()) {
            try {
                getTraineeMapper(sqlSession).deleteAll();

            } catch (RuntimeException ex) {
                LOGGER.debug("Cant't delete all Trainees {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
