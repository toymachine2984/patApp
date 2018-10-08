package app.comp.repository.dataRepository;

import app.comp.entity.data.Krp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KrpRepository extends CrudRepository<Krp, Long> {

    @Override
    Iterable<Krp> findAll();
}
