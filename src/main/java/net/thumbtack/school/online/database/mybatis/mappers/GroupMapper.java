package net.thumbtack.school.online.database.mybatis.mappers;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.School;
import net.thumbtack.school.online.database.model.Subject;
import net.thumbtack.school.online.database.model.Trainee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface GroupMapper {

    @Insert("INSERT INTO `group` (nameGroup, room, schoolid) VALUES (#{group.nameGroup}, #{group.room}, #{school.idSchool})")
    @Options(useGeneratedKeys = true, keyProperty = "group.idGroup")
    public Integer insert(@Param("school") School school, @Param("group") Group group);


    @Select("SELECT * FROM `group` WHERE idGroup = #{id}")
    public Group getById(int id);

    @Update("UPDATE `group` SET nameGroup = #{nameGroup}, room = #{room} WHERE idGroup = #{idGroup}")
    public void update(Group group);

    @Select("SELECT * FROM `group`")
    public List<Group> getAll();

    @Select("Select idGroup, nameGroup, room FROM `group` WHERE schoolid = #{id}")

    @Results({
            @Result(property = "id", column = "idGroup", id = true),
            @Result(property = "trainees", column = "idGroup", javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.online.database.mybatis.mappers.TraineeMapper.getAllTraineesByIdGroup", fetchType = FetchType.LAZY)),
            @Result(property = "subjects", column = "idGroup", javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.online.database.mybatis.mappers.SubjectMapper.getAllSubjectsByIdGroup", fetchType = FetchType.LAZY))
    })
    public List<Group> getAllGroupsByIdSchool(int id);

    @Delete("DELETE FROM `group` WHERE idGroup = #{idGroup}")
    public void delete(Group group);


    @Update("UPDATE trainee SET groupid = #{group.idGroup} WHERE idTrainee = #{trainee.idTrainee}")
    public void moveTraineeToGroup(@Param("group") Group group, @Param("trainee") Trainee trainee);

    @Insert("INSERT INTO subject_group (subjectid, groupid) VALUES (#{subject.idSubject}, #{group.idGroup})")
    public void addSubjectToGroup(@Param("group") Group group, @Param("subject") Subject subject);

    @Update("UPDATE trainee SET groupid = null WHERE idTrainee = #{idTrainee}")
    public void deleteTraineeFromGroup(Trainee trainee);
}
