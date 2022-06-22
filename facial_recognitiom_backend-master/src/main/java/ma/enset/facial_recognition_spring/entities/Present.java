package ma.enset.facial_recognition_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Present {
    @Id
    private Long id;
    private String firstname;
    private  String lastname;
    private Date date;


}
