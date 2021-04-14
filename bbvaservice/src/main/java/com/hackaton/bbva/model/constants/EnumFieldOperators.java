package com.hackaton.bbva.model.constants;

public enum EnumFieldOperators {
    EQUAL("="),
    NOT_EQUAL("!="),
    LESS("<"),
    LESS_EQUAL("<="),
    GREATER(">"),
    GREATER_EQUAL(">="),
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE"),
    IN("IN"),
    NOT_IN("NOT IN");

    private String operator;

    EnumFieldOperators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}