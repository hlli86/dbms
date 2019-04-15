package com.springboot.dao;

import com.springboot.domain.po.Patients;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Component
public interface PatientsMapper {
    int findId(String admissionnumber);
    int updatePatients(@Param("patients") Patients patients, @Param("id") int id);
    int findPatient_id(String admissionnumber);
    Patients findPatients(String admissionnumber);
    @Transactional
    int insertPatients(Patients patients);
}
