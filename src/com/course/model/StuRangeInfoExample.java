package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class StuRangeInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public StuRangeInfoExample() {
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
 public Criteria andRangeIdIsNull() {
		 addCriterion("range_id is null");
		return (Criteria) this;
		}
  public Criteria andRangeIdIsNotNull(){
		addCriterion("range_id is not null");
		return (Criteria) this;
		}
  public Criteria andRangeIdEqualTo(Integer value) {
		  addCriterion("range_id =", value, "rangeId");
		return (Criteria) this;
		}
   public Criteria andRangeIdNotEqualTo(Integer value) {
		  addCriterion("range_id <>", value, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdGreaterThan(Integer value) {
		 addCriterion("range_id >", value, "rangeId");
		return (Criteria) this;
		}
  public Criteria andRangeIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("range_id >=", value, "RangeId");
		return (Criteria) this;
		}
   public Criteria andRangeIdLessThan(Integer value) {
		  addCriterion("range_id <", value, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdLessThanOrEqualTo(Integer value) {
		  addCriterion("range_id <=", value, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdIn(List<Integer> values) {
		  addCriterion("range_id in", values, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdNotIn(List<Integer> values) {
		  addCriterion("range_id not in", values, "rangeId");
		return (Criteria) this;
		}
     public Criteria andRangeIdBetween(Integer value1, Integer value2) {
		   addCriterion("range_id between", value1, value2, "rangeId");
		return (Criteria) this;
		}
     public Criteria andRangeIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("range_id not between", value1, value2, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdLike(Integer value) {
		  addCriterion("range_id like", value, "rangeId");
		return (Criteria) this;
		}
    public Criteria andRangeIdNotLike(Integer value) {
		  addCriterion("range_id not like", value, "rangeId");
		return (Criteria) this;
		}
 public Criteria andStuIdIsNull() {
		 addCriterion("stu_id is null");
		return (Criteria) this;
		}
  public Criteria andStuIdIsNotNull(){
		addCriterion("stu_id is not null");
		return (Criteria) this;
		}
  public Criteria andStuIdEqualTo(Integer value) {
		  addCriterion("stu_id =", value, "stuId");
		return (Criteria) this;
		}
   public Criteria andStuIdNotEqualTo(Integer value) {
		  addCriterion("stu_id <>", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdGreaterThan(Integer value) {
		 addCriterion("stu_id >", value, "stuId");
		return (Criteria) this;
		}
  public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
		  addCriterion("stu_id >=", value, "StuId");
		return (Criteria) this;
		}
   public Criteria andStuIdLessThan(Integer value) {
		  addCriterion("stu_id <", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdLessThanOrEqualTo(Integer value) {
		  addCriterion("stu_id <=", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdIn(List<Integer> values) {
		  addCriterion("stu_id in", values, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdNotIn(List<Integer> values) {
		  addCriterion("stu_id not in", values, "stuId");
		return (Criteria) this;
		}
     public Criteria andStuIdBetween(Integer value1, Integer value2) {
		   addCriterion("stu_id between", value1, value2, "stuId");
		return (Criteria) this;
		}
     public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
		   addCriterion("stu_id not between", value1, value2, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdLike(Integer value) {
		  addCriterion("stu_id like", value, "stuId");
		return (Criteria) this;
		}
    public Criteria andStuIdNotLike(Integer value) {
		  addCriterion("stu_id not like", value, "stuId");
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
