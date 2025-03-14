package scd.lab.uni_sys.service;

import scd.lab.uni_sys.entities.Student;
import scd.lab.uni_sys.entities.StudentProfile;
import scd.lab.uni_sys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentWithProfile(int id) {
        return studentRepository.findStudentWithProfile(id);
    }

    public Student addProfileToStudent(int studentId, StudentProfile profile) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setProfile(profile);
        return studentRepository.save(student);
    }
}

