package com.course.controller.teacher;
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
@RequestMapping("/teacher/course_apply")
public class TCourseApplyController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	CourseApplyService courseApplyService;
	@Autowired
	CourseApplyMapper courseApplyMapper;
	@Autowired
	TeacherInfoMapper teacherInfoMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("applyStatusList",DataListUtils.getApplyStatusList());//返回apply_status列表
	}
	/**
	* 返回调停课申请列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",teacherInfo);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "teacher/course_apply/list";
	}
	/**
	* 根据查询条件分页查询调停课申请数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(CourseApply model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return courseApplyService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入申请调停课页面
	*/
	@RequestMapping("apply")
	public String apply(ModelMap modelMap,CourseApply model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "teacher/course_apply/apply_page";
	}
	/**
	申请调停课提交信息接口
	*/
	@RequestMapping("apply_submit")
	@ResponseBody
	public Object apply_submit(CourseApply model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseApplyService.apply(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","申请调停课成功");
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
	public String update(ModelMap modelMap,CourseApply model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		CourseApply data = courseApplyMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "teacher/course_apply/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(CourseApply model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseApplyService.update(model,login);//执行修改操作
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
	删除调停课申请接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		courseApplyService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
