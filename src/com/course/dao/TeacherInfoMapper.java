package com.course.dao;

import com.course.model.TeacherInfo;
import com.course.model.TeacherInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeacherInfoMapper {
    long countByExample(TeacherInfoExample example);

    int deleteByExample(TeacherInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    List<TeacherInfo> selectByExample(TeacherInfoExample example);

    TeacherInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TeacherInfo record, @Param("example")
    TeacherInfoExample example);

    int updateByExample(@Param("record")
    TeacherInfo record, @Param("example")
    TeacherInfoExample example);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}

