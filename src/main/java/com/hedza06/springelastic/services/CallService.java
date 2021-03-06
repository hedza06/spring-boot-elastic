package com.hedza06.springelastic.services;

import com.hedza06.springelastic.domain.Call;
import com.hedza06.springelastic.domain.Customer;
import com.hedza06.springelastic.domain.Product;
import com.hedza06.springelastic.repository.CallRepository;
import com.hedza06.springelastic.repository.CustomerRepository;
import com.hedza06.springelastic.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CallService {

    private final CallRepository callRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public CallService(CallRepository callRepository,
                       CustomerRepository customerRepository,
                       ProductRepository productRepository)
    {
        this.callRepository = callRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /**
     * Insert bulk calls
     */
    public void insertAll()
    {
        int counter = 300000;
        int limit = 320000;
        String identifier = "CALL-";

        log.info("Processing...");
        List<Call> calls = new ArrayList<>();
        while (counter < limit)
        {
            Call call = new Call();
            call.setId(identifier + counter);
            call.setNote(RandomStringUtils.random(64, true, false));

            Customer customer = customerRepository.findById("CUSTOMER-15")
                    .orElseThrow(() -> new IllegalArgumentException("Customer not exists!"));

            Product product = productRepository.findById("PRODUCT-15")
                    .orElseThrow(() -> new IllegalArgumentException("Product not exists!"));

            call.setCustomer(customer);
            call.setProduct(product);
            calls.add(call);
            counter++;
        }
        log.info("Processing done. Start inserting...");
        callRepository.saveAll(calls);
        log.info("Insert done!");
    }

    @Transactional(readOnly = true)
    public Page<Call> findAll(Pageable pageable) {
        return callRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<Call> findByCustomerPrimaryIdentifier(String primaryIdentifier, Pageable pageable) {
        return callRepository.findByCustomerPrimaryIdentifier(primaryIdentifier, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Call> findByProductCategoryName(String categoryName, Pageable pageable) {
        return callRepository.findByProductCategoryName(categoryName, pageable);
    }

    @Transactional(readOnly = true)
    public List<Call> findByNoteStartPart(String notePart) {
        return callRepository.findByNoteStartingWith(notePart);
    }

    @Transactional(readOnly = true)
    public List<Call> findByNoteEndPart(String notePart) {
        return callRepository.findByNoteEndingWith(notePart);
    }
}
