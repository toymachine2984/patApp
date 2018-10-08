package app.comp.service.interfaces;


import app.comp.entity.system.Role;


public interface RoleService {


    Role save(Role role);

    Role findById(Long aLong);

    Iterable<Role> findAll();

    void deleteById(Long aLong);

    void delete(Role role);

}
