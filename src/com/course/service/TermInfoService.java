package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TermInfoService {
    /**
      分页查询学期数据列表
    */
    public Map<String, Object> getDataList(TermInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装学期为前台展示的数据形式
    */
    public Map<String, Object> getTermInfoModel(TermInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(TermInfo model, LoginModel login);

    /**
      修改
    */
    public String update(TermInfo model, LoginModel login);
}

