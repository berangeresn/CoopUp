package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import dao.ProfileDao;
import database.CoopUpRoomDatabase;

import entities.Profile;

public class ProfileRepository {

    private ProfileDao mProfileDao;
    private LiveData<Profile> mAllProfiles;

    public ProfileRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mProfileDao = db.profileDao();
        mAllProfiles = mProfileDao.getAllProfiles();
    }

    public void insert (Profile profile){
        new insertAsyncTask((ProfileDao) mProfileDao).execute(profile);
    }

    public LiveData<Profile> getAllProfiles() {
        return mAllProfiles;
    }

    private static class insertAsyncTask extends AsyncTask<Profile, Void, Void> {

        private ProfileDao mAsyncTaskDao;

        insertAsyncTask(ProfileDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Profile... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }



    }
}


