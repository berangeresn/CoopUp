package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.Date;


@Entity(tableName = "articles",
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
                )
        })

public class Article implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private Date published;

    @NonNull
    private String title;

    @NonNull
    private String content;

    private byte image;

    @NonNull
    @ColumnInfo(name = "user_id")
    private String author;

    @ColumnInfo(name = "comment_id")
    private Comment comment;

    public Article(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Article setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public Date getPublished() {
        return published;
    }

    public Article setPublished(@NonNull Date published) {
        this.published = published;
        return this;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public Article setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public Article setContent(@NonNull String content) {
        this.content = content;
        return this;
    }

    public byte getImage() {
        return image;
    }

    public Article setImage(byte image) {
        this.image = image;
        return this;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public Article setAuthor(@NonNull String author) {
        this.author = author;
        return this;
    }

    public Comment getComment() {
        return comment;
    }

    public Article setComment(Comment comment) {
        this.comment = comment;
        return this;
    }

    public String serialize(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
