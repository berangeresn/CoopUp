package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.SkillDao;
import database.CoopUpRoomDatabase;
import entities.Skill;

public class SkillRepository {

    private SkillDao mSkillDao;
    private LiveData<Skill> mAllSkills;

    public SkillRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mSkillDao = db.skillDao();
        mAllSkills = mSkillDao.getAllSkills();
    }

    public LiveData<Skill> getAllSkills() {
        return mAllSkills;
    }

    public void insert (Skill skill) {
        new insertAsyncTask(mSkillDao).execute(skill);
    }

    private static class insertAsyncTask extends AsyncTask<Skill, Void, Void>{

        private SkillDao mAsyncTaskDao;

        insertAsyncTask(SkillDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Skill... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


}
