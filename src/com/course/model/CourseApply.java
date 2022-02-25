package com.course.model;
public class CourseApply {
	private Integer id;//ID
	private String courseName;//课程名
	private String reason;//调停原因
	private Integer applyStatus;//申请状态
	private String checkRemark;//管理员备注
	private Integer teacherId;//申请教师
	private String createTime;//申请时间
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
	public String getReason(){
		return reason;
	}
	public void setReason(String reason){
		this.reason = reason == null ? null : reason.trim();
	}
	public Integer getApplyStatus(){
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus){
		this.applyStatus = applyStatus;
	}
	public String getCheckRemark(){
		return checkRemark;
	}
	public void setCheckRemark(String checkRemark){
		this.checkRemark = checkRemark == null ? null : checkRemark.trim();
	}
	public Integer getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(Integer teacherId){
		this.teacherId = teacherId;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
