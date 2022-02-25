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
@RequestMapping("/student/course_info")
public class SCourseInfoController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	CourseInfoService courseInfoService;
	@Autowired
	TermInfoMapper termInfoMapper;
	@Autowired
	RoomInfoMapper roomInfoMapper;
	@Autowired
	CourseInfoMapper courseInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	@Autowired
	MajorInfoMapper majorInfoMapper;
	@Autowired
	MajorDirectInfoMapper majorDirectInfoMapper;
	@Autowired
	XkLogMapper xkLogMapper;
	
	
	/**
	* 根据专业ID查询专业方向列表
	*/
	@RequestMapping(value="getMajorDirectInfoListByMajorId")
	@ResponseBody
	public Object getMajorDirectInfoListByMajorId(Integer majorId){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		if(majorId==null){
			return rs;
		}
		MajorDirectInfoExample te = new MajorDirectInfoExample();
		MajorDirectInfoExample.Criteria tc = te.createCriteria();
		tc.andMajorIdEqualTo(majorId);
		List<MajorDirectInfo> tl = majorDirectInfoMapper.selectByExample(te);
		for(MajorDirectInfo t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",t.getId());
			map.put("name",t.getDirectName());
			rs.add(map);
		}
		return rs;
	}
	/**
	* 返回课程列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",studentInfo);
		return "student/course_info/list";
	}
	/**
	* 根据查询条件分页查询课程数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(CourseInfo model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return courseInfoService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	@RequestMapping(value = "xk")
	@ResponseBody
	public Object xk(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		
		
		XkLogExample xe = new XkLogExample();
		XkLogExample.Criteria xc = xe.createCriteria();
		xc.andCourseIdEqualTo(id);
		xc.andStuIdEqualTo(login.getId());
		int count = (int) xkLogMapper.countByExample(xe);
		if(count>0){
			rs.put("code", 0);
			rs.put("msg","您已选过该课程");
			return rs;
		}
		
		XkLog log = new XkLog();
		log.setCourseId(id);
		log.setCreateTime(sdf1.format(new Date()));
		log.setStuId(login.getId());
		xkLogMapper.insertSelective(log);
		rs.put("code", 1);
		rs.put("msg","选课成功");
		return rs;
	}
}
