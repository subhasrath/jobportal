package com.subhas.jobportal.company.service.impl;

import com.subhas.jobportal.company.dto.CompanyDto;
import com.subhas.jobportal.company.entity.Company;
import com.subhas.jobportal.company.repository.CompanyRepository;
import com.subhas.jobportal.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

//    public CompanyServiceImpl(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(this::transformToDto).collect(Collectors.toList());
    }
    private CompanyDto transformToDto(Company company) {
        return new CompanyDto(company.getId(),company.getName(),company.getLogo(),
                company.getIndustry(),company.getSize(),company.getRating(),company.getLocations(),
                company.getFounded(),company.getDescription(),company.getEmployees(),company.getWebsite(),company.getCreatedAt());
    }
}
