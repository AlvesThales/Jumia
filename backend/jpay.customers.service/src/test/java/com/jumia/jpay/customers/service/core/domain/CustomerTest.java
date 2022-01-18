package com.jumia.jpay.customers.service.core.domain;

import com.jumia.jpay.customers.service.core.domain.mocks.CustomerMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerTest {

    @Test
    void shouldCreateValidCustomer() {
        var customer = CustomerMock.create();

        assertNotNull(customer);
        assertNotNull(customer.getPhone());
        assertEquals(1, customer.getId());
        assertEquals("John Doe", customer.getName());
    }

}