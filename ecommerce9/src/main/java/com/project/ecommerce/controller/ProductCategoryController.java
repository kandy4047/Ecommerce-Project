package com.project.ecommerce.controller;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.FilterCategoryDto;
import com.project.ecommerce.entity.ProductCategory;
import com.project.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class ProductCategoryController {

    @Autowired
    ProductCategoryService categoryService;



    @GetMapping("/category/view/all")
    public List<ProductCategory> viewAll
            (@RequestHeader(name = "offset",
                    required = false,
                    defaultValue = "0") Integer offset,
             @RequestHeader(name = "size",
                     required = false,
                     defaultValue = "10") Integer size) {
        return categoryService.getAll(offset, size);
    }




    @PostMapping("/admin/category/add")
    public String addCategory(@RequestBody ProductCategory productCategory,
                              @RequestHeader(name = "Accept-Language",
                                      required = false) Locale locale){
        return categoryService.addCategory(productCategory,locale);
    }



    @GetMapping("/admin/category/view/{id}")
    public Optional<ProductCategory> viewCategory(@PathVariable Long id) {
        return categoryService.getACategory(id);
    }



    @PutMapping("/admin/category/update/{id}")
    public String updateCategory(@PathVariable Long id,
                                 @RequestBody ProductCategory name,
                                 @RequestHeader(name = "Accept-Language",
                                         required = false) Locale locale){
        return categoryService.updateCategory(id,name,locale);
    }



    @GetMapping("/customer/category/view/all")//
    public List<CategoryDto> viewAllCategoriesByCustomer(){
        return categoryService.viewAllCategoriesByCustomer(null);
    }



    @GetMapping("/customer/category/view/{id}")
    public List<CategoryDto> viewAllCategoriesByIdByCustomer(@PathVariable Long id ){
        return categoryService.viewAllCategoriesByCustomer(id);
    }



    @GetMapping("/customer/category/filter/{id}")
    public FilterCategoryDto filterCategoriesByIdByCustomer(@PathVariable Long id ){
        return categoryService.filterCategoryByCustomer(id);
    }
}
