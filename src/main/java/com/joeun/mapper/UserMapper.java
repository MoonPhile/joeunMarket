package com.joeun.mapper;

import com.joeun.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    int insertUser(UserDTO user);

    Optional<UserDTO> selectById(String id);

}
