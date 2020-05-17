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

    @RequestMapping("/topics/{topicID}/")
    public String basePage(){
       return courseService.baseLine();
    }

    @RequestMapping("/topics/{topicID}/courses")
    public List<Course> getAllCoursesString(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }
    
    @RequestMapping("/topics/{topicID}/courses/{courseId}")
    public Course getCourse(@PathVariable("courseId") String courseId){
       return courseService.getCourse(courseId);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicID}/courses/")
    public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }


    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicID}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId , @PathVariable("courseId") String courseId){
        course.setTopic(new Topic(topicId , "" , ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicID}/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId")  String courseId){
        courseService.deleteCourse(courseId);
    }
    
}

