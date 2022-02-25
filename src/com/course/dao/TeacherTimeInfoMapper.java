package com.course.dao;

import com.course.model.TeacherTimeInfo;
import com.course.model.TeacherTimeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeacherTimeInfoMapper {
    long countByExample(TeacherTimeInfoExample example);

    int deleteByExample(TeacherTimeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherTimeInfo record);

    int insertSelective(TeacherTimeInfo record);

    List<TeacherTimeInfo> selectByExample(TeacherTimeInfoExample example);

    TeacherTimeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TeacherTimeInfo record, @Param("example")
    TeacherTimeInfoExample example);

    int updateByExample(@Param("record")
    TeacherTimeInfo record, @Param("example")
    TeacherTimeInfoExample example);

    int updateByPrimaryKeySelective(TeacherTimeInfo record);

    int updateByPrimaryKey(TeacherTimeInfo record);
}

