package app.comp.controller;


import app.comp.entity.data.Krp;
import app.comp.entity.data.Region;
import app.comp.service.interfaces.KrpService;
import app.comp.service.interfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/data")
public class DataController {

    private RegionService regionService;

    private KrpService krpService;


    @Autowired
    public void setKrpService(KrpService krpService) {
        this.krpService = krpService;
    }

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping(value = "/region")
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public Iterable<Region> getRegions() {
        return regionService.getAll();
    }


    @PostMapping(value = "/region", params = "form")
    public Region save(@Valid Region region) {
        return regionService.save(region);
    }


    @GetMapping(value = "/krp")
    @ResponseBody
    public Iterable<Krp> getKrps() {
        return krpService.getAll();
    }


    @PostMapping(value = "/krp", params = "form")
    public Krp save(@Valid Krp krp) {
        return krpService.save(krp);
    }


}
