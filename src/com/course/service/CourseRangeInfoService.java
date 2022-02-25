package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CourseRangeInfoService {
    /**
      分页查询课程表数据列表
    */
    public Map<String, Object> getDataList(CourseRangeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装课程表为前台展示的数据形式
    */
    public Map<String, Object> getCourseRangeInfoModel(CourseRangeInfo model,
        LoginModel login);
    /**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(CourseRangeInfo model,LoginModel login);
	/**
	修改
	*/
	public String update(CourseRangeInfo model,LoginModel login);
	/**
	导出课程表数据
	*/
	public void exportData(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login);
	/**
	导出课程表数据
	*/
	public void exportData2(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login);
}

