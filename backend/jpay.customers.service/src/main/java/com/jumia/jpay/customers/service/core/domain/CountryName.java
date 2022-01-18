package com.jumia.jpay.customers.service.core.domain;

public enum CountryName {
    CAMEROON(237), ETHIOPIA(251), MOROCCO(212), MOZAMBIQUE(258), UGANDA(256);

    private final int code;

    CountryName(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
