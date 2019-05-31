package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Category;
import entities.Cooperator;

@Dao
public interface CategoryDao {

    //insérer categories
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Category categories);

    //supprimer categories
    @Delete
    void delete(Category categories);

    //modifier categories
    @Update
    void update(Category categories);

    //toutes les categories
    @Query("SELECT * FROM categories ORDER BY id ASC")
    LiveData<Category> getAllCategories();

      //toutes les categories par jobs
    @Query("SELECT * FROM categories WHERE id = job_id")
    LiveData<Category> getCategoryByJob(int jobId);




}
