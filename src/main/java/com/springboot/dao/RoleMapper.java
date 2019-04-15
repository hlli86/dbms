package com.springboot.dao;

import com.springboot.domain.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {

    List<Role> findRoleByUsername(String username);
}
