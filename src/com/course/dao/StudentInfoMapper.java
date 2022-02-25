package com.course.dao;

import com.course.model.StudentInfo;
import com.course.model.StudentInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentInfoMapper {
    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    StudentInfo record, @Param("example")
    StudentInfoExample example);

    int updateByExample(@Param("record")
    StudentInfo record, @Param("example")
    StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}

