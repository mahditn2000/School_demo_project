package ir.school.demo.controller;

import ir.school.demo.dto.StudentCourseCountDTO;
import ir.school.demo.entity.Course;
import ir.school.demo.entity.Student;
import ir.school.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student addStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.addStudentToCourse(studentId, courseId);
    }

    // @GetMapping("/{studentId}/courses")
    // public Courses getCourses(@PathVariable Long studentId) {
    // return studentService.getCourses(studentId);
    // }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
        List<Course> s = studentService.getCoursesByStudentId(studentId);
        System.err.println(s);
        return s;
    }

    @GetMapping("/repeated")
    public List<StudentCourseCountDTO> getStudentsWithMultipleEnrollments() {
        return studentService.getStudentsWithMultipleEnrollments();
    }

    
}
