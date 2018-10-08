package app.comp.repository.systemRepository;

import app.comp.entity.system.User;
import app.comp.entity.system.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {

    @Override
    <S extends VerificationToken> S save(S entity);

    Optional<VerificationToken> findByTokenEquals(String token);

    Optional<VerificationToken> findByUser(User user);


}
