package com.example.Servizi.Email2.controllers;

import com.example.Servizi.Email2.entities.NotificationDTO;
import com.example.Servizi.Email2.entities.Student;
import com.example.Servizi.Email2.services.NotificationService;
import com.example.Servizi.Email2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class notificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notifications")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO payload){
        try {
            Student st = studentService.getStudentById(payload.getContactId());
            if (st == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find the Student");
            }
            notificationService.sendTo(st.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            System.out.println("Error in NotificationController: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
