package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.JobDao;
import database.CoopUpRoomDatabase;
import entities.Job;

public class JobRepository {

    private JobDao mJobDao;
    private LiveData<Job> mAllJobs;

    public JobRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mJobDao = db.jobDao();
        mAllJobs = mJobDao.getAllJobs();
    }

    public LiveData<Job> getAllJobs() {
        return mAllJobs;
    }

    public void insert (Job job){
        new insertAsyncTask(mJobDao).execute(job);
    }

    private static class insertAsyncTask extends AsyncTask<Job, Void, Void> {

        private JobDao mAsyncTaskDao;

        insertAsyncTask(JobDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Job... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }



}
