package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.CategoryDao;
import database.CoopUpRoomDatabase;
import entities.Category;

public class CategoryRepository {

    private CategoryDao mCategoryDao;
    private LiveData<Category> mAllCategories;

    public CategoryRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mCategoryDao = db.categoryDao();
        mAllCategories = mCategoryDao.getAllCategories();
    }

    public LiveData<Category> getAllCategories(){
        return mAllCategories;
    }

    public void insert (Category category) {

        new insertAsyncTask(mCategoryDao).execute(category);
    }

    private static class insertAsyncTask extends AsyncTask<Category, Void, Void>{

        private CategoryDao mAsyncTaskDao;

        insertAsyncTask(CategoryDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Category... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
