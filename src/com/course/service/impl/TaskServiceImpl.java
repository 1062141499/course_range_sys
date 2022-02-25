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
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class TaskServiceImpl implements TaskService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    MajorInfoMapper majorInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    StudentTimeInfoMapper studentTimeInfoMapper;
    @Autowired
    MajorDirectInfoMapper majorDirectInfoMapper;
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    TeacherTimeInfoMapper teacherTimeInfoMapper;
    @Autowired
    TermInfoMapper termInfoMapper;
    @Autowired
    CourseRangeInfoMapper courseRangeInfoMapper;
    @Autowired
    StuRangeInfoMapper stuRangeInfoMapper;
    @Autowired
    XkLogMapper xkLogMapper;

    @Override
    public void courseRange(Integer termId) {
        //排课贪心算法
    	TermInfo t = termInfoMapper.selectByPrimaryKey(termId);
    	CourseRangeInfoExample cre5 = new CourseRangeInfoExample();
    	CourseRangeInfoExample.Criteria crc5 = cre5.createCriteria();
    	List<CourseRangeInfo> crl5 = courseRangeInfoMapper.selectByExample(cre5);
    	List<Integer> delIds = new ArrayList<Integer>();//要删除的排课id
    	for(CourseRangeInfo cr5:crl5){
    		delIds.add(cr5.getId());
    	}
    	if(delIds.size()>0){
    		StuRangeInfoExample sre5 = new StuRangeInfoExample();
    		StuRangeInfoExample.Criteria src5 = sre5.createCriteria();
    		src5.andRangeIdIn(delIds);
    		stuRangeInfoMapper.deleteByExample(sre5);
    	}
    	courseRangeInfoMapper.deleteByExample(cre5);//清掉该学期的所有排课信息
    	
//    	TermInfoExample te = new TermInfoExample();
//    	List<TermInfo> tl = termInfoMapper.selectByExample(te);//所有届
    	
    	RoomInfoExample re = new RoomInfoExample();
		List<RoomInfo> rl = roomInfoMapper.selectByExample(re);//所有教室	
    		CourseInfoExample ce = new CourseInfoExample();
    		CourseInfoExample.Criteria cc =ce.createCriteria();
    		cc.andTermIdEqualTo(termId);//这学期所有课程
//    		cc.andIsBxEqualTo(1);//只运行必修课
        	List<CourseInfo> cl = courseInfoMapper.selectByExample(ce);//所有课程
        	
        	
        	
        	//选择选修的课程
//        	CourseInfoExample ce = new CourseInfoExample();
//    		CourseInfoExample.Criteria cc =ce.createCriteria();
//    		cc.andTermIdEqualTo(termId);//这学期所有课程
//    		cc.andIsBxEqualTo(1);//只运行必修课
//        	List<CourseInfo> cl = courseInfoMapper.selectByExample(ce);
        	
        	List<Map<String,Object>> clist =new ArrayList<Map<String,Object>>();
        	for(CourseInfo c:cl){
        		Map<String,Object> map  = new HashMap<String,Object>();
        		map.put("course", c);
        		List<Integer> rids = new ArrayList<Integer>();//可上课教室
        		if(c.getRoomIds()!=null&&c.getRoomIds().equals("")==false){
        			String [] split = c.getRoomIds().split(",");
        			for(String str:split){
        				if(str.trim().equals("")==false){
        					rids.add(Integer.parseInt(str));
        				}
        			}
        		}
        		List<RoomInfo> rlist = new ArrayList<RoomInfo>();
        		if(rids.size()>0){
        			RoomInfoExample re2 = new RoomInfoExample();
        			RoomInfoExample.Criteria rc2 = re2.createCriteria();
        			rc2.andIdIn(rids);
        			rlist = roomInfoMapper.selectByExample(re2);
        		}
        		
        		map.put("rlist", rlist);//可上课的教室
        		
        		TeacherTimeInfoExample te3 = new TeacherTimeInfoExample();
        		TeacherTimeInfoExample.Criteria tc3 = te3.createCriteria();
        		tc3.andTeacherIdEqualTo(c.getTeacherId());
        		List<TeacherTimeInfo> tl3 = teacherTimeInfoMapper.selectByExample(te3);//该教师可上课时间
        		map.put("timeList", tl3);
        		clist.add(map);
 	
        	}
    		int totalWeekNum= t.getWeekNum();//这个学期总共有多少周
    		for(int i=1;i<=totalWeekNum;i++){//第几周
    			System.out.println();
    			for(int j=1;j<=7;j++){//星期几
    				for(int k=1;k<=5;k++){//第几节				
    					for(RoomInfo r:rl){			
    						List<Map<String,Object>> clist2 =new ArrayList<Map<String,Object>>();
        	    			//先遍历课程，寻找在该时间能上课的课程
        	    			for(Map<String,Object> map:clist){
        	    				CourseInfo course = (CourseInfo) map.get("course");
        	    				
        	    				int count =0;
        	    				
        	    				if(course.getIsBx()==1){//比修课需要拉上所有学生进行排课
        	    					StudentInfoExample se3 = new StudentInfoExample();
            	    	    		StudentInfoExample.Criteria sc3 =se3.createCriteria();
            	    	    		sc3.andTermIdEqualTo(t.getId());
            	    	    		sc3.andDirectIdEqualTo(course.getDirectId());
            	    	    		 count = (int) studentInfoMapper.countByExample(se3);//需要上这门课的学生总共有多少人       	
        	    				}
        	    				
        	    				if(course.getIsBx()==2){//选修课只选择有选课的学生
        	    					
        	    					XkLogExample xe = new XkLogExample();
        	    					XkLogExample.Criteria xc = xe.createCriteria();
        	    					xc.andCourseIdEqualTo(course.getId());
        	    					 count = (int) xkLogMapper.countByExample(xe);
        	    					
        	    				}
        	    				      		
        	    	    		int totalSeat = count*course.getCourseTimes();//需要的教室座位*课程次数
        	    	    		int rangeSeat=0;//已安排的座位次数
        	    				//查询该课程是否已安排完毕
        	    	    		CourseRangeInfoExample cre = new CourseRangeInfoExample();
        	    	    		CourseRangeInfoExample.Criteria crc = cre.createCriteria();
        	    	    		crc.andCourseIdEqualTo(course.getId());
        	    				List<CourseRangeInfo> crl = courseRangeInfoMapper.selectByExample(cre);
        	    				
        	    				for(CourseRangeInfo cr:crl){
        	    					StuRangeInfoExample sre = new  StuRangeInfoExample();
        	    					StuRangeInfoExample.Criteria src = sre.createCriteria();
        	    					src.andRangeIdEqualTo(cr.getId());
        	    					rangeSeat+=stuRangeInfoMapper.countByExample(sre);
        	    				}
        	    				
        	    				if(rangeSeat>=totalSeat){
        	    					continue;//已安排的课位已足够，不需要安排该课程了
        	    				}
        	    				
        	    				
        	    				List<RoomInfo> rlist = (List<RoomInfo>) map.get("rlist");
        	    				boolean roomIsCompete=false;//该教室是否可上
        	    				for(RoomInfo t2:rlist){
        	    					if(t2.getId().equals(r.getId())){
        	    						roomIsCompete=true;
        	    						break;
        	    					}
        	    				}
        	    				if(roomIsCompete==false){
        	    					continue;
        	    				}
        	    				
        	    				
        	    				List<TeacherTimeInfo> tlist = (List<TeacherTimeInfo>) map.get("timeList");
        	    				boolean timeIsCompete=false;//该课程的教师时间是否对得上
        	    				for(TeacherTimeInfo t2:tlist){
        	    					if(t2.getWeekDay()==j&&t2.getJs()==k){
        	    						timeIsCompete=true;
        	    						break;
        	    					}
        	    				}
        	    				if(timeIsCompete==false){
        	    					continue;
        	    				}

        	    				CourseRangeInfoExample cre3 = new CourseRangeInfoExample();
        	    	    		CourseRangeInfoExample.Criteria crc3 = cre3.createCriteria();
        	    	    		crc3.andJsEqualTo(k);
        	    	    		crc3.andWeekNoEqualTo(i);
        	    	    		crc3.andWeekDayEqualTo(j);//查询这个时间安排的所有课程
        	    				List<CourseRangeInfo> crl3 = courseRangeInfoMapper.selectByExample(cre3);
        	    				//查询这个时间该教师是否被调到其他课程了
        	    				boolean teacherHasCourse=false;
        	    				for(CourseRangeInfo cr3:crl3){
        	    					if(cr3.getTeacherId().equals(course.getTeacherId())){
        	    						teacherHasCourse=true;
        	    						break;
        	    					}
        	    				}
        	    				if(teacherHasCourse==true){
        	    					continue;//该时间该教师被安排到他自己的其他课程上，不能按照这个时间他的课程
        	    				}
        	    				
        	    				List<Integer> rangeIds = new ArrayList<Integer>();
        	    				for(CourseRangeInfo cr3:crl3){
        	    					rangeIds.add(cr3.getId());
        	    				}
        	    				
        	    				List<Integer> stuIds3 = new ArrayList<Integer>();//这个时间是否该学生被安排到了其他的课程了
        	    				if(rangeIds.size()>0){
        	    					StuRangeInfoExample sre = new StuRangeInfoExample();
        	    					StuRangeInfoExample.Criteria src = sre.createCriteria();
        	    					src.andRangeIdIn(rangeIds);
        	    					List<StuRangeInfo> srl = stuRangeInfoMapper.selectByExample(sre);
        	    					for(StuRangeInfo sr:srl){
        	    						stuIds3.add(sr.getStuId());	
        	    					}
        	    				}
        	    				
        	    				
        	    				
        	    				List<Integer> stuIds = new ArrayList<Integer>();
        	    				List<StudentInfo> sl4 = new ArrayList<StudentInfo>();
        	    				if(course.getIsBx()==2){
        	    					XkLogExample xe = new XkLogExample();
        	    					XkLogExample.Criteria xc = xe.createCriteria();
        	    					xc.andCourseIdEqualTo(course.getId());
        	    					List<XkLog> xl = xkLogMapper.selectByExample(xe);
        	    					List<Integer> sids = new ArrayList<Integer>();
        	    					for(XkLog x:xl){
        	    						sids.add(x.getStuId());
        	    					}
        	    					
        	    					StudentTimeInfoExample ste = new StudentTimeInfoExample();
            	    				StudentTimeInfoExample.Criteria stc = ste.createCriteria();
            	    				stc.andJsEqualTo(k);
            	    				stc.andWeekDayEqualTo(j);
            	    				if(sids.size()==0){
            	    					stc.andIdEqualTo(0);
            	    				}else{
            	    					stc.andStuIdIn(sids);
            	    				}
            	    				List<StudentTimeInfo> stl = studentTimeInfoMapper.selectByExample(ste);//查出这个时间有空的学生
            	    				for(StudentTimeInfo st:stl){
            	    					stuIds.add(st.getStuId());
            	    				}
            	    				
            	    				if(stuIds.size()>0){
            	    					StudentInfoExample se4 = new StudentInfoExample();
                	    	    		StudentInfoExample.Criteria sc4 =se4.createCriteria();
                	    	    		sc4.andTermIdEqualTo(t.getId());
                	    	    		sc4.andDirectIdEqualTo(course.getDirectId());
                	    	    		sc4.andIdIn(stuIds);//学生在该时间有空
                	    	    		if(stuIds3.size()>0){
                	    	    			sc4.andIdNotIn(stuIds3);//学生在该时间没分配其他课程
                	    	    		}
                	    	    		sl4 =  studentInfoMapper.selectByExample(se4);//查出这个方向，且这个时间点有空的学生
            	    				}
        	    					
        	    				}else{
        	    					StudentTimeInfoExample ste = new StudentTimeInfoExample();
            	    				StudentTimeInfoExample.Criteria stc = ste.createCriteria();
            	    				stc.andJsEqualTo(k);
            	    				stc.andWeekDayEqualTo(j);
            	    				List<StudentTimeInfo> stl = studentTimeInfoMapper.selectByExample(ste);//查出这个时间有空的学生
            	    				for(StudentTimeInfo st:stl){
            	    					stuIds.add(st.getStuId());
            	    				}
            	    				if(stuIds.size()>0){
            	    					StudentInfoExample se4 = new StudentInfoExample();
                	    	    		StudentInfoExample.Criteria sc4 =se4.createCriteria();
                	    	    		sc4.andTermIdEqualTo(t.getId());
                	    	    		sc4.andDirectIdEqualTo(course.getDirectId());
                	    	    		sc4.andIdIn(stuIds);//学生在该时间有空
                	    	    		if(stuIds3.size()>0){
                	    	    			sc4.andIdNotIn(stuIds3);//学生在该时间没分配其他课程
                	    	    		}
                	    	    		sl4 =  studentInfoMapper.selectByExample(se4);//查出这个方向，且这个时间点有空的学生
            	    				}
        	    				}
        	    			
        	    				    			
        	    				map.put("sl4", sl4);
        	    				
//        	    				map.put("restSeat", totalSeat-rangeSeat);//剩余需要安排的课位
        	    				clist2.add(map);
        	    				
        	    			}
        	    			
        	    			//寻找该课位最佳的（可容纳人数最多的）课程
        	    			searchCourse( clist2, r,i,k,j);
        	    		}
        	    	}
    	    	}
    		}

    }
    
    /**
     * 优先找数量符合容量最合适的课程
     */
    private void searchCourse(List<Map<String,Object>> clist,RoomInfo room,Integer weekNo,Integer js,Integer weekDay){
    	Map<String,Object> rs = null;
    		for(Map<String,Object> c:clist){
    			List<StudentInfo> sl4 = (List<StudentInfo>) c.get("sl4");
    			if(sl4.size()>0&&sl4.size()==room.getMaxNum()){//先找出数量一致的
    				rs = c;
    				break;
    			}
    		}
    		
    		if(rs==null){
    			for(Map<String,Object> c:clist){
        			CourseInfo course = (CourseInfo) c.get("course");
        			List<StudentInfo> sl4 = (List<StudentInfo>) c.get("sl4");
        			if(sl4.size()>0&&sl4.size()>room.getMaxNum()){//再找出学生数量大于教室人数的，尽可能地塞满最多人
        				rs = c;
        				break;
        			}
        		}
    		}
    		
    		if(rs==null){
    			int minNum=99999999;
    			Map<String,Object> tmp=null;
    			for(Map<String,Object> c:clist){
        			List<StudentInfo> sl4 = (List<StudentInfo>) c.get("sl4");
        			if(sl4.size()>0&&sl4.size()<room.getMaxNum()){//再找出学生数量小于教室人数的
        				int diff = room.getMaxNum()-sl4.size();
        				if(diff<minNum){
        					minNum = diff;
        					tmp = c;
        				}
        			}
        		}
    			
    			rs = tmp;//找到差距最小的课程
    		}
    		
    		
    		if(rs!=null){//找到该课程
    			CourseInfo course = (CourseInfo) rs.get("course");
    			List<StudentInfo> sl4 = (List<StudentInfo>) rs.get("sl4");
    			
    			CourseRangeInfo crange = new CourseRangeInfo();
				crange.setCourseId(course.getId());
				crange.setCourseName(course.getCourseName());
				crange.setDirectId(course.getDirectId());
				crange.setJs(js);
				crange.setMajorId(course.getMajorId());
				crange.setRoomId(room.getId());
				crange.setTeacherId(course.getTeacherId());
				crange.setTermId(course.getTermId());
				crange.setWeekDay(weekDay);
				crange.setWeekNo(weekNo);
				courseRangeInfoMapper.insertSelective(crange);
    			
    			if(sl4.size()<=room.getMaxNum()){//教室可以容纳全部人，则全部加进来
    				for(StudentInfo s:sl4){
    					StuRangeInfo sr = new StuRangeInfo();
    					sr.setClassId(s.getClassId());
    					sr.setRangeId(crange.getId());
    					sr.setStuId(s.getId());
    					sr.setCourseId(course.getId());
    					stuRangeInfoMapper.insertSelective(sr);
    				}
    			}else{//否则优先找上过该课程最少的学生
    				//先进行统计，统计这些学生上过该课程的次数
    				
    				List<Map<String,Object>> slist = new ArrayList<Map<String,Object>>();
    				for(StudentInfo s:sl4){
    					Map<String,Object> map = new HashMap<String,Object>();
    					map.put("stu", s);
    					StuRangeInfoExample sre2 = new StuRangeInfoExample();
    					StuRangeInfoExample.Criteria src2 = sre2.createCriteria();
    					src2.andStuIdEqualTo(s.getId());
    					src2.andCourseIdEqualTo(course.getId());
    					int count = (int) stuRangeInfoMapper.countByExample(sre2);//已经安排的次数
    					map.put("count", count);
    					slist.add(map);
    				}
    				
    				
    				 Collections.sort(slist, new Comparator<Map<String,Object>>() {
    				    @Override
    				    public int compare(Map<String,Object> u1, Map<String,Object> u2) {
    				    	int count1 = Integer.parseInt(u1.get("count").toString());
    				    	int count2 = Integer.parseInt(u2.get("count").toString());
    				      int diff = count1 -count2;
    				      if (diff > 0) {
    				        return 1;
    				      }else if (diff < 0) {
    				        return -1;
    				      }
    				      return 0; //相等为0
    				    }
    				  }); 
    				 
    				 slist = slist.subList(0, room.getMaxNum());//取前面的所有学生
    				 
    				 for(Map<String,Object> map:slist){
    					 StudentInfo s = (StudentInfo) map.get("stu");
    					 StuRangeInfo sr = new StuRangeInfo();
     					sr.setClassId(s.getClassId());
     					sr.setRangeId(crange.getId());
     					sr.setCourseId(course.getId());
     					sr.setStuId(s.getId());
     					stuRangeInfoMapper.insertSelective(sr);
    				 }
    				 
    			}
    		}
    }
    
}

