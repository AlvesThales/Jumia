package com.jumia.jpay.customers.service.core.application.service.customer;

import com.jumia.jpay.customers.service.core.application.service.customer.mocks.CountryDtoMock;
import com.jumia.jpay.customers.service.core.application.service.customer.mocks.PhoneDtoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDtoTest {

    @Test
    void shouldCreatePhoneDtoFromNoArgsConstructor() {

        var phoneDto = PhoneDtoMock.create();

        assertNotNull(phoneDto);
        assertNotNull(phoneDto.getCountry());
        assertEquals("(251) 9773199405", phoneDto.getNumber());
        assertTrue(phoneDto.isValid());
    }

    @Test
    void shouldCreatePhoneDtoFromConstructor() {

        var phoneDto = new PhoneDto("(251) 9773199405", CountryDtoMock.create(), true);

        assertNotNull(phoneDto);
        assertNotNull(phoneDto.getCountry());
        assertEquals("(251) 9773199405", phoneDto.getNumber());
        assertTrue(phoneDto.isValid());
    }
}