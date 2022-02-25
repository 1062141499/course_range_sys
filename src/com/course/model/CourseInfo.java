package com.course.model;
public class CourseInfo {
	private Integer id;//ID
	private String courseName;//课程名
	private Integer majorId;//专业
	private Integer directId;//专业方向
	private Integer termId;//学期
	private String roomIds;//可上课教室
	private Integer courseTimes;//上课次数
	private Integer isBx;//课程类型
	private Integer teacherId;//负责教师
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getCourseName(){
		return courseName;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName == null ? null : courseName.trim();
	}
	public Integer getMajorId(){
		return majorId;
	}
	public void setMajorId(Integer majorId){
		this.majorId = majorId;
	}
	public Integer getDirectId(){
		return directId;
	}
	public void setDirectId(Integer directId){
		this.directId = directId;
	}
	public Integer getTermId(){
		return termId;
	}
	public void setTermId(Integer termId){
		this.termId = termId;
	}
	public String getRoomIds(){
		return roomIds;
	}
	public void setRoomIds(String roomIds){
		this.roomIds = roomIds == null ? null : roomIds.trim();
	}
	public Integer getCourseTimes(){
		return courseTimes;
	}
	public void setCourseTimes(Integer courseTimes){
		this.courseTimes = courseTimes;
	}
	public Integer getIsBx(){
		return isBx;
	}
	public void setIsBx(Integer isBx){
		this.isBx = isBx;
	}
	public Integer getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(Integer teacherId){
		this.teacherId = teacherId;
	}
}
