package io.javabrains.springbootstarter.topic;


import org.springframework.data.repository.CrudRepository;

//No need to create a class as Spring JPA have all the methods implemented in CrudRepository for every entity class
public interface TopicRepository extends CrudRepository<Topic,String> {
}
