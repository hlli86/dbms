package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface NationalityMapper {
    int findNationalityId(String natinality);
    String findNationality(int id);
}
