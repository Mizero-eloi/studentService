package com.example.studentservice.controller;

import com.example.studentservice.model.Book;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentDao;
import com.example.studentservice.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentDao dao;

    @Autowired
    StudentRepository repo;

    @PostMapping("saveStudent")
    public void saveStudent (@RequestBody  Student student){
        dao.insertStudent(student);
    }

    @PostMapping("persistStudent")
    public void persistStudent (@RequestBody  Student student){
        repo.save(student);
    }

    @GetMapping("allStudent")
    public List<Student> getAllStudent(){
        return repo.findAll();
    }

    @GetMapping("getStudentById/{id}")
    public Student getStudentById(@PathVariable  long id){
        Optional<Student> byId = repo.findById(id);
        return  byId.get();
    }

    @GetMapping("getBooksById/{id}")
    public List<Book> getBooksById(@PathVariable Long id){
        Student byId =  repo.getById(id);
        return byId.getAllBooks();
        
    }
    @GetMapping("getBooksById")
    public List<Student> getAllBooks(){
        return repo.findAll();
    }


}
