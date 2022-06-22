package ma.enset.facial_recognition_spring.repositories;

import ma.enset.facial_recognition_spring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
