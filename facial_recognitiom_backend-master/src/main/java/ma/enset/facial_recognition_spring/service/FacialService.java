package ma.enset.facial_recognition_spring.service;

import ma.enset.facial_recognition_spring.entities.DateStudent;
import ma.enset.facial_recognition_spring.entities.Present;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;

import java.util.Date;
import java.util.List;



public interface FacialService {
    List<Student>getAllStudent();

    List<Present> getAllPresent();

    List<Present>getAllPresentStudent(Date t1, Date t2);
    List<Student>getAllAbsentStudent(Date t1, Date t2);

    List<DateStudent> getAllPresents(Date t1, Date t2);

    List<PresentAndAbsent> getPresentsAndAbsent(Date t1, Date t2);
}
