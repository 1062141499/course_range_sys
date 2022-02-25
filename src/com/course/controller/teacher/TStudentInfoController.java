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
@RequestMapping("/teacher/student_info")
public class TStudentInfoController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	StudentInfoService studentInfoService;
	@Autowired
	TermInfoMapper termInfoMapper;
	@Autowired
	TeacherInfoMapper teacherInfoMapper;
	@Autowired
	ClassInfoMapper classInfoMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	@Autowired
	MajorInfoMapper majorInfoMapper;
	@Autowired
	MajorDirectInfoMapper majorDirectInfoMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("sexList",DataListUtils.getSexList());//返回sex列表
		MajorInfoExample majorInfoE = new MajorInfoExample();
		MajorInfoExample.Criteria majorInfoC=majorInfoE.createCriteria();
		List<MajorInfo> majorInfoList=majorInfoMapper.selectByExample(majorInfoE);
		List<Map<String,Object>>  majorInfoList2 = new ArrayList<Map<String,Object>>();
		for(MajorInfo m:majorInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getMajorName());
			majorInfoList2.add(map);
		}
		modelMap.addAttribute("majorInfoList",majorInfoList2);
		MajorDirectInfoExample majorDirectInfoE = new MajorDirectInfoExample();
		MajorDirectInfoExample.Criteria majorDirectInfoC=majorDirectInfoE.createCriteria();
		List<MajorDirectInfo> majorDirectInfoList=majorDirectInfoMapper.selectByExample(majorDirectInfoE);
		List<Map<String,Object>>  majorDirectInfoList2 = new ArrayList<Map<String,Object>>();
		for(MajorDirectInfo m:majorDirectInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getDirectName());
			majorDirectInfoList2.add(map);
		}
		modelMap.addAttribute("majorDirectInfoList",majorDirectInfoList2);
		ClassInfoExample classInfoE = new ClassInfoExample();
		ClassInfoExample.Criteria classInfoC=classInfoE.createCriteria();
		List<ClassInfo> classInfoList=classInfoMapper.selectByExample(classInfoE);
		List<Map<String,Object>>  classInfoList2 = new ArrayList<Map<String,Object>>();
		for(ClassInfo m:classInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getClassName());
			classInfoList2.add(map);
		}
		modelMap.addAttribute("classInfoList",classInfoList2);
		TermInfoExample termInfoE = new TermInfoExample();
		TermInfoExample.Criteria termInfoC=termInfoE.createCriteria();
		List<TermInfo> termInfoList=termInfoMapper.selectByExample(termInfoE);
		List<Map<String,Object>>  termInfoList2 = new ArrayList<Map<String,Object>>();
		for(TermInfo m:termInfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getTermName());
			termInfoList2.add(map);
		}
		modelMap.addAttribute("termInfoList",termInfoList2);
	}
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
	* 返回学生列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",teacherInfo);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "teacher/student_info/list";
	}
	/**
	* 根据查询条件分页查询学生数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(StudentInfo model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return studentInfoService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,StudentInfo model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "teacher/student_info/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(StudentInfo model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = studentInfoService.add(model,login);//执行添加操作
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
	public String update(ModelMap modelMap,StudentInfo model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		StudentInfo data = studentInfoMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "teacher/student_info/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(StudentInfo model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = studentInfoService.update(model,login);//执行修改操作
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
	删除学生接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		studentInfoService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	* 生成导入学生导入excel模板
	*/
	@RequestMapping(value="import_data_model")
	public void import_data_model(HttpServletResponse response,HttpServletRequest request){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();// 空数据模板
		PoiExcelExport pee = new PoiExcelExport(response, "导入学生模板", "sheet1");
	String[] headers = {"学号（必填）","密码（必填）","性别（必填）","姓名（必填）","所属学科（必填）","方向（必填）","班级（必填）","联系电话（必填）","入学年份（必填，数）","学期id（必填）","家庭住址（必填）","家长联系方式（必填）"};
	String[] columns = {"stuNo","password","sex","realName","majorId","directId","classId","celPhone","enterYear","termId","familyAddress","parentCel"};
	int[] titleSize = {20,20,20,20,20,20,20,20,20,20,20,20};
		try {
			pee.wirteExcel(columns, headers, titleSize, new ArrayList<Map<String,Object>>());//生成excel
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	* 批量导入数据的接口，解析上传的excel中的数据，将数据批量插入到数据库中
	**/
	@RequestMapping(value = "import_data", method = RequestMethod.POST)
	@ResponseBody
	public Object importData(@RequestParam MultipartFile file,ModelMap modelMap,HttpServletRequest request,
	StudentInfo model, HttpServletResponse response)throws IOException {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String, Object> rs = new HashMap<String, Object>();
		String data = studentInfoService.importData(file.getInputStream(),file.getOriginalFilename(), login,model);// 导入数据
		if (!data.equals("")) {
			rs.put("code", 0);
			rs.put("msg", data);
			return rs;
		} else {
			rs.put("code", 1);
			rs.put("msg", "导入学生成功");
			return rs;
		}
	}
}
