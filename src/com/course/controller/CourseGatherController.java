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
@RequestMapping("/commonapi/gather")
public class CourseGatherController {
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
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    StuRangeInfoMapper stuRangeInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
 

    /**
     * 按教室统计
    */
    @RequestMapping(value = "room_gather")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        TermInfoExample te = new TermInfoExample();
      List<TermInfo> tl = termInfoMapper.selectByExample(te);
      modelMap.addAttribute("tl", tl);
        return "room_gather";
    }
    
    
    @RequestMapping(value = "queryRoom")
    @ResponseBody
    public Object toList(Integer termId,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        RoomInfoExample re = new RoomInfoExample();
        List<RoomInfo> rl = roomInfoMapper.selectByExample(re);
        
        List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
        
        
        TermInfoExample te = new TermInfoExample();
        TermInfoExample.Criteria tc = te.createCriteria();
        if(termId!=null){
        	tc.andIdEqualTo(termId);
        }
      List<TermInfo> tl = termInfoMapper.selectByExample(te);
      List<Map<String,Object>> jsList = DataListUtils.getJsList();
      List<Map<String,Object>> weekList = DataListUtils.getJsList();
        		
        	
        
        for(RoomInfo r:rl){
        	
        	
        	for(TermInfo t:tl){
        		for(Map<String,Object> week:weekList){
        		
        			for(Map<String,Object> js:jsList){
        			
        	        	String courseNames="";
        	        	CourseRangeInfoExample ce = new CourseRangeInfoExample();
        	        	CourseRangeInfoExample.Criteria cc = ce.createCriteria();
        	        	cc.andRoomIdEqualTo(r.getId());
        	        	cc.andWeekDayEqualTo(Integer.parseInt(week.get("id").toString()));
        	        	cc.andJsEqualTo(Integer.parseInt(js.get("id").toString()));
        	        	List<CourseRangeInfo> cl = courseRangeInfoMapper.selectByExample(ce);
        	        	for(CourseRangeInfo c:cl){
        	        		
        	        		TeacherInfo teacher = teacherInfoMapper.selectByPrimaryKey(c.getTeacherId());
        	        		if(courseNames.contains(c.getCourseName())==false){
        	        			courseNames+=c.getCourseName()+"（"+teacher.getTno()+"），";	
        	        		}
        	        		
        	        	}
        	        	
        	        	if(courseNames.equals("")==false){
        	        		Map<String,Object> map = new HashMap<String,Object>();
            	        	map.put("room", r.getRoomName());
            	        	map.put("term",t.getTermName());
            	        	map.put("week", week.get("name").toString());
            	        	map.put("js", js.get("name").toString());
            	        	map.put("courseNames", courseNames);
            	        	rlist.add(map);
        	        	}
        	        	
        	        	
            		}
        		}
        	}
        	
        	
        }
        
        
        return rlist;
    }
    
    
    
    /**
     * 按班级统计
    */
    @RequestMapping(value = "class_gather")
    public String class_gather(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        TermInfoExample te = new TermInfoExample();
      List<TermInfo> tl = termInfoMapper.selectByExample(te);
      modelMap.addAttribute("tl", tl);
        return "class_gather";
    }
    
    
    @RequestMapping(value = "queryClassGather")
    @ResponseBody
    public Object queryClassGather(Integer termId,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        ClassInfoExample re = new ClassInfoExample();
        List<ClassInfo> rl = classInfoMapper.selectByExample(re);
        
        List<Map<String,Object>> rlist = new ArrayList<Map<String,Object>>();
        
        
        TermInfoExample te = new TermInfoExample();
        TermInfoExample.Criteria tc = te.createCriteria();
        if(termId!=null){
        	tc.andIdEqualTo(termId);
        }
      List<TermInfo> tl = termInfoMapper.selectByExample(te);
      List<Map<String,Object>> weekList = DataListUtils.getJsList();
        		
        	
        
        for(ClassInfo r:rl){
        	
        	
        	for(TermInfo t:tl){
        		for(Map<String,Object> week:weekList){
        		
        			
        	        	String courseNames="";
        	        	CourseRangeInfoExample ce = new CourseRangeInfoExample();
        	        	CourseRangeInfoExample.Criteria cc = ce.createCriteria();
        	        	cc.andRoomIdEqualTo(r.getId());
        	        	cc.andWeekDayEqualTo(Integer.parseInt(week.get("id").toString()));
        	        	List<CourseRangeInfo> cl = courseRangeInfoMapper.selectByExample(ce);
        	        	for(CourseRangeInfo c:cl){
        	        		
        	        		TeacherInfo teacher = teacherInfoMapper.selectByPrimaryKey(c.getTeacherId());
        	        		if(courseNames.contains(c.getCourseName())==false){
        	        			courseNames+=c.getCourseName()+"（"+teacher.getTno()+"），";	
        	        		}
        	        		
        	        	}
        	        	
        	        	if(courseNames.equals("")==false){
        	        		Map<String,Object> map = new HashMap<String,Object>();
            	        	map.put("className", r.getClassName());
            	        	map.put("term",t.getTermName());
            	        	map.put("week", week.get("name").toString());
            	        	map.put("courseNames", courseNames);
            	        	rlist.add(map);
        	        	}
        	        	
        	        	
        		}
        	}
        	
        	
        }
        
        
        return rlist;
    }

  
}

