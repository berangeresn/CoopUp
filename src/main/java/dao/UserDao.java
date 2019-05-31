package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.User;

@Dao
public interface UserDao {

    //insérer users
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    //supprimer users
    @Delete
    void deleteUser(User users);

    //modifier users
    @Update
    void updateUser(User user);

    //tous les users
    @Query("SELECT * FROM users ORDER BY id ASC")
    List<User> getAllUsers();

    //tous les users par nom ou prenom
    @Query("SELECT * FROM users WHERE firstname LIKE :search " +
            "OR lastname LIKE :search")
    public List<User> findUserWithName(String search);

    //tous les users par leur id
    @Query("SELECT * FROM users WHERE id =:userId")
    List<User> getUserById(int userId);


}
