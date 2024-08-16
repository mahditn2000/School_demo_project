package ir.school.demo.dto;

import ir.school.demo.entity.Course;
import ir.school.demo.entity.Student;

public class StudentCourseCountDTO {
    private Student student;
    private Course course;
    private Long count;

    public StudentCourseCountDTO(Student student, Course course, Long count) {
        this.student = student;
        this.course = course;
        this.count = count;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}