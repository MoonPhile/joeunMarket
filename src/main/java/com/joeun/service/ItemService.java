package com.joeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dto.Item;
import com.joeun.mapper.ItemMapper;

@Service
public class ItemService {
    
    private final ItemMapper itemMapper;

    // ItemMapper를 주입받는 생성자
    @Autowired
    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    // 아이템 목록 조회
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    // 아이템 상세 정보 조회
    public Item getItemById(long itemId) {
        return itemMapper.findById(itemId);
    }

    // 아이템 저장
    public void save(Item item) {
        itemMapper.save(item);
    }

    // 아이템 수정
    public void updateItem(Item item) {
        itemMapper.update(item);
    }

    // 아이템 삭제
    public void deleteItem(long itemId) {
        itemMapper.deleteById(itemId);
    }
}