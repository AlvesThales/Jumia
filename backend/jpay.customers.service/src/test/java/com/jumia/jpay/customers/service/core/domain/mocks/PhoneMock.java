package com.jumia.jpay.customers.service.core.domain.mocks;

import com.jumia.jpay.customers.service.core.domain.Phone;

public class PhoneMock {

    public static Phone create() {
        return Phone.create("(212) 698054317");
    }
}
