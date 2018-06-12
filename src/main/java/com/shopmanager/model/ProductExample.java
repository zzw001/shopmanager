package com.shopmanager.model;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Integer value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Integer value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Integer> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNull() {
            addCriterion("pro_price is null");
            return (Criteria) this;
        }

        public Criteria andProPriceIsNotNull() {
            addCriterion("pro_price is not null");
            return (Criteria) this;
        }

        public Criteria andProPriceEqualTo(Integer value) {
            addCriterion("pro_price =", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotEqualTo(Integer value) {
            addCriterion("pro_price <>", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThan(Integer value) {
            addCriterion("pro_price >", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_price >=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThan(Integer value) {
            addCriterion("pro_price <", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceLessThanOrEqualTo(Integer value) {
            addCriterion("pro_price <=", value, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceIn(List<Integer> values) {
            addCriterion("pro_price in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotIn(List<Integer> values) {
            addCriterion("pro_price not in", values, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceBetween(Integer value1, Integer value2) {
            addCriterion("pro_price between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_price not between", value1, value2, "proPrice");
            return (Criteria) this;
        }

        public Criteria andProStackIsNull() {
            addCriterion("pro_stack is null");
            return (Criteria) this;
        }

        public Criteria andProStackIsNotNull() {
            addCriterion("pro_stack is not null");
            return (Criteria) this;
        }

        public Criteria andProStackEqualTo(Integer value) {
            addCriterion("pro_stack =", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackNotEqualTo(Integer value) {
            addCriterion("pro_stack <>", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackGreaterThan(Integer value) {
            addCriterion("pro_stack >", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_stack >=", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackLessThan(Integer value) {
            addCriterion("pro_stack <", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackLessThanOrEqualTo(Integer value) {
            addCriterion("pro_stack <=", value, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackIn(List<Integer> values) {
            addCriterion("pro_stack in", values, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackNotIn(List<Integer> values) {
            addCriterion("pro_stack not in", values, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackBetween(Integer value1, Integer value2) {
            addCriterion("pro_stack between", value1, value2, "proStack");
            return (Criteria) this;
        }

        public Criteria andProStackNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_stack not between", value1, value2, "proStack");
            return (Criteria) this;
        }

        public Criteria andProSizeIsNull() {
            addCriterion("pro_size is null");
            return (Criteria) this;
        }

        public Criteria andProSizeIsNotNull() {
            addCriterion("pro_size is not null");
            return (Criteria) this;
        }

        public Criteria andProSizeEqualTo(String value) {
            addCriterion("pro_size =", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotEqualTo(String value) {
            addCriterion("pro_size <>", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeGreaterThan(String value) {
            addCriterion("pro_size >", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_size >=", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLessThan(String value) {
            addCriterion("pro_size <", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLessThanOrEqualTo(String value) {
            addCriterion("pro_size <=", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeLike(String value) {
            addCriterion("pro_size like", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotLike(String value) {
            addCriterion("pro_size not like", value, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeIn(List<String> values) {
            addCriterion("pro_size in", values, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotIn(List<String> values) {
            addCriterion("pro_size not in", values, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeBetween(String value1, String value2) {
            addCriterion("pro_size between", value1, value2, "proSize");
            return (Criteria) this;
        }

        public Criteria andProSizeNotBetween(String value1, String value2) {
            addCriterion("pro_size not between", value1, value2, "proSize");
            return (Criteria) this;
        }

        public Criteria andProDescIsNull() {
            addCriterion("pro_desc is null");
            return (Criteria) this;
        }

        public Criteria andProDescIsNotNull() {
            addCriterion("pro_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProDescEqualTo(String value) {
            addCriterion("pro_desc =", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotEqualTo(String value) {
            addCriterion("pro_desc <>", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescGreaterThan(String value) {
            addCriterion("pro_desc >", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescGreaterThanOrEqualTo(String value) {
            addCriterion("pro_desc >=", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLessThan(String value) {
            addCriterion("pro_desc <", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLessThanOrEqualTo(String value) {
            addCriterion("pro_desc <=", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescLike(String value) {
            addCriterion("pro_desc like", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotLike(String value) {
            addCriterion("pro_desc not like", value, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescIn(List<String> values) {
            addCriterion("pro_desc in", values, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotIn(List<String> values) {
            addCriterion("pro_desc not in", values, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescBetween(String value1, String value2) {
            addCriterion("pro_desc between", value1, value2, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProDescNotBetween(String value1, String value2) {
            addCriterion("pro_desc not between", value1, value2, "proDesc");
            return (Criteria) this;
        }

        public Criteria andProImageIsNull() {
            addCriterion("pro_image is null");
            return (Criteria) this;
        }

        public Criteria andProImageIsNotNull() {
            addCriterion("pro_image is not null");
            return (Criteria) this;
        }

        public Criteria andProImageEqualTo(String value) {
            addCriterion("pro_image =", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageNotEqualTo(String value) {
            addCriterion("pro_image <>", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageGreaterThan(String value) {
            addCriterion("pro_image >", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageGreaterThanOrEqualTo(String value) {
            addCriterion("pro_image >=", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageLessThan(String value) {
            addCriterion("pro_image <", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageLessThanOrEqualTo(String value) {
            addCriterion("pro_image <=", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageLike(String value) {
            addCriterion("pro_image like", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageNotLike(String value) {
            addCriterion("pro_image not like", value, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageIn(List<String> values) {
            addCriterion("pro_image in", values, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageNotIn(List<String> values) {
            addCriterion("pro_image not in", values, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageBetween(String value1, String value2) {
            addCriterion("pro_image between", value1, value2, "proImage");
            return (Criteria) this;
        }

        public Criteria andProImageNotBetween(String value1, String value2) {
            addCriterion("pro_image not between", value1, value2, "proImage");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(Integer value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(Integer value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(Integer value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(Integer value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<Integer> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<Integer> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
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