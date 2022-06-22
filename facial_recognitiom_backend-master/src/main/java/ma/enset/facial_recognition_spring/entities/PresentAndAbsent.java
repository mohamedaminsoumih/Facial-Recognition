package ma.enset.facial_recognition_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PresentAndAbsent extends Student {
    private Etat etat;
}
