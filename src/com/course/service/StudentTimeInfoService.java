package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface StudentTimeInfoService {
    /**
      分页查询学生空闲时间设置数据列表
    */
    public Map<String, Object> getDataList(StudentTimeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装学生空闲时间设置为前台展示的数据形式
    */
    public Map<String, Object> getStudentTimeInfoModel(StudentTimeInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(StudentTimeInfo model, LoginModel login);

    /**
      修改
    */
    public String update(StudentTimeInfo model, LoginModel login);
}

