package com.course.controller.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.course.dao.*;
import com.course.model.*;
import com.course.service.impl.*;
import com.course.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.course.controller.LoginModel;
import com.course.service.*;
@Controller
@RequestMapping("/admin/course_range_info")
public class ACourseRangeInfoController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	CourseRangeInfoService courseRangeInfoService;
	@Autowired
	TermInfoMapper termInfoMapper;
	@Autowired
	RoomInfoMapper roomInfoMapper;
	@Autowired
	CourseInfoMapper courseInfoMapper;
	@Autowired
	CourseRangeInfoMapper courseRangeInfoMapper;
	@Autowired
	AdminInfoMapper adminInfoMapper;
	@Autowired
	TeacherInfoMapper teacherInfoMapper;
	@Autowired
	MajorInfoMapper majorInfoMapper;
	@Autowired
	MajorDirectInfoMapper majorDirectInfoMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		CourseInfoExample courseInfoE = new CourseInfoExample();
		CourseInfoExample.Criteria courseInfoC=courseInfoE.createCriteria();
		List<CourseInfo> courseInfoList=courseInfoMapper.selectByExample(courseInfoE);
		List<Map<String,Object>>  courseInfoList2 = new ArrayList<Map<String,Object>>();
		for(CourseInfo m:courseInfoList){
			
			TeacherInfo teacher = teacherInfoMapper.selectByPrimaryKey(m.getTeacherId());
			
			MajorInfo major = majorInfoMapper.selectByPrimaryKey(m.getMajorId());
			MajorDirectInfo direct = majorDirectInfoMapper.selectByPrimaryKey(m.getDirectId());
			TermInfo t = termInfoMapper.selectByPrimaryKey(m.getTermId());
			
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name","【"+teacher.getTno()+"】"+m.getCourseName()+"-"+major.getMajorName()+"("+t.getTermName()+")");
			courseInfoList2.add(map);
		}
		modelMap.addAttribute("courseInfoList",courseInfoList2);
		RoomInfoExample roomInfoE = new RoomInfoExample();
		RoomInfoExample.Criteria roomInfoC=roomInfoE.createCriteria();
		List<RoomInfo> roomInfoList=roomInfoMapper.selectByExample(roomInfoE);
		List<Map<String,Object>>  roomInfoList2 = new ArrayList<Map<String,Object>>();
		for(RoomInfo m:roomInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getRoomName());
			roomInfoList2.add(map);
		}
		modelMap.addAttribute("roomInfoList",roomInfoList2);
		modelMap.addAttribute("weekDayList",DataListUtils.getWeekDayList());//返回week_day列表
		modelMap.addAttribute("jsList",DataListUtils.getJsList());//返回js列表
	}
	/**
	* 返回课程表列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminInfo);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/course_range_info/list";
	}
	/**
	* 根据查询条件分页查询课程表数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(CourseRangeInfo model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return courseRangeInfoService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,CourseRangeInfo model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "admin/course_range_info/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(CourseRangeInfo model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseRangeInfoService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update")
	public String update(ModelMap modelMap,CourseRangeInfo model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		CourseRangeInfo data = courseRangeInfoMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/course_range_info/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(CourseRangeInfo model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseRangeInfoService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除课程表接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		courseRangeInfoService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	* 根据查询条件导出课程表数据,生成excel
	*/
	@RequestMapping(value="export_data")
	public void export_data(CourseRangeInfo model,Integer page,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> data =  courseRangeInfoService.getDataList(model,page,CommonVal.pageSize,login);//获取数据列表，不分页
		courseRangeInfoService.exportData( request,  response,data, login);
	}
}
