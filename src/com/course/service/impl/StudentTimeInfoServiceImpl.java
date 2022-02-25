package com.course.service.impl;

import com.course.controller.LoginModel;

import com.course.dao.*;

import com.course.model.*;

import com.course.service.*;

import com.course.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class StudentTimeInfoServiceImpl implements StudentTimeInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    StudentTimeInfoMapper studentTimeInfoMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;

    /**
      新增
    */
    @Override
    public String add(StudentTimeInfo model, LoginModel login) {
        if (model.getWeekDay() == null) {
            return "星期几为必填属性";
        }

        if (model.getJs() == null) {
            return "第几节为必填属性";
        }

        model.setStuId(login.getId()); //登录id
        studentTimeInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(StudentTimeInfo model, LoginModel login) {
        StudentTimeInfo preModel = studentTimeInfoMapper.selectByPrimaryKey(model.getId());

        if (model.getWeekDay() == null) {
            return "星期几为必填属性";
        }

        if (model.getJs() == null) {
            return "第几节为必填属性";
        }

        preModel.setWeekDay(model.getWeekDay());
        preModel.setJs(model.getJs());
        studentTimeInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询学生空闲时间设置列表数据
    */
    @Override
    public Map<String, Object> getDataList(StudentTimeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        StudentTimeInfoExample se = new StudentTimeInfoExample();
        StudentTimeInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getStuId() != null) {
            sc.andStuIdEqualTo(queryModel.getStuId());
        }

        int count = (int) studentTimeInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<StudentTimeInfo> list = studentTimeInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (StudentTimeInfo model : list) {
            list2.add(getStudentTimeInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装学生空闲时间设置为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getStudentTimeInfoModel(StudentTimeInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("studentTimeInfo", model);
        map.put("weekDayStr",
            DataListUtils.getWeekDayNameById(model.getWeekDay() + "")); //解释星期几字段
        map.put("jsStr", DataListUtils.getJsNameById(model.getJs() + "")); //解释第几节字段

        if (model.getStuId() != null) {
            StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(model.getStuId()); //学生id为外接字段,需要关联学生来解释该字段

            if (studentInfo != null) {
                map.put("stuIdStr", studentInfo.getStuNo());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        studentTimeInfoMapper.deleteByPrimaryKey(id);
    }
}

