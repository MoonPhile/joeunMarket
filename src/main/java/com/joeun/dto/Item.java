package com.joeun.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private Long product_id;
    private String product_name;
    private String product_condition;
    private Long product_price;
    private String product_description;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Long product_category_id;

}