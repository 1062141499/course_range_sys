package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface StuRangeInfoService {
    /**
      分页查询课程学生安排数据列表
    */
    public Map<String, Object> getDataList(StuRangeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装课程学生安排为前台展示的数据形式
    */
    public Map<String, Object> getStuRangeInfoModel(StuRangeInfo model,
        LoginModel login);
}

