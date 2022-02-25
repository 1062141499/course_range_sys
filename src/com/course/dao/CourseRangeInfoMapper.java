package com.course.dao;

import com.course.model.CourseRangeInfo;
import com.course.model.CourseRangeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CourseRangeInfoMapper {
    long countByExample(CourseRangeInfoExample example);

    int deleteByExample(CourseRangeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseRangeInfo record);

    int insertSelective(CourseRangeInfo record);

    List<CourseRangeInfo> selectByExample(CourseRangeInfoExample example);

    CourseRangeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    CourseRangeInfo record, @Param("example")
    CourseRangeInfoExample example);

    int updateByExample(@Param("record")
    CourseRangeInfo record, @Param("example")
    CourseRangeInfoExample example);

    int updateByPrimaryKeySelective(CourseRangeInfo record);

    int updateByPrimaryKey(CourseRangeInfo record);
}

