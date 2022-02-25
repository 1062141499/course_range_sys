package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TeacherTimeInfoService {
    /**
      分页查询教师空闲时间设置数据列表
    */
    public Map<String, Object> getDataList(TeacherTimeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装教师空闲时间设置为前台展示的数据形式
    */
    public Map<String, Object> getTeacherTimeInfoModel(TeacherTimeInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(TeacherTimeInfo model, LoginModel login);

    /**
      修改
    */
    public String update(TeacherTimeInfo model, LoginModel login);
}

