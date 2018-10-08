package app.comp.repository.dataRepository;

import app.comp.entity.data.Company;
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

//
//    @Query(value = "select  c.name_ru, c.bin,c.address,c.branch_ru, r.* from company as c " +
//            "left join region r on c.region_id = r.id " +
//            "where (c.name_ru like ?1) and (c.bin like ?2) order by ?#{#pageable}"
//            , nativeQuery = true)
//    Page<Company> dataTableOrdering(String nameRu, String bin, Pageable pageable);

    Page<Company> findByNameRuContainingAndBinContaining(String nameRu, String bin, Pageable pageable);
}
