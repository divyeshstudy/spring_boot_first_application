package io.javabrains.springbootstarter.topic;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// The spring checks the classpath for this annotation and create the instance and then register it
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("Java","Java Core","Core Java Description"),
                new Topic("JavaScript","JavaScript","JavaScript Description"))
    );

    public List<Topic> getAllTopics(){
       // return topics;
        List<Topic> topics= new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){

        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return(topicRepository.findById(id).get());
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        //Optional<Object> result= topics.stream().filter(t->t.getId().equals(id)).findFirst().map(t->new Topic(topic.getId(),topic.getName(),topic.getDescription()));
       /* for (int i=0;i<topics.size();i++){
            Topic t=topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        topicRepository.save(topic);
        }


    public void deleteTopic(String id) {
    //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);

    }
}
