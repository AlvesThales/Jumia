package com.jumia.jpay.customers.service.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryNameTest {

    @Test
    void shouldGetCodeFromCountryName() {

        var countryName = CountryName.CAMEROON;

        assertEquals(237, countryName.getCode());
    }
}