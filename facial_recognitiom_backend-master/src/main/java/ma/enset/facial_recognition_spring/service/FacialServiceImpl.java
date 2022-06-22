package ma.enset.facial_recognition_spring.service;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.*;
import ma.enset.facial_recognition_spring.repositories.PresentRepository;
import ma.enset.facial_recognition_spring.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static org.apache.coyote.http11.Constants.a;

@Service
@Transactional
@AllArgsConstructor
public class FacialServiceImpl implements FacialService {
    private PresentRepository presentRepository;
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public List<Present> getAllPresent() {
        List<Present> presents = presentRepository.findAll();
        return presents;
    }

    @Override
    public List<Present> getAllPresentStudent(Date t1,Date t2) {

        return presentRepository.findPresentsBetweenTwoDate(t1,t2);
    }

    @Override
    public List<Student> getAllAbsentStudent(Date t1, Date t2) {
        System.out.println("absents");
        List<Student>students=getAllStudent();
        List<Present>presents=getAllPresentStudent(t1,t2);
        List<Student> absents = new ArrayList<>();

       students.forEach(
               student -> {
                   int i=0;

                   for (int j=0;j<presents.size();j++){
                       String na1=presents.get(j).getFirstname();
                       String na2=student.getFirstname();

                       System.out.println(na2+"///"+na1);
                       if (student.getFirstname().equals(presents.get(j).getFirstname()) ){
                           System.out.println("pre°");
                           i++;
                       }
                   }
                   if(i==0){
                       System.out.println("ajouter"+i);
                       absents.add(student);
                   }

               }
       );

        Collections.sort(absents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getLastname()+" "+o1.getFirstname()).compareTo(o2.getLastname()+" "+o2.getFirstname());
            }
        });

        System.out.println(absents);

        return absents;
    }
    @Override
    public List<DateStudent> getAllPresents(Date t1, Date t2) {
        List<Student>students=getAllStudent();
        List<Present>presents=getAllPresentStudent(t1,t2);
        List<DateStudent> returnPresence = new ArrayList<>();

        students.forEach(
                student -> {
                    int i=0;
                    Date date=null;
                    for (int j=0;j<presents.size();j++){
                        String na1=presents.get(j).getFirstname();
                        String na2=student.getFirstname();

                        if (na2.equals(na1) ){
                            System.out.println("okokokokkokok");
                             date=presents.get(j).getDate();
                            i++;
                        }
                    }
                    if(i>0){
                        System.out.println("abs");

                        returnPresence.add( new DateStudent(student,date) );
                    }

                }
        );

        Collections.sort(returnPresence, new Comparator<DateStudent>() {
            @Override
            public int compare(DateStudent o1, DateStudent o2) {
                return (o1.getStudent().getLastname()+" "+o1.getStudent().getFirstname()).compareTo(o2.getStudent().getLastname()+" "+o2.getStudent().getFirstname());
            }
        });

        return returnPresence;
    }

    @Override
    public List<PresentAndAbsent> getPresentsAndAbsent(Date t1, Date t2) {
        List<PresentAndAbsent> presentAndAbsentList = new ArrayList<>();
        List<DateStudent> presents = getAllPresents(t1, t2);
        List<Student> absents = getAllAbsentStudent(t1, t2);
        presents.forEach(p->{
          PresentAndAbsent presentAndAbsent = new PresentAndAbsent();
          BeanUtils.copyProperties(p.getStudent(),presentAndAbsent);
          presentAndAbsent.setEtat(Etat.PRESENT);
          presentAndAbsentList.add(presentAndAbsent);
        });
        absents.forEach(p->{
            PresentAndAbsent presentAndAbsent = new PresentAndAbsent();
            BeanUtils.copyProperties(p,presentAndAbsent);
            presentAndAbsent.setEtat(Etat.ABSENT);
            presentAndAbsentList.add(presentAndAbsent);
        });
        Collections.sort(presentAndAbsentList, new Comparator<PresentAndAbsent>() {
            @Override
            public int compare(PresentAndAbsent o1, PresentAndAbsent o2) {
                return (((PresentAndAbsent)o1).getLastname()+" "+o1.getFirstname())
                        .compareTo(((PresentAndAbsent)o2).getLastname()+" "+o2.getFirstname());
            }
        });
        return presentAndAbsentList;
    }
}
