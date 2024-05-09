package BlogApp_Microservices.Comment.Service;

import BlogApp_Microservices.Comment.Config.ResttemplateConfig;
import BlogApp_Microservices.Comment.Entity.Comment;
import BlogApp_Microservices.Comment.Payload.Post;
import BlogApp_Microservices.Comment.Repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ResttemplateConfig restTemplate;  // REST TEMPLATE TO INTERACT WITH POST PROJECT..
    public CommentService(CommentRepository commentRepository, ResttemplateConfig restTemplate) {
        this.commentRepository = commentRepository;

        this.restTemplate = restTemplate;
    }
    // GETFOROBJECT WILL GO TO THIS URL AND GET THE POST ENTITY FROM OTHER PROJECT THEN WE WILL STORE THAT IN POST PAYLOAD.
    // HERE IN POST CONTROLLER WE ARE CALLING GET METHOD BASED ON POSTID.
    // USE POSTFOR OBJECT WHEN WE SUPPLY POST URL AND USE GETFOR OBJECT WHEN WE SUPPLY GET URL
    // WE WILL SUPPLY THE POST ID FROM POST MAN TO COMMENT ENTITY THEN TAKE THAT IN GET TEMPLATE.
    //+comment.getPostId()  WE WILL GET THIS ID FROM JSON WHICH WE WILL SUPPLU TO COMMENT CLASS
  public Comment addComment(Comment comment)  {
    Post post = restTemplate.getResttemplate().getForObject("http://localhost:8081/api/Post/"+comment.getPostId(), Post.class);
                                                                 // NOW INSTEAD OF USING URL WE CAN USE NAME OF APP AND NOW BY CHANGING PORT NUMBER
                                                     // IN YML FILE IT WILL CHANGER EVERYWHERE WE USE POST-SERVICE
    if(post!=null){

        String stringCommentId = UUID.randomUUID().toString();
        comment.setId(stringCommentId);
        Comment savedComment = commentRepository.save(comment);
         return savedComment;
    }else {
        return null;
    }
}

    public List<Comment> getAllCommentsByPostId(String postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);
         return byPostId;

    }
}