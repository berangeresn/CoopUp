package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import database.CoopUpRoomDatabase;
import entities.Comment;
import repository.CommentRepository;

public class CommentViewModel extends AndroidViewModel {

    private CommentRepository mRepository;
    private LiveData<List<Comment>> mAllComments;

    public CommentViewModel (Application application){
        super(application);
        mRepository = new CommentRepository(application);
        mAllComments = mRepository.getmAllComments();

    }

    LiveData<List<Comment>> getmAllComments(){
        return mAllComments;
    }

    public void insert(Comment comment) {
        mRepository.insert(comment);

    }
}
