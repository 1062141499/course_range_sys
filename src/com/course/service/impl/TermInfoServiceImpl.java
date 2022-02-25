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
public class TermInfoServiceImpl implements TermInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TermInfoMapper termInfoMapper;

    /**
      新增
    */
    @Override
    public String add(TermInfo model, LoginModel login) {
        if ((model.getTermName() == null) || model.getTermName().equals("")) {
            return "学期名为必填属性";
        }

        if ((model.getEndTime() == null) || model.getEndTime().equals("")) {
            return "学期排课截止时间为必填属性";
        }

        if (model.getWeekNum() == null) {
            return "周数为必填属性";
        }

        if (model.getEnterYear() == null) {
            return "入学年份为必填属性";
        }

        if (model.getIsSetting() == null) {
            return "是否可修改空闲时间为必填属性";
        }

        termInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(TermInfo model, LoginModel login) {
        TermInfo preModel = termInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getTermName() == null) || model.getTermName().equals("")) {
            return "学期名为必填属性";
        }

        if ((model.getEndTime() == null) || model.getEndTime().equals("")) {
            return "学期排课截止时间为必填属性";
        }

        if (model.getWeekNum() == null) {
            return "周数为必填属性";
        }

        if (model.getEnterYear() == null) {
            return "入学年份为必填属性";
        }

        if (model.getIsSetting() == null) {
            return "是否可修改空闲时间为必填属性";
        }

        preModel.setTermName(model.getTermName());
        preModel.setTermIntro(model.getTermIntro());
        preModel.setEndTime(model.getEndTime());
        preModel.setWeekNum(model.getWeekNum());
        preModel.setEnterYear(model.getEnterYear());
        preModel.setIsSetting(model.getIsSetting());
        termInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询学期列表数据
    */
    @Override
    public Map<String, Object> getDataList(TermInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        TermInfoExample se = new TermInfoExample();
        TermInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getTermName() != null) &&
                (queryModel.getTermName().equals("") == false)) {
            sc.andTermNameLike("%" + queryModel.getTermName() + "%"); //模糊查询
        }

        int count = (int) termInfoMapper.countByExample(se);
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

        List<TermInfo> list = termInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TermInfo model : list) {
            list2.add(getTermInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装学期为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTermInfoModel(TermInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("termInfo", model);
        map.put("isSettingStr",
            DataListUtils.getIsSettingNameById(model.getIsSetting() + "")); //解释是否可修改空闲时间字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        termInfoMapper.deleteByPrimaryKey(id);
    }
}

