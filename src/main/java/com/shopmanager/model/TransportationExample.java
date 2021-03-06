package com.shopmanager.model;

import java.util.ArrayList;
import java.util.List;

public class TransportationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransportationExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
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