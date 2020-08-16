package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.mybatis.dao.CommonDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonDaoImpl extends DaoImplBase implements CommonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDaoImpl.class);

    @Override
    public void clear() {
        LOGGER.debug("DAO clear DATABASE");
        try (SqlSession sqlSession = getSession()) {
            try {
                getSchoolMapper(sqlSession).clear();
            } catch (RuntimeException ex) {
                LOGGER.debug("Can't clear DATABASE {}", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }
}
