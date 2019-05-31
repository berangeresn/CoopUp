package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Cooperator;
import entities.Skill;

@Dao
public interface SkillDao {

    //insérer skill
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Skill skill);

    //supprimer skills
    @Delete
    void delete(Skill skills);

    //modifier skill
    @Update
    void update(Skill skills);

    //tous les skills
    @Query("SELECT * FROM skills ORDER BY id ASC")
    LiveData<Skill> getAllSkills();

    //tous les skills par job
    @Query("SELECT * FROM skills WHERE id = job_id")
    public LiveData<Skill> findSkillsByJob(int jobId);

    //tous les skills par cooperateur
    @Query("SELECT * FROM skills WHERE id = cooperator_id")
    LiveData<Skill> getSkillsByCoop(int cooperatorId);


}
