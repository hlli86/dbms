package com.springboot.dao;

import com.springboot.domain.vo.PatientsInfo;
import com.springboot.domain.vo.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PatientsinfoMapper {
    List<PatientsInfo> queryPatientsInfo(QueryParam queryParam);
}
