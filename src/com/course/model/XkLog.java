package com.course.model;
public class XkLog {
	private Integer id;//ID
	private Integer courseId;//课程
	private Integer stuId;//选课学生
	private String createTime;//选课时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getCourseId(){
		return courseId;
	}
	public void setCourseId(Integer courseId){
		this.courseId = courseId;
	}
	public Integer getStuId(){
		return stuId;
	}
	public void setStuId(Integer stuId){
		this.stuId = stuId;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
