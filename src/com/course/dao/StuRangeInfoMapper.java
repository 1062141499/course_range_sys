package com.course.dao;

import com.course.model.StuRangeInfo;
import com.course.model.StuRangeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StuRangeInfoMapper {
    long countByExample(StuRangeInfoExample example);

    int deleteByExample(StuRangeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuRangeInfo record);

    int insertSelective(StuRangeInfo record);

    List<StuRangeInfo> selectByExample(StuRangeInfoExample example);

    StuRangeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    StuRangeInfo record, @Param("example")
    StuRangeInfoExample example);

    int updateByExample(@Param("record")
    StuRangeInfo record, @Param("example")
    StuRangeInfoExample example);

    int updateByPrimaryKeySelective(StuRangeInfo record);

    int updateByPrimaryKey(StuRangeInfo record);
}

