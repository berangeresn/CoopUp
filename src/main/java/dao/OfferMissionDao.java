package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Cooperator;
import entities.OfferMission;

@Dao
public interface OfferMissionDao {

    //insérer Offre mission
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OfferMission offerMission);

    //supprimer offre mission
    @Delete
    void delete(OfferMission offerMission);

    //modifier offre mission
    @Update
    void update(OfferMission offerMission);

    //toutes les offres mission
    @Query("SELECT * FROM cooperators ORDER BY id DESC")
    LiveData<OfferMission> getAllOffersMissions();

    //toutes les offres mission par user
    @Query("SELECT * FROM offermissions WHERE user_id LIKE :search ")
    public LiveData<OfferMission> findOfferMissionByUser(String search);


}
