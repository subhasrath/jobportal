package com.subhas.jobportal.company.controller;


import com.subhas.jobportal.company.dto.CompanyDto;
import com.subhas.jobportal.company.entity.Company;
import com.subhas.jobportal.company.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:5173"})
public class CompanyController {
    private final CompanyService companyService;

//    public CompanyController(CompanyService companyService) {
//        this.companyService = companyService;
//    }

//    @GetMapping(version="1.0")
//    public ResponseEntity<String> getAllCompanies(){
//        return ResponseEntity.ok().body("Updated companies List");
//    }
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompany(){
        List<CompanyDto> allCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok().body(allCompanies);
    }
}
