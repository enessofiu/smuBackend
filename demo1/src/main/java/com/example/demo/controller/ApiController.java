package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.service.CourseService;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CourseService courseService;

    // Endpoints for Department
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}") // Get department by id endpoint
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public void removeDepartment(@PathVariable Long id) {
        departmentService.removeDepartment(id);
    }

    // Endpoints for Course
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}") // Add this method
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public void removeCourse(@PathVariable Long id) {
        courseService.removeCourse(id);
    }
}
