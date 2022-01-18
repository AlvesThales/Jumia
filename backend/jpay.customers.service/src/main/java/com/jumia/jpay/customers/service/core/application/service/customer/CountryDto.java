package com.jumia.jpay.customers.service.core.application.service.customer;

public class CountryDto {

    private Integer code;
    private String name;

    public CountryDto(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public CountryDto() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
