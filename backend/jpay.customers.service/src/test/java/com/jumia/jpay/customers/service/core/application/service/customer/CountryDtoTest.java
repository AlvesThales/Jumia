package com.jumia.jpay.customers.service.core.application.service.customer;

import com.jumia.jpay.customers.service.core.application.service.customer.mocks.CountryDtoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CountryDtoTest {

    @Test
    void shouldCreateCountryDtoFromNoArgsConstructor() {

        var countryDto = CountryDtoMock.create();

        assertNotNull(countryDto);
        assertEquals("ETHIOPIA", countryDto.getName());
        assertEquals(251, countryDto.getCode());
    }

    @Test
    void shouldCreateCountryDtoFromConstructor() {

        var countryDto = new CountryDto(251, "ETHIOPIA");

        assertNotNull(countryDto);
        assertEquals("ETHIOPIA", countryDto.getName());
        assertEquals(251, countryDto.getCode());
    }

}