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
public class TeacherInfoServiceImpl implements TeacherInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    TeacherInfoMapper teacherInfoMapper;

    /**
      新增
    */
    @Override
    public String add(TeacherInfo model, LoginModel login) {
        if ((model.getTno() == null) || model.getTno().equals("")) {
            return "工号为必填属性";
        }

        if (model.getTno() != null) {
            TeacherInfoExample te = new TeacherInfoExample();
            TeacherInfoExample.Criteria tc = te.createCriteria();
            tc.andTnoEqualTo(model.getTno());

            int count = (int) teacherInfoMapper.countByExample(te);

            if (count > 0) {
                return "系统已存在该 工号 ,请重新填写";
            }
        }

        if ((model.getRealName() == null) || model.getRealName().equals("")) {
            return "姓名为必填属性";
        }

        if (model.getSex() == null) {
            return "性别为必填属性";
        }

        if ((model.getCelPhone() == null) || model.getCelPhone().equals("")) {
            return "联系电话为必填属性";
        }

        if (model.getCelPhone() != null) {
            Pattern p = Pattern.compile(
                    "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(model.getCelPhone());

            if (m.matches() == false) {
                return "请输入正确的联系电话";
            }
        }

        teacherInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(TeacherInfo model, LoginModel login) {
        TeacherInfo preModel = teacherInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getTno() == null) || model.getTno().equals("")) {
            return "工号为必填属性";
        }

        if (model.getTno() != null) {
            TeacherInfoExample te = new TeacherInfoExample();
            TeacherInfoExample.Criteria tc = te.createCriteria();
            tc.andTnoEqualTo(model.getTno());
            tc.andIdNotEqualTo(model.getId());

            int count = (int) teacherInfoMapper.countByExample(te);

            if (count > 0) {
                return "系统已存在该 工号 ,请重新填写";
            }
        }

        if ((model.getRealName() == null) || model.getRealName().equals("")) {
            return "姓名为必填属性";
        }

        if (model.getSex() == null) {
            return "性别为必填属性";
        }

        if ((model.getCelPhone() == null) || model.getCelPhone().equals("")) {
            return "联系电话为必填属性";
        }

        if (model.getCelPhone() != null) {
            Pattern p = Pattern.compile(
                    "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(model.getCelPhone());

            if (m.matches() == false) {
                return "请输入正确的联系电话";
            }
        }

        preModel.setTno(model.getTno());
        preModel.setPassWord(model.getPassWord());
        preModel.setRealName(model.getRealName());
        preModel.setSex(model.getSex());
        preModel.setCelPhone(model.getCelPhone());
        teacherInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询教师列表数据
    */
    @Override
    public Map<String, Object> getDataList(TeacherInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        TeacherInfoExample se = new TeacherInfoExample();
        TeacherInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getTno() != null) &&
                (queryModel.getTno().equals("") == false)) {
            sc.andTnoLike("%" + queryModel.getTno() + "%"); //模糊查询
        }

        if ((queryModel.getRealName() != null) &&
                (queryModel.getRealName().equals("") == false)) {
            sc.andRealNameLike("%" + queryModel.getRealName() + "%"); //模糊查询
        }

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        int count = (int) teacherInfoMapper.countByExample(se);
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

        List<TeacherInfo> list = teacherInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (TeacherInfo model : list) {
            list2.add(getTeacherInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装教师为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getTeacherInfoModel(TeacherInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("teacherInfo", model);
        map.put("sexStr", DataListUtils.getSexNameById(model.getSex() + "")); //解释性别字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        teacherInfoMapper.deleteByPrimaryKey(id);
    }
}

