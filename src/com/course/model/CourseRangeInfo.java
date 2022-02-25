package com.course.model;
public class CourseRangeInfo {
	private Integer id;//ID
	private Integer teacherId;//教师
	private Integer courseId;//课程ID
	private String courseName;//课程名
	private Integer majorId;//专业
	private Integer directId;//方向
	private Integer roomId;//教室
	private Integer weekNo;//第几周
	private Integer weekDay;//星期几
	private Integer js;//第几节
	private Integer termId;//学期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(Integer teacherId){
		this.teacherId = teacherId;
	}
	public Integer getCourseId(){
		return courseId;
	}
	public void setCourseId(Integer courseId){
		this.courseId = courseId;
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
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
	public Integer getWeekNo(){
		return weekNo;
	}
	public void setWeekNo(Integer weekNo){
		this.weekNo = weekNo;
	}
	public Integer getWeekDay(){
		return weekDay;
	}
	public void setWeekDay(Integer weekDay){
		this.weekDay = weekDay;
	}
	public Integer getJs(){
		return js;
	}
	public void setJs(Integer js){
		this.js = js;
	}
	public Integer getTermId(){
		return termId;
	}
	public void setTermId(Integer termId){
		this.termId = termId;
	}
}
