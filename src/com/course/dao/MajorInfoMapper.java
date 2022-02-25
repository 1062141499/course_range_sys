package com.course.dao;

import com.course.model.MajorInfo;
import com.course.model.MajorInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MajorInfoMapper {
    long countByExample(MajorInfoExample example);

    int deleteByExample(MajorInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MajorInfo record);

    int insertSelective(MajorInfo record);

    List<MajorInfo> selectByExample(MajorInfoExample example);

    MajorInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    MajorInfo record, @Param("example")
    MajorInfoExample example);

    int updateByExample(@Param("record")
    MajorInfo record, @Param("example")
    MajorInfoExample example);

    int updateByPrimaryKeySelective(MajorInfo record);

    int updateByPrimaryKey(MajorInfo record);
}

