package com.course.controller.student;

import com.course.controller.LoginModel;

import com.course.dao.*;

import com.course.model.*;

import com.course.service.*;
import com.course.service.impl.*;

import com.course.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/student/course_range_info")
public class SCourseRangeInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    CourseRangeInfoService courseRangeInfoService;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;

    /**
    * 返回课程表列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", studentInfo);

        return "student/course_range_info/list";
    }

    /**
     * 根据查询条件分页查询课程表数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(CourseRangeInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return courseRangeInfoService.getDataList(model, page,
            CommonVal.pageSize, login); //分页查询数据
    }
}

