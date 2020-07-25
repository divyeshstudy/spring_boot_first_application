package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    //Injects the service dependency,means it ask for the instance of this service
    @Autowired
    private CourseService courseService;

    //By default the method type is GET
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    // @PathVariable -> tells spring that the id in argument must be the value suppied in the URI
    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId ){

        //wrong logic.Just to understand added here
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/topics/{foo}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable("foo") String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/topics/{foo}/courses/{courseId}")
    public void deleteCourse(@PathVariable("foo") String courseId) {
        courseService.deleteCourse(courseId);
    }
}
