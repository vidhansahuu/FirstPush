package BlogApp_Microservices.Comment.Payload;

public class Post {
private  String  postId;
private String title;
private String descriptiob;
private String content;

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

    public String getDescriptiob() {
        return descriptiob;
    }

    public void setDescriptiob(String descriptiob) {
        this.descriptiob = descriptiob;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
