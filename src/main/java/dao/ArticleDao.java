package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import entities.Article;
import entities.Cooperator;

@Dao
public interface ArticleDao {

    //insérer article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    //supprimer article
    @Delete
    void delete(Article article);

    //modifier article
    @Update
    void update(Article article);

    //tous les articles
    @Query("SELECT * FROM articles ORDER BY id ASC")
    LiveData<Article> getAllArticles();

    //tous les articles par date récente
    @Query(value = "SELECT * FROM articles WHERE published LIKE :search AND DESC")
    public LiveData<Article> findArticleWithDate(String search);



}

