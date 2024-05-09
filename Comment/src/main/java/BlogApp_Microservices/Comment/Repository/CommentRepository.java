package BlogApp_Microservices.Comment.Repository;

import BlogApp_Microservices.Comment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

   List<Comment> findByPostId(String postId);//findByPostId HERE POST ID IS THE COLUMN NAME PRESENT IS DATABASE AND HERE WE HAVE TO FOLLOW HE CONVENTION.
}                                            // HIBERNATE WILL CONVERT THIS METHOD INTO HQL QUERY AUTOMATICALLY.