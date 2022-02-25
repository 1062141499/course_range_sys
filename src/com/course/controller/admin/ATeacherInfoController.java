package com.course.controller.admin;

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
@RequestMapping("/admin/teacher_info")
public class ATeacherInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    
    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台
        modelMap.addAttribute("sexList", DataListUtils.getSexList()); //返回sex数据列表
    }

    /**
     * 返回教师列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/teacher_info/list";
    }
    
    
    
    @RequestMapping(value = "queryTeacherCourse")
    public String queryTeacherCourse(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
     

        return "admin/teacher_info/teacher_course";
    }
    
    
    /**
     * 根据查询条件分页查询教师授课数据
    */
    @RequestMapping(value = "queryCourseList")
    @ResponseBody
    public Object toList(String cname, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
        CourseInfoExample ce = new CourseInfoExample();
        CourseInfoExample.Criteria cc = ce.createCriteria();
        if(cname!=null&&cname.trim().equals("")==false){
        	cc.andCourseNameLike("%"+cname+"%");
        }
        
        int count = (int) courseInfoMapper.countByExample(ce);
        int totalPage = 0;

        if ((page != null) && (CommonVal.pageSize != null)) { //分页

            if ((count > 0) && ((count % CommonVal.pageSize) == 0)) {
                totalPage = count / CommonVal.pageSize;
            } else {
                totalPage = (count / CommonVal.pageSize) + 1;
            }

            ce.setPageRows(CommonVal.pageSize);
            ce.setStartRow((page - 1) * CommonVal.pageSize);
        }

        List<CourseInfo> list = courseInfoMapper.selectByExample(ce); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CourseInfo model : list) {
        	list2.add(castCourseModel( model,1));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
        
    }
    
    private Map<String,Object> castCourseModel(CourseInfo model,Integer type){
    	Map<String, Object> map = new HashMap<String, Object>();
    	TeacherInfo t = teacherInfoMapper.selectByPrimaryKey(model.getTeacherId());
    	map.put("tname", t.getRealName());
    	map.put("cname", model.getCourseName());
    	
    	List<Integer> rids = new ArrayList<Integer>();
    	if(model.getRoomIds()!=null&&model.getRoomIds().trim().equals("")==false){
    		String [] split = model.getRoomIds().split(",");
    		for(String str:split){
    			if(str.trim().equals("")==false){
    				rids.add(Integer.parseInt(str));
    			}
    		}
    	}
    	
    	String roomNames ="";
    	
    	if(rids.size()>0){
    		RoomInfoExample re = new RoomInfoExample();
        	RoomInfoExample.Criteria rc =re.createCriteria();
        	rc.andIdIn(rids);
        	List<RoomInfo> rl = roomInfoMapper.selectByExample(re);
        	for(RoomInfo r:rl){
        		if(type==1){
        			roomNames+="<p>"+r.getRoomName()+";</p>";	
        		}else{
        			roomNames+=""+r.getRoomName()+";";
        		}
        		
        	}
    	}
    
    	map.put("roomNames", roomNames);
    	TermInfo term = termInfoMapper.selectByPrimaryKey(model.getTermId());
    	map.put("termName", term.getTermName());
    	
    	CourseRangeInfoExample re = new CourseRangeInfoExample();
    	CourseRangeInfoExample.Criteria rc = re.createCriteria();
    	rc.andCourseIdEqualTo(model.getId());
    	List<CourseRangeInfo> rl = courseRangeInfoMapper.selectByExample(re);
    	String rangeTime="";
    	List<String> tmpList = new ArrayList<String>();//已出现过的所有的时间
    	
    	for(CourseRangeInfo r:rl){
    		boolean hasAdd=false;
    		for(String str:tmpList){
    			if(str.equals(r.getJs()+","+r.getWeekDay())){
    				hasAdd=true;
    			}
    		}
    		if(hasAdd==false){
    			if(type==1){
    				rangeTime+="<p>"+DataListUtils.getWeekDayNameById(r.getWeekDay()+"")+DataListUtils.getJsNameById(r.getJs()+"")+"</p>";	
    			}else{
    				rangeTime+=""+DataListUtils.getWeekDayNameById(r.getWeekDay()+"")+DataListUtils.getJsNameById(r.getJs()+"")+";";
    			}
    				
    			tmpList.add(r.getJs()+","+r.getWeekDay());
    		}
    		
    	}
    	map.put("rangeTime", rangeTime);
    	
    	
    	MajorInfo m = majorInfoMapper.selectByPrimaryKey(model.getMajorId());
    	 MajorDirectInfo d = majorDirectInfoMapper.selectByPrimaryKey(model.getDirectId());
    	 map.put("md", m.getMajorName()+" "+d.getDirectName());
    	return map;
    }
    
    /**
     * 根据查询条件导出课程,生成excel
    */
    @RequestMapping(value = "export_course_data")
    public void export_data(String cname, Integer page,
        HttpServletRequest request, HttpServletResponse response,
        ModelMap modelMap) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        CourseInfoExample ce = new CourseInfoExample();
        CourseInfoExample.Criteria cc = ce.createCriteria();
        if(cname!=null&&cname.trim().equals("")==false){
        	cc.andCourseNameLike("%"+cname+"%");
        }
        List<CourseInfo> list = courseInfoMapper.selectByExample(ce); 
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CourseInfo model : list) {
        	list2.add(castCourseModel( model,2));
        }
        
        PoiExcelExport pee = new PoiExcelExport(response,
                "课程表导出报表" +
                sdf2.format(new Date()), "sheet1");
        String[] headers = {
                "课程",
                "教师",
                "教室",
                "上课时间",
                "专业方向",
                "学期"
            };
        String[] columns = { "cname", "tname","roomNames", "rangeTime", "md", "termName" };
        int[] titleSize = { 20, 20, 20, 20, 20,20 };
        try {
            pee.wirteExcel(columns, headers, titleSize, list2); //根据数据列表生成excel文件
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

    /**
     * 根据查询条件分页查询教师数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(TeacherInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return teacherInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    /**
     进入新增页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, TeacherInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "admin/teacher_info/add_page";
    }

    /**
     新增提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(TeacherInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teacherInfoService.add(model, login); //执行添加操作

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
    public String update(ModelMap modelMap, TeacherInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        TeacherInfo data = teacherInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "admin/teacher_info/update_page";
    }

    /**
     修改提交信息接口
    */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(TeacherInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = teacherInfoService.update(model, login); //执行修改操作

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
        teacherInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
            "删除成功");

        return rs;
    }
}

