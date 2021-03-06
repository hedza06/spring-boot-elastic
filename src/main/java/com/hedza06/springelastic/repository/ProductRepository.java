package com.hedza06.springelastic.repository;

import com.hedza06.springelastic.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> { }
