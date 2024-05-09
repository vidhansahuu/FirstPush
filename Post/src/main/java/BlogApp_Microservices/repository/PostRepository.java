package BlogApp_Microservices.repository;

import BlogApp_Microservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}

//1==CRUD REPOSITORY DOES NOT SUPPORT PAGINATION BUT JPA REPOSITORY SUPPORTS PAGINATION..
//2 IN CRUS FINDALL METHOD RETURNS ITERABLE BUT IN JPA REPOSITORY FINDALL METHOD RETURNS LIST OF ENTITY CLASS.