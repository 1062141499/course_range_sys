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
public class CourseInfoServiceImpl implements CourseInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;

    /**
      新增
    */
    @Override
    public String add(CourseInfo model, LoginModel login) {
        if ((model.getCourseName() == null) ||
                model.getCourseName().equals("")) {
            return "课程名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "专业为必填属性";
        }

        if (model.getDirectId() == null) {
            return "专业方向为必填属性";
        }

        if (model.getTermId() == null) {
            return "学期为必填属性";
        }

        if ((model.getRoomIds() == null) || model.getRoomIds().equals("")) {
            return "可上课教室为必填属性";
        }

        if (model.getCourseTimes() == null) {
            return "上课次数为必填属性";
        }
    	if(model.getIsBx()==null){
			return "课程类型为必填属性";
		}

        model.setTeacherId(login.getId()); //登录id
        courseInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(CourseInfo model, LoginModel login) {
        CourseInfo preModel = courseInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getCourseName() == null) ||
                model.getCourseName().equals("")) {
            return "课程名为必填属性";
        }

        if (model.getMajorId() == null) {
            return "专业为必填属性";
        }

        if (model.getDirectId() == null) {
            return "专业方向为必填属性";
        }

        if (model.getTermId() == null) {
            return "学期为必填属性";
        }

        if ((model.getRoomIds() == null) || model.getRoomIds().equals("")) {
            return "可上课教室为必填属性";
        }

        if (model.getCourseTimes() == null) {
            return "上课次数为必填属性";
        }
        if(model.getIsBx()==null){
			return "课程类型为必填属性";
		}

        preModel.setCourseName(model.getCourseName());
        preModel.setMajorId(model.getMajorId());
        preModel.setDirectId(model.getDirectId());
        preModel.setTermId(model.getTermId());
        preModel.setRoomIds(model.getRoomIds());
        preModel.setCourseTimes(model.getCourseTimes());
		preModel.setIsBx(model.getIsBx());
        courseInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询课程列表数据
    */
    @Override
    public Map<String, Object> getDataList(CourseInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        CourseInfoExample se = new CourseInfoExample();
        CourseInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getCourseName() != null) &&
                (queryModel.getCourseName().equals("") == false)) {
            sc.andCourseNameLike("%" + queryModel.getCourseName() + "%"); //模糊查询
        }

        if (queryModel.getMajorId() != null) {
            sc.andMajorIdEqualTo(queryModel.getMajorId()); //查询专业等于指定值
        }

        if (queryModel.getDirectId() != null) {
            sc.andDirectIdEqualTo(queryModel.getDirectId()); //查询专业方向等于指定值
        }

        if (queryModel.getTeacherId() != null) {
            sc.andTeacherIdEqualTo(queryModel.getTeacherId());
        }
        if(login.getLoginType()==3){
        	StudentInfo stu = studentInfoMapper.selectByPrimaryKey(login.getId());
        	sc.andIsBxEqualTo(2);//学生只显示选修课
        	sc.andDirectIdEqualTo(stu.getDirectId());
        	sc.andMajorIdEqualTo(stu.getMajorId());
        }

        int count = (int) courseInfoMapper.countByExample(se);
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

        List<CourseInfo> list = courseInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CourseInfo model : list) {
            list2.add(getCourseInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装课程为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getCourseInfoModel(CourseInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseInfo", model);

        if (model.getMajorId() != null) {
            MajorInfo majorInfo = majorInfoMapper.selectByPrimaryKey(model.getMajorId()); //专业为外接字段,需要关联专业来解释该字段

            if (majorInfo != null) {
                map.put("majorIdStr", majorInfo.getMajorName());
            }
        }

        if (model.getDirectId() != null) {
            MajorDirectInfo majorDirectInfo = majorDirectInfoMapper.selectByPrimaryKey(model.getDirectId()); //专业方向为外接字段,需要关联专业方向来解释该字段

            if (majorDirectInfo != null) {
                map.put("directIdStr", majorDirectInfo.getDirectName());
            }
        }

        if (model.getTermId() != null) {
            TermInfo termInfo = termInfoMapper.selectByPrimaryKey(model.getTermId()); //学期为外接字段,需要关联学期来解释该字段

            if (termInfo != null) {
                map.put("termIdStr", termInfo.getTermName());
            }
        }

        if (model.getRoomIds() != null) {
            String[] split = model.getRoomIds().split(",");
            String roomIdsStr = "";

            for (String s : split) {
                if (s.equals("") == false) {
                    RoomInfo roomInfo = roomInfoMapper.selectByPrimaryKey(Integer.parseInt(
                                s)); //可上课教室为外接字段,需要关联教室来解释该字段

                    if (roomInfo != null) {
                        roomIdsStr += (roomInfo.getRoomName() + ",");
                    }
                }
            }

            map.put("roomIdsStr", roomIdsStr);
        }

        if (model.getTeacherId() != null) {
            TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(model.getTeacherId()); //负责教师为外接字段,需要关联教师来解释该字段

            if (teacherInfo != null) {
                map.put("teacherIdStr",
                    teacherInfo.getTno() + "+" + teacherInfo.getRealName());
            }
        }
        
    	map.put("isBxStr",DataListUtils.getIsBxNameById(model.getIsBx()+""));//解释课程类型字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        courseInfoMapper.deleteByPrimaryKey(id);
    }
}

