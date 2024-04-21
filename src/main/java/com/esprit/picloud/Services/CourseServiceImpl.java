package com.esprit.picloud.Services;

import com.esprit.picloud.entities.Course;
import com.esprit.picloud.repositories.CourseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService{

        CourseRepo courseRepo;

    @Override
    public List<Course> retrieveCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course AddCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course UpdateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course retrieveCourse(String CourseID) {
        return courseRepo.findById(CourseID).orElse(null);
    }

    @Override
    public void DeleteCourse(String CourseID) {
        courseRepo.deleteById(CourseID);
    }
}
