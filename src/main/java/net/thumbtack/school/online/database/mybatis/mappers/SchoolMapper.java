package net.thumbtack.school.online.database.mybatis.mappers;

import net.thumbtack.school.online.database.model.School;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SchoolMapper {

    @Insert("INSERT INTO school () VALUES (#{idSchool}, #{nameSchool}, #{year})")
    @Options(useGeneratedKeys = true)
    public Integer insert(School school);

    @Select("SELECT idSchool, nameSchool, year FROM school WHERE idSchool = #{id} ")
    @Results(value = {
            @Result(property = "idSchool", column = "idSchool"),
            @Result(property = "groups", column = "idSchool", javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.online.database.mybatis.mappers.GroupMapper.getAllGroupsByIdSchool", fetchType = FetchType.LAZY)),
    })
    public School getById(int id);

    @Update("UPDATE school SET nameSchool = #{nameSchool}, year = #{year} WHERE idSchool = #{idSchool}")
    public void update(School school);

    @Delete("DELETE FROM school WHERE idSchool = #{idSchool}")
    public void delete(School school);

    @Delete("DELETE FROM school")
    public void deleteAll();


    @Select("SELECT idSchool, nameSchool, year FROM school")
    @Results(value = {
            @Result(property = "idSchool", column = "idSchool"),
            @Result(property = "groups", column = "idSchool", javaType = List.class,
                    many = @Many(select = "net.thumbtack.school.online.database.mybatis.mappers.GroupMapper.getAllGroupsByIdSchool", fetchType = FetchType.LAZY)),
    })
    public List<School> getAllLazy();

    @Delete("DELETE school FROM schools LEFT JOIN trainees ON idTrainee != null LEFT JOIN subjects ON idSubject != null")
    public void clear();

}
