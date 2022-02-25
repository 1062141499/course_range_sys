package com.course.controller.student;
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
@RequestMapping("/student/xk_log")
public class SXkLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	XkLogService xkLogService;
	@Autowired
	CourseInfoMapper courseInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	@Autowired
	XkLogMapper xkLogMapper;
	/**
	* 返回选课记录列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",studentInfo);
		return "student/xk_log/list";
	}
	/**
	* 根据查询条件分页查询选课记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(XkLog model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setStuId(login.getId());//选课学生等于当前登录id
		return xkLogService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除选课记录接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		xkLogService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
