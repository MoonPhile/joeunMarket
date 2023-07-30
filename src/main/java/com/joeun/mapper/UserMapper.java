package com.joeun.mapper;

import com.joeun.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int insertUser(User user);

    User selectById(String id);

    void updateUser(User user);

    int deleteById(String id);

    User searchIdPw(User user);

    void updateRank(Map<String, String> map);

    List<User> selectAllUser();
}
