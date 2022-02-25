package com.course.dao;

import com.course.model.TermInfo;
import com.course.model.TermInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TermInfoMapper {
    long countByExample(TermInfoExample example);

    int deleteByExample(TermInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TermInfo record);

    int insertSelective(TermInfo record);

    List<TermInfo> selectByExample(TermInfoExample example);

    TermInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    TermInfo record, @Param("example")
    TermInfoExample example);

    int updateByExample(@Param("record")
    TermInfo record, @Param("example")
    TermInfoExample example);

    int updateByPrimaryKeySelective(TermInfo record);

    int updateByPrimaryKey(TermInfo record);
}

