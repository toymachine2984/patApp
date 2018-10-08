package app.comp.service.interfaces;

import app.comp.entity.data.Krp;

public interface KrpService {


    Iterable<Krp> getAll();

    Krp save(Krp krp);
}
