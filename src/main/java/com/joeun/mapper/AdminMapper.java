package com.joeun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dto.UserResponse;

@Mapper
public interface AdminMapper {

    /**
     *
     * @return - 회원정보 리스트
     */
    List<UserResponse> findAllUser();

}
