package com.course.dao;

import com.course.model.StudentTimeInfo;
import com.course.model.StudentTimeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentTimeInfoMapper {
    long countByExample(StudentTimeInfoExample example);

    int deleteByExample(StudentTimeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentTimeInfo record);

    int insertSelective(StudentTimeInfo record);

    List<StudentTimeInfo> selectByExample(StudentTimeInfoExample example);

    StudentTimeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    StudentTimeInfo record, @Param("example")
    StudentTimeInfoExample example);

    int updateByExample(@Param("record")
    StudentTimeInfo record, @Param("example")
    StudentTimeInfoExample example);

    int updateByPrimaryKeySelective(StudentTimeInfo record);

    int updateByPrimaryKey(StudentTimeInfo record);
}

