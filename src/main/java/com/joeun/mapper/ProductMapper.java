package com.joeun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

	List<ProductDto> findAllProduct();
	
	List<ProductDto> findAllProductsPaging(@Param("offset") int offset, @Param("size") int size);
	
	List<ProductDto> findProductsByKeywordPaging(@Param("offset") int offset, @Param("size") int size, @Param("keyword") String keyword);
	
	List<ProductDto> findAllProductsPrice(@Param("offset") int offset, @Param("size") int size);
	
	List<ProductDto> findProductsByKeywordPrice(@Param("offset") int offset, @Param("size") int size, @Param("keyword") String keyword);
	


	List<Integer> findAllProductId();

	ProductDto findProductById(int productId);

	void updateProduct(ProductDto product);


// order 관련

	ProductDto getProductInfo(int productId);
}

