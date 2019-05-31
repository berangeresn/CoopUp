package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import dao.RecommendationDao;
import database.CoopUpRoomDatabase;
import entities.Recommendation;

public class RecommendationRepository {

    private RecommendationDao mRecommendationDao;
    private LiveData<List<Recommendation>> mAllRecommendations;

    public RecommendationRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mRecommendationDao = db.recommendationDao();
        mAllRecommendations = mRecommendationDao.getAllRecommendations();
    }

    public LiveData<List<Recommendation>> getmAllRecommendations() {
        return mAllRecommendations;
    }

    public void insert (Recommendation recommendation){
        new insertAsyncTask(mRecommendationDao).execute(recommendation);
    }

    private static class insertAsyncTask extends AsyncTask<Recommendation, Void, Void>{

        private RecommendationDao mAsyncTaskDao;

        insertAsyncTask(RecommendationDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Recommendation... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
