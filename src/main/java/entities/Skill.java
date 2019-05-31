package entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "skills")
public class Skill implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @NonNull
    private String skill;

    @NonNull
    @ColumnInfo(name = "cooperator_id")
    private Cooperator cooperator;

    @NonNull
    @ColumnInfo(name = "job_id")
    private Job job;



    public Long getId() {
        return id;
    }

    public Skill setId(Long id) {
        this.id = id;
        return this;
    }

    @NonNull
    public String getSkill() {
        return skill;
    }

    public Skill setSkill(@NonNull String skill) {
        this.skill = skill;
        return this;
    }

    @NonNull
    public Cooperator getCooperator() {
        return cooperator;
    }

    public Skill setCooperator(@NonNull Cooperator cooperator) {
        this.cooperator = cooperator;
        return this;
    }

    @NonNull
    public Job getJob() {
        return job;
    }

    public Skill setJob(@NonNull Job job) {
        this.job = job;
        return this;
    }
}
