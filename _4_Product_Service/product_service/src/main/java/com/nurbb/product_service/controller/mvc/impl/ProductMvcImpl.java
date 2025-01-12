package com.nurbb.product_service.controller.mvc.impl;

import com.nurbb.product_service.business.dto.ProductDto;
import com.nurbb.product_service.business.services.IProductServices;
import com.nurbb.product_service.controller.mvc.IProductMvc;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/*
Spring mvc kuralları
 1-) String dönmelidir
 2-) Http GetMapping ve PostMapping
 3-) ekleme ve Güncellemede GET ve POST farklı 2 tane method yazılır.
*/

// LOMBOK
@RequiredArgsConstructor
@Log4j2
@Getter
@Setter

// SPRING MVC
// Dikkat: Spring MVC ile çalışırken;  sistem kararlığı için @GetMapping ile @PostMapping ile çalışın
@Controller
@RequestMapping("/product/mvc/v1/")
public class ProductMvcImpl implements IProductMvc {

    // Variable
    private String modelAttributesTemp = "";
    private final IProductServices iProductServices;


    ////////////////////////////////////////////////////////////////

    // http://localhost:5555/product/mvc/v1/deleteAll
    // DELETE ALL
    @Override
    @GetMapping("/deleteAll") // Burası URL
    public String deleteAll() {
        iProductServices.productServiceDeleteAll();
        modelAttributesTemp = iProductServices.productServiceList().size()+" tane veri silindir";
        return "redirect:/product/mvc/v1/list"; // Burası @GetMapping URL gidecek yer.
    }

    ////////////////////////////////////////////////////////////////
    // http://localhost:5555/product/mvc/v1/create
    // CREATE GET
    @Override
    @GetMapping("/create") // Burası URL
    public String productCreateGet(Model model) {
        model.addAttribute("key_product_create", new ProductDto());
        return "product/create"; // Burası create sayfasına gidilecek yerdir
    }

    // CREATE POST
    @Override
    @PostMapping("/create") // Burası URL
    public String productCreatePost(
            @Valid @ModelAttribute("key_product_create")  ProductDto productDto,
            BindingResult bindingResult,
            Model model) {
        // Eğer Hata varsa Create Sayfasında kalsın
        if (bindingResult.hasErrors()) {
            //log.error(bindingResult.getAllErrors());
            log.error(bindingResult.hasErrors());
            return "product/create";
        }
        iProductServices.productServiceCreate(productDto);
        modelAttributesTemp = "Eklendi productDto"+ productDto ;
        return "redirect:/product/mvc/v1/list"; // Burası @GetMapping URL gidecek yer.r.
    }

    /////////////////////////////////////////////////////////
    // LIST
    // http://localhost:4444/product/mvc/v1/list
    @Override
    @GetMapping("/list")
    public String productListGet(Model model) {
        model.addAttribute("key_product_list", iProductServices.productServiceList());
        modelAttributesTemp = iProductServices.productServiceList().size() + " tane veri eklendi";
        model.addAttribute("modelAttributesTemp", modelAttributesTemp);
        return "product/list"; // Burası list sayfasına gidilecek yerdir
    }


    /////////////////////////////////////////////////////////
    // FIND
    // http://localhost:4444/product/mvc/v1/find
    // http://localhost:4444/product/mvc/v1/find/1
    @GetMapping( "/find/{id}")
    @Override
    public String productFindGet(@PathVariable(name = "id") Long id, Model model) {
        // eğer id numaralı veri varsa
        if (iProductServices.productServiceFindById(id)!=null) {
            model.addAttribute("key_product_find", iProductServices.productServiceFindById(id));
            return "product/view"; // Burası view sayfasına gidilecek yerdir
        }else{ //Yoksa
            model.addAttribute("key_product_find",id+" nolu product Yoktur");
        }
        model.addAttribute("key_product_find", iProductServices.productServiceFindById(id));
        return "redirect:/product/mvc/v1/list"; // Burası @GetMapping URL gidecek yer.
    }

    /////////////////////////////////////////////////////////
    // UPDATE GET
    //http://localhost:4444/product/mvc/v1/update/1
    @Override
    @GetMapping( "/update/{id}")
    public String productUpdateGet( @PathVariable(name = "id") Long id, Model model) {
        modelAttributesTemp = id + " numaralı veri yoktur";
        ProductDto productDto = null;
        model.addAttribute("key_product_update", iProductServices.productServiceFindById(id));
        return "product/update"; // Burası create sayfasına gidilecek yerdir
    }


    // UPDATE POST
    //http://localhost:4444/product/mvc/v1/update/1
    @Override
    @PostMapping( "/update/{id}")
    public String productUpdatePost(
            @PathVariable(name = "id") Long id,
            @Valid @ModelAttribute("key_product_update") ProductDto productDto,
            BindingResult bindingResult,
            Model model) {

        // Eğer Hata varsa Create Sayfasında kalsın
        if (bindingResult.hasErrors()) {
            //log.error(bindingResult.getAllErrors());
            log.error(bindingResult.hasErrors());
            return "product/update";
        }else{

            // eğer id numaralı veri varsa
            if (iProductServices.productServiceFindById(id)!=null) {
                model.addAttribute("key_product_update", iProductServices.productServiceFindById(id));
                iProductServices.productServiceUpdate(id,productDto);
                modelAttributesTemp = "Eklendi productDto";
            }else{ //Yoksa
                model.addAttribute("key_product_update",id+" nolu product Yoktur");
                return "product/update";
            }
        }
        // Anasayfaya Göndersin
        return "redirect:/product/mvc/v1/list"; // Burası @GetMapping URL gidecek yer.
    } //end productCreatePost


    /////////////////////////////////////////////////////////
    // DELETE
    @Override
    @GetMapping( "/delete/{id}")
    public String productDeleteGet( @PathVariable(name = "id") Long id, Model model) {
        // eğer id numaralı veri varsa
        if (iProductServices.productServiceFindById(id)!=null) {
            model.addAttribute("key_product_delete", iProductServices.productServiceFindById(id));
            iProductServices.productServiceDelete(id);
        }else{ //Yoksa
            model.addAttribute("key_product_delete",id+" nolu Product Yoktur");
        }
        return "redirect:/product/mvc/v1/list"; // Burası @GetMapping URL gidecek yer.

    }

} //end ProductMvcImpl
