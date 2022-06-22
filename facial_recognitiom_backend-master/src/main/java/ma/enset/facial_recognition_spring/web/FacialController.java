package ma.enset.facial_recognition_spring.web;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.DateStudent;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Stub;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
public class FacialController {
    FacialService facialService;
    @GetMapping("/absents")
    List<Student>getAbsents(@RequestParam(name = "t1") String t1,
                            @RequestParam(name = "t2") String t2) throws ParseException {

   List<Student>  absents=   facialService.getAllAbsentStudent( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));

       return  absents;
    }

    @GetMapping("/presents")
    List<DateStudent>getpresents(@RequestParam(name = "t1") String t1,
                                 @RequestParam(name = "t2") String t2) throws ParseException {
        List<DateStudent>  presents=   facialService.getAllPresents( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
        Collections.sort(presents, new Comparator<DateStudent>() {
            @Override
            public int compare(DateStudent o1, DateStudent o2) {
                return (o1.getStudent().getLastname()+" "+o1.getStudent().getFirstname()).compareTo(o2.getStudent().getLastname()+" "+o2.getStudent().getFirstname());
            }
        });
        return  presents;
    }

    @GetMapping("/presentsabsents")
    List<PresentAndAbsent> presentAndAbsents(@RequestParam(name = "t1", defaultValue = "0") String t1,
                                             @RequestParam(name = "t2", defaultValue = "0") String t2) throws ParseException {
        List<PresentAndAbsent> presentAndAbsentList = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));

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
