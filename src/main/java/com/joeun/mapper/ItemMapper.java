package com.joeun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dto.Item;

@Mapper
public interface ItemMapper {
    void save(Item item);
    Item findById(long id);
    void update(Item item);
    void deleteById(long id);
    List<Item> findAll();
}