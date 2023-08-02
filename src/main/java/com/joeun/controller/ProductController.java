package com.joeun.controller;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/addProduct.do")
    public String goToAddProduct(Model model) {
        List<ProductCategoryDto> categoryList = productService.findAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "/admin/addProduct";
    }

    @GetMapping("/addCategory.do")
    public String goToAddCategory() {
        return "/admin/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(final ProductCategoryDto categoryDto) {
        productService.addCategory(categoryDto);
        return "/admin/adminMain";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("image") List<MultipartFile> images, ProductDto product) {
        System.out.println("상품 등록");
//        System.out.println(product.getProductId());
//        System.out.println(product.getProductName());
//        System.out.println(product.getProductCondition());
//        System.out.println(product.getProductPrice());
//        System.out.println(product.getProductDescription());
//        System.out.println(product.getProductCategoryId());

//        List<String> filePath = new ArrayList<>();
        String originPath = "";
        String[] filePath = new String[4];
        String[] tempArray;
        for (MultipartFile file : images) {
            String temp = productService.uploadFile(file);
            originPath += temp + " ";
        }
        tempArray = originPath.split(" ");

        for (int i = 0; i < tempArray.length; i++) {
            filePath[i] = tempArray[i];
        }

//        product.setImgs(filePath);

        product.setImgs(filePath);
        productService.addProduct(product);
        return "/admin/adminMain";
    }
}