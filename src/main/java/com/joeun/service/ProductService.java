package com.joeun.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProduct(ProductDto product) {
        productMapper.addProduct(product);
    }

    public void addCategory(ProductCategoryDto category) {
        productMapper.addCategory(category);
    }

	public List<ProductDto> findAllProduct() {
		return productMapper.findAllProduct();
	}

	public List<ProductCategoryDto> findAllCategory() {
		return productMapper.findAllCategory();
	}

	public String uploadFile(MultipartFile file) {
		System.out.println("이미지 업로드");
		if (file.isEmpty()) {
			return "NULL";
		}
		String origName = file.getOriginalFilename();
		String savedPath = "C:/images/" + origName;
		File dest = new File(savedPath);
		try {
			file.transferTo(dest);
			return savedPath;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//        try{
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(savedPath+origName);
//            Files.write(path,bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
	}

	
	public List<ProductDto> findProductsByKeywordPaging(int offset, int size, String keyword) {
        return productMapper.findProductsByKeywordPaging(offset, size, keyword);
    }

	public List<ProductDto> findAllProductsPaging(int offset, int size) {
        return productMapper.findAllProductsPaging(offset, size);
    }
	public List<ProductDto> findProductsByKeywordPrice(int offset, int size, String keyword) {
        return productMapper.findProductsByKeywordPrice(offset, size, keyword);
    }

	public List<ProductDto> findAllProductsPrice(int offset, int size) {
        return productMapper.findAllProductsPrice(offset, size);
    }


	public List<Integer> findAllProductId(){
		return productMapper.findAllProductId();
	}

	public ProductDto findProductById(int productId){
		return productMapper.findProductById(productId);
	}

	public void updateProduct(ProductDto product){
		productMapper.updateProduct(product);
	}
}