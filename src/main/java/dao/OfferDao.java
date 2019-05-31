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
import entities.Offer;

@Dao
public interface OfferDao {

    //insérer offres
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Offer offers);

    //supprimer offres
    @Delete
    void delete(Offer offers);

    //modifier offres
    @Update
    void update(Offer offers);

    //toutes les offres par cooperateur
    @Query(value = "SELECT * FROM offers WHERE id =cooperator_id")
    public LiveData<Offer> findOfferByCoop(int cooperatorId);

     //tous les offres par leur offre de mission
    @Query("SELECT * FROM offers WHERE id = offermission_id")
    LiveData<Offer> getOffersByOfferMissions(int offerMissionId);

    @Query("SELECT * FROM offers")
    LiveData<List<Offer>> getAllOffers(Application application);
}
