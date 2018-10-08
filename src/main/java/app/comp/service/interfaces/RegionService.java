package app.comp.service.interfaces;


import app.comp.entity.data.Region;

public interface RegionService {


    Iterable<Region> getAll();
    Region save(Region region);

}
