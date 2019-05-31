package entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Entity(tableName = "categories",
        foreignKeys = {
                @ForeignKey(
                        entity = Job.class,
                        parentColumns = "id",
                        childColumns = "job_id"
                )
        })

public class Category {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String category;

    @ColumnInfo(name = "job_id")
    private Job job;

    public Category(Long id, String category, Job job) {
        this.id = id;
        this.category = category;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Category setCategory(String category) {
        this.category = category;
        return this;
    }

    public Job getJob() {
        return job;
    }

    public Category setJob(Job job) {
        this.job = job;
        return this;
    }

    public String serialize(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
