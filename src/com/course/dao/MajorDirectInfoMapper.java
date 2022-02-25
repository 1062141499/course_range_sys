package com.course.dao;

import com.course.model.MajorDirectInfo;
import com.course.model.MajorDirectInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MajorDirectInfoMapper {
    long countByExample(MajorDirectInfoExample example);

    int deleteByExample(MajorDirectInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MajorDirectInfo record);

    int insertSelective(MajorDirectInfo record);

    List<MajorDirectInfo> selectByExample(MajorDirectInfoExample example);

    MajorDirectInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    MajorDirectInfo record, @Param("example")
    MajorDirectInfoExample example);

    int updateByExample(@Param("record")
    MajorDirectInfo record, @Param("example")
    MajorDirectInfoExample example);

    int updateByPrimaryKeySelective(MajorDirectInfo record);

    int updateByPrimaryKey(MajorDirectInfo record);
}

