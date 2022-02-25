package com.course.service;

import com.course.controller.LoginModel;

import com.course.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface StudentInfoService {
    /**
      分页查询学生数据列表
    */
    public Map<String, Object> getDataList(StudentInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装学生为前台展示的数据形式
    */
    public Map<String, Object> getStudentInfoModel(StudentInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(StudentInfo model, LoginModel login);

    /**
      修改
    */
    public String update(StudentInfo model, LoginModel login);

    /**
    **导入学生数据,根据传入的excel,得到传入数据,然后做值的校验并导入系统
    */
    public String importData(InputStream is, String fileName, LoginModel login,
        StudentInfo pageModel);
}

