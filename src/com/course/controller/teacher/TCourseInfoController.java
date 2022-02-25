package com.course.controller.teacher;

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
@RequestMapping("/teacher/course_info")
public class TCourseInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    CourseInfoService courseInfoService;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        MajorInfoExample majorInfoE = new MajorInfoExample();
        MajorInfoExample.Criteria majorInfoC = majorInfoE.createCriteria();
        List<MajorInfo> majorInfoList = majorInfoMapper.selectByExample(majorInfoE);
        List<Map<String, Object>> majorInfoList2 = new ArrayList<Map<String, Object>>();

        for (MajorInfo m : majorInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getMajorName());
            majorInfoList2.add(map);
        }

        modelMap.addAttribute("majorInfoList", majorInfoList2);

        MajorDirectInfoExample majorDirectInfoE = new MajorDirectInfoExample();
        MajorDirectInfoExample.Criteria majorDirectInfoC = majorDirectInfoE.createCriteria();
        List<MajorDirectInfo> majorDirectInfoList = majorDirectInfoMapper.selectByExample(majorDirectInfoE);
        List<Map<String, Object>> majorDirectInfoList2 = new ArrayList<Map<String, Object>>();

        for (MajorDirectInfo m : majorDirectInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getDirectName());
            majorDirectInfoList2.add(map);
        }

        modelMap.addAttribute("majorDirectInfoList", majorDirectInfoList2);

        TermInfoExample termInfoE = new TermInfoExample();
        TermInfoExample.Criteria termInfoC = termInfoE.createCriteria();
        List<TermInfo> termInfoList = termInfoMapper.selectByExample(termInfoE);
        List<Map<String, Object>> termInfoList2 = new ArrayList<Map<String, Object>>();

        for (TermInfo m : termInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getTermName());
            termInfoList2.add(map);
        }

        modelMap.addAttribute("termInfoList", termInfoList2);

        RoomInfoExample roomInfoE = new RoomInfoExample();
        RoomInfoExample.Criteria roomInfoC = roomInfoE.createCriteria();
        List<RoomInfo> roomInfoList = roomInfoMapper.selectByExample(roomInfoE);
        List<Map<String, Object>> roomInfoList2 = new ArrayList<Map<String, Object>>();

        for (RoomInfo m : roomInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getRoomName());
            roomInfoList2.add(map);
        }

        modelMap.addAttribute("roomInfoList", roomInfoList2);
		modelMap.addAttribute("isBxList",DataListUtils.getIsBxList());//返回is_bx列表
    }

    /**
     * 根据所属专业查询专业方向列表数据
    */
    @RequestMapping(value = "getMajorDirectInfoListByMajorId")
    @ResponseBody
    public Object getMajorDirectInfoListByMajorId(Integer majorId) {
        List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();

        if (majorId == null) {
            return rs;
        }

        MajorDirectInfoExample te = new MajorDirectInfoExample();
        MajorDirectInfoExample.Criteria tc = te.createCriteria();
        tc.andMajorIdEqualTo(majorId);

        List<MajorDirectInfo> tl = majorDirectInfoMapper.selectByExample(te);

        for (MajorDirectInfo t : tl) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", t.getId());
            map.put("name", t.getDirectName());
            rs.add(map);
        }

        return rs;
    }

    /**
     * 返回课程列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", teacherInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "teacher/course_info/list";
    }

    /**
     * 根据查询条件分页查询课程数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(CourseInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setTeacherId(login.getId()); //负责教师等于当前登录id

        return courseInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    /**
     进入新增页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, CourseInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "teacher/course_info/add_page";
    }

    /**
     新增提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(CourseInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = courseInfoService.add(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "新增成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     进入修改页面
    */
    @RequestMapping("update")
    public String update(ModelMap modelMap, CourseInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        CourseInfo data = courseInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "teacher/course_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(CourseInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = courseInfoService.update(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "修改成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     删除数据接口
    */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        courseInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

