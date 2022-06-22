package ma.enset.facial_recognition_spring.security.repositories;

import ma.enset.facial_recognition_spring.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);

}
