package com.springboot.dao;

import com.springboot.domain.po.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UsersMapper {

    Users findByUsername(String username);
    int insert(Users users);
    /*int update(Users users);*/
}
