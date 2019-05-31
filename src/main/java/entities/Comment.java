package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "comments",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "user_id"
                ),
                @ForeignKey(
                        entity = Comment.class,
                        parentColumns = "id",
                        childColumns = "comment_id"
                ),
                @ForeignKey(
                        entity = Article.class,
                        parentColumns = "id",
                        childColumns = "article_id"
                )
        })
public class Comment {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @ColumnInfo(name = "user_id")
    private User user;

    @ColumnInfo(name = "comment_id")
    private Comment comment;

    @ColumnInfo(name = "article_id")
    @NonNull
    private Article article;



    public Comment(Long id, @NonNull String title, @NonNull String content, User user, Comment comment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public Comment setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public Comment setContent(@NonNull String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }

    public Comment getComment() {
        return comment;
    }

    public Comment setComment(Comment comment) {
        this.comment = comment;
        return this;
    }

    @NonNull
    public Article getArticle() {
        return article;
    }

    public Comment setArticle(@NonNull Article article) {
        this.article = article;
        return this;
    }
}
