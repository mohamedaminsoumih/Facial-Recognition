package ma.enset.facial_recognition_spring.security.web;

import lombok.AllArgsConstructor;

import ma.enset.facial_recognition_spring.security.repositories.AppRoleRepository;
import ma.enset.facial_recognition_spring.security.repositories.AppUserRepository;
import ma.enset.facial_recognition_spring.security.service.SecurityService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class SecurityController {



   @RequestMapping("/login")
    public String loginPage(){
        return "login"; // retourne la vue loginp.html
    }
    @GetMapping("/403")
    public String notAuthorized(){
        return "403";
    }

}
