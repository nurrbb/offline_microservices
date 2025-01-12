package com.nurbb.product_service.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductApi<D> {

    // DELETE ALL
    public ResponseEntity<String>  productApiDeleteAll();

    ////////////////////////////////////////////////////////////////////////////////////////
    // C R U D
    // CREATE
    public ResponseEntity<?>  productApiCreate(D d);

    // LIST
    public ResponseEntity<List<D> >   productApiList();

    // FIND BY ID
    public ResponseEntity<?>  productApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?>  productApiUpdate(Long id, D d);

    // DELETE
    public ResponseEntity<?>  productApiDelete(Long id);
}
