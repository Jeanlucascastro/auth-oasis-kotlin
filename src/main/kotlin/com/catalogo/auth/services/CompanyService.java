package com.catalogo.auth.services;

import com.catalogo.auth.domain.Company;
import com.catalogo.auth.domain.DTO.CompanyDTO;
import com.catalogo.auth.exception.GenericException;
import com.catalogo.auth.repositories.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company saveCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = new Company(companyDTO.getName(), companyDTO.getDescription());
        return this.companyRepository.save(company);
    }

    public Company atualizarPorId(@PathVariable Long companyId, @RequestBody final CompanyDTO companyDTO) throws Exception {

        Company existingCompany = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrado com o ID: " + companyId));

        existingCompany.setName(companyDTO.getName());
        existingCompany.setDescription(companyDTO.getDescription());

        return companyRepository.save(existingCompany);
    }

    public Company deleteFisicamente(@PathVariable Long companyId) throws Exception {
        Company existingCompany = companyRepository.findById(companyId)
                    .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrado com o ID: " + companyId));
            existingCompany.setDeleted(true);
            return companyRepository.save(existingCompany);
    }

    public Page<Company> pesquisar(Pageable pageable, Boolean isPageable) throws Exception {
        if (isPageable) {
            return this.companyRepository.findAll(pageable);
        } else {
            return new PageImpl<>(this.companyRepository.findAll());
        }
    }

    public Company findbyId(Long id) {
        return this.companyRepository.findById(id).orElseThrow(() -> new GenericException("BC-0003"));
    }

}
