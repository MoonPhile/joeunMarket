package com.joeun.mapper;

import com.joeun.dto.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface AdminMapper {

    /**
     *
     * @return - 회원정보 리스트
     */
    List<User> findAllUser();

}
