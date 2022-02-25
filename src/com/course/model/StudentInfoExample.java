package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class StudentInfoExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public StudentInfoExample() {
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
		public Criteria andStuNoIsNull() {
			addCriterion("stu_no is null");
			return (Criteria) this;
		}
		public Criteria andStuNoIsNotNull(){
			addCriterion("stu_no is not null");
			return (Criteria) this;
		}
		public Criteria andStuNoEqualTo(String value) {
			addCriterion("stu_no =", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotEqualTo(String value) {
			addCriterion("stu_no <>", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoGreaterThan(String value) {
			addCriterion("stu_no >", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoGreaterThanOrEqualTo(String value) {
			addCriterion("stu_no >=", value, "StuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLessThan(String value) {
			addCriterion("stu_no <", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLessThanOrEqualTo(String value) {
			addCriterion("stu_no <=", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoIn(List<String> values) {
			addCriterion("stu_no in", values, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotIn(List<String> values) {
			addCriterion("stu_no not in", values, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoBetween(String value1, String value2) {
			addCriterion("stu_no between", value1, value2, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotBetween(String value1, String value2) {
			addCriterion("stu_no not between", value1, value2, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLike(String value) {
			addCriterion("stu_no like", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotLike(String value) {
			addCriterion("stu_no not like", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}
		public Criteria andPasswordIsNotNull(){
			addCriterion("password is not null");
			return (Criteria) this;
		}
		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "Password");
			return (Criteria) this;
		}
		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}
		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNull() {
			addCriterion("real_name is null");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNotNull(){
			addCriterion("real_name is not null");
			return (Criteria) this;
		}
		public Criteria andRealNameEqualTo(String value) {
			addCriterion("real_name =", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotEqualTo(String value) {
			addCriterion("real_name <>", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThan(String value) {
			addCriterion("real_name >", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThanOrEqualTo(String value) {
			addCriterion("real_name >=", value, "RealName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThan(String value) {
			addCriterion("real_name <", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThanOrEqualTo(String value) {
			addCriterion("real_name <=", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameIn(List<String> values) {
			addCriterion("real_name in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotIn(List<String> values) {
			addCriterion("real_name not in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameBetween(String value1, String value2) {
			addCriterion("real_name between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotBetween(String value1, String value2) {
			addCriterion("real_name not between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLike(String value) {
			addCriterion("real_name like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotLike(String value) {
			addCriterion("real_name not like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andCelPhoneIsNull() {
			addCriterion("cel_phone is null");
			return (Criteria) this;
		}
		public Criteria andCelPhoneIsNotNull(){
			addCriterion("cel_phone is not null");
			return (Criteria) this;
		}
		public Criteria andCelPhoneEqualTo(String value) {
			addCriterion("cel_phone =", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneNotEqualTo(String value) {
			addCriterion("cel_phone <>", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneGreaterThan(String value) {
			addCriterion("cel_phone >", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("cel_phone >=", value, "CelPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneLessThan(String value) {
			addCriterion("cel_phone <", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneLessThanOrEqualTo(String value) {
			addCriterion("cel_phone <=", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneIn(List<String> values) {
			addCriterion("cel_phone in", values, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneNotIn(List<String> values) {
			addCriterion("cel_phone not in", values, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneBetween(String value1, String value2) {
			addCriterion("cel_phone between", value1, value2, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneNotBetween(String value1, String value2) {
			addCriterion("cel_phone not between", value1, value2, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneLike(String value) {
			addCriterion("cel_phone like", value, "celPhone");
			return (Criteria) this;
		}
		public Criteria andCelPhoneNotLike(String value) {
			addCriterion("cel_phone not like", value, "celPhone");
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
		public Criteria andEnterYearIsNull() {
			addCriterion("enter_year is null");
			return (Criteria) this;
		}
		public Criteria andEnterYearIsNotNull(){
			addCriterion("enter_year is not null");
			return (Criteria) this;
		}
		public Criteria andEnterYearEqualTo(Integer value) {
			addCriterion("enter_year =", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearNotEqualTo(Integer value) {
			addCriterion("enter_year <>", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearGreaterThan(Integer value) {
			addCriterion("enter_year >", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearGreaterThanOrEqualTo(Integer value) {
			addCriterion("enter_year >=", value, "EnterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearLessThan(Integer value) {
			addCriterion("enter_year <", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearLessThanOrEqualTo(Integer value) {
			addCriterion("enter_year <=", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearIn(List<Integer> values) {
			addCriterion("enter_year in", values, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearNotIn(List<Integer> values) {
			addCriterion("enter_year not in", values, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearBetween(Integer value1, Integer value2) {
			addCriterion("enter_year between", value1, value2, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearNotBetween(Integer value1, Integer value2) {
			addCriterion("enter_year not between", value1, value2, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearLike(Integer value) {
			addCriterion("enter_year like", value, "enterYear");
			return (Criteria) this;
		}
		public Criteria andEnterYearNotLike(Integer value) {
			addCriterion("enter_year not like", value, "enterYear");
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
		public Criteria andFamilyAddressIsNull() {
			addCriterion("family_address is null");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressIsNotNull(){
			addCriterion("family_address is not null");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressEqualTo(String value) {
			addCriterion("family_address =", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressNotEqualTo(String value) {
			addCriterion("family_address <>", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressGreaterThan(String value) {
			addCriterion("family_address >", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressGreaterThanOrEqualTo(String value) {
			addCriterion("family_address >=", value, "FamilyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressLessThan(String value) {
			addCriterion("family_address <", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressLessThanOrEqualTo(String value) {
			addCriterion("family_address <=", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressIn(List<String> values) {
			addCriterion("family_address in", values, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressNotIn(List<String> values) {
			addCriterion("family_address not in", values, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressBetween(String value1, String value2) {
			addCriterion("family_address between", value1, value2, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressNotBetween(String value1, String value2) {
			addCriterion("family_address not between", value1, value2, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressLike(String value) {
			addCriterion("family_address like", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andFamilyAddressNotLike(String value) {
			addCriterion("family_address not like", value, "familyAddress");
			return (Criteria) this;
		}
		public Criteria andParentCelIsNull() {
			addCriterion("parent_cel is null");
			return (Criteria) this;
		}
		public Criteria andParentCelIsNotNull(){
			addCriterion("parent_cel is not null");
			return (Criteria) this;
		}
		public Criteria andParentCelEqualTo(String value) {
			addCriterion("parent_cel =", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelNotEqualTo(String value) {
			addCriterion("parent_cel <>", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelGreaterThan(String value) {
			addCriterion("parent_cel >", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelGreaterThanOrEqualTo(String value) {
			addCriterion("parent_cel >=", value, "ParentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelLessThan(String value) {
			addCriterion("parent_cel <", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelLessThanOrEqualTo(String value) {
			addCriterion("parent_cel <=", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelIn(List<String> values) {
			addCriterion("parent_cel in", values, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelNotIn(List<String> values) {
			addCriterion("parent_cel not in", values, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelBetween(String value1, String value2) {
			addCriterion("parent_cel between", value1, value2, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelNotBetween(String value1, String value2) {
			addCriterion("parent_cel not between", value1, value2, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelLike(String value) {
			addCriterion("parent_cel like", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andParentCelNotLike(String value) {
			addCriterion("parent_cel not like", value, "parentCel");
			return (Criteria) this;
		}
		public Criteria andClassIdIsNull() {
			addCriterion("class_id is null");
			return (Criteria) this;
		}
		public Criteria andClassIdIsNotNull(){
			addCriterion("class_id is not null");
			return (Criteria) this;
		}
		public Criteria andClassIdEqualTo(Integer value) {
			addCriterion("class_id =", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotEqualTo(Integer value) {
			addCriterion("class_id <>", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdGreaterThan(Integer value) {
			addCriterion("class_id >", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("class_id >=", value, "ClassId");
			return (Criteria) this;
		}
		public Criteria andClassIdLessThan(Integer value) {
			addCriterion("class_id <", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("class_id <=", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdIn(List<Integer> values) {
			addCriterion("class_id in", values, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotIn(List<Integer> values) {
			addCriterion("class_id not in", values, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdBetween(Integer value1, Integer value2) {
			addCriterion("class_id between", value1, value2, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("class_id not between", value1, value2, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdLike(Integer value) {
			addCriterion("class_id like", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotLike(Integer value) {
			addCriterion("class_id not like", value, "classId");
			return (Criteria) this;
		}
		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}
		public Criteria andSexIsNotNull(){
			addCriterion("sex is not null");
			return (Criteria) this;
		}
		public Criteria andSexEqualTo(Integer value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotEqualTo(Integer value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexGreaterThan(Integer value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sex >=", value, "Sex");
			return (Criteria) this;
		}
		public Criteria andSexLessThan(Integer value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexLessThanOrEqualTo(Integer value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexIn(List<Integer> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotIn(List<Integer> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}
		public Criteria andSexBetween(Integer value1, Integer value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotBetween(Integer value1, Integer value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}
		public Criteria andSexLike(Integer value) {
			addCriterion("sex like", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotLike(Integer value) {
			addCriterion("sex not like", value, "sex");
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
