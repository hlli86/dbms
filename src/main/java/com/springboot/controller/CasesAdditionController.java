package com.springboot.controller;


import com.springboot.api.ErrorCode;
import com.springboot.api.GetresponseMessage;
import com.springboot.api.InsertResponseMessage;
import com.springboot.api.ResponseMessage;
import com.springboot.dao.*;
import com.springboot.domain.po.*;
import com.springboot.service.PatientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CasesAdditionController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  NationalityMapper nationalityMapper;

    @Autowired
    private PatientsMapper patientsMapper;

    @Autowired
    private PatientsService patientsService;

    @Autowired
    private BasicCaseMapper basicCaseMapper;

    @Autowired
    private ComprehensiveCaseMapper comprehensiveCaseMapper;

    @Autowired
    private CtMapper ctMapper;

    @Autowired
    private ImagingReportMapper imagingReportMapper;

    @Autowired
    private  DiagnoseInfoMapper diagnoseInfoMapper;

    @PostMapping("/CasesAddition/findNationalityId")
    @ResponseBody
    public ResponseMessage findNationalityId(@RequestParam("nationality") String nationality)
    {
        if(!nationality.contains("族"))
            nationality=nationality+"族";
        int id = nationalityMapper.findNationalityId(nationality);
        if(id<0||id>57)
        {
            return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR, id + "not exists.");
        }
        return new InsertResponseMessage(id, ErrorCode.SUCCESS, "Insert data into patients success.");
    }

    @PostMapping("/CasesAddition/insertPatients")
    @ResponseBody
    public ResponseMessage insertPatients(@RequestBody Patients patients) {
        Patients p = patientsMapper.findPatients(patients.getAdmissionnumber());
        if (p == null) {
            //patientsMapper.insertPatients(patients);
            patientsService.insertPatients(patients);
            log.info("Patients表插入成功");
            Patients patients1 = patientsMapper.findPatients(patients.getAdmissionnumber());
            return new InsertResponseMessage(patients1.getId(), ErrorCode.SUCCESS, "Insert data into patients success.");
        }
        else {
            return new ResponseMessage(ErrorCode.PATIENT_EXIST_ERROR, "Patient" + patients.getAdmissionnumber() + " exists.");
        }
    }
    @PostMapping("/CasesAddition/insertBasicCase")
    @ResponseBody
    public ResponseMessage insertBasiccase(@RequestBody Basiccase basiccase) {
        basicCaseMapper .insertBasicCase(basiccase);
        log.info("BasicCase表插入成功");
        return new ResponseMessage(ErrorCode.SUCCESS, "Insert data into basic_case success.");
    }
    @PostMapping("/CasesAddition/insertComprehensiveCase")
    public ResponseMessage insertComprehensiveCase( @RequestBody ComprehensiveCase comprehensiveCase) {
         comprehensiveCaseMapper.insertComprehensiveCase(comprehensiveCase);
        log.info("ComprehensiveCase表插入成功");
        return new ResponseMessage(ErrorCode.SUCCESS, "Insert data into basic_case success.");
    }
    @PostMapping("/CasesAddition/insertRadiography")
    public ResponseMessage insertRadiography(@RequestBody ImagingReport imagingReport) {
        imagingReportMapper.insertImagingReport(imagingReport);
        log.info("ImagingReport表插入成功");
        return new ResponseMessage(ErrorCode.SUCCESS, "Insert data into ImagiNgReport success.");
    }
    @PostMapping("/CasesAddition/insertCT")
    public ResponseMessage insertCT(@RequestBody Ct_report ctReport) {
        ctMapper.insertCt(ctReport);
        log.info("CT表插入成功");
        return new ResponseMessage(ErrorCode.SUCCESS, "Insert data into  CT_report success.");
    }
    @PostMapping("/CasesAddition/insertDiagnoseInfo")
    public ResponseMessage insertDiagnoseInfo(@RequestBody Diagnose_info diagnose_info) {
         diagnoseInfoMapper.insertDiagnoseInfo(diagnose_info);
         log.info("diagnose_info表插入成功");
        return new InsertResponseMessage(1, ErrorCode.SUCCESS, "Insert data into diagnose_info success.");
    }
    @PostMapping("/CasesAddition/findNationality")
    public ResponseMessage findNationality(@RequestParam("id") int id) {
        String nationality =nationalityMapper.findNationality(id);
        if(id<0||id>57)
        {
            return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR, "名族 not exists.");
        }
        return new GetresponseMessage(nationality, ErrorCode.SUCCESS, "Get nationality success.");
    }
}
