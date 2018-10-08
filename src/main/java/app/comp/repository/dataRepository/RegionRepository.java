package app.comp.repository.dataRepository;

import app.comp.entity.data.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

    @Override
    Iterable<Region> findAll();
}
