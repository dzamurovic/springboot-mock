package rs.ezamur.springbootmock.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.ezamur.springbootmock.dto.CompanyDTO;
import rs.ezamur.springbootmock.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("rest/companies")
public class CompanyController {

    @Autowired
    protected CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CompanyDTO save(@RequestBody CompanyDTO companyDTO) {
        return companyService.saveOrUpdate(companyDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CompanyDTO update(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        companyDTO.setCompanyId(id);
        return companyService.saveOrUpdate(companyDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyDTO> findAll() {
        return companyService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CompanyDTO findOne(@PathVariable Long id) {
        return companyService.findOne(id);
    }

    @RequestMapping(value = "/{id}/owners", method = RequestMethod.POST)
    @ResponseBody
    public CompanyDTO addBeneficialOwners(@PathVariable Long id, @RequestBody List<String> newOwners) {
        return companyService.addBeneficialOwners(id, newOwners);
    }

}
