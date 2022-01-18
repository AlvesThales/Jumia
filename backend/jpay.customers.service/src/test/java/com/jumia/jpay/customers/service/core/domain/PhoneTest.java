package com.jumia.jpay.customers.service.core.domain;

import com.jumia.jpay.customers.service.core.domain.mocks.PhoneMock;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static com.jumia.jpay.customers.service.core.domain.Phone.toPhoneDto;
import static com.jumia.jpay.customers.service.core.domain.Phone.validatePhoneNumber;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldCreateValidPhoneFromMorocco() {

        var phone = PhoneMock.create();

        assertNotNull(phone);
        assertEquals("(212) 698054317", phone.getNumber());
        assertNotNull(phone.getCountry());
        assertTrue(phone.isValid());
    }

    @Test
    void shouldCreateValidPhoneFromCameroon() {

        var phone = Phone.create("(237) 696443597");

        assertNotNull(phone);
        assertEquals("(237) 696443597", phone.getNumber());
        assertNotNull(phone.getCountry());
        assertTrue(phone.isValid());
    }

    @Test
    void shouldCreateValidPhoneFromEthiopia() {

        var phone = Phone.create("(251) 966002259");

        assertNotNull(phone);
        assertEquals("(251) 966002259", phone.getNumber());
        assertNotNull(phone.getCountry());
        assertTrue(phone.isValid());
    }

    @Test
    void shouldCreateValidPhoneFromMozambique() {

        var phone = Phone.create("(258) 823747618");

        assertNotNull(phone);
        assertEquals("(258) 823747618", phone.getNumber());
        assertNotNull(phone.getCountry());
        assertTrue(phone.isValid());
    }

    @Test
    void shouldCreateValidPhoneFromUganda() {

        var phone = Phone.create("(256) 714660221");

        assertNotNull(phone);
        assertEquals("(256) 714660221", phone.getNumber());
        assertNotNull(phone.getCountry());
        assertTrue(phone.isValid());
    }

    @Test
    void shouldNotCreatePhoneFromNullNumber() {
        assertThrows(ConstraintViolationException.class, () -> {
            Phone.create(null);
        });
    }

    @Test
    void shouldReturnFalseWhenValidatingPhoneFromUnknownCountry() {
        assertFalse(validatePhoneNumber("(999) 714660221"));
    }

    @Test
    void shouldNotCreatePhoneFromInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> {
            Phone.create("abcdefghj");
        });
    }

    @Test
    void shouldCreatePhoneDtoFromDomain() {
        var phone = PhoneMock.create();

        var phoneDto = toPhoneDto(phone);

        assertNotNull(phoneDto);
        assertNotNull(phoneDto.getCountry());
        assertEquals(phone.getNumber(), phoneDto.getNumber());
    }
}