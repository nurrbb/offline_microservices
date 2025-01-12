package com.nurbb.product_service.controller.mvc;

import com.nurbb.product_service.business.dto.ProductDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/*
Spring mvc kuralları
 1-) String dönmelidir
 2-) Http GetMapping ve PostMapping
 3-) ekleme ve Güncellemede GET ve POST farklı 2 tane method yazılır.
*/
public interface IProductMvc {

    // DELETE ALL
    public String deleteAll();

    ////////////////////////////////////////////////////////
    // CREATE GET
    // Model: import org.springframework.ui.Model;
    public String productCreateGet(Model model);

    // CREATE POST
    public String productCreatePost(ProductDto productDto, BindingResult bindingResult, Model model);

    // LIST
    public String productListGet(Model model);

    // FIND
    public String productFindGet(Long id, Model model);

    // UPDATE GET
    public String productUpdateGet(Long id, Model model);

    // UPDATE POST
    public String productUpdatePost(Long id,ProductDto productDto, BindingResult bindingResult, Model model);

    // DELETE
    public String productDeleteGet(Long id, Model model);
}
