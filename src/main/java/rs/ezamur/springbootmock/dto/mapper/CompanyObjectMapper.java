package rs.ezamur.springbootmock.dto.mapper;

import org.springframework.stereotype.Component;
import rs.ezamur.springbootmock.entity.Company;
import rs.ezamur.springbootmock.dto.CompanyDTO;

@Component
public class CompanyObjectMapper implements ObjectMapper<Company, CompanyDTO> {

    @Override
    public CompanyDTO toDTO(Company entity) {
        CompanyDTO dto = new CompanyDTO();

        dto.setAddress(entity.getAddress());
        dto.setBeneficialOwners(entity.getBeneficialOwners());
        dto.setCity(entity.getCity());
        dto.setCompanyId(entity.getId());
        dto.setCountry(entity.getCountry());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());

        return dto;
    }

    @Override
    public Company toEntity(CompanyDTO dto) {
        return new Company(dto);
    }

}
