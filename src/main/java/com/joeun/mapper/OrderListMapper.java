package com.joeun.mapper;

import com.joeun.dto.OrderListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderListMapper {
    List<OrderListDto> getAllOrderLists();

}