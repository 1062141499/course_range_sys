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
public class ClassInfoServiceImpl implements ClassInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;

    /**
      新增
    */
    @Override
    public String add(ClassInfo model, LoginModel login) {
        if ((model.getClassName() == null) || model.getClassName().equals("")) {
            return "班级名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "所属专业为必填属性";
        }

        classInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(ClassInfo model, LoginModel login) {
        ClassInfo preModel = classInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getClassName() == null) || model.getClassName().equals("")) {
            return "班级名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "所属专业为必填属性";
        }

        preModel.setClassName(model.getClassName());
        preModel.setMajorId(model.getMajorId());
        classInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询班级列表数据
    */
    @Override
    public Map<String, Object> getDataList(ClassInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        ClassInfoExample se = new ClassInfoExample();
        ClassInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getClassName() != null) &&
                (queryModel.getClassName().equals("") == false)) {
            sc.andClassNameLike("%" + queryModel.getClassName() + "%"); //模糊查询
        }

        if (queryModel.getMajorId() != null) {
            sc.andMajorIdEqualTo(queryModel.getMajorId()); //查询所属专业等于指定值
        }

        int count = (int) classInfoMapper.countByExample(se);
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

        List<ClassInfo> list = classInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ClassInfo model : list) {
            list2.add(getClassInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装班级为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getClassInfoModel(ClassInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("classInfo", model);

        if (model.getMajorId() != null) {
            MajorInfo majorInfo = majorInfoMapper.selectByPrimaryKey(model.getMajorId()); //所属专业为外接字段,需要关联专业来解释该字段

            if (majorInfo != null) {
                map.put("majorIdStr", majorInfo.getMajorName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        classInfoMapper.deleteByPrimaryKey(id);
    }
}

