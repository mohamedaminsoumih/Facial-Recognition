package ma.enset.facial_recognition_spring.repositories;

import ma.enset.facial_recognition_spring.entities.Present;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PresentRepository extends JpaRepository<Present,Long> {
    @Query("select p FROM Present p where p.date BETWEEN :t1 AND :t2")
    List<Present>findPresentsBetweenTwoDate(@Param("t1") Date t1,@Param("t2") Date t2 );
}
