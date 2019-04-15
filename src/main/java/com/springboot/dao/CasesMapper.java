package com.springboot.dao;


import com.springboot.domain.po.Cases;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CasesMapper {
    Cases findCasesByAdmissionnumber(String admissionnumber);
}
