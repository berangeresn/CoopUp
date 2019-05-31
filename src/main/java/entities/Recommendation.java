package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "recommendations",
        foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "user_id"
        ),
        @ForeignKey(
                entity = Cooperator.class,
                parentColumns = "id",
                childColumns = "cooperator_id"
        )
})

public class Recommendation implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    @ColumnInfo(name = "user_id")
    private User user;

    @NonNull
    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;

    @NonNull
    private int rate;

    @ColumnInfo(name = "profile_id")
    private Profile profile;


    public Long getId() {
        return id;
    }

    public Recommendation setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public Recommendation setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public Recommendation setContent(@NonNull String content) {
        this.content = content;
        return this;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    public Recommendation setUser(@NonNull User user) {
        this.user = user;
        return this;
    }

    @NonNull
    public Cooperator getCooperator() {
        return cooperator;
    }

    public Recommendation setCooperator(@NonNull Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    public int getRate() {
        return rate;
    }

    public Recommendation setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public Profile getProfile() {
        return profile;
    }

    public Recommendation setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }
}
