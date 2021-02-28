package com.hedza06.springelastic.repository;

import com.hedza06.springelastic.domain.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category, String> { }
