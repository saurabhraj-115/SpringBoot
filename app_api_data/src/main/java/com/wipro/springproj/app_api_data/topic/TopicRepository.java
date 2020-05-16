package com.wipro.springproj.app_api_data.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

     //  CrudRepository<what is the entity class we are working with, what is the id type that
    //   we are working with> (its a interface, and JPA has implemention for it)
    //  takes care of all basic implementations of Database management 
    // and has defined methods in it. We simply have to extend it
    //  and customise the Custom Repository we build (here TopicRepository).

    
    
}