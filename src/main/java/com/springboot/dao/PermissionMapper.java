package com.springboot.dao;

import com.springboot.domain.po.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PermissionMapper {
    List<Permission> findUserPermissions(String userName);
}
