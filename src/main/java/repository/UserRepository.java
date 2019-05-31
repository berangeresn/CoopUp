package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import dao.UserDao;
import database.CoopUpRoomDatabase;
import entities.User;

public class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    public UserRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUsers = (LiveData<List<User>>) mUserDao.getAllUsers();
    }

    public void insert (User user){
        new insertAsyncTask(mUserDao).execute(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public static class insertAsyncTask extends AsyncTask<User, Void, Void>{

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }
}
