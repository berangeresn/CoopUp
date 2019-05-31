package entities;

import android.os.Build;
import android.support.annotation.RequiresApi;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;



@Entity(tableName = "Users",
        foreignKeys = {
        @ForeignKey(
                entity = Recommendation.class,
                parentColumns = "id",
                childColumns = "reco_id"
        ),
        @ForeignKey(
                entity = Cooperator.class,
                parentColumns = "id",
                childColumns = "cooperator_id"
        )
})
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;

    @NonNull
    private String lastname;

    @NonNull
    private String firstname;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String society;

    @ColumnInfo(name = "reco_id")
    private Recommendation recommendation;

    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;




    @NonNull
    public Long getId() {
        return id;
    }

    public User setId(@NonNull Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public User setLastname(@NonNull String lastname) {
        this.lastname = lastname;
        return this;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
        return this;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public User setEmail(@NonNull String email) {
        this.email = email;
        return this;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public User setPassword(@NonNull String password) {
        this.password = password;
        return this;
    }

    public String getSociety() {
        return society;
    }

    public User setSociety(String society) {
        this.society = society;
        return this;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public User setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
        return this;
    }

    public Cooperator getCooperator() {
        return cooperator;
    }

    public User setCooperator(Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    public String serialize(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

}
