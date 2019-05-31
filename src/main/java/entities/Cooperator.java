package entities;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;



@Entity(tableName = "cooperators",
        foreignKeys = {
                @ForeignKey(
                        entity = Recommendation.class,
                        parentColumns = "id",
                        childColumns = "reco_id"
                ),
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "user_id"
                )
        })

public class Cooperator extends User implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String lastname;

    @NonNull
    private String firstname;

    private String society;

    @NonNull
    private String city;

    @ColumnInfo(name = "reco_id")
    private Recommendation recommendation;

    @NonNull
    @ColumnInfo(name = "user_id")
    private User user;

    @NonNull
    @ColumnInfo(name = "profile_id")
    private Profile profile;

    public Cooperator(Long id, @NonNull String lastname, @NonNull String firstname, String society, Recommendation recommendation, @NonNull User user) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.society = society;
        this.recommendation = recommendation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Cooperator setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public Cooperator setLastname(@NonNull String lastname) {
        this.lastname = lastname;
        return this;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public Cooperator setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSociety() {
        return society;
    }

    public Cooperator setSociety(String society) {
        this.society = society;
        return this;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public Cooperator setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
        return this;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    public Cooperator setUser(@NonNull User user) {
        this.user = user;
        return this;
    }

    @NonNull
    public Profile getProfile() {
        return profile;
    }

    public Cooperator setProfile(@NonNull Profile profile) {
        this.profile = profile;
        return this;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public Cooperator setCity(@NonNull String city) {
        this.city = city;
        return this;
    }

    public String serialize(){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }


}
