package app.comp.service.implementations;


import app.comp.entity.data.Region;
import app.comp.repository.dataRepository.RegionRepository;
import app.comp.service.interfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("regionService")
@Transactional("dataEntityManager")
public class RegionServiceImpl implements RegionService {


    private RegionRepository regionRepository;

    @Autowired
    public void setRegionRepository(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

}
