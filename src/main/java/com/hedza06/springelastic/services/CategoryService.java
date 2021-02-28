package com.hedza06.springelastic.services;

import com.hedza06.springelastic.domain.Category;
import com.hedza06.springelastic.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Insert categories in bulk
     */
    public void insertAll()
    {
        int counter = 0;
        int limit = 2000;
        String identifier = "CATEGORY-";

        log.info("Processing...");
        List<Category> categories = new ArrayList<>();
        while (counter < limit)
        {
            Category category = new Category();
            category.setId(identifier + counter);
            category.setName(RandomStringUtils.random(12, true, true));
            category.setDescription(RandomStringUtils.random(128, true, true));
            categories.add(category);
            counter++;
        }
        log.info("Start bulk insert...");
        categoryRepository.saveAll(categories);
        log.info("Category bulk insert done!");
    }
}
