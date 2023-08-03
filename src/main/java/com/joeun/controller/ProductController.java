package com.joeun.controller;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;
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
    private final ProductMapper productMapper;

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

    @GetMapping("/productList.do")
    public String goToProductList(Model model) {
        List<ProductDto> productList = productService.findAllProduct();
        model.addAttribute("products", productList);
        return "/admin/adminProductList";
    }

    @PostMapping("/addCategory")
    public String addCategory(final ProductCategoryDto categoryDto) {
        productService.addCategory(categoryDto);
        return "redirect:/admin.do";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("imgs") List<MultipartFile> imgs, ProductDto product) {
        System.out.println("상품 등록");
        String originPath = "";
        String[] filePath = new String[4];
        String[] tempArray;
        for (MultipartFile file : imgs) {
            String temp = productService.uploadFile(file);
            originPath += temp + " ";
        }
        tempArray = originPath.split(" ");

        for(int i=0;i<filePath.length;i++){
            if(!tempArray[i].isEmpty()){
                filePath[i] = tempArray[i];
            }else {
                filePath[i] = null;
            }

        }
        product.setImg1(filePath[0]);
        product.setImg2(filePath[1]);
        product.setImg3(filePath[2]);
        product.setImg4(filePath[3]);
        productService.addProduct(product);
        return "/admin/adminMain";
    }


    @GetMapping("/productlist")
    public String showProductList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  Model model) {
        int totalCount = productService.countAllProducts();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        if (page < 1) {
            page = 1;
        } else if (page > totalPages) {
            page = totalPages;
        }

        int offset = (page - 1) * size;

        List<ProductDto> products = productService.findAllProductsPaging(offset, size);

        model.addAttribute("items", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "productlist";
    }
}