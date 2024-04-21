package com.esprit.picloud.EndPoints;

import com.esprit.picloud.Services.ICourseService;
import com.esprit.picloud.entities.Course;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Courses")
public class CourseEndPoint {
    ICourseService iCourseService;
    @GetMapping("/afficherCourses")
    public List<Course> retrieveCourses(){return iCourseService.retrieveCourses();}
    @PostMapping("/addCourse")
    public Course AddCourse(@RequestBody Course course){return iCourseService.AddCourse(course);}
    @PutMapping("/updateCourse")
    public Course UpdateCourse(@RequestBody Course course){return iCourseService.UpdateCourse(course);}
    @GetMapping("/retrievebyId/{CourseID}")
    public Course retrieveCourse(@PathVariable String CourseID){return iCourseService.retrieveCourse(CourseID);}
    @DeleteMapping("/delete/{CourseID}")
    public void DeleteCourse(@PathVariable String CourseID){ iCourseService.DeleteCourse(CourseID);}
}
