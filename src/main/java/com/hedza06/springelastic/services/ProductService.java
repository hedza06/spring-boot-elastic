package com.hedza06.springelastic.services;

import com.hedza06.springelastic.domain.Category;
import com.hedza06.springelastic.domain.Customer;
import com.hedza06.springelastic.domain.Product;
import com.hedza06.springelastic.repository.CategoryRepository;
import com.hedza06.springelastic.repository.CustomerRepository;
import com.hedza06.springelastic.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          CustomerRepository customerRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Insert all products
     */
    public void insertAll()
    {
        int counter = 0;
        int limit = 10000;
        String identifier = "PRODUCT-";

        log.info("Processing...");
        List<Product> products = new ArrayList<>();
        while (counter < limit)
        {
            Product product = new Product();
            product.setId(identifier + counter);
            product.setPrimaryIdentifier(RandomStringUtils.random(13, true, false));
            product.setCatalogName(RandomStringUtils.random(32, true, false));

            Category category = categoryRepository.findById("CATEGORY-0")
                    .orElseThrow(() -> new IllegalArgumentException("Category not exists!"));

            Customer customer = customerRepository.findById("CUSTOMER-0")
                    .orElseThrow(() -> new IllegalArgumentException("Customer not exists!"));

            product.setCategory(category);
            product.setCustomer(customer);
            product.setIsActive(true);
            products.add(product);
            counter++;
        }
        log.info("Processing done. Inserting products...");
        productRepository.saveAll(products);
        log.info("Product bulk insert done!");
    }
}
