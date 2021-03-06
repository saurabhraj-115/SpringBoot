package com.wipro.springproj.app_api_data.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Note that spring sees the embedded database and automatically asume that the Derby
// database is the database to be used. External database will be covered int the next proj

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
       
    public List<Course> getAllCourses(String topicId){    
            
        List<Course> courses = new ArrayList<Course>(); 
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;

    }

    public Course getCourse(String id){

        return courseRepository.findById(id).get();

        
    }

    public void addCourse(Course course){
        

        courseRepository.save(course);
    }

    public void updateCourse(Course course){

        
        courseRepository.save(course);
        
    }

	public void deleteCourse(String id) {
        
        courseRepository.deleteById(id);
	}





    
}