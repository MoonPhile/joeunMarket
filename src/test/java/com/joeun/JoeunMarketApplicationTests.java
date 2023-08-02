package com.joeun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joeun.dto.ProductCategoryDto;
import com.joeun.dto.ProductDto;
import com.joeun.mapper.ProductMapper;

@SpringBootTest
class JoeunMarketApplicationTests {

	@Autowired
	ProductMapper productMapper;
	@Test
	void contextLoads() {
	}

	@Test
	void addProductTest(){
		ProductDto product = new ProductDto();
		ProductCategoryDto categoryDto = new ProductCategoryDto();
		categoryDto.setProductCategoryName("테스트카테고리");
		product.setProductId(1);
		product.setProductName("test상품");
		product.setProductCondition("컨디션");
		product.setProductPrice(1000);
		product.setProductDescription("상품 설명");
		product.setImg1("이미지경로1");
		product.setImg2("이미지경로2");
		product.setImg3("이미지경로3");
		product.setImg4("이미지경로4");
		product.setProductCategoryId(1);
		productMapper.addCategory(categoryDto);
		productMapper.addProduct(product);
	}

}
