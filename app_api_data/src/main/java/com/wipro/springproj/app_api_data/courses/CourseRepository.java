package com.wipro.springproj.app_api_data.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	
/*
CrudRepository<what is the entity class we are working with, what is the id type that
we are working with> (its a interface, and JPA has implemention for it)
takes care of all basic implementations of Database management 
and has defined methods in it. We simply have to extend it
and customise the Custom Repository we build (here TopicRepository).
__________________________________________________________________
public List<Course> getCoursesByTopic(String topicId);
___________________________________________________________________
we can define like this but then we'll have to write the implementation.
we have the way to counter this problem by providing hints to CrudRepo by writing the 
name of the mehtod in a certain way. You won't need to define the method now, JPA will know 
by itself what the methods aims to find.

Format:

<visibility> <Type> findBy<Proprty>(List of arguments).

Thats it! Don't even need to define the method.

*/

public List<Course> findByTopicId(String topicId);
    
    
}