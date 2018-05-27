package com.shopmanager.model;

import java.util.ArrayList;
import java.util.List;

public class ManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerExample() {
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

        public Criteria andManaIdIsNull() {
            addCriterion("mana_id is null");
            return (Criteria) this;
        }

        public Criteria andManaIdIsNotNull() {
            addCriterion("mana_id is not null");
            return (Criteria) this;
        }

        public Criteria andManaIdEqualTo(Integer value) {
            addCriterion("mana_id =", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdNotEqualTo(Integer value) {
            addCriterion("mana_id <>", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdGreaterThan(Integer value) {
            addCriterion("mana_id >", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mana_id >=", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdLessThan(Integer value) {
            addCriterion("mana_id <", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdLessThanOrEqualTo(Integer value) {
            addCriterion("mana_id <=", value, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdIn(List<Integer> values) {
            addCriterion("mana_id in", values, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdNotIn(List<Integer> values) {
            addCriterion("mana_id not in", values, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdBetween(Integer value1, Integer value2) {
            addCriterion("mana_id between", value1, value2, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mana_id not between", value1, value2, "manaId");
            return (Criteria) this;
        }

        public Criteria andManaNameIsNull() {
            addCriterion("mana_name is null");
            return (Criteria) this;
        }

        public Criteria andManaNameIsNotNull() {
            addCriterion("mana_name is not null");
            return (Criteria) this;
        }

        public Criteria andManaNameEqualTo(String value) {
            addCriterion("mana_name =", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameNotEqualTo(String value) {
            addCriterion("mana_name <>", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameGreaterThan(String value) {
            addCriterion("mana_name >", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameGreaterThanOrEqualTo(String value) {
            addCriterion("mana_name >=", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameLessThan(String value) {
            addCriterion("mana_name <", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameLessThanOrEqualTo(String value) {
            addCriterion("mana_name <=", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameLike(String value) {
            addCriterion("mana_name like", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameNotLike(String value) {
            addCriterion("mana_name not like", value, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameIn(List<String> values) {
            addCriterion("mana_name in", values, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameNotIn(List<String> values) {
            addCriterion("mana_name not in", values, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameBetween(String value1, String value2) {
            addCriterion("mana_name between", value1, value2, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaNameNotBetween(String value1, String value2) {
            addCriterion("mana_name not between", value1, value2, "manaName");
            return (Criteria) this;
        }

        public Criteria andManaPasswordIsNull() {
            addCriterion("mana_password is null");
            return (Criteria) this;
        }

        public Criteria andManaPasswordIsNotNull() {
            addCriterion("mana_password is not null");
            return (Criteria) this;
        }

        public Criteria andManaPasswordEqualTo(String value) {
            addCriterion("mana_password =", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordNotEqualTo(String value) {
            addCriterion("mana_password <>", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordGreaterThan(String value) {
            addCriterion("mana_password >", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("mana_password >=", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordLessThan(String value) {
            addCriterion("mana_password <", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordLessThanOrEqualTo(String value) {
            addCriterion("mana_password <=", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordLike(String value) {
            addCriterion("mana_password like", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordNotLike(String value) {
            addCriterion("mana_password not like", value, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordIn(List<String> values) {
            addCriterion("mana_password in", values, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordNotIn(List<String> values) {
            addCriterion("mana_password not in", values, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordBetween(String value1, String value2) {
            addCriterion("mana_password between", value1, value2, "manaPassword");
            return (Criteria) this;
        }

        public Criteria andManaPasswordNotBetween(String value1, String value2) {
            addCriterion("mana_password not between", value1, value2, "manaPassword");
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