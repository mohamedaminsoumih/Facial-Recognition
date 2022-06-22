package ma.enset.facial_recognition_spring.security.service;

import ma.enset.facial_recognition_spring.security.entities.AppRole;
import ma.enset.facial_recognition_spring.security.entities.AppUser;

//@ComponentScan(basePackages = {"ma.enset.patientsmvc.PatientsMvcApplication"})
public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
