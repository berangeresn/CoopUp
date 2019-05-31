package dao;

import android.arch.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Comment;
import entities.Cooperator;

@Dao
public interface CommentDao {

    //insérer commentaire
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Comment comments);

    //supprimer commentaires
    @Delete
    void delete(Comment comments);

    //modifier commentaire
    @Update
    void update(Comment comment);

    //tous les commentaires par article
    @Query("SELECT * FROM comments WHERE id = article_id")
    LiveData<Comment> getCommentsByArticle(int article_id);

    @Query("SELECT * FROM comments")
    LiveData<List<Comment>> getAllComments();
}
