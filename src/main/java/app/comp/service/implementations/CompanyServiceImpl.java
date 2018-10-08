package app.comp.service.implementations;


import app.comp.entity.data.Company;
import app.comp.repository.dataRepository.CompanyRepository;
import app.comp.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
@Transactional("dataEntityManager")
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public void setRepository(CompanyRepository repository) {
        this.companyRepository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findByBinContains(String bin) {
        return companyRepository.findByBinContains(bin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findByNameRuContains(String name) {
        return companyRepository.findByNameRuContains(name);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable("company")
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Company findByBinEquals(String bin) {
        return companyRepository.findByBinEquals(bin);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(long id) {
        return companyRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteCompanyById(long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void deleteCompanyByBin(String bin) {
        companyRepository.deleteByBinContains(bin);
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Company> findAllByPage(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Company> findCompaniesByNameRuIsLikeAndBinLike(String nameRu, String bin, Pageable pageable) {
       return companyRepository.findByNameRuContainingAndBinContaining(nameRu, bin, pageable);

    }
}
