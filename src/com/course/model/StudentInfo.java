package com.course.model;
public class StudentInfo {
	private Integer id;//ID
	private String stuNo;//学号
	private String password;//密码
	private String realName;//姓名
	private String celPhone;//联系电话
	private Integer majorId;//所属学科
	private Integer directId;//方向
	private Integer enterYear;//入学年份
	private Integer termId;//学期id
	private String createTime;//创建时间
	private String familyAddress;//家庭住址
	private String parentCel;//家长联系方式
	private Integer classId;//班级
	private Integer sex;//性别
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getStuNo(){
		return stuNo;
	}
	public void setStuNo(String stuNo){
		this.stuNo = stuNo == null ? null : stuNo.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelPhone(){
		return celPhone;
	}
	public void setCelPhone(String celPhone){
		this.celPhone = celPhone == null ? null : celPhone.trim();
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
	public Integer getEnterYear(){
		return enterYear;
	}
	public void setEnterYear(Integer enterYear){
		this.enterYear = enterYear;
	}
	public Integer getTermId(){
		return termId;
	}
	public void setTermId(Integer termId){
		this.termId = termId;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public String getFamilyAddress(){
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress){
		this.familyAddress = familyAddress == null ? null : familyAddress.trim();
	}
	public String getParentCel(){
		return parentCel;
	}
	public void setParentCel(String parentCel){
		this.parentCel = parentCel == null ? null : parentCel.trim();
	}
	public Integer getClassId(){
		return classId;
	}
	public void setClassId(Integer classId){
		this.classId = classId;
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
}
