package com.course.controller;

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
@RequestMapping("/commonapi/course_show")
public class CourseShowController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ClassInfoService classInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    StuRangeInfoMapper stuRangeInfoMapper;

    /**
     * 返回班级列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        TermInfoExample te = new TermInfoExample();
        List<TermInfo> tl = termInfoMapper.selectByExample(te);
        modelMap.addAttribute("tl", tl);
        
        List<Map<String,Object>> weekList =new ArrayList<Map<String,Object>>();
        for(int i=1;i<=30;i++){
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("id", i);
        	map.put("name", "第"+i+"周");
        	weekList.add(map);
        }
        
        modelMap.addAttribute("weekList",DataListUtils.getWeekDayList());
        modelMap.addAttribute("weekNoList",weekList);
        return "course_show";
    }

    /**
     * 根据查询条件分页查询班级数据,然后返回给前台渲染
    */
    @RequestMapping(value = "courseQuery")
    @ResponseBody
    public Object courseQuery(Integer termId,Integer weekNo,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        List<Integer> rangeIds = new ArrayList<Integer>();
        if(login.getLoginType()==3){//学生只查自己的课程
        	StuRangeInfoExample se = new StuRangeInfoExample();
        	StuRangeInfoExample.Criteria sc= se.createCriteria();
        	sc.andStuIdEqualTo(login.getId());
        	List<StuRangeInfo> sl = stuRangeInfoMapper.selectByExample(se);
        	
        	for(StuRangeInfo s:sl){
        		rangeIds.add(s.getRangeId());
        	}
        
        }
        List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> jsList = DataListUtils.getJsList();
        for(Map<String,Object> js:jsList){
        	 CourseRangeInfoExample ce = new CourseRangeInfoExample();
             CourseRangeInfoExample.Criteria cc = ce.createCriteria();
             
             if(login.getLoginType()==2){//教师只查自己负责的课程
             	cc.andTeacherIdEqualTo(login.getId());
             }
             if(login.getLoginType()==3){
             	if(rangeIds.size()==0){
             		cc.andIdEqualTo(0);
             	}else{
             		cc.andIdIn(rangeIds);
             	}
             }
          
             if(termId!=null){
             	cc.andTermIdEqualTo(termId);	
             }
             if(termId!=null){
             	cc.andWeekNoEqualTo(weekNo);
             }
             cc.andJsEqualTo(Integer.parseInt(js.get("id").toString()));
             
             List<CourseRangeInfo> cl = courseRangeInfoMapper.selectByExample(ce);
             
             Map<String,Object> map = new HashMap<String,Object>();
             map.put("js", js.get("name").toString());
             String course1 = "";
             String course2 = "";
             String course3 = "";
             String course4 = "";
             String course5 = "";
             String course6 = "";
             String course7 = "";
             for(CourseRangeInfo range:cl){
            	 if(range.getWeekDay()==1){
            		 course1+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==2){
            		 course2+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==3){
            		 course3+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==4){
            		 course4+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==5){
            		 course5+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==6){
            		 course6+=range.getCourseName()+",";
            	 }
            	 if(range.getWeekDay()==7){
            		 course7+=range.getCourseName()+",";
            	 }
            	
             }
             
             
             if(course1.equals("")==false){
            	 course1 = course1.substring(0, course1.length()-1);
             }
             if(course2.equals("")==false){
            	 course2 = course2.substring(0, course2.length()-1);
             }
             if(course3.equals("")==false){
            	 course3 = course3.substring(0, course3.length()-1);
             }
             if(course4.equals("")==false){
            	 course4 = course4.substring(0, course4.length()-1);
             }
             if(course5.equals("")==false){
            	 course5 = course5.substring(0, course5.length()-1);
             }
             if(course6.equals("")==false){
            	 course6= course6.substring(0, course6.length()-1);
             }
             if(course7.equals("")==false){
            	 course7 = course7.substring(0, course7.length()-1);
             }
             
             map.put("course1", course1);
             map.put("course2", course2);
             map.put("course3", course3);
             map.put("course4", course4);
             map.put("course5", course5);
             map.put("course6", course6);
             map.put("course7", course7);
             rs.add(map);
             
        }
        
       
        return rs;
    		
        
      
    }

}

