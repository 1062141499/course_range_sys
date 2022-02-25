package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class CourseInfoExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public CourseInfoExample() {
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
		public Criteria andRoomIdsIsNull() {
			addCriterion("room_ids is null");
			return (Criteria) this;
		}
		public Criteria andRoomIdsIsNotNull(){
			addCriterion("room_ids is not null");
			return (Criteria) this;
		}
		public Criteria andRoomIdsEqualTo(String value) {
			addCriterion("room_ids =", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsNotEqualTo(String value) {
			addCriterion("room_ids <>", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsGreaterThan(String value) {
			addCriterion("room_ids >", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsGreaterThanOrEqualTo(String value) {
			addCriterion("room_ids >=", value, "RoomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsLessThan(String value) {
			addCriterion("room_ids <", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsLessThanOrEqualTo(String value) {
			addCriterion("room_ids <=", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsIn(List<String> values) {
			addCriterion("room_ids in", values, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsNotIn(List<String> values) {
			addCriterion("room_ids not in", values, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsBetween(String value1, String value2) {
			addCriterion("room_ids between", value1, value2, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsNotBetween(String value1, String value2) {
			addCriterion("room_ids not between", value1, value2, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsLike(String value) {
			addCriterion("room_ids like", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andRoomIdsNotLike(String value) {
			addCriterion("room_ids not like", value, "roomIds");
			return (Criteria) this;
		}
		public Criteria andCourseTimesIsNull() {
			addCriterion("course_times is null");
			return (Criteria) this;
		}
		public Criteria andCourseTimesIsNotNull(){
			addCriterion("course_times is not null");
			return (Criteria) this;
		}
		public Criteria andCourseTimesEqualTo(Integer value) {
			addCriterion("course_times =", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesNotEqualTo(Integer value) {
			addCriterion("course_times <>", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesGreaterThan(Integer value) {
			addCriterion("course_times >", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesGreaterThanOrEqualTo(Integer value) {
			addCriterion("course_times >=", value, "CourseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesLessThan(Integer value) {
			addCriterion("course_times <", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesLessThanOrEqualTo(Integer value) {
			addCriterion("course_times <=", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesIn(List<Integer> values) {
			addCriterion("course_times in", values, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesNotIn(List<Integer> values) {
			addCriterion("course_times not in", values, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesBetween(Integer value1, Integer value2) {
			addCriterion("course_times between", value1, value2, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesNotBetween(Integer value1, Integer value2) {
			addCriterion("course_times not between", value1, value2, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesLike(Integer value) {
			addCriterion("course_times like", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andCourseTimesNotLike(Integer value) {
			addCriterion("course_times not like", value, "courseTimes");
			return (Criteria) this;
		}
		public Criteria andIsBxIsNull() {
			addCriterion("is_bx is null");
			return (Criteria) this;
		}
		public Criteria andIsBxIsNotNull(){
			addCriterion("is_bx is not null");
			return (Criteria) this;
		}
		public Criteria andIsBxEqualTo(Integer value) {
			addCriterion("is_bx =", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxNotEqualTo(Integer value) {
			addCriterion("is_bx <>", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxGreaterThan(Integer value) {
			addCriterion("is_bx >", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_bx >=", value, "IsBx");
			return (Criteria) this;
		}
		public Criteria andIsBxLessThan(Integer value) {
			addCriterion("is_bx <", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxLessThanOrEqualTo(Integer value) {
			addCriterion("is_bx <=", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxIn(List<Integer> values) {
			addCriterion("is_bx in", values, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxNotIn(List<Integer> values) {
			addCriterion("is_bx not in", values, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxBetween(Integer value1, Integer value2) {
			addCriterion("is_bx between", value1, value2, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxNotBetween(Integer value1, Integer value2) {
			addCriterion("is_bx not between", value1, value2, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxLike(Integer value) {
			addCriterion("is_bx like", value, "isBx");
			return (Criteria) this;
		}
		public Criteria andIsBxNotLike(Integer value) {
			addCriterion("is_bx not like", value, "isBx");
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
