package com.springboot.dao;

import com.springboot.domain.po.Diagnosis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DiagnosisMapper {
    List<Diagnosis> queryDiagnosis(String admissionnumber);
}
