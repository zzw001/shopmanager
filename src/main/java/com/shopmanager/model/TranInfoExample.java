package com.shopmanager.model;

import java.util.ArrayList;
import java.util.List;

public class TranInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TranInfoExample() {
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

        public Criteria andTranInfoIdIsNull() {
            addCriterion("tran_info_id is null");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdIsNotNull() {
            addCriterion("tran_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdEqualTo(Integer value) {
            addCriterion("tran_info_id =", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdNotEqualTo(Integer value) {
            addCriterion("tran_info_id <>", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdGreaterThan(Integer value) {
            addCriterion("tran_info_id >", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tran_info_id >=", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdLessThan(Integer value) {
            addCriterion("tran_info_id <", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("tran_info_id <=", value, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdIn(List<Integer> values) {
            addCriterion("tran_info_id in", values, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdNotIn(List<Integer> values) {
            addCriterion("tran_info_id not in", values, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("tran_info_id between", value1, value2, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tran_info_id not between", value1, value2, "tranInfoId");
            return (Criteria) this;
        }

        public Criteria andTranIdIsNull() {
            addCriterion("tran_id is null");
            return (Criteria) this;
        }

        public Criteria andTranIdIsNotNull() {
            addCriterion("tran_id is not null");
            return (Criteria) this;
        }

        public Criteria andTranIdEqualTo(String value) {
            addCriterion("tran_id =", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdNotEqualTo(String value) {
            addCriterion("tran_id <>", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdGreaterThan(String value) {
            addCriterion("tran_id >", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdGreaterThanOrEqualTo(String value) {
            addCriterion("tran_id >=", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdLessThan(String value) {
            addCriterion("tran_id <", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdLessThanOrEqualTo(String value) {
            addCriterion("tran_id <=", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdLike(String value) {
            addCriterion("tran_id like", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdNotLike(String value) {
            addCriterion("tran_id not like", value, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdIn(List<String> values) {
            addCriterion("tran_id in", values, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdNotIn(List<String> values) {
            addCriterion("tran_id not in", values, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdBetween(String value1, String value2) {
            addCriterion("tran_id between", value1, value2, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranIdNotBetween(String value1, String value2) {
            addCriterion("tran_id not between", value1, value2, "tranId");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextIsNull() {
            addCriterion("tran_info_context is null");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextIsNotNull() {
            addCriterion("tran_info_context is not null");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextEqualTo(String value) {
            addCriterion("tran_info_context =", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextNotEqualTo(String value) {
            addCriterion("tran_info_context <>", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextGreaterThan(String value) {
            addCriterion("tran_info_context >", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextGreaterThanOrEqualTo(String value) {
            addCriterion("tran_info_context >=", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextLessThan(String value) {
            addCriterion("tran_info_context <", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextLessThanOrEqualTo(String value) {
            addCriterion("tran_info_context <=", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextLike(String value) {
            addCriterion("tran_info_context like", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextNotLike(String value) {
            addCriterion("tran_info_context not like", value, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextIn(List<String> values) {
            addCriterion("tran_info_context in", values, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextNotIn(List<String> values) {
            addCriterion("tran_info_context not in", values, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextBetween(String value1, String value2) {
            addCriterion("tran_info_context between", value1, value2, "tranInfoContext");
            return (Criteria) this;
        }

        public Criteria andTranInfoContextNotBetween(String value1, String value2) {
            addCriterion("tran_info_context not between", value1, value2, "tranInfoContext");
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