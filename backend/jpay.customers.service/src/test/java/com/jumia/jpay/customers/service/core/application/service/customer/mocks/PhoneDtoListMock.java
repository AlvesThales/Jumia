package com.jumia.jpay.customers.service.core.application.service.customer.mocks;

import com.jumia.jpay.customers.service.core.application.service.customer.PhoneDto;

import java.util.ArrayList;
import java.util.List;

public class PhoneDtoListMock {

    public static List<PhoneDto> create() {
        List<PhoneDto> phonesDto = new ArrayList<>();
        phonesDto.add(PhoneDtoMock.create());
        phonesDto.add(PhoneDtoMock.create());
        phonesDto.add(PhoneDtoMock.create());

        return phonesDto;
    }
}
