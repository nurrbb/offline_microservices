package com.nurbb.product_service.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IProductServices <D,E>{

    // Model Mapper
    public D EntityToDto(E e);
    public E DtoToEntity(D d);

    ///////////////////////////////////////////////////////////////////////////

    // SPEED DATA

    // DELETE ALL
    public String productServiceDeleteAll();

    ///////////////////////////////////////////////////////////////////////////
    // C R U D
    // CREATE
    public D productServiceCreate(D d);

    // LIST
    public List<D> productServiceList();

    // FIND BY ID
    public D productServiceFindById(Long id);

    // UPDATE
    public D productServiceUpdate(Long id, D d);

    // DELETE
    public D productServiceDelete(Long id);
} //end IProductServices
