package com.shopmanager.model;

import java.util.ArrayList;
import java.util.List;

public class TransporterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransporterExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andTrerIdIsNull() {
            addCriterion("trer_id is null");
            return (Criteria) this;
        }

        public Criteria andTrerIdIsNotNull() {
            addCriterion("trer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrerIdEqualTo(Integer value) {
            addCriterion("trer_id =", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdNotEqualTo(Integer value) {
            addCriterion("trer_id <>", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdGreaterThan(Integer value) {
            addCriterion("trer_id >", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trer_id >=", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdLessThan(Integer value) {
            addCriterion("trer_id <", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdLessThanOrEqualTo(Integer value) {
            addCriterion("trer_id <=", value, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdIn(List<Integer> values) {
            addCriterion("trer_id in", values, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdNotIn(List<Integer> values) {
            addCriterion("trer_id not in", values, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdBetween(Integer value1, Integer value2) {
            addCriterion("trer_id between", value1, value2, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trer_id not between", value1, value2, "trerId");
            return (Criteria) this;
        }

        public Criteria andTrerNameIsNull() {
            addCriterion("trer_name is null");
            return (Criteria) this;
        }

        public Criteria andTrerNameIsNotNull() {
            addCriterion("trer_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrerNameEqualTo(String value) {
            addCriterion("trer_name =", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameNotEqualTo(String value) {
            addCriterion("trer_name <>", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameGreaterThan(String value) {
            addCriterion("trer_name >", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameGreaterThanOrEqualTo(String value) {
            addCriterion("trer_name >=", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameLessThan(String value) {
            addCriterion("trer_name <", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameLessThanOrEqualTo(String value) {
            addCriterion("trer_name <=", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameLike(String value) {
            addCriterion("trer_name like", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameNotLike(String value) {
            addCriterion("trer_name not like", value, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameIn(List<String> values) {
            addCriterion("trer_name in", values, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameNotIn(List<String> values) {
            addCriterion("trer_name not in", values, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameBetween(String value1, String value2) {
            addCriterion("trer_name between", value1, value2, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerNameNotBetween(String value1, String value2) {
            addCriterion("trer_name not between", value1, value2, "trerName");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordIsNull() {
            addCriterion("trer_password is null");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordIsNotNull() {
            addCriterion("trer_password is not null");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordEqualTo(String value) {
            addCriterion("trer_password =", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordNotEqualTo(String value) {
            addCriterion("trer_password <>", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordGreaterThan(String value) {
            addCriterion("trer_password >", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("trer_password >=", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordLessThan(String value) {
            addCriterion("trer_password <", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordLessThanOrEqualTo(String value) {
            addCriterion("trer_password <=", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordLike(String value) {
            addCriterion("trer_password like", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordNotLike(String value) {
            addCriterion("trer_password not like", value, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordIn(List<String> values) {
            addCriterion("trer_password in", values, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordNotIn(List<String> values) {
            addCriterion("trer_password not in", values, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordBetween(String value1, String value2) {
            addCriterion("trer_password between", value1, value2, "trerPassword");
            return (Criteria) this;
        }

        public Criteria andTrerPasswordNotBetween(String value1, String value2) {
            addCriterion("trer_password not between", value1, value2, "trerPassword");
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