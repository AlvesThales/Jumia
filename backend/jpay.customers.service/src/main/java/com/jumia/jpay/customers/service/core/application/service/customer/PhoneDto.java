package com.jumia.jpay.customers.service.core.application.service.customer;

public class PhoneDto {

    private String number;
    private CountryDto country;
    private boolean isValid;

    public PhoneDto(String number, CountryDto country, boolean isValid) {
        this.number = number;
        this.country = country;
        this.isValid = isValid;
    }

    public PhoneDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
