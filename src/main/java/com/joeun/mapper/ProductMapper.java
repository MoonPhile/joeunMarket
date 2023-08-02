package com.joeun.mapper;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 
     * @param product - 등록할 상품 정보
     */
    void addProduct(ProductDto product);

    void addCategory(ProductCategoryDto category);

    List<ProductCategoryDto> findAllCategory();

    List<ProductDto> findAll();
    
}
