package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course newCourseData) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setTitle(newCourseData.getTitle());
            existingCourse.setCredits(newCourseData.getCredits());
            existingCourse.setSchedule(newCourseData.getSchedule());
            existingCourse.setLecturer(newCourseData.getLecturer());
            existingCourse.setClassroomLocation(newCourseData.getClassroomLocation());
            return courseRepository.save(existingCourse);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }

    public Course getCourseById(Long id) {  // Add this method
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }
}
