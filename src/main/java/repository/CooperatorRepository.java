package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.CooperatorDao;
import database.CoopUpRoomDatabase;
import entities.Cooperator;

public class CooperatorRepository {

    private CooperatorDao mCooperatorDao;
    private LiveData<Cooperator> mAllCooperators;

    public CooperatorRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mCooperatorDao = db.cooperatorDao();
        mAllCooperators = mCooperatorDao.getAllCooperators();
    }

    public LiveData<Cooperator> getmAllCooperators(){
        return mAllCooperators;
    }

    public void insert (Cooperator cooperator){
        new CooperatorRepository(new insertAsyncTask(mCooperatorDao).execute(cooperator);
    }

    private static class insertAsyncTask extends AsyncTask<Cooperator, Void, Void> {

        private CooperatorDao mAsyncTaskDao;

        insertAsyncTask(CooperatorDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Cooperator... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
