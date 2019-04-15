package com.springboot.service.impl;

import com.springboot.domain.po.Patients;
import com.springboot.dao.PatientsMapper;
import com.springboot.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PatientsService")
public class PatientsServiceImpl implements PatientsService {
    @Autowired
    private PatientsMapper patientsMapper;
    @Override
    @Transactional
    public void insertPatients(Patients patients)
    {
      patientsMapper.insertPatients(patients);
    }

}
