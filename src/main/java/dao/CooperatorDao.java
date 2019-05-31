package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Cooperator;

@Dao
public interface CooperatorDao {

    //insérer cooperateurs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cooperator cooperators);

    //supprimer cooperateurs
    @Delete
    void delete(Cooperator cooperators);

    //modifier cooperateurs
    @Update
    void update(Cooperator cooperators);

    //tous les cooperateurs
    @Query("SELECT * FROM cooperators ORDER BY id ASC")
    LiveData<Cooperator> getAllCooperators();

    //tous les cooperateurs par nom ou prenom
    @Query("SELECT * FROM cooperators WHERE firstname LIKE :search " +
            "OR lastname LIKE :search")
    public LiveData<Cooperator> findCooperatorWithName(String search);

    //tous les cooperateurs par leur id
    @Query("SELECT * FROM cooperators WHERE id =:cooperatorId")
    LiveData<Cooperator> getCooperatorById(int cooperatorId);

    //tous les cooperators par leur categorie
    @Query("SELECT * FROM cooperators WHERE id =:categoryId")
    LiveData<Cooperator> getCooperatorByCategory(int categoryId);

    //tous les cooperateurs par ville
    @Query("SELECT * FROM cooperators WHERE city LIKE :search ")
    public LiveData<Cooperator> findCooperatorByCity(String search);

}
