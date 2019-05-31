package entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


import java.io.Serializable;

@Entity(tableName = "profiles",
        foreignKeys = {
                @ForeignKey(
                        entity = Category.class,
                        parentColumns = "id",
                        childColumns = "category_id"
                ),
                @ForeignKey(
                        entity = Cooperator.class,
                        parentColumns = "id",
                        childColumns = "cooperator_id"
                ),
                @ForeignKey(
                        entity = Job.class,
                        parentColumns = "id",
                        childColumns = "job_id"
                ),
                @ForeignKey(
                        entity = Skill.class,
                        parentColumns = "id",
                        childColumns = "skill_id"
                ),
                @ForeignKey(
                        entity = Recommendation.class,
                        parentColumns = "id",
                        childColumns = "reco_id"
                )
        })

public class Profile implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;

    @NonNull
    private String title;

    @NonNull
    private String email;

    private String website;

    @NonNull
    private String description;

    @NonNull
    private String city;

    @NonNull
    private String experience;

    private String education;

    private String language;

    private String social;

    @NonNull
    @ColumnInfo(name = "category_id")
    private Category category;

    @NonNull
    @ColumnInfo(name = "job_id")
    private Job job;

    @NonNull
    private int price;

    @ColumnInfo(name = "skill_id")
    @NonNull
    private Skill skills;

    @ColumnInfo(name = "reco_id")
    private Recommendation recommendation;


    public Long getId() {
        return id;
    }

    public Profile setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public Cooperator getCooperator() {
        return cooperator;
    }

    public Profile setCooperator(@NonNull Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public Profile setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public Profile setEmail(@NonNull String email) {
        this.email = email;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Profile setWebsite(String website) {
        this.website = website;
        return this;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public Profile setDescription(@NonNull String description) {
        this.description = description;
        return this;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public Profile setCity(@NonNull String city) {
        this.city = city;
        return this;
    }

    @NonNull
    public String getExperience() {
        return experience;
    }

    public Profile setExperience(@NonNull String experience) {
        this.experience = experience;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public Profile setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Profile setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getSocial() {
        return social;
    }

    public Profile setSocial(String social) {
        this.social = social;
        return this;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public Profile setCategory(@NonNull Category category) {
        this.category = category;
        return this;
    }

    @NonNull
    public Job getJob() {
        return job;
    }

    public Profile setJob(@NonNull Job job) {
        this.job = job;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Profile setPrice(int price) {
        this.price = price;
        return this;
    }

    @NonNull
    public Skill getSkills() {
        return skills;
    }

    public Profile setSkills(@NonNull Skill skills) {
        this.skills = skills;
        return this;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public Profile setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
        return this;
    }
}
