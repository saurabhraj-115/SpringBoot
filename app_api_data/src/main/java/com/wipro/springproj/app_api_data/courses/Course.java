package com.wipro.springproj.app_api_data.courses;

import com.wipro.springproj.app_api_data.topic.Topic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//  import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne //So that the mapping of many courses to a given topic could be mapped and understood by SpringBoot
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.topic = new Topic(topicId, "", "");
    }
        
    

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return Topic return the topic
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}