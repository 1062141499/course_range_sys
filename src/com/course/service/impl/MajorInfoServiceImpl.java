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
public class MajorInfoServiceImpl implements MajorInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    MajorInfoMapper majorInfoMapper;

    /**
      新增
    */
    @Override
    public String add(MajorInfo model, LoginModel login) {
        if ((model.getMajorName() == null) || model.getMajorName().equals("")) {
            return "专业名为必填属性";
        }

        majorInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(MajorInfo model, LoginModel login) {
        MajorInfo preModel = majorInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getMajorName() == null) || model.getMajorName().equals("")) {
            return "专业名为必填属性";
        }

        preModel.setMajorName(model.getMajorName());
        majorInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询专业列表数据
    */
    @Override
    public Map<String, Object> getDataList(MajorInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        MajorInfoExample se = new MajorInfoExample();
        MajorInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getMajorName() != null) &&
                (queryModel.getMajorName().equals("") == false)) {
            sc.andMajorNameLike("%" + queryModel.getMajorName() + "%"); //模糊查询
        }

        int count = (int) majorInfoMapper.countByExample(se);
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

        List<MajorInfo> list = majorInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (MajorInfo model : list) {
            list2.add(getMajorInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装专业为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getMajorInfoModel(MajorInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("majorInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        majorInfoMapper.deleteByPrimaryKey(id);
    }
}

