package scd.lab.uni_sys.repository;

import scd.lab.uni_sys.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.profile WHERE s.studentId = :id")
    Optional<Student> findStudentWithProfile(@Param("id") int id);
}