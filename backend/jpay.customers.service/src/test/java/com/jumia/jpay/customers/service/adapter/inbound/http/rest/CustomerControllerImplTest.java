package com.jumia.jpay.customers.service.adapter.inbound.http.rest;

import com.jumia.jpay.customers.service.core.application.service.customer.CustomerService;
import com.jumia.jpay.customers.service.core.application.service.customer.mocks.CustomerDtoListMock;
import com.jumia.jpay.customers.service.core.application.service.customer.mocks.PhoneDtoListMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerImplTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerControllerImpl customerController;

    @Test
    void shouldGetAllCustomers() {

        var customers = CustomerDtoListMock.create();
        when(customerService.getAll()).thenReturn(customers);

        var responseEntity = customerController.getAll();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(customers, responseEntity.getBody());
        verify(customerService, times(1)).getAll();
    }

    @Test
    void shouldReturnNotFoundIfThereAreNoCustomers() {

        when(customerService.getAll()).thenReturn(new ArrayList<>());
        var responseEntity = customerController.getAll();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(customerService, times(1)).getAll();
    }

    @Test
    void shouldGetCustomerPhones() {

        var customers = CustomerDtoListMock.create();
        var phones = PhoneDtoListMock.create();
        when(customerService.getAll()).thenReturn(customers);
        when(customerService.getCustomersPhones(customers)).thenReturn(phones);

        var responseEntity = customerController.getCustomersPhones();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(phones, responseEntity.getBody());
        verify(customerService, times(1)).getCustomersPhones(customers);
    }
}