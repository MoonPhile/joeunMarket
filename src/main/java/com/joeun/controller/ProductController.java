package com.joeun.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;
import com.joeun.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    
    @GetMapping("/addProduct")
    public String goToAddProduct(Model model) {
        List<ProductCategoryDto> categoryList = productService.findAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "/admin/addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("image") List<MultipartFile> images, ProductDto product) {
        System.out.println("상품 등록");
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
        System.out.println(product.getProductCondition());
        System.out.println(product.getProductPrice());
        System.out.println(product.getProductDescription());
        System.out.println(product.getProductCategoryId());

//        List<String> filePath = new ArrayList<>();
        String originPath = "";
        String[] filePath = new String[4];
        for (MultipartFile file : images) {
            String temp = productService.uploadFile(file);
            originPath += temp + " ";
        }
        filePath = originPath.split(" ");
        for (String s : filePath) {
            System.out.println(s);
        }
//        product.setImgs(filePath);

//        productService.addProduct(product);
        return "/admin/addProduct";
    }
    
    @GetMapping("/itemlist.do")
    String itemlist(Model model){
    	List<ProductDto> itemList = productMapper.findAll();
        model.addAttribute("items", itemList);
        return "test/itemList";
    }
}