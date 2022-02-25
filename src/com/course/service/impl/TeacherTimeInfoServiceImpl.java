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
public class TeacherTimeInfoServiceImpl implements TeacherTimeInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TeacherTimeInfoMapper teacherTimeInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;

    /**
      新增
    */
    @Override
    public String add(TeacherTimeInfo model, LoginModel login) {
        if (model.getWeekDay() == null) {
            return "星期几为必填属性";
        }

        if (model.getJs() == null) {
            return "第几节为必填属性";
        }

        model.setTeacherId(login.getId()); //登录id
        teacherTimeInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(TeacherTimeInfo model, LoginModel login) {
        TeacherTimeInfo preModel = teacherTimeInfoMapper.selectByPrimaryKey(model.getId());

        if (model.getWeekDay() == null) {
            return "星期几为必填属性";
        }

        if (model.getJs() == null) {
            return "第几节为必填属性";
        }

        preModel.setWeekDay(model.getWeekDay());
        preModel.setJs(model.getJs());
        teacherTimeInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询教师空闲时间设置列表数据
    */
    @Override
    public Map<String, Object> getDataList(TeacherTimeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        TeacherTimeInfoExample se = new TeacherTimeInfoExample();
        TeacherTimeInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getTeacherId() != null) {
            sc.andTeacherIdEqualTo(queryModel.getTeacherId());
        }

        int count = (int) teacherTimeInfoMapper.countByExample(se);
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

        List<TeacherTimeInfo> list = teacherTimeInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TeacherTimeInfo model : list) {
            list2.add(getTeacherTimeInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装教师空闲时间设置为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTeacherTimeInfoModel(TeacherTimeInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("teacherTimeInfo", model);
        map.put("weekDayStr",
            DataListUtils.getWeekDayNameById(model.getWeekDay() + "")); //解释星期几字段
        map.put("jsStr", DataListUtils.getJsNameById(model.getJs() + "")); //解释第几节字段

        if (model.getTeacherId() != null) {
            TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(model.getTeacherId()); //教师id为外接字段,需要关联教师来解释该字段

            if (teacherInfo != null) {
                map.put("teacherIdStr", teacherInfo.getTno());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        teacherTimeInfoMapper.deleteByPrimaryKey(id);
    }
}

