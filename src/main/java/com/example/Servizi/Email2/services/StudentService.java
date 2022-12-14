package com.example.Servizi.Email2.services;

import com.example.Servizi.Email2.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    Student st1 = new Student("1", "Alessandro", "Serra", "alessandroserra233@gmail.com");
    Student st2 = new Student("2", "Tizio", "Rossi", "tiziomail@mail.com");
    Student st3 = new Student("3", "Caio", "Verdi", "caiomail@mail.com");
    Student st4 = new Student("4", "Sempronio", "Neri", "sempromail@mail.com");

    List<Student> classe = Arrays.asList(st1, st2, st4, st3);

    public Student getStudentById(String id){
        for (Student student : classe) {
            if (student.getId().equals(id)){
                return student;
            }
        }throw new RuntimeException("This Id don't exist in the db");
    }
}
