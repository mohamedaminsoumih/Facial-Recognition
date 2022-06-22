package ma.enset.facial_recognition_spring.security.repositories;

import ma.enset.facial_recognition_spring.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);

}
