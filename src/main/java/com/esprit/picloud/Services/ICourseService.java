package com.esprit.picloud.Services;

import com.esprit.picloud.entities.Course;

import java.util.List;

public interface ICourseService {
    List<Course> retrieveCourses();
    Course AddCourse(Course course);
    Course UpdateCourse(Course course);
    Course retrieveCourse(String CourseID);
    void DeleteCourse(String CourseID);
}
