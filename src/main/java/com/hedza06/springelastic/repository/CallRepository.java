package com.hedza06.springelastic.repository;

import com.hedza06.springelastic.domain.Call;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CallRepository extends ElasticsearchRepository<Call, String>
{
    Page<Call> findByCustomerPrimaryIdentifier(String primaryIdentifier, Pageable pageable);
    Page<Call> findByProductCategoryName(String categoryName, Pageable pageable);

    List<Call> findByNoteStartingWith(String notePart);
    List<Call> findByNoteEndingWith(String notePart);
}
