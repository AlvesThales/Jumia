package com.jumia.jpay.customers.service.core.domain;

import com.jumia.jpay.customers.service.core.domain.mocks.CountryMock;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static com.jumia.jpay.customers.service.core.domain.Country.toCountryDto;
import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void shouldCreateCountryFromValidPhoneNumber() {

        var country = Country.create("(212) 698054317");

        assertNotNull(country);
        assertEquals(212, country.getCode());
        assertEquals("MOROCCO", country.getName());
    }

    @Test
    void shouldNotCreateCountryFromUnknownCountryCode() {

        assertThrows(ConstraintViolationException.class, () -> {
            Country.create("(999) 698054317");
        });
    }

    @Test
    void shouldNotCreateCountryFromBadPhoneNumber() {

        assertThrows(ConstraintViolationException.class, () -> {
            Country.create("00");
        });
    }

    @Test
    void shouldCreateCountryDtoFromDomain() {
        var country = CountryMock.create();

        var countryDto = toCountryDto(country);

        assertNotNull(countryDto);
        assertEquals(country.getCode(), countryDto.getCode());
        assertEquals(country.getName(), countryDto.getName());
    }

}