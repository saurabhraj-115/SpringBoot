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

    private List <Topic> topics = new ArrayList<>( Arrays.asList(
        new Topic("01", "Ram", "Good"),
        new Topic("02", "Ram2", "Good2"),
        new Topic("03", "Ram3", "Good3"),
        new Topic("04", "Ram4", "Good4"),
        new Topic("05", "Ram5", "Good5"),
        new Topic("06", "Ram6", "Good6"),
        new Topic("07", "Ram7", "Good7")
    )
    );

    public List<Topic> getAllTopics(){
        // return topics;
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
        
        for(int i=0 ; i < topics.size() ; i++){
            Topic t = topics.get(i);
            if((t.getId()).equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

	public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
	}

	public String baseLine() {
        return "Welcome to the Base1 class!!";
	}

    
}