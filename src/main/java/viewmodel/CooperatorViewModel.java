package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Cooperator;
import repository.CooperatorRepository;

public class CooperatorViewModel extends AndroidViewModel {

    private CooperatorRepository mRepository;
    private LiveData<Cooperator> mAllCooperators;

    public CooperatorViewModel (Application application){
        super(application);
        mRepository = new CooperatorRepository(application);
        mAllCooperators = mRepository.getmAllCooperators();
    }

    LiveData<Cooperator> getmAllCooperators(){
        return mAllCooperators;
    }

    public void insert(Cooperator cooperator){
        mRepository.insert(cooperator);
    }
}
