package com.wipro.springproj.app_api_data.courses;


import java.util.List;
import com.wipro.springproj.app_api_data.topic.Topic;

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

    @RequestMapping("/topics/{topicId}/")
    public String basePage(){
       return courseService.baseLine();
    }

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCoursesString(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }
    
    @RequestMapping("/topics/{topicID}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
       return courseService.getCourse(courseId);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses/")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }


    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId , @PathVariable String courseId){
        course.setTopic(new Topic(topicId , "" , ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
    
}

