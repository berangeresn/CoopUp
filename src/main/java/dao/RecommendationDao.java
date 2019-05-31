package dao;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Cooperator;
import entities.Recommendation;

@Dao
public interface RecommendationDao {

    //insérer recommandation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Recommendation recommendation);

    //supprimer recommandation
    @Delete
    void delete(Recommendation recommendation);

    //modifier recommandation
    @Update
    void update(Recommendation recommendation);

    //toutes les recommandations par user
    @Query("SELECT * FROM recommendations WHERE user_id LIKE :search ")
    public LiveData<Recommendation> findRecommendationByUser(String search);

    //toutes les recommandations par cooperateur
    @Query("SELECT * FROM recommendations WHERE id =:cooperatorId")
    LiveData<Recommendation> getRecommendationByCoop(int cooperatorId);

    //toutes les recos par profil
    @Query("SELECT * FROM cooperators WHERE id =:profileId")
    LiveData<Recommendation> getRecommendationByProfile(int profileId);

    @Query("SELECT * FROM recommendations")
    LiveData<List<Recommendation>> getAllRecommendations();


}

