package ir.school.demo.service;

import ir.school.demo.dto.StudentCourseCountDTO;
import ir.school.demo.entity.Course;
import ir.school.demo.entity.Student;
import ir.school.demo.repository.CourseRepository;
import ir.school.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student addStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        course.getStudents().add(student);

        courseRepository.save(course);
        return studentRepository.save(student);
    }

    // public Courses getCourses(Long studentId) {
    // Student student = studentRepository.findById(studentId)
    // .orElseThrow(() -> new RuntimeException("Student not found"));

    // Set<Course> courses = courseRepository.
    // }

    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return student.getCourses();
    }

    public List<StudentCourseCountDTO> getStudentsWithMultipleEnrollments() {
        List<Object[]> results = studentRepository.findStudentsWithMultipleEnrollments();
        List<StudentCourseCountDTO> studentCourseCountDTOs = new ArrayList<>();

        for (Object[] result : results) {
            Student student = (Student) result[0];
            Course course = (Course) result[1];
            Long count = (Long) result[2];
            studentCourseCountDTOs.add(new StudentCourseCountDTO(student, course, count));
        }

        return studentCourseCountDTOs;
    }
}
