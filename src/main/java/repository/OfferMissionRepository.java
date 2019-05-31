package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.OfferMissionDao;
import database.CoopUpRoomDatabase;
import entities.OfferMission;

public class OfferMissionRepository {

    private OfferMissionDao mOfferMissionDao;
    private LiveData<OfferMission> mAllOfferMissions;

    public OfferMissionRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mOfferMissionDao = db.offerMissionDao();
        mAllOfferMissions = mOfferMissionDao.getAllOffersMissions();
    }

    public LiveData<OfferMission> getAllOfferMissions(){
        return mAllOfferMissions;
    }

    public void insert (OfferMission offerMission){
        new insertAsyncTask(mOfferMissionDao).execute(offerMission);
    }

    private static class insertAsyncTask extends AsyncTask<OfferMission, Void, Void>{

        private OfferMissionDao mAsyncTaskDao;

        insertAsyncTask(OfferMissionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(OfferMission... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


}
