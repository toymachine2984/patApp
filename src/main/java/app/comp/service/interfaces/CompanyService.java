package app.comp.service.interfaces;

import app.comp.entity.data.Company;
import app.comp.util.ViewMessage.View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> findByBinContains(String bin);

    List<Company> findByNameRuContains(String name);

    Iterable<Company> findAll();

    Company findByBinEquals(String bin);

    Company findById(long id);


    void deleteCompanyById(long id);

    void deleteCompanyByBin(String bin);

    void deleteCompany(Company company);

    Company saveCompany(Company company);

    Page<Company> findAllByPage(Pageable pageable);

    Page<View.AJAXCompanyRu> findAllRuEnByPage(long regionId, Pageable pageable);


    Page<Company> findCompaniesByNameRuIsLikeAndBinLike(String nameRu, String bin, Pageable pageable);

}
