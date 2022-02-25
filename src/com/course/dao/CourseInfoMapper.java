package com.course.dao;

import com.course.model.CourseInfo;
import com.course.model.CourseInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CourseInfoMapper {
    long countByExample(CourseInfoExample example);

    int deleteByExample(CourseInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    List<CourseInfo> selectByExample(CourseInfoExample example);

    CourseInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    CourseInfo record, @Param("example")
    CourseInfoExample example);

    int updateByExample(@Param("record")
    CourseInfo record, @Param("example")
    CourseInfoExample example);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}

