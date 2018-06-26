package com.golden.pojo;

import java.util.ArrayList;
import java.util.List;

public class BeamDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BeamDataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
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
            addCriterion("id >=", value, "id");
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

        public Criteria andWifiidIsNull() {
            addCriterion("wifiid is null");
            return (Criteria) this;
        }

        public Criteria andWifiidIsNotNull() {
            addCriterion("wifiid is not null");
            return (Criteria) this;
        }

        public Criteria andWifiidEqualTo(String value) {
            addCriterion("wifiid =", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidNotEqualTo(String value) {
            addCriterion("wifiid <>", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidGreaterThan(String value) {
            addCriterion("wifiid >", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidGreaterThanOrEqualTo(String value) {
            addCriterion("wifiid >=", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidLessThan(String value) {
            addCriterion("wifiid <", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidLessThanOrEqualTo(String value) {
            addCriterion("wifiid <=", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidLike(String value) {
            addCriterion("wifiid like", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidNotLike(String value) {
            addCriterion("wifiid not like", value, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidIn(List<String> values) {
            addCriterion("wifiid in", values, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidNotIn(List<String> values) {
            addCriterion("wifiid not in", values, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidBetween(String value1, String value2) {
            addCriterion("wifiid between", value1, value2, "wifiid");
            return (Criteria) this;
        }

        public Criteria andWifiidNotBetween(String value1, String value2) {
            addCriterion("wifiid not between", value1, value2, "wifiid");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiIsNull() {
            addCriterion("shebeibiaozhi is null");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiIsNotNull() {
            addCriterion("shebeibiaozhi is not null");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiEqualTo(String value) {
            addCriterion("shebeibiaozhi =", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiNotEqualTo(String value) {
            addCriterion("shebeibiaozhi <>", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiGreaterThan(String value) {
            addCriterion("shebeibiaozhi >", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiGreaterThanOrEqualTo(String value) {
            addCriterion("shebeibiaozhi >=", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiLessThan(String value) {
            addCriterion("shebeibiaozhi <", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiLessThanOrEqualTo(String value) {
            addCriterion("shebeibiaozhi <=", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiLike(String value) {
            addCriterion("shebeibiaozhi like", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiNotLike(String value) {
            addCriterion("shebeibiaozhi not like", value, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiIn(List<String> values) {
            addCriterion("shebeibiaozhi in", values, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiNotIn(List<String> values) {
            addCriterion("shebeibiaozhi not in", values, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiBetween(String value1, String value2) {
            addCriterion("shebeibiaozhi between", value1, value2, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeibiaozhiNotBetween(String value1, String value2) {
            addCriterion("shebeibiaozhi not between", value1, value2, "shebeibiaozhi");
            return (Criteria) this;
        }

        public Criteria andShebeileixingIsNull() {
            addCriterion("shebeileixing is null");
            return (Criteria) this;
        }

        public Criteria andShebeileixingIsNotNull() {
            addCriterion("shebeileixing is not null");
            return (Criteria) this;
        }

        public Criteria andShebeileixingEqualTo(String value) {
            addCriterion("shebeileixing =", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingNotEqualTo(String value) {
            addCriterion("shebeileixing <>", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingGreaterThan(String value) {
            addCriterion("shebeileixing >", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingGreaterThanOrEqualTo(String value) {
            addCriterion("shebeileixing >=", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingLessThan(String value) {
            addCriterion("shebeileixing <", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingLessThanOrEqualTo(String value) {
            addCriterion("shebeileixing <=", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingLike(String value) {
            addCriterion("shebeileixing like", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingNotLike(String value) {
            addCriterion("shebeileixing not like", value, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingIn(List<String> values) {
            addCriterion("shebeileixing in", values, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingNotIn(List<String> values) {
            addCriterion("shebeileixing not in", values, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingBetween(String value1, String value2) {
            addCriterion("shebeileixing between", value1, value2, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andShebeileixingNotBetween(String value1, String value2) {
            addCriterion("shebeileixing not between", value1, value2, "shebeileixing");
            return (Criteria) this;
        }

        public Criteria andBeamIsNull() {
            addCriterion("beam is null");
            return (Criteria) this;
        }

        public Criteria andBeamIsNotNull() {
            addCriterion("beam is not null");
            return (Criteria) this;
        }

        public Criteria andBeamEqualTo(String value) {
            addCriterion("beam =", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotEqualTo(String value) {
            addCriterion("beam <>", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamGreaterThan(String value) {
            addCriterion("beam >", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamGreaterThanOrEqualTo(String value) {
            addCriterion("beam >=", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamLessThan(String value) {
            addCriterion("beam <", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamLessThanOrEqualTo(String value) {
            addCriterion("beam <=", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamLike(String value) {
            addCriterion("beam like", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotLike(String value) {
            addCriterion("beam not like", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamIn(List<String> values) {
            addCriterion("beam in", values, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotIn(List<String> values) {
            addCriterion("beam not in", values, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamBetween(String value1, String value2) {
            addCriterion("beam between", value1, value2, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotBetween(String value1, String value2) {
            addCriterion("beam not between", value1, value2, "beam");
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