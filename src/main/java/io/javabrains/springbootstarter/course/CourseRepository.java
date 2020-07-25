package io.javabrains.springbootstarter.course;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

//No need to create a class as Spring JPA have all the methods implemented in CrudRepository for every entity class
public interface CourseRepository extends CrudRepository<Course,String> {

    // the menthod name identify the query
    public List<Course> findByTopicId(String topicId);
}
