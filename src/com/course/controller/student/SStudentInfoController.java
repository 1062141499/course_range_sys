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
@RequestMapping("/student/student_info")
public class SStudentInfoController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	StudentInfoService studentInfoService;
	@Autowired
	TermInfoMapper termInfoMapper;
	@Autowired
	ClassInfoMapper classInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	@Autowired
	MajorInfoMapper majorInfoMapper;
	@Autowired
	MajorDirectInfoMapper majorDirectInfoMapper;
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
	* 根据所属学科查询班级列表
	*/
	@RequestMapping(value="getClassInfoListByMajorId")
	@ResponseBody
	public Object getClassInfoListByMajorId(Integer majorId){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		if(majorId==null){
			return rs;
		}
		ClassInfoExample te = new ClassInfoExample();
		ClassInfoExample.Criteria tc = te.createCriteria();
		tc.andMajorIdEqualTo(majorId);
		List<ClassInfo> tl = classInfoMapper.selectByExample(te);
		for(ClassInfo t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",t.getId());
			map.put("name",t.getClassName());
			rs.add(map);
		}
		return rs;
	}
	/**
	进入学生详情页
	*/
	@RequestMapping("detail")
	public Object detail(ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		StudentInfo model = new StudentInfo();
		model.setId(login.getId());
		StudentInfo preModel = studentInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("detail",studentInfoService.getStudentInfoModel(preModel,login));
		return "student/personal";
	}
}
