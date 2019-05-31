package dao;

import android.arch.lifecycle.LiveData;
import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Cooperator;
import entities.Profile;

@Dao
public interface ProfileDao {

    //insérer profils
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Profile profile);

    //supprimer profils
    @Delete
    void delete(Profile profile);

    //modifier profils
    @Update
    void update(Profile profile);

    //tous les profils
    @Query("SELECT * FROM profiles ORDER BY id ASC")
    LiveData<Profile> getAllProfiles();

    //tous les profils par leur categorie
    @Query("SELECT * FROM profiles WHERE id =:categoryId")
    LiveData<Profile> getProfileByCategory(int categoryId);

    //tous les profils par ville
    @Query("SELECT * FROM profiles WHERE city LIKE :search ")
    public LiveData<Profile> findProfileByCity(String search);

}

