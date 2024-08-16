package ir.school.demo.repository;

import ir.school.demo.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s, c, COUNT(c) as courseCount " +
            "FROM Student s " +
            "JOIN s.courses c " +
            "GROUP BY s, c " +
            "HAVING COUNT(c) > 1")
    List<Object[]> findStudentsWithMultipleEnrollments();

}
