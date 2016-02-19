package rs.ezamur.springbootmock.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO implements DTO {

    private Long companyId;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private List<String> beneficialOwners;

    public CompanyDTO() {
        beneficialOwners = new ArrayList<>(0);
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getBeneficialOwners() {
        return beneficialOwners;
    }

    public void setBeneficialOwners(List<String> beneficialOwners) {
        this.beneficialOwners = beneficialOwners;
    }
}
