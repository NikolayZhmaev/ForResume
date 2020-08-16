package net.thumbtack.school.online.database.mybatis.mappers;

import net.thumbtack.school.online.database.model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {
    @Insert("INSERT INTO subject (idSubject, nameSubject) VALUES (#{idSubject}, #{nameSubject})")
    @Options(useGeneratedKeys = true)
    public Integer insert(Subject subject);

    @Delete("DELETE FROM subject WHERE idSubject = #{idSubject}")
    public void delete(Subject subject);

    @Delete("DELETE FROM subject")
    public void deleteAll();

    @Select("SELECT idSubject, nameSubject FROM subject WHERE idSubject = #{id} ")
    public Subject getById(int id);

    @Update("UPDATE subject SET nameSubject = #{nameSubject} WHERE idSubject = #{idSubject}")
    public void update(Subject subject);

    @Select("SELECT * from subject WHERE idSubject IN (SELECT subjectid FROM subject_group WHERE groupid = #{idGroup})")

    public List<Subject> getAllSubjectsByIdGroup(int idGroup);


    @Select("SELECT idSubject, nameSubject FROM subject")
    public List<Subject> getAll();
}
