package com.jumia.jpay.customers.service.core.application.port.outbound.database.sqlite;

import com.jumia.jpay.customers.service.core.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
