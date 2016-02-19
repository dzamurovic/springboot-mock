package rs.ezamur.springbootmock.entity;

import rs.ezamur.springbootmock.dto.CompanyDTO;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Company extends Entity<Long> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = false)
    @ElementCollection(targetClass = String.class)
    private List<String> beneficialOwners;

    public Company() {
        beneficialOwners = new ArrayList<>(0);
    }

    public Company(CompanyDTO dto) {
        long companyId = dto.getCompanyId() != null ? dto.getCompanyId() : 0;
        if (companyId != 0) {
            setId(companyId);
        }
        name = dto.getName();
        address = dto.getAddress();
        city = dto.getCity();
        country = dto.getCountry();
        email = dto.getEmail();
        phone = dto.getPhone();
        beneficialOwners = dto.getBeneficialOwners();
    }

    public void update(CompanyDTO dto) {
        name = dto.getName();
        address = dto.getAddress();
        city = dto.getCity();
        country = dto.getCountry();
        email = dto.getEmail();
        phone = dto.getPhone();
        beneficialOwners = dto.getBeneficialOwners();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getBeneficialOwners() {
        return beneficialOwners;
    }

}
