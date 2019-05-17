package com.diary.dao.login.mapper;


import java.util.List;

//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.diary.dao.login.pojo.User;
import com.diary.dao.login.pojo.UserExample;

//@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    List<User> selectByExampleWithBLOBs(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    User selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diary_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(User record);
}