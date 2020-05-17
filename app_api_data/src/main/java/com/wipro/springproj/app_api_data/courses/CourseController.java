package com.wipro.springproj.app_api_data.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String basePage(){
       return courseService.baseLine();
    }

    @RequestMapping("/courses")
    public List<Course> getAllCoursesString(){
        return courseService.getAllCourses() ;
    }
    
    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
       return courseService.getCourse(id);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/courses")
    public void addCourse(@RequestBody Course topic){
        courseService.addCourse(topic);
    }


    @RequestMapping(method = RequestMethod.PUT , value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
    
}

