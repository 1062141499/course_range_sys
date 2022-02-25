package com.course.service;
import java.util.Map;
import com.course.controller.LoginModel;
import com.course.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface CourseApplyService{
	/**
	分页查询调停课申请数据列表
	*/
	public Map<String,Object> getDataList(CourseApply queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装调停课申请为前台展示的数据形式
	*/
	public Map<String,Object> getCourseApplyModel(CourseApply model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	申请调停课
	*/
	public String apply(CourseApply model,LoginModel login);
	/**
	修改
	*/
	public String update(CourseApply model,LoginModel login);
	/**
	申请通过
	*/
	public String tg(CourseApply model,LoginModel login);
	/**
	申请不通过
	*/
	public String btg(CourseApply model,LoginModel login);
}
