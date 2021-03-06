package com.hedza06.springelastic.services;

import com.hedza06.springelastic.domain.Customer;
import com.hedza06.springelastic.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Insert bulk customers
     */
    public void insertAll()
    {
        int counter = 0;
        int limit = 50000;
        String identifier = "CUSTOMER-";

        log.info("Processing...");
        List<Customer> customers = new ArrayList<>();
        while (counter < limit)
        {
            Customer customer = new Customer();
            customer.setId(identifier + counter);
            customer.setPrimaryIdentifier(RandomStringUtils.random(13, false, true));
            customer.setCreatedAt(new Date());
            customer.setFullName(RandomStringUtils.random(24, true, false));
            customer.setIsActive(true);
            customers.add(customer);
            counter++;
        }
        log.info("Processing done. Inserting customers...");
        customers.parallelStream().forEach(customerRepository::save);
        log.info("Customer bulk insert done!");
    }
}
