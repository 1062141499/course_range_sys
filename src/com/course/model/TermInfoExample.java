package com.course.model;
import java.util.ArrayList;
import java.util.List;
public class TermInfoExample {
    protected String orderByClause;
    protected boolean distinct;
    protected int startRow;
    protected int pageRows;
    protected List<Criteria> oredCriteria;
    public TermInfoExample() {
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
 public Criteria andTermNameIsNull() {
		 addCriterion("term_name is null");
		return (Criteria) this;
		}
  public Criteria andTermNameIsNotNull(){
		addCriterion("term_name is not null");
		return (Criteria) this;
		}
  public Criteria andTermNameEqualTo(String value) {
		  addCriterion("term_name =", value, "termName");
		return (Criteria) this;
		}
   public Criteria andTermNameNotEqualTo(String value) {
		  addCriterion("term_name <>", value, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameGreaterThan(String value) {
		 addCriterion("term_name >", value, "termName");
		return (Criteria) this;
		}
  public Criteria andTermNameGreaterThanOrEqualTo(String value) {
		  addCriterion("term_name >=", value, "TermName");
		return (Criteria) this;
		}
   public Criteria andTermNameLessThan(String value) {
		  addCriterion("term_name <", value, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameLessThanOrEqualTo(String value) {
		  addCriterion("term_name <=", value, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameIn(List<String> values) {
		  addCriterion("term_name in", values, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameNotIn(List<String> values) {
		  addCriterion("term_name not in", values, "termName");
		return (Criteria) this;
		}
     public Criteria andTermNameBetween(String value1, String value2) {
		   addCriterion("term_name between", value1, value2, "termName");
		return (Criteria) this;
		}
     public Criteria andTermNameNotBetween(String value1, String value2) {
		   addCriterion("term_name not between", value1, value2, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameLike(String value) {
		  addCriterion("term_name like", value, "termName");
		return (Criteria) this;
		}
    public Criteria andTermNameNotLike(String value) {
		  addCriterion("term_name not like", value, "termName");
		return (Criteria) this;
		}
 public Criteria andTermIntroIsNull() {
		 addCriterion("term_intro is null");
		return (Criteria) this;
		}
  public Criteria andTermIntroIsNotNull(){
		addCriterion("term_intro is not null");
		return (Criteria) this;
		}
  public Criteria andTermIntroEqualTo(String value) {
		  addCriterion("term_intro =", value, "termIntro");
		return (Criteria) this;
		}
   public Criteria andTermIntroNotEqualTo(String value) {
		  addCriterion("term_intro <>", value, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroGreaterThan(String value) {
		 addCriterion("term_intro >", value, "termIntro");
		return (Criteria) this;
		}
  public Criteria andTermIntroGreaterThanOrEqualTo(String value) {
		  addCriterion("term_intro >=", value, "TermIntro");
		return (Criteria) this;
		}
   public Criteria andTermIntroLessThan(String value) {
		  addCriterion("term_intro <", value, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroLessThanOrEqualTo(String value) {
		  addCriterion("term_intro <=", value, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroIn(List<String> values) {
		  addCriterion("term_intro in", values, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroNotIn(List<String> values) {
		  addCriterion("term_intro not in", values, "termIntro");
		return (Criteria) this;
		}
     public Criteria andTermIntroBetween(String value1, String value2) {
		   addCriterion("term_intro between", value1, value2, "termIntro");
		return (Criteria) this;
		}
     public Criteria andTermIntroNotBetween(String value1, String value2) {
		   addCriterion("term_intro not between", value1, value2, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroLike(String value) {
		  addCriterion("term_intro like", value, "termIntro");
		return (Criteria) this;
		}
    public Criteria andTermIntroNotLike(String value) {
		  addCriterion("term_intro not like", value, "termIntro");
		return (Criteria) this;
		}
 public Criteria andEndTimeIsNull() {
		 addCriterion("end_time is null");
		return (Criteria) this;
		}
  public Criteria andEndTimeIsNotNull(){
		addCriterion("end_time is not null");
		return (Criteria) this;
		}
  public Criteria andEndTimeEqualTo(String value) {
		  addCriterion("end_time =", value, "endTime");
		return (Criteria) this;
		}
   public Criteria andEndTimeNotEqualTo(String value) {
		  addCriterion("end_time <>", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeGreaterThan(String value) {
		 addCriterion("end_time >", value, "endTime");
		return (Criteria) this;
		}
  public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
		  addCriterion("end_time >=", value, "EndTime");
		return (Criteria) this;
		}
   public Criteria andEndTimeLessThan(String value) {
		  addCriterion("end_time <", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeLessThanOrEqualTo(String value) {
		  addCriterion("end_time <=", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeIn(List<String> values) {
		  addCriterion("end_time in", values, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeNotIn(List<String> values) {
		  addCriterion("end_time not in", values, "endTime");
		return (Criteria) this;
		}
     public Criteria andEndTimeBetween(String value1, String value2) {
		   addCriterion("end_time between", value1, value2, "endTime");
		return (Criteria) this;
		}
     public Criteria andEndTimeNotBetween(String value1, String value2) {
		   addCriterion("end_time not between", value1, value2, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeLike(String value) {
		  addCriterion("end_time like", value, "endTime");
		return (Criteria) this;
		}
    public Criteria andEndTimeNotLike(String value) {
		  addCriterion("end_time not like", value, "endTime");
		return (Criteria) this;
		}
 public Criteria andWeekNumIsNull() {
		 addCriterion("week_num is null");
		return (Criteria) this;
		}
  public Criteria andWeekNumIsNotNull(){
		addCriterion("week_num is not null");
		return (Criteria) this;
		}
  public Criteria andWeekNumEqualTo(Integer value) {
		  addCriterion("week_num =", value, "weekNum");
		return (Criteria) this;
		}
   public Criteria andWeekNumNotEqualTo(Integer value) {
		  addCriterion("week_num <>", value, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumGreaterThan(Integer value) {
		 addCriterion("week_num >", value, "weekNum");
		return (Criteria) this;
		}
  public Criteria andWeekNumGreaterThanOrEqualTo(Integer value) {
		  addCriterion("week_num >=", value, "WeekNum");
		return (Criteria) this;
		}
   public Criteria andWeekNumLessThan(Integer value) {
		  addCriterion("week_num <", value, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumLessThanOrEqualTo(Integer value) {
		  addCriterion("week_num <=", value, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumIn(List<Integer> values) {
		  addCriterion("week_num in", values, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumNotIn(List<Integer> values) {
		  addCriterion("week_num not in", values, "weekNum");
		return (Criteria) this;
		}
     public Criteria andWeekNumBetween(Integer value1, Integer value2) {
		   addCriterion("week_num between", value1, value2, "weekNum");
		return (Criteria) this;
		}
     public Criteria andWeekNumNotBetween(Integer value1, Integer value2) {
		   addCriterion("week_num not between", value1, value2, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumLike(Integer value) {
		  addCriterion("week_num like", value, "weekNum");
		return (Criteria) this;
		}
    public Criteria andWeekNumNotLike(Integer value) {
		  addCriterion("week_num not like", value, "weekNum");
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
 public Criteria andIsSettingIsNull() {
		 addCriterion("is_setting is null");
		return (Criteria) this;
		}
  public Criteria andIsSettingIsNotNull(){
		addCriterion("is_setting is not null");
		return (Criteria) this;
		}
  public Criteria andIsSettingEqualTo(Integer value) {
		  addCriterion("is_setting =", value, "isSetting");
		return (Criteria) this;
		}
   public Criteria andIsSettingNotEqualTo(Integer value) {
		  addCriterion("is_setting <>", value, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingGreaterThan(Integer value) {
		 addCriterion("is_setting >", value, "isSetting");
		return (Criteria) this;
		}
  public Criteria andIsSettingGreaterThanOrEqualTo(Integer value) {
		  addCriterion("is_setting >=", value, "IsSetting");
		return (Criteria) this;
		}
   public Criteria andIsSettingLessThan(Integer value) {
		  addCriterion("is_setting <", value, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingLessThanOrEqualTo(Integer value) {
		  addCriterion("is_setting <=", value, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingIn(List<Integer> values) {
		  addCriterion("is_setting in", values, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingNotIn(List<Integer> values) {
		  addCriterion("is_setting not in", values, "isSetting");
		return (Criteria) this;
		}
     public Criteria andIsSettingBetween(Integer value1, Integer value2) {
		   addCriterion("is_setting between", value1, value2, "isSetting");
		return (Criteria) this;
		}
     public Criteria andIsSettingNotBetween(Integer value1, Integer value2) {
		   addCriterion("is_setting not between", value1, value2, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingLike(Integer value) {
		  addCriterion("is_setting like", value, "isSetting");
		return (Criteria) this;
		}
    public Criteria andIsSettingNotLike(Integer value) {
		  addCriterion("is_setting not like", value, "isSetting");
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
