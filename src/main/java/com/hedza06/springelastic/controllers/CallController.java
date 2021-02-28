package com.hedza06.springelastic.controllers;

import com.hedza06.springelastic.domain.Call;
import com.hedza06.springelastic.services.CallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/call", produces = MediaType.APPLICATION_JSON_VALUE)
public class CallController {

    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @PostMapping
    public ResponseEntity<Void> bulkInsert()
    {
        callService.insertAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Page<Call>> page(Pageable pageable)
    {
        Page<Call> page = callService.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping(value = "/by-customer/primary-identifier/{primaryIdentifier}")
    public ResponseEntity<Page<Call>> byCustomerPrimaryIdentifier(@PathVariable String primaryIdentifier,
                                                                  Pageable pageable)
    {
        Page<Call> calls = callService.findByCustomerPrimaryIdentifier(primaryIdentifier, pageable);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @GetMapping(value = "/by-product/category/{categoryName}")
    public ResponseEntity<Page<Call>> byProductCategoryName(@PathVariable String categoryName, Pageable pageable)
    {
        Page<Call> calls = callService.findByProductCategoryName(categoryName, pageable);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @GetMapping(value = "/by-note/start-part/{note}")
    public ResponseEntity<List<Call>> byNoteStartPart(@PathVariable String note)
    {
        List<Call> calls = callService.findByNoteStartPart(note);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @GetMapping(value = "/by-note/end-part/{note}")
    public ResponseEntity<List<Call>> byNoteEndPart(@PathVariable String note)
    {
        List<Call> calls = callService.findByNoteEndPart(note);
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }
}
