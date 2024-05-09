package BlogApp_Microservices.controller;

import BlogApp_Microservices.PayLoad.PostDto;
import BlogApp_Microservices.entity.Post;
import BlogApp_Microservices.repository.PostRepository;
import BlogApp_Microservices.service.PostService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/Post")
public class PostController {
    private PostRepository postRepository;
    private PostService postService;

    public PostController(PostRepository postRepository, PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }
    @PostMapping("/createPost")
     public ResponseEntity<?>savePost(@RequestBody Post post){
       Post SavedPost = postService.createPost(post);
        return new ResponseEntity<>(SavedPost, HttpStatus.CREATED);

   }
@GetMapping("{postId}")// http://localhost:8081/api/Post/postId
  public ResponseEntity<Post> getPostById(@PathVariable String postId){//postId THIS IS UNIQUE STRING ID
    Post post = postService.postById(postId);
    return new ResponseEntity<>(post,HttpStatus.OK);

    }


    //http://localhost:8081/api/Post/{postId}/comments
    //(commentBreaker)-THIS NAME SHOULD BE SAME AS WE USE IN YML INSTANCE .. IN THE CONTROLLER LAYER
    // fallbackMethod-- THIS WILL Call THE METHOD WHEN THE SERVICE IS DOWN AND WE WILL RETURN A MESSAGE
   @GetMapping("{postId}/comments")                                             // WE CANT USE SAME URL MORE THAN ONE TIME WE WE DID / COMMENTS
   @CircuitBreaker(name = "commentBreaker",fallbackMethod = "commentFallback")  // WE HAVE TO USE CIRCUIT BREAKER ON THE METHOD  WHERE WE ARE CONNECTION THE MICROSERVICES WITH HELP OF REST TEMPLATE..
   public  ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId) {
      PostDto postDto = postService.getPostWithComments(postId);
      return  new ResponseEntity<>(postDto,HttpStatus.OK);

   }

   // THIS METHOD SHLUD RETURN SAME THINGS AS OF HANDLER METHOD
    // THIS METHOD SHLUD USE SAME METHOD ARGS AS OF HANDLER METHOD
    public  ResponseEntity<PostDto> commentFallback(String postId,Exception ex) { // WHEN COMMENT SERVICE IS DOWN THIS METHOD WILL BE CALLED.
        System.out.println("FALLBACK IS EXECUTED BECAUSE SERVICE IS DOWN:"+ ex.getMessage());
        ex.printStackTrace();

      PostDto postDto = new PostDto();// WE HAVE TO RETURN SAME OBJECT AS OF FALLBACK METHOD..
      postDto.setPostId("1234");
      postDto.setTitle("Server Down");
      postDto.setDescription("Server Down");
      return  new ResponseEntity<>(postDto,HttpStatus.BAD_REQUEST);
    }


}
// WHAT IS CIRCUIT BREAKER LIFE CYCLE ?
//THIS IS THRESH HOLD?
// WHAT IS CIRCUIT BREAKER?










