package com.jumia.jpay.customers.service.core.application.service.customer.mocks;

import com.jumia.jpay.customers.service.core.application.service.customer.CountryDto;

public class CountryDtoMock {

    public static CountryDto create() {
        var countryDto = new CountryDto();
        countryDto.setName("ETHIOPIA");
        countryDto.setCode(251);

        return countryDto;
    }
}
