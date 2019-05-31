package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import entities.Recommendation;
import repository.RecommendationRepository;

public class RecommendationViewModel extends AndroidViewModel {

    private RecommendationRepository mRepository;
    private LiveData<List<Recommendation>> mAllRecommendations;

    public RecommendationViewModel (Application application){
        super(application);
        mRepository = new RecommendationRepository(application);
        mAllRecommendations = mRepository.getmAllRecommendations();
    }

    LiveData<List<Recommendation>> getmAllRecommendations(){
        return mAllRecommendations;
    }

    public void insert(Recommendation recommendation){
        mRepository.insert(recommendation);
    }
}
