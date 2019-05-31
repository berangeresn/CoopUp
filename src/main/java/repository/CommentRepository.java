package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import dao.CommentDao;
import database.CoopUpRoomDatabase;
import entities.Comment;

public class CommentRepository {

    private CommentDao mCommentDao;
    private LiveData<List<Comment>> mAllComments;

    public CommentRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mCommentDao = db.commentDao();
        mAllComments = mCommentDao.getAllComments();
    }

    public LiveData<List<Comment>> getmAllComments(){
        return mAllComments;
    }

    public void insert (Comment comment){
        new insertAsyncTask(mCommentDao).execute(comment);
    }

    public static class insertAsyncTask extends AsyncTask<Comment, Void, Void>{

        private CommentDao mAsyncTaskDao;

        insertAsyncTask(CommentDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Comment... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
