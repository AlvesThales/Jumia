package com.jumia.jpay.customers.service.core.domain;

import com.jumia.jpay.customers.service.core.application.service.customer.CountryDto;
import com.jumia.jpay.customers.service.core.domain.validators.CustomValidator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.jumia.jpay.customers.service.core.domain.Phone.getCountryCodeFromPhoneNumber;
import static com.jumia.jpay.customers.service.core.domain.Phone.getCountryNameFromCountryCode;

public class Country {

    @NotNull
    private Integer code;

    @NotEmpty
    private String name;

    private Country(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Country create(String phoneNumber) {

        if (phoneNumber == null) return null;
        var code = getCountryCodeFromPhoneNumber(phoneNumber);
        String name = code != null ? getCountryNameFromCountryCode(code) : null;
        var country = new Country(code, name);
        CustomValidator.validateAndThrow(country);
        return country;
    }

    public static CountryDto toCountryDto(Country country) {
        return new CountryDto(country.getCode(), country.getName());
    }


    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
