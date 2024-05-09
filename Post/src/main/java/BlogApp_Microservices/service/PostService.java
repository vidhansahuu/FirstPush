package BlogApp_Microservices.service;

import BlogApp_Microservices.Config.RestTemPlateConfig;
import BlogApp_Microservices.PayLoad.PostDto;
import BlogApp_Microservices.entity.Post;
import BlogApp_Microservices.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    private PostRepository postRepository;
    private RestTemPlateConfig restTemPlateConfig;

    public PostService(PostRepository postRepository, RestTemPlateConfig restTemPlateConfig) {
        this.postRepository = postRepository;
        this.restTemPlateConfig = restTemPlateConfig;
    }

    public Post createPost(Post post){
        String postId = UUID.randomUUID().toString();// THIS WILL ALSO GENERATE RANDOM String UNIQUE  ID IN DB..
        post.setId(postId);
        Post save = postRepository.save(post);
         return save;
    }

    public Post postById(String postid){
        Post post = postRepository.findById(postid).get();
          return post;

    }
 public PostDto getPostWithComments(String postId)   {                                           // IF IT RETURNS COMMENTS WE WILL USE COMMENT.CLASS
     ArrayList forObject = restTemPlateConfig.getRestTemplate().getForObject("http://COMMENT-SERVICE/api/comments/" + postId, ArrayList.class);// THIS WILL RETURN A LIST OF COMMENTS SO WE USE ARRAYLIST.CLASS
     Post post = postRepository.findById(postId).get();      // WE ARE RETURNING POST WITH COMMENT SO POST IS ALSO REQUIRED
     PostDto postDto = new PostDto(); //  NOW WE WILL SET THE  POST AND LIST OF COMMENT TO POSTDTO AND WILL RETURN IT BACK TO POSTMAN
     postDto.setPostId(post.getId());
     postDto.setCommentList(forObject);
     postDto.setContent(post.getContent());
     postDto.setDescription(post.getDescription());
     postDto.setTitle(post.getTitle());
    return  postDto;
 }


}
