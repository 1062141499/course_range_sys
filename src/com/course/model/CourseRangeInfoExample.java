package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class CourseRangeInfoExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public CourseRangeInfoExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andTeacherIdIsNull() {
			addCriterion("teacher_id is null");
			return (Criteria) this;
		}
		public Criteria andTeacherIdIsNotNull(){
			addCriterion("teacher_id is not null");
			return (Criteria) this;
		}
		public Criteria andTeacherIdEqualTo(Integer value) {
			addCriterion("teacher_id =", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotEqualTo(Integer value) {
			addCriterion("teacher_id <>", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdGreaterThan(Integer value) {
			addCriterion("teacher_id >", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("teacher_id >=", value, "TeacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLessThan(Integer value) {
			addCriterion("teacher_id <", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
			addCriterion("teacher_id <=", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdIn(List<Integer> values) {
			addCriterion("teacher_id in", values, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotIn(List<Integer> values) {
			addCriterion("teacher_id not in", values, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
			addCriterion("teacher_id between", value1, value2, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
			addCriterion("teacher_id not between", value1, value2, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLike(Integer value) {
			addCriterion("teacher_id like", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotLike(Integer value) {
			addCriterion("teacher_id not like", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andCourseIdIsNull() {
			addCriterion("course_id is null");
			return (Criteria) this;
		}
		public Criteria andCourseIdIsNotNull(){
			addCriterion("course_id is not null");
			return (Criteria) this;
		}
		public Criteria andCourseIdEqualTo(Integer value) {
			addCriterion("course_id =", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotEqualTo(Integer value) {
			addCriterion("course_id <>", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdGreaterThan(Integer value) {
			addCriterion("course_id >", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("course_id >=", value, "CourseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLessThan(Integer value) {
			addCriterion("course_id <", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
			addCriterion("course_id <=", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdIn(List<Integer> values) {
			addCriterion("course_id in", values, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotIn(List<Integer> values) {
			addCriterion("course_id not in", values, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdBetween(Integer value1, Integer value2) {
			addCriterion("course_id between", value1, value2, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("course_id not between", value1, value2, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLike(Integer value) {
			addCriterion("course_id like", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotLike(Integer value) {
			addCriterion("course_id not like", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseNameIsNull() {
			addCriterion("course_name is null");
			return (Criteria) this;
		}
		public Criteria andCourseNameIsNotNull(){
			addCriterion("course_name is not null");
			return (Criteria) this;
		}
		public Criteria andCourseNameEqualTo(String value) {
			addCriterion("course_name =", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameNotEqualTo(String value) {
			addCriterion("course_name <>", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameGreaterThan(String value) {
			addCriterion("course_name >", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
			addCriterion("course_name >=", value, "CourseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameLessThan(String value) {
			addCriterion("course_name <", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameLessThanOrEqualTo(String value) {
			addCriterion("course_name <=", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameIn(List<String> values) {
			addCriterion("course_name in", values, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameNotIn(List<String> values) {
			addCriterion("course_name not in", values, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameBetween(String value1, String value2) {
			addCriterion("course_name between", value1, value2, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameNotBetween(String value1, String value2) {
			addCriterion("course_name not between", value1, value2, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameLike(String value) {
			addCriterion("course_name like", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andCourseNameNotLike(String value) {
			addCriterion("course_name not like", value, "courseName");
			return (Criteria) this;
		}
		public Criteria andMajorIdIsNull() {
			addCriterion("major_id is null");
			return (Criteria) this;
		}
		public Criteria andMajorIdIsNotNull(){
			addCriterion("major_id is not null");
			return (Criteria) this;
		}
		public Criteria andMajorIdEqualTo(Integer value) {
			addCriterion("major_id =", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdNotEqualTo(Integer value) {
			addCriterion("major_id <>", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdGreaterThan(Integer value) {
			addCriterion("major_id >", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("major_id >=", value, "MajorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdLessThan(Integer value) {
			addCriterion("major_id <", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdLessThanOrEqualTo(Integer value) {
			addCriterion("major_id <=", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdIn(List<Integer> values) {
			addCriterion("major_id in", values, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdNotIn(List<Integer> values) {
			addCriterion("major_id not in", values, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdBetween(Integer value1, Integer value2) {
			addCriterion("major_id between", value1, value2, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdNotBetween(Integer value1, Integer value2) {
			addCriterion("major_id not between", value1, value2, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdLike(Integer value) {
			addCriterion("major_id like", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andMajorIdNotLike(Integer value) {
			addCriterion("major_id not like", value, "majorId");
			return (Criteria) this;
		}
		public Criteria andDirectIdIsNull() {
			addCriterion("direct_id is null");
			return (Criteria) this;
		}
		public Criteria andDirectIdIsNotNull(){
			addCriterion("direct_id is not null");
			return (Criteria) this;
		}
		public Criteria andDirectIdEqualTo(Integer value) {
			addCriterion("direct_id =", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdNotEqualTo(Integer value) {
			addCriterion("direct_id <>", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdGreaterThan(Integer value) {
			addCriterion("direct_id >", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("direct_id >=", value, "DirectId");
			return (Criteria) this;
		}
		public Criteria andDirectIdLessThan(Integer value) {
			addCriterion("direct_id <", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdLessThanOrEqualTo(Integer value) {
			addCriterion("direct_id <=", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdIn(List<Integer> values) {
			addCriterion("direct_id in", values, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdNotIn(List<Integer> values) {
			addCriterion("direct_id not in", values, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdBetween(Integer value1, Integer value2) {
			addCriterion("direct_id between", value1, value2, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdNotBetween(Integer value1, Integer value2) {
			addCriterion("direct_id not between", value1, value2, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdLike(Integer value) {
			addCriterion("direct_id like", value, "directId");
			return (Criteria) this;
		}
		public Criteria andDirectIdNotLike(Integer value) {
			addCriterion("direct_id not like", value, "directId");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNull() {
			addCriterion("room_id is null");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNotNull(){
			addCriterion("room_id is not null");
			return (Criteria) this;
		}
		public Criteria andRoomIdEqualTo(Integer value) {
			addCriterion("room_id =", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotEqualTo(Integer value) {
			addCriterion("room_id <>", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThan(Integer value) {
			addCriterion("room_id >", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("room_id >=", value, "RoomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThan(Integer value) {
			addCriterion("room_id <", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
			addCriterion("room_id <=", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdIn(List<Integer> values) {
			addCriterion("room_id in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotIn(List<Integer> values) {
			addCriterion("room_id not in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdBetween(Integer value1, Integer value2) {
			addCriterion("room_id between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
			addCriterion("room_id not between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLike(Integer value) {
			addCriterion("room_id like", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotLike(Integer value) {
			addCriterion("room_id not like", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andWeekNoIsNull() {
			addCriterion("week_no is null");
			return (Criteria) this;
		}
		public Criteria andWeekNoIsNotNull(){
			addCriterion("week_no is not null");
			return (Criteria) this;
		}
		public Criteria andWeekNoEqualTo(Integer value) {
			addCriterion("week_no =", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoNotEqualTo(Integer value) {
			addCriterion("week_no <>", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoGreaterThan(Integer value) {
			addCriterion("week_no >", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_no >=", value, "WeekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoLessThan(Integer value) {
			addCriterion("week_no <", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoLessThanOrEqualTo(Integer value) {
			addCriterion("week_no <=", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoIn(List<Integer> values) {
			addCriterion("week_no in", values, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoNotIn(List<Integer> values) {
			addCriterion("week_no not in", values, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoBetween(Integer value1, Integer value2) {
			addCriterion("week_no between", value1, value2, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoNotBetween(Integer value1, Integer value2) {
			addCriterion("week_no not between", value1, value2, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoLike(Integer value) {
			addCriterion("week_no like", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekNoNotLike(Integer value) {
			addCriterion("week_no not like", value, "weekNo");
			return (Criteria) this;
		}
		public Criteria andWeekDayIsNull() {
			addCriterion("week_day is null");
			return (Criteria) this;
		}
		public Criteria andWeekDayIsNotNull(){
			addCriterion("week_day is not null");
			return (Criteria) this;
		}
		public Criteria andWeekDayEqualTo(Integer value) {
			addCriterion("week_day =", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayNotEqualTo(Integer value) {
			addCriterion("week_day <>", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayGreaterThan(Integer value) {
			addCriterion("week_day >", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_day >=", value, "WeekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayLessThan(Integer value) {
			addCriterion("week_day <", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayLessThanOrEqualTo(Integer value) {
			addCriterion("week_day <=", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayIn(List<Integer> values) {
			addCriterion("week_day in", values, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayNotIn(List<Integer> values) {
			addCriterion("week_day not in", values, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayBetween(Integer value1, Integer value2) {
			addCriterion("week_day between", value1, value2, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayNotBetween(Integer value1, Integer value2) {
			addCriterion("week_day not between", value1, value2, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayLike(Integer value) {
			addCriterion("week_day like", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andWeekDayNotLike(Integer value) {
			addCriterion("week_day not like", value, "weekDay");
			return (Criteria) this;
		}
		public Criteria andJsIsNull() {
			addCriterion("js is null");
			return (Criteria) this;
		}
		public Criteria andJsIsNotNull(){
			addCriterion("js is not null");
			return (Criteria) this;
		}
		public Criteria andJsEqualTo(Integer value) {
			addCriterion("js =", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsNotEqualTo(Integer value) {
			addCriterion("js <>", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsGreaterThan(Integer value) {
			addCriterion("js >", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsGreaterThanOrEqualTo(Integer value) {
			addCriterion("js >=", value, "Js");
			return (Criteria) this;
		}
		public Criteria andJsLessThan(Integer value) {
			addCriterion("js <", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsLessThanOrEqualTo(Integer value) {
			addCriterion("js <=", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsIn(List<Integer> values) {
			addCriterion("js in", values, "js");
			return (Criteria) this;
		}
		public Criteria andJsNotIn(List<Integer> values) {
			addCriterion("js not in", values, "js");
			return (Criteria) this;
		}
		public Criteria andJsBetween(Integer value1, Integer value2) {
			addCriterion("js between", value1, value2, "js");
			return (Criteria) this;
		}
		public Criteria andJsNotBetween(Integer value1, Integer value2) {
			addCriterion("js not between", value1, value2, "js");
			return (Criteria) this;
		}
		public Criteria andJsLike(Integer value) {
			addCriterion("js like", value, "js");
			return (Criteria) this;
		}
		public Criteria andJsNotLike(Integer value) {
			addCriterion("js not like", value, "js");
			return (Criteria) this;
		}
		public Criteria andTermIdIsNull() {
			addCriterion("term_id is null");
			return (Criteria) this;
		}
		public Criteria andTermIdIsNotNull(){
			addCriterion("term_id is not null");
			return (Criteria) this;
		}
		public Criteria andTermIdEqualTo(Integer value) {
			addCriterion("term_id =", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdNotEqualTo(Integer value) {
			addCriterion("term_id <>", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdGreaterThan(Integer value) {
			addCriterion("term_id >", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("term_id >=", value, "TermId");
			return (Criteria) this;
		}
		public Criteria andTermIdLessThan(Integer value) {
			addCriterion("term_id <", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdLessThanOrEqualTo(Integer value) {
			addCriterion("term_id <=", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdIn(List<Integer> values) {
			addCriterion("term_id in", values, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdNotIn(List<Integer> values) {
			addCriterion("term_id not in", values, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdBetween(Integer value1, Integer value2) {
			addCriterion("term_id between", value1, value2, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdNotBetween(Integer value1, Integer value2) {
			addCriterion("term_id not between", value1, value2, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdLike(Integer value) {
			addCriterion("term_id like", value, "termId");
			return (Criteria) this;
		}
		public Criteria andTermIdNotLike(Integer value) {
			addCriterion("term_id not like", value, "termId");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
