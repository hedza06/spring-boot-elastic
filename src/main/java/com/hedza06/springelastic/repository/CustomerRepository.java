package com.hedza06.springelastic.repository;

import com.hedza06.springelastic.domain.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> { }
