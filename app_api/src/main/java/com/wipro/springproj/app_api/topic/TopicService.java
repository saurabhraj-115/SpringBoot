package com.wipro.springproj.app_api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

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
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
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

        // for(int i=0 ; i < topics.size() ; i++){
        //     Topic t = topics.get(i);
        //     if((t.getId()).equals(id)){
        //         topics.remove(i);
        //         return;
        //     }
        // }
	}

    
}