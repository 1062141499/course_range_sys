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
public class StuRangeInfoServiceImpl implements StuRangeInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    StuRangeInfoMapper stuRangeInfoMapper;
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;

    /**
    *根据参数查询课程学生安排列表数据
    */
    @Override
    public Map<String, Object> getDataList(StuRangeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        StuRangeInfoExample se = new StuRangeInfoExample();
        StuRangeInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getRangeId() != null) {
            sc.andRangeIdEqualTo(queryModel.getRangeId());
        }

        int count = (int) stuRangeInfoMapper.countByExample(se);
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

        List<StuRangeInfo> list = stuRangeInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (StuRangeInfo model : list) {
            list2.add(getStuRangeInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装课程学生安排为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getStuRangeInfoModel(StuRangeInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuRangeInfo", model);

        if (model.getRangeId() != null) {
            CourseRangeInfo courseRangeInfo = courseRangeInfoMapper.selectByPrimaryKey(model.getRangeId()); //安排课程为外接字段,需要关联课程表来解释该字段

            if (courseRangeInfo != null) {
                map.put("rangeIdStr", courseRangeInfo.getCourseName());
            }
        }

        if (model.getClassId() != null) {
            ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(model.getClassId()); //班级为外接字段,需要关联班级来解释该字段

            if (classInfo != null) {
                map.put("classIdStr", classInfo.getClassName());
            }
        }

        if (model.getCourseId() != null) {
            CourseInfo courseInfo = courseInfoMapper.selectByPrimaryKey(model.getCourseId()); //课程id为外接字段,需要关联课程来解释该字段

            if (courseInfo != null) {
                map.put("courseIdStr", courseInfo.getCourseName());
            }
        }

        if (model.getStuId() != null) {
            StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(model.getStuId()); //学生id为外接字段,需要关联学生来解释该字段

            if (studentInfo != null) {
                map.put("stuIdStr",
                    studentInfo.getStuNo() + "+" + studentInfo.getRealName() +
                    "+" + studentInfo.getCelPhone());
            }
        }

        return map;
    }
}

