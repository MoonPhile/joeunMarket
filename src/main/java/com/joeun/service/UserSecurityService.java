package com.joeun.service;

import com.joeun.config.UserRole;
import com.joeun.dto.User;
import com.joeun.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        Optional<User> user = this.userMapper.selectById(id);
        if(user == null){
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        User users = user.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(id)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new org.springframework.security.core.userdetails.User(users.getId(), users.getPassword(), authorities);
    }
}
