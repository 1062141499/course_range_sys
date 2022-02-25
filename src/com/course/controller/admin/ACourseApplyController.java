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
@RequestMapping("/admin/course_apply")
public class ACourseApplyController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	CourseApplyService courseApplyService;
	@Autowired
	CourseApplyMapper courseApplyMapper;
	@Autowired
	AdminInfoMapper adminInfoMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("applyStatusList",DataListUtils.getApplyStatusList());//返回apply_status列表
	}
	/**
	* 返回调停课申请列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminInfo);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/course_apply/list";
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
	进入申请通过页面
	*/
	@RequestMapping("tg")
	public String tg(ModelMap modelMap,CourseApply model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		CourseApply data = courseApplyMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/course_apply/tg_page";
	}
	/**
	申请通过提交信息接口
	*/
	@RequestMapping("tg_submit")
	@ResponseBody
	public Object tg_submit(CourseApply model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseApplyService.tg(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","申请通过成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入申请不通过页面
	*/
	@RequestMapping("btg")
	public String btg(ModelMap modelMap,CourseApply model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		CourseApply data = courseApplyMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "admin/course_apply/btg_page";
	}
	/**
	申请不通过提交信息接口
	*/
	@RequestMapping("btg_submit")
	@ResponseBody
	public Object btg_submit(CourseApply model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = courseApplyService.btg(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","申请不通过成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除调停课申请接口
	*/
	@RequestMapping("del2")
	@ResponseBody
	public Object del2(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		courseApplyService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
