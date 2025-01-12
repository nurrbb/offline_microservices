package com.nurbb.product_service.controller.api.impl;


import com.nurbb.product_service.business.dto.ProductDto;
import com.nurbb.product_service.business.services.IProductServices;
import com.nurbb.product_service.controller.api.IProductApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = ReactFrontend.PRODUCTION_REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/product/api/v1")
public class ProductApiImpl implements IProductApi<ProductDto> {

    // Injection
    private final IProductServices iProductServices;

    ///////////////////////////////////////////////////////////////
    // DELETE ALL  (PRODUCT)
    @Override
    @GetMapping("/delete/all")
    public ResponseEntity<String> productApiDeleteAll() {
        return ResponseEntity.ok(iProductServices.productServiceDeleteAll());
    }

    ///////////////////////////////////////////////////////////////
    // CREATE (PRODUCT)
    // http://localhost:5555/product/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> productApiCreate(@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(iProductServices.productServiceCreate(productDto));
    }

    ///////////////////////////////////////////////////////////////
    // LIST (PRODUCT)
    // http://localhost:5555/product/api/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> productApiList() {
        return ResponseEntity.ok(iProductServices.productServiceList());
    }

    ///////////////////////////////////////////////////////////////
    // FIND (PRODUCT)
    // http://localhost:5555/product/api/v1/find/1
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> productApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iProductServices.productServiceFindById(id));
    }

    ///////////////////////////////////////////////////////////////
    // UPDATE (PRODUCT)
    // http://localhost:5555/product/api/v1/update/1
    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<?> productApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody ProductDto productDto) {
       return ResponseEntity.ok(iProductServices.productServiceUpdate(id,productDto));
    }

    ///////////////////////////////////////////////////////////////
    // DELETE (PRODUCT)
    // http://localhost:5555/product/api/v1/delete/1
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> productApiDelete(@PathVariable(name = "id") Long id) {
        return  ResponseEntity.ok(iProductServices.productServiceDelete(id));
    }

} //end ProductApiImpl
