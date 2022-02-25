package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TeacherInfoService {
    /**
      分页查询教师数据列表
    */
    public Map<String, Object> getDataList(TeacherInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装教师为前台展示的数据形式
    */
    public Map<String, Object> getTeacherInfoModel(TeacherInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(TeacherInfo model, LoginModel login);

    /**
      修改
    */
    public String update(TeacherInfo model, LoginModel login);
}

