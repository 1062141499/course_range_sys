package com.course.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.dao.*;
import com.course.model.*;
import com.course.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.course.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.course.service.*;
import com.course.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Service
public class CourseApplyServiceImpl implements CourseApplyService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	CourseApplyMapper courseApplyMapper;
	@Autowired
	TeacherInfoMapper teacherInfoMapper;
	/**
	申请调停课
	*/
	@Override
	public String apply(CourseApply model,LoginModel login){
		if(model.getCourseName()==null||model.getCourseName().equals("")){
			return "课程名为必填属性";
		}
		if(model.getReason()==null||model.getReason().equals("")){
			return "调停原因为必填属性";
		}
		model.setApplyStatus(1);//默认已申请,
		model.setTeacherId(login.getId());//登录id
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		courseApplyMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(CourseApply model,LoginModel login){
		CourseApply preModel = courseApplyMapper.selectByPrimaryKey(model.getId());
		if(model.getCourseName()==null||model.getCourseName().equals("")){
			return "课程名为必填属性";
		}
		if(model.getReason()==null||model.getReason().equals("")){
			return "调停原因为必填属性";
		}
		preModel.setCourseName(model.getCourseName());
		preModel.setReason(model.getReason());
		courseApplyMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	申请通过
	*/
	@Override
	public String tg(CourseApply model,LoginModel login){
		CourseApply preModel = courseApplyMapper.selectByPrimaryKey(model.getId());
		if(model.getCheckRemark()==null||model.getCheckRemark().equals("")){
			return "管理员备注为必填属性";
		}
		preModel.setApplyStatus(2);//申请状态设置为申请通过
		preModel.setCheckRemark(model.getCheckRemark());
		courseApplyMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	申请不通过
	*/
	@Override
	public String btg(CourseApply model,LoginModel login){
		CourseApply preModel = courseApplyMapper.selectByPrimaryKey(model.getId());
		if(model.getCheckRemark()==null||model.getCheckRemark().equals("")){
			return "管理员备注为必填属性";
		}
		preModel.setApplyStatus(3);//申请状态设置为申请不通过
		preModel.setCheckRemark(model.getCheckRemark());
		courseApplyMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询调停课申请列表数据
	*/
	@Override
	public Map<String,Object> getDataList(CourseApply queryModel,Integer page,Integer pageSize,LoginModel login) {
		CourseApplyExample se = new CourseApplyExample();
		CourseApplyExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getCourseName()!=null&&queryModel.getCourseName().equals("")==false){
			sc.andCourseNameLike("%"+queryModel.getCourseName()+"%");//模糊查询
		}
		if(queryModel.getApplyStatus()!=null){
			sc.andApplyStatusEqualTo(queryModel.getApplyStatus());//查询申请状态等于指定值
		}
		int count = (int)courseApplyMapper.countByExample(se);
		int totalPage = 0;
		if(page!=null&&pageSize!=null){//分页
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<CourseApply> list = courseApplyMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(CourseApply model:list){
			list2.add(getCourseApplyModel(model,login));
		}
		rs.put("list",list2);//数据列表
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	封装调停课申请为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getCourseApplyModel(CourseApply model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("courseApply",model);
		map.put("applyStatusStr",DataListUtils.getApplyStatusNameById(model.getApplyStatus()+""));//解释申请状态字段
		if(model.getTeacherId()!=null){
			TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(model.getTeacherId());//申请教师为外接字段，需要关联教师来解释该字段
			if(teacherInfo!=null){
				map.put("teacherIdStr",teacherInfo.getTno()+"，"+teacherInfo.getRealName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		courseApplyMapper.deleteByPrimaryKey(id);
	}
}
