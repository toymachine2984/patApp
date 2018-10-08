package app.comp.service.interfaces;


import app.comp.entity.system.User;
import app.comp.entity.system.VerificationToken;
import app.comp.util.exceptions.EmailExistsException;

import java.util.Optional;


public interface UserService {


    <S extends User> S save(S s);


    User findById(Long aLong);


    Iterable<User> findAll();


    void deleteById(Long aLong);


    void delete(User user);

    User findUserByRevision(Long id, int revision);

    User registerNewUserAccount(User accountDto) throws EmailExistsException;

    boolean isLoginExist(String email);

    <S extends VerificationToken> S save(S entity);

    VerificationToken createVerificationToken(User user, String token);

    Optional<VerificationToken> findByTokenEquals(String token);

    Optional<VerificationToken> reissueVerificationToken(String token);

//    Optional<User> update(User s);

}
