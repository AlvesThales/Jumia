package com.jumia.jpay.customers.service.core.application.service.customer.mocks;

import com.jumia.jpay.customers.service.core.application.service.customer.PhoneDto;

public class PhoneDtoMock {

    public static PhoneDto create() {
        var phoneDto = new PhoneDto();
        phoneDto.setNumber("(251) 9773199405");
        phoneDto.setCountry(CountryDtoMock.create());
        phoneDto.setValid(true);

        return phoneDto;
    }
}
