package entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "jobs")
public class Job implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String job;

    private String city;

    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;

    @ColumnInfo(name = "category_id")
    private Category category;

    public Job(Long id, String job, Cooperator cooperator, Category category) {
        this.id = id;
        this.job = job;
        this.cooperator = cooperator;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public Job setId(Long id) {
        this.id = id;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Job setJob(String job) {
        this.job = job;
        return this;
    }

    public Cooperator getCooperator() {
        return cooperator;
    }

    public Job setCooperator(Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Job setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Job setCity(String city) {
        this.city = city;
        return this;
    }
}
