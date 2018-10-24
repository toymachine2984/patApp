package app.comp.repository.dataRepository;

import app.comp.entity.data.Company;
import app.comp.util.ViewMessage.View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    List<Company> findByBinContains(String bin);

    List<Company> findByNameRuContains(String name);

    Company findByBinEquals(String bin);

    void deleteByBinContains(String bin);

    @Override
    Iterable<Company> findAll();

    @Override
    Page<Company> findAll(Pageable pageable);

    Page<View.AJAXCompanyKz> findAllBy(Pageable pageable);

    Page<View.AJAXCompanyRu> getAllBy(Pageable pageable);

    Page<Company> findByNameRuContainingAndBinContaining(String nameRu, String bin, Pageable pageable);
}
