package com.course.service;
import java.util.Map;
import com.course.controller.LoginModel;
import com.course.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface XkLogService{
	/**
	分页查询选课记录数据列表
	*/
	public Map<String,Object> getDataList(XkLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装选课记录为前台展示的数据形式
	*/
	public Map<String,Object> getXkLogModel(XkLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
