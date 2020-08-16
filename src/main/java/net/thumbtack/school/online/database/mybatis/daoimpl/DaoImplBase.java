package net.thumbtack.school.online.database.mybatis.daoimpl;

import net.thumbtack.school.online.database.mybatis.mappers.GroupMapper;
import net.thumbtack.school.online.database.mybatis.mappers.SchoolMapper;
import net.thumbtack.school.online.database.mybatis.mappers.SubjectMapper;
import net.thumbtack.school.online.database.mybatis.mappers.TraineeMapper;
import org.apache.ibatis.session.SqlSession;

import net.thumbtack.school.online.database.mybatis.utils.MyBatisUtils;

public class DaoImplBase {

    protected SqlSession getSession() {
        return MyBatisUtils.getSqlSessionFactory().openSession();
    }

    protected SchoolMapper getSchoolMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(SchoolMapper.class);
    }

    protected GroupMapper getGroupMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(GroupMapper.class);
    }

    protected TraineeMapper getTraineeMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(TraineeMapper.class);
    }

    protected SubjectMapper getSubjectMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(SubjectMapper.class);
    }

}