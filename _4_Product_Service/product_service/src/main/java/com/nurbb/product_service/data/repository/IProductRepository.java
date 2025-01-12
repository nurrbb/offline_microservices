package com.nurbb.product_service.data.repository;


import com.nurbb.product_service.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
// CrudRepository<ProductEntity,Long>
// JpaRepository<ProductEntity,Long>
// PagingAndSortingRepository<ProductEntity,Long>

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity,Long> {
    // Delivered Query
} // end IProductRepository
