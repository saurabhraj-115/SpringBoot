package com.wipro.springproj.app_api_data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Note that spring sees the embedded database and automatically asume that the Derby
// database is the database to be used. External database will be covered int the next proj

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    
    public List<Topic> getAllTopics(){
       
        List<Topic> topics = new ArrayList<Topic>();
        // findAll return an iterable, and we use the funtion on this iterable 
        // to say what action needs to be performed via forEach method 
        topicRepository.findAll().forEach(topics::add);

        return topics;

    }

    public Topic getTopic(String id){

        return topicRepository.findById(id).get();

        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        // topics.add(topic);

        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){

        // save method searches if there exists has an id matching, if yes then updte, else add
        topicRepository.save(topic);
        
    }

	public void deleteTopic(String id) {
        // topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
	}

	public String baseLine() {
        return "Welcome to the Base Page!!";
	}

    
}