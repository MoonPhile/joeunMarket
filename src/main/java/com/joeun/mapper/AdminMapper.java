package com.joeun.mapper;

import com.joeun.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     *
     * @return - 회원정보 리스트
     */
    List<User> findAllUser();

}
