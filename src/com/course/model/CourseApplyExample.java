package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class CourseApplyExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public CourseApplyExample() {
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
		public Criteria andReasonIsNull() {
			addCriterion("reason is null");
			return (Criteria) this;
		}
		public Criteria andReasonIsNotNull(){
			addCriterion("reason is not null");
			return (Criteria) this;
		}
		public Criteria andReasonEqualTo(String value) {
			addCriterion("reason =", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonNotEqualTo(String value) {
			addCriterion("reason <>", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonGreaterThan(String value) {
			addCriterion("reason >", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonGreaterThanOrEqualTo(String value) {
			addCriterion("reason >=", value, "Reason");
			return (Criteria) this;
		}
		public Criteria andReasonLessThan(String value) {
			addCriterion("reason <", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonLessThanOrEqualTo(String value) {
			addCriterion("reason <=", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonIn(List<String> values) {
			addCriterion("reason in", values, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonNotIn(List<String> values) {
			addCriterion("reason not in", values, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonBetween(String value1, String value2) {
			addCriterion("reason between", value1, value2, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonNotBetween(String value1, String value2) {
			addCriterion("reason not between", value1, value2, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonLike(String value) {
			addCriterion("reason like", value, "reason");
			return (Criteria) this;
		}
		public Criteria andReasonNotLike(String value) {
			addCriterion("reason not like", value, "reason");
			return (Criteria) this;
		}
		public Criteria andApplyStatusIsNull() {
			addCriterion("apply_status is null");
			return (Criteria) this;
		}
		public Criteria andApplyStatusIsNotNull(){
			addCriterion("apply_status is not null");
			return (Criteria) this;
		}
		public Criteria andApplyStatusEqualTo(Integer value) {
			addCriterion("apply_status =", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusNotEqualTo(Integer value) {
			addCriterion("apply_status <>", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusGreaterThan(Integer value) {
			addCriterion("apply_status >", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("apply_status >=", value, "ApplyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusLessThan(Integer value) {
			addCriterion("apply_status <", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("apply_status <=", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusIn(List<Integer> values) {
			addCriterion("apply_status in", values, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusNotIn(List<Integer> values) {
			addCriterion("apply_status not in", values, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusBetween(Integer value1, Integer value2) {
			addCriterion("apply_status between", value1, value2, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("apply_status not between", value1, value2, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusLike(Integer value) {
			addCriterion("apply_status like", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andApplyStatusNotLike(Integer value) {
			addCriterion("apply_status not like", value, "applyStatus");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIsNull() {
			addCriterion("check_remark is null");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIsNotNull(){
			addCriterion("check_remark is not null");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkEqualTo(String value) {
			addCriterion("check_remark =", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotEqualTo(String value) {
			addCriterion("check_remark <>", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkGreaterThan(String value) {
			addCriterion("check_remark >", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("check_remark >=", value, "CheckRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLessThan(String value) {
			addCriterion("check_remark <", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLessThanOrEqualTo(String value) {
			addCriterion("check_remark <=", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIn(List<String> values) {
			addCriterion("check_remark in", values, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotIn(List<String> values) {
			addCriterion("check_remark not in", values, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkBetween(String value1, String value2) {
			addCriterion("check_remark between", value1, value2, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotBetween(String value1, String value2) {
			addCriterion("check_remark not between", value1, value2, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLike(String value) {
			addCriterion("check_remark like", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotLike(String value) {
			addCriterion("check_remark not like", value, "checkRemark");
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
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
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
