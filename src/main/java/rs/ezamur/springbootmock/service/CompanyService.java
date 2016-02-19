package rs.ezamur.springbootmock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ezamur.springbootmock.entity.Company;
import rs.ezamur.springbootmock.repository.CompanyRepository;
import rs.ezamur.springbootmock.dto.CompanyDTO;
import rs.ezamur.springbootmock.dto.mapper.CompanyObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    protected CompanyRepository companyRepository;

    @Autowired
    protected CompanyObjectMapper objectMapper;

    public CompanyDTO saveOrUpdate(CompanyDTO dto) {
        Long id = dto.getCompanyId();
        Company company = null;
        if (id == null) {
            company = companyRepository.save(objectMapper.toEntity(dto));
        } else {
            company = companyRepository.findOne(id);
            company.update(dto);
            company = companyRepository.save(company);
        }

        return objectMapper.toDTO(company);
    }

    public List<CompanyDTO> findAll() {
        List<CompanyDTO> all;

        List<Company> companies = companyRepository.findAll();
        if (companies != null && !companies.isEmpty()) {
            all = new ArrayList<>(companies.size());
            for (Company c : companies) {
                all.add(objectMapper.toDTO(c));
            }
        } else {
            all = Collections.emptyList();
        }

        return all;
    }

    public CompanyDTO findOne(long id) {
        CompanyDTO dto = null;

        Company company = companyRepository.findOne(id);
        if (company != null) {
            dto = objectMapper.toDTO(company);
        }

        return dto;
    }

    public CompanyDTO addBeneficialOwners(long id, List<String> newOwners) {
        CompanyDTO dto = null;

        Company company = companyRepository.findOne(id);
        if (company != null) {
            company.getBeneficialOwners().addAll(newOwners);
            company = companyRepository.save(company);

            dto = objectMapper.toDTO(company);
        }

        return dto;
    }

}
