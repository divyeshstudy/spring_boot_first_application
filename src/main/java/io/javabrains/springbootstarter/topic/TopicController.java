package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    //Injects the service dependency,means it ask for the instance of this service
    @Autowired
    private TopicService topicService;

    //By default the method type is GET
    @RequestMapping("/topics")
    public List<Topic> getAllTipics(){
        return topicService.getAllTopics();
    }

    // @PathVariable -> tells spring that the id in argument must be the value suppied in the URI
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
         topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/topics/{foo}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable("foo") String id) {
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/topics/{foo}")
    public void deleteTopic(@PathVariable("foo") String id) {
        topicService.deleteTopic(id);
    }
}
