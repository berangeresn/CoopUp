package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Cooperator;
import entities.Job;

@Dao
public interface JobDao {

    //insérer jobs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Job jobs);

    //supprimer jobs
    @Delete
    void delete(Job jobs);

    //modifier jobs
    @Update
    void update(Job jobs);

    //tous les jobs
    @Query("SELECT * FROM jobs ORDER BY id ASC")
    LiveData<Job> getAllJobs();

    //tous les jobs par leur categorie
    @Query("SELECT * FROM jobs WHERE id =:categoryId")
    LiveData<Job> getJobByCategory(int categoryId);

    //tous les jobs par ville
    @Query("SELECT * FROM jobs WHERE city LIKE :search ")
    public LiveData<Cooperator> findCooperatorByCity(String search);

}

