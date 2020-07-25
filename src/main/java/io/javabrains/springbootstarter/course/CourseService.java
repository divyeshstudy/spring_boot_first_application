package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// The spring checks the classpath for this annotation and create the instance and then register it
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

   /* private List<Course> topics = new ArrayList<>(Arrays.asList(
            new Course("Spring","Spring Framework","Spring Framework Description"),
                new Course("Java","Java Core","Core Java Description"),
                new Course("JavaScript","JavaScript","JavaScript Description"))
    );*/

    public List<Course> getAllCourses(String id){
       // return topics;
        /*List<Course> topics= new ArrayList<>();
        courseRepository.findAllById(id).forEach(Collectors.toList());
        return topics;*/
        List<Course> courses= new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){

        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return(courseRepository.findById(id).get());
    }

    public void addCourse(Course course) {
        //topics.add(topic);

        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        //Optional<Object> result= topics.stream().filter(t->t.getId().equals(id)).findFirst().map(t->new Topic(topic.getId(),topic.getName(),topic.getDescription()));
       /* for (int i=0;i<topics.size();i++){
            Topic t=topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        courseRepository.save(course);
        }


    public void deleteCourse(String id) {
    //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);

    }
}
