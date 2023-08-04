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
import com.joeun.mapper.PagingMapper;
import com.joeun.mapper.ProductMapper;
import com.joeun.service.PagingService;
import com.joeun.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final PagingService pagingService;
    private final PagingMapper pagingMapper;
    
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
    
    @GetMapping("/productlist")
    public String showProductList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(required = false) String keyword, // 검색어 파라미터 추가
                                  Model model) {
        int totalCount;
        int totalPages;
        List<ProductDto> products;

        // 검색어가 있는 경우와 없는 경우를 구분하여 처리
        if (keyword != null && !keyword.isEmpty()) {
            totalCount = pagingService.countProductsByKeyword(keyword);
            totalPages = (int) Math.ceil((double) totalCount / size);

            if (page < 1) {
                page = 1;
            } else if (page > totalPages) {
                page = totalPages;
            }

            int offset = (page - 1) * size;
            products = productService.findProductsByKeywordPaging(offset, size,keyword);
        } else {
            totalCount = pagingService.countAllProducts();
            totalPages = (int) Math.ceil((double) totalCount / size);

            if (page < 1) {
                page = 1;
            } else if (page > totalPages) {
                page = totalPages;
            }

            int offset = (page - 1) * size;
            products = productService.findAllProductsPaging(offset, size);
        }

        model.addAttribute("items", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("keyword", keyword); // 검색어를 다시 뷰로 전달

        return "productlist";
    }
}