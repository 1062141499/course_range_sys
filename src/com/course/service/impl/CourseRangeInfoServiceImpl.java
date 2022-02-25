package com.course.service.impl;

import com.course.controller.LoginModel;

import com.course.dao.*;

import com.course.model.*;

import com.course.service.*;

import com.course.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class CourseRangeInfoServiceImpl implements CourseRangeInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    StuRangeInfoMapper stuRangeInfoMapper;

    
    /**
	新增
	*/
	@Override
	public String add(CourseRangeInfo model,LoginModel login){
		if(model.getCourseId()==null){
			return "课程ID为必填属性";
		}
		if(model.getRoomId()==null){
			return "教室为必填属性";
		}
		if(model.getWeekNo()==null){
			return "第几周为必填属性";
		}
		if(model.getWeekDay()==null){
			return "星期几为必填属性";
		}
		if(model.getJs()==null){
			return "第几节为必填属性";
		}
		CourseInfo courseIdT = courseInfoMapper.selectByPrimaryKey(model.getCourseId());//查询课程供以下填入其他字段
		if(courseIdT!=null){
			model.setTeacherId(courseIdT.getTeacherId());
		}
		if(courseIdT!=null){
			model.setCourseName(courseIdT.getCourseName());
		}
		if(courseIdT!=null){
			model.setMajorId(courseIdT.getMajorId());
		}
		if(courseIdT!=null){
			model.setDirectId(courseIdT.getDirectId());
		}
		if(courseIdT!=null){
			model.setTermId(courseIdT.getTermId());
		}
		courseRangeInfoMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(CourseRangeInfo model,LoginModel login){
		CourseRangeInfo preModel = courseRangeInfoMapper.selectByPrimaryKey(model.getId());
		if(model.getCourseId()==null){
			return "课程ID为必填属性";
		}
		if(model.getRoomId()==null){
			return "教室为必填属性";
		}
		if(model.getWeekNo()==null){
			return "第几周为必填属性";
		}
		if(model.getWeekDay()==null){
			return "星期几为必填属性";
		}
		if(model.getJs()==null){
			return "第几节为必填属性";
		}
		preModel.setCourseId(model.getCourseId());
		preModel.setRoomId(model.getRoomId());
		preModel.setWeekNo(model.getWeekNo());
		preModel.setWeekDay(model.getWeekDay());
		preModel.setJs(model.getJs());
		CourseInfo courseIdT = courseInfoMapper.selectByPrimaryKey(model.getCourseId());//查询课程供以下填入其他字段
		if(courseIdT!=null){
			preModel.setTeacherId(courseIdT.getTeacherId());
		}
		if(courseIdT!=null){
			preModel.setCourseName(courseIdT.getCourseName());
		}
		if(courseIdT!=null){
			preModel.setMajorId(courseIdT.getMajorId());
		}
		if(courseIdT!=null){
			preModel.setDirectId(courseIdT.getDirectId());
		}
		if(courseIdT!=null){
			preModel.setTermId(courseIdT.getTermId());
		}
		courseRangeInfoMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	
	
	
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		courseRangeInfoMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void exportData(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login){
		List<Map<String,Object>> list2 = (List<Map<String,Object>>)data.get("list");//根据查询条件获取数据
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:list2){
			Map<String,Object> map2 = new HashMap<String,Object>();
			CourseRangeInfo courseRangeInfo = (CourseRangeInfo)map.get("courseRangeInfo");
			Object teacherId = map.get("teacherIdStr");
			if(teacherId!=null){
				map2.put("teacherId",teacherId.toString());//解释教师
			}
			map2.put("courseName",courseRangeInfo.getCourseName());//解释课程名
			Object majorId = map.get("majorIdStr");
			if(majorId!=null){
				map2.put("majorId",majorId.toString());//解释学科
			}
			Object directId = map.get("directIdStr");
			if(directId!=null){
				map2.put("directId",directId.toString());//解释学科方向
			}
			Object roomId = map.get("roomIdStr");
			if(roomId!=null){
				map2.put("roomId",roomId.toString());//解释教室
			}
			map2.put("weekNo",courseRangeInfo.getWeekNo());//解释第几周
			Object weekDay = map.get("weekDayStr");
			if(weekDay!=null){
				map2.put("weekDay",weekDay.toString());//解释星期几
			}
			Object js = map.get("jsStr");
			if(js!=null){
				map2.put("js",js.toString());//解释第几节
			}
			Object termId = map.get("termIdStr");
			if(termId!=null){
				map2.put("termId",termId.toString());//解释学期
			}
			list3.add(map2);
		}
		PoiExcelExport pee = new PoiExcelExport(response,"课程表导出报表"+sdf2.format(new Date()),"sheet1");
	String[] headers = {"教师","课程名","学科","学科方向","教室","第几周","星期几","第几节","学期"};
	String[] columns = {"teacherId","courseName","majorId","directId","roomId","weekNo","weekDay","js","termId"};
	int[] titleSize = {20,20,20,20,20,20,20,20,20};
		try {
			pee.wirteExcel(columns, headers, titleSize, list3);//根据数据列表生成excel文件
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void exportData2(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data,LoginModel login){
		List<Map<String,Object>> list2 = (List<Map<String,Object>>)data.get("list");//根据查询条件获取数据
		List<Map<String,Object>> list3 = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> map:list2){
			Map<String,Object> map2 = new HashMap<String,Object>();
			CourseRangeInfo courseRangeInfo = (CourseRangeInfo)map.get("courseRangeInfo");
			Object teacherId = map.get("teacherIdStr");
			if(teacherId!=null){
				map2.put("teacherId",teacherId.toString());//解释教师
			}
			map2.put("courseName",courseRangeInfo.getCourseName());//解释课程名
			Object majorId = map.get("majorIdStr");
			if(majorId!=null){
				map2.put("majorId",majorId.toString());//解释学科
			}
			Object directId = map.get("directIdStr");
			if(directId!=null){
				map2.put("directId",directId.toString());//解释学科方向
			}
			Object roomId = map.get("roomIdStr");
			if(roomId!=null){
				map2.put("roomId",roomId.toString());//解释教室
			}
			map2.put("weekNo",courseRangeInfo.getWeekNo());//解释第几周
			Object weekDay = map.get("weekDayStr");
			if(weekDay!=null){
				map2.put("weekDay",weekDay.toString());//解释星期几
			}
			Object js = map.get("jsStr");
			if(js!=null){
				map2.put("js",js.toString());//解释第几节
			}
			Object termId = map.get("termIdStr");
			if(termId!=null){
				map2.put("termId",termId.toString());//解释学期
			}
			list3.add(map2);
		}
		PoiExcelExport pee = new PoiExcelExport(response,"课程表导出报表"+sdf2.format(new Date()),"sheet1");
	String[] headers = {"教师","课程名","学科","学科方向","教室","第几周","星期几","第几节","学期"};
	String[] columns = {"teacherId","courseName","majorId","directId","roomId","weekNo","weekDay","js","termId"};
	int[] titleSize = {20,20,20,20,20,20,20,20,20};
		try {
			pee.wirteExcel(columns, headers, titleSize, list3);//根据数据列表生成excel文件
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    /**
    *根据参数查询课程表列表数据
    */
    @Override
    public Map<String, Object> getDataList(CourseRangeInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        CourseRangeInfoExample se = new CourseRangeInfoExample();
        CourseRangeInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if ((queryModel.getCourseName() != null) &&
                (queryModel.getCourseName().equals("") == false)) {
            sc.andCourseNameLike("%" + queryModel.getCourseName() + "%"); //模糊查询
        }

        if (queryModel.getTeacherId() != null) {
            sc.andTeacherIdEqualTo(queryModel.getTeacherId());
        }
        if(login.getLoginType()==3){
        	StuRangeInfoExample re = new StuRangeInfoExample();
        	StuRangeInfoExample.Criteria rc =re.createCriteria();
        	rc.andStuIdEqualTo(login.getId());
        	List<StuRangeInfo> rl = stuRangeInfoMapper.selectByExample(re);//查询该学生的所有排课信息
        	List<Integer> rids = new ArrayList<Integer>();//排课ID
        	for(StuRangeInfo r:rl){
        		rids.add(r.getRangeId());
        	}
        	
        	if(rids.size()==0){
        		sc.andIdEqualTo(0);
        	}else{
        		sc.andIdIn(rids);
        	}
        }
        int count = (int) courseRangeInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<CourseRangeInfo> list = courseRangeInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CourseRangeInfo model : list) {
            list2.add(getCourseRangeInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装课程表为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getCourseRangeInfoModel(CourseRangeInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseRangeInfo", model);

        if (model.getTeacherId() != null) {
            TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(model.getTeacherId()); //教师id为外接字段,需要关联教师来解释该字段

            if (teacherInfo != null) {
                map.put("teacherIdStr",
                    teacherInfo.getTno() + "+" + teacherInfo.getRealName());
            }
        }

        if (model.getCourseId() != null) {
            CourseInfo courseInfo = courseInfoMapper.selectByPrimaryKey(model.getCourseId()); //课程id为外接字段,需要关联课程来解释该字段

            if (courseInfo != null) {
                map.put("courseIdStr", courseInfo.getCourseName());
            }
        }

        if (model.getMajorId() != null) {
            MajorInfo majorInfo = majorInfoMapper.selectByPrimaryKey(model.getMajorId()); //学科为外接字段,需要关联学科来解释该字段

            if (majorInfo != null) {
                map.put("majorIdStr", majorInfo.getMajorName());
            }
        }

        if (model.getDirectId() != null) {
            MajorDirectInfo majorDirectInfo = majorDirectInfoMapper.selectByPrimaryKey(model.getDirectId()); //学科方向为外接字段,需要关联学科学科方向来解释该字段

            if (majorDirectInfo != null) {
                map.put("directIdStr", majorDirectInfo.getDirectName());
            }
        }

        if (model.getRoomId() != null) {
            RoomInfo roomInfo = roomInfoMapper.selectByPrimaryKey(model.getRoomId()); //教室为外接字段,需要关联教室来解释该字段

            if (roomInfo != null) {
                map.put("roomIdStr", roomInfo.getRoomName());
            }
        }

        map.put("weekDayStr",
            DataListUtils.getWeekDayNameById(model.getWeekDay() + "")); //解释星期几字段
        map.put("jsStr", DataListUtils.getJsNameById(model.getJs() + "")); //解释第几节字段

        if (model.getTermId() != null) {
            TermInfo termInfo = termInfoMapper.selectByPrimaryKey(model.getTermId()); //学期为外接字段,需要关联学期来解释该字段

            if (termInfo != null) {
                map.put("termIdStr", termInfo.getTermName());
            }
        }

        return map;
    }
}

