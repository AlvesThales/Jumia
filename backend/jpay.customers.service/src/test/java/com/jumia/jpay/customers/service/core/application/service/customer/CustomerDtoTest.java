package com.jumia.jpay.customers.service.core.application.service.customer;

import com.jumia.jpay.customers.service.core.application.service.customer.mocks.CustomerDtoMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerDtoTest {

    @Test
    void shouldCreateCustomerDtoFromNoArgsConstructor() {

        var customerDto = CustomerDtoMock.create();

        assertNotNull(customerDto);
        assertEquals(123, customerDto.getId());
        assertEquals("Jane Doe", customerDto.getName());
        assertEquals("(256) 714660221", customerDto.getPhone());
    }

    @Test
    void shouldCreateCustomerDtoFromConstructor() {

        var customerDto = new CustomerDto(321, "Darth Vader", "(251) 9773199405");

        assertNotNull(customerDto);
        assertEquals(321, customerDto.getId());
        assertEquals("Darth Vader", customerDto.getName());
        assertEquals("(251) 9773199405", customerDto.getPhone());
    }

}