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
public class XkLogServiceImpl implements XkLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	CourseInfoMapper courseInfoMapper;
	@Autowired
	XkLogMapper xkLogMapper;
	@Autowired
	StudentInfoMapper studentInfoMapper;
	/**
	*根据参数查询选课记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(XkLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		XkLogExample se = new XkLogExample();
		XkLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getStuId()!=null){
			sc.andStuIdEqualTo(queryModel.getStuId());//查询选课学生等于指定值
		}
		int count = (int)xkLogMapper.countByExample(se);
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
		List<XkLog> list = xkLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(XkLog model:list){
			list2.add(getXkLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	封装选课记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getXkLogModel(XkLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("xkLog",model);
		if(model.getCourseId()!=null){
			CourseInfo courseInfo = courseInfoMapper.selectByPrimaryKey(model.getCourseId());//课程为外接字段，需要关联课程来解释该字段
			if(courseInfo!=null){
				map.put("courseIdStr",courseInfo.getCourseName());
			}
		}
		if(model.getStuId()!=null){
			StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(model.getStuId());//选课学生为外接字段，需要关联学生来解释该字段
			if(studentInfo!=null){
				map.put("stuIdStr",studentInfo.getStuNo());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		xkLogMapper.deleteByPrimaryKey(id);
	}
}
