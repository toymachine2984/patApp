package app.comp.service.implementations;


import app.comp.entity.data.Krp;
import app.comp.repository.dataRepository.KrpRepository;
import app.comp.service.interfaces.KrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("krpService")
@Transactional("dataEntityManager")
public class KrpServiceImpl implements KrpService {


    private KrpRepository repository;


    @Autowired
    public void setRepository(KrpRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)

    public Iterable<Krp> getAll() {
        return repository.findAll();
    }

    @Override
    public Krp save(Krp krp) {
        return repository.save(krp);
    }

}
