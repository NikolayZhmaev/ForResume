package net.thumbtack.school.online.database.mybatis.mappers;

import net.thumbtack.school.online.database.model.Group;
import net.thumbtack.school.online.database.model.Trainee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TraineeMapper {

    @Insert("INSERT INTO trainee () VALUES (#{trainee.idTrainee}, #{trainee.firstName}, #{trainee.lastName}, #{trainee.rating}, #{group.idGroup})")
    @Options(useGeneratedKeys = true, keyProperty = "trainee.idTrainee")
    public Integer insert(@Param("group") Group group, @Param("trainee") Trainee trainee);


    @Select("SELECT idTrainee, firstName, lastName, rating FROM trainee WHERE idTrainee = #{id} ")
    public Trainee getById(int id);

    @Select(value = {"<script>",
            "SELECT idTrainee, firstName, lastName, rating FROM trainee",
            "<where>" +
                    "<if test='paramFirstName != null'> firstName like #{paramFirstName}",
            "</if >",
            "<if test='paramLastName != null'> AND lastName like #{paramLastName}",
            "</if >",
            "<if test='paramRating != null'> AND rating = #{paramRating}",
            "</if >",
            "</where>" +
                    "</script>"})

    public List<Trainee> getAllWithParams(@Param("paramFirstName") String firstName, @Param("paramLastName") String lastName, @Param("paramRating") Integer rating);

    @Update("UPDATE trainee SET firstName = #{firstName}, lastName = #{lastName}, rating = #{rating} WHERE idTrainee = #{idTrainee}")
    public void update(Trainee trainee);

    @Delete("DELETE FROM trainee WHERE idTrainee = #{idTrainee}")
    public void delete(Trainee trainee);

    @Delete("DELETE FROM trainee")
    public void deleteAll();

    @Select("Select idTrainee, firstName, lastName, rating FROM trainee WHERE groupid = #{id}")
    public List<Trainee> getAllTraineesByIdGroup(int id);


    @Select("SELECT idTrainee, firstName, lastName, rating FROM trainee")
    public List<Trainee> getAll();
}
