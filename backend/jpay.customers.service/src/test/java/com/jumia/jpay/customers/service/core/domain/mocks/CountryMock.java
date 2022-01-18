package com.jumia.jpay.customers.service.core.domain.mocks;

import com.jumia.jpay.customers.service.core.domain.Country;

public class CountryMock {

    public static Country create() {
        return Country.create("(251) 9773199405");
    }
}
