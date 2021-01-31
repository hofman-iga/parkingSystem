package pl.hofman.parkingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.hofman.parkingSystem.model.UserDb;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDb,Integer> {
    Optional<UserDb> findByUserNameDb(String userNameDb);

}
