package BlogApp_Microservices.Comment.Controller;

import BlogApp_Microservices.Comment.Entity.Comment;
import BlogApp_Microservices.Comment.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
 @PostMapping("/createComment")
  public ResponseEntity<Comment>createComment(@RequestBody Comment comment)  {
      Comment savedComment = commentService.addComment(comment);
       return new ResponseEntity<>(savedComment, HttpStatus.CREATED);

  }
 @GetMapping("{postId}")  // THIS METHOD WILL RETURN ALL COMMENTS DETAILS BASED ON POST ID BUT IT SHOULD BE PRESENT IN COMMENTS DB AND FINDBYPOSTID() THIS MWTHOD WE HAVE TO CREATE MANUALLY IN COMMENT REPOSITORY
    public ResponseEntity<List<Comment>> getAllCommenByPostId(@PathVariable String postId){
     List<Comment> allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
     return new ResponseEntity<>(allCommentsByPostId,HttpStatus.OK);

 }

}
