package com.course.dao;

import com.course.model.RoomInfo;
import com.course.model.RoomInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoomInfoMapper {
    long countByExample(RoomInfoExample example);

    int deleteByExample(RoomInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    List<RoomInfo> selectByExample(RoomInfoExample example);

    RoomInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    RoomInfo record, @Param("example")
    RoomInfoExample example);

    int updateByExample(@Param("record")
    RoomInfo record, @Param("example")
    RoomInfoExample example);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);
}

