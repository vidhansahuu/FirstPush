package BlogApp_Microservices.PayLoad;

import java.util.List;

public class PostDto {  // WE CAN RETURN DATA FROM 2 DIFFERENT ENTITIES  BY USING DTO CLASS WITHOUT ALTERING OF  THE MAIN ENTITY CLASS.
    private String postId;
    private  String title;
    private  String description;
    private  String content;
     private List<Comment> commentList;  // WE HAVE TO CREATE A COMMENT LIST IN POST PROJECT SO WE CAN RETURN

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
