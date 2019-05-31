package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Article;
import repository.ArticleRepository;

public class ArticleViewModel extends AndroidViewModel {


    private ArticleRepository mRepository;

    private LiveData<Article> mAllArticles;

    public ArticleViewModel (Application application){
        super(application);
        mRepository = new ArticleRepository(application);
        mAllArticles = mRepository.getAllArticles();
    }

    LiveData<Article> getAllArticles(){
        return mAllArticles;
    }

    public void insert(Article article){
        mRepository.insert(article);
    }
}
