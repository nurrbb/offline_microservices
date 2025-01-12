package com.nurbb.product_service.business.services.impl;

import com.nurbb.product_service.bean.ModelMapperBean;
import com.nurbb.product_service.business.dto.ProductDto;
import com.nurbb.product_service.business.services.IProductServices;
import com.nurbb.product_service.data.entity.ProductEntity;
import com.nurbb.product_service.data.repository.IProductRepository;
import com.nurbb.product_service.exception.NotFound404Exception;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class ProductServiceImpl implements IProductServices<ProductDto, ProductEntity> {

    // Injection
    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;


    ///////////////////////////////////////////
    // Model Mapper
    @Override
    public ProductDto EntityToDto(ProductEntity productEntity) {
        return modelMapperBean.getModelMapperMethod().map(productEntity, ProductDto.class);
    }

    @Override
    public ProductEntity DtoToEntity(ProductDto productDto) {
        return modelMapperBean.getModelMapperMethod().map(productDto, ProductEntity.class);
    }

    /////////////////////////////////////////////////////////////////////////
    // DELETE ALL  (PRODUCT)
    @Override
    public String productServiceDeleteAll() {
        iProductRepository.deleteAll();
        return productServiceList().size()+" silindi";
    }

    /////////////////////////////////////////////////////////////////////////
    // C R U D
    // CREATE (PRODUCT)
    @Override
    @Transactional
    public ProductDto productServiceCreate(ProductDto productDto) {
        if(productDto!=null){
            ProductEntity productEntity = DtoToEntity(productDto);
            iProductRepository.save(productEntity);
            // Kayıt işleminden sonra Id Set et
            productDto.setId(productEntity.getId());
            productDto.setCreatedDate(productEntity.getCreatedDate());
        }else{
            throw new NullPointerException("ProductDto is null");
        }
        return productDto;
    }

    // LIST  (PRODUCT)
    @Override
    public List<ProductDto> productServiceList() {
        Iterable<ProductEntity> productEntityList=   iProductRepository.findAll();

        // List
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductEntity temp:productEntityList){
            ProductDto productDto=EntityToDto(temp);
            productDtoList.add(productDto);
        }
        log.info(productDtoList.size());
        log.info(productDtoList);

        //return List.of();
        return productDtoList;
    }

    // FIND BY ID (PRODUCT)
    @Override
    public ProductDto productServiceFindById(Long id) {
        // 1.YOL
        /*
        Optional<ProductEntity>  findOptionalProductEntity= iProductRepository.findById(id);
        ProductDto productDto=EntityToDto(findOptionalProductEntity.get());
        if(findOptionalProductEntity.isPresent()){
            return  productDto;
        }
        */

        // 2.YOL
        ProductEntity productEntity=null;
        if(id!=null){
             productEntity = iProductRepository.findById(id)
                    .orElseThrow(()->new NotFound404Exception(id+" nolu id bulunamadı"));
        }else if(id==null){
            throw new NullPointerException("id is null");
        }
        return EntityToDto(productEntity);
    }

    // UPDATE (PRODUCT)
    @Override
    @Transactional
    public ProductDto productServiceUpdate(Long id, ProductDto productDto) {
        // Önce Product Id ile Bul
        ProductDto findUpdateProductDto=productServiceFindById(id);
        if(findUpdateProductDto!=null){
            // Bulduğu Object set
            ProductEntity productEntity=DtoToEntity(findUpdateProductDto);
            // productDto kaydettir
            productEntity.setProductName(productDto.getProductName());
            productEntity.setProductPrice(productDto.getProductPrice());
            productEntity.setProductQuantify(productDto.getProductQuantify());
            iProductRepository.save(productEntity);
        }
        return productDto;
    }

    // DELETE (PRODUCT)
    @Override
    @Transactional
    public ProductDto productServiceDelete(Long id) {
        // Önce Product Id ile Bul
        ProductDto findDeleteProductDto=productServiceFindById(id);

        if(findDeleteProductDto!=null){
            iProductRepository.deleteById(id);
        }
        return findDeleteProductDto;
    }

} //end ProductServiceImpl
