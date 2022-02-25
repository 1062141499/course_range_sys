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
public class MajorDirectInfoServiceImpl implements MajorDirectInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;

    /**
      新增
    */
    @Override
    public String add(MajorDirectInfo model, LoginModel login) {
        if ((model.getDirectName() == null) ||
                model.getDirectName().equals("")) {
            return "方向名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "所属专业为必填属性";
        }

        majorDirectInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(MajorDirectInfo model, LoginModel login) {
        MajorDirectInfo preModel = majorDirectInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getDirectName() == null) ||
                model.getDirectName().equals("")) {
            return "方向名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "所属专业为必填属性";
        }

        preModel.setDirectName(model.getDirectName());
        preModel.setMajorId(model.getMajorId());
        majorDirectInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询专业方向列表数据
    */
    @Override
    public Map<String, Object> getDataList(MajorDirectInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        MajorDirectInfoExample se = new MajorDirectInfoExample();
        MajorDirectInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getDirectName() != null) &&
                (queryModel.getDirectName().equals("") == false)) {
            sc.andDirectNameLike("%" + queryModel.getDirectName() + "%"); //模糊查询
        }

        if (queryModel.getMajorId() != null) {
            sc.andMajorIdEqualTo(queryModel.getMajorId()); //查询所属专业等于指定值
        }

        int count = (int) majorDirectInfoMapper.countByExample(se);
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

        List<MajorDirectInfo> list = majorDirectInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (MajorDirectInfo model : list) {
            list2.add(getMajorDirectInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装专业方向为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getMajorDirectInfoModel(MajorDirectInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("majorDirectInfo", model);

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
        majorDirectInfoMapper.deleteByPrimaryKey(id);
    }
}

