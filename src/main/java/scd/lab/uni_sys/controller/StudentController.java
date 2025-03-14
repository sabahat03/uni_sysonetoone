package scd.lab.uni_sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import scd.lab.uni_sys.entities.Student;
import scd.lab.uni_sys.entities.StudentProfile;
import scd.lab.uni_sys.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Create a student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get student with profile
    @GetMapping("/{id}/with-profile")
    public ResponseEntity<Student> getStudentWithProfile(@PathVariable int id) {
        return studentService.getStudentWithProfile(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add profile to a student
    @PostMapping("/{id}/profile")
    public ResponseEntity<Student> addProfileToStudent(
            @PathVariable int id,
            @RequestBody StudentProfile profile) {
        Student updatedStudent = studentService.addProfileToStudent(id, profile);
        return ResponseEntity.ok(updatedStudent);
    }
}