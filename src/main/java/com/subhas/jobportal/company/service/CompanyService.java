package com.subhas.jobportal.company.service;

import com.subhas.jobportal.company.dto.CompanyDto;
import com.subhas.jobportal.company.entity.Company;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();
}
