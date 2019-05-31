package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import dao.ArticleDao;
import database.CoopUpRoomDatabase;
import entities.Article;

public class ArticleRepository {

    private ArticleDao mArticleDao;
    private LiveData<Article> mAllArticles;

    public ArticleRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mArticleDao = db.articleDao();
        mAllArticles = mArticleDao.getAllArticles();
    }

    public void insert (Article article){
        new insertAsyncTask((ArticleDao) mArticleDao).execute(article);
    }

    public LiveData<Article> getAllArticles() {
        return mAllArticles;
    }

    private static class insertAsyncTask extends AsyncTask<Article, Void, Void> {

        private ArticleDao mAsyncTaskDao;

        insertAsyncTask(ArticleDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Article... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }

}
