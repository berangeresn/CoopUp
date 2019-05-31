package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.OfferMission;
import repository.OfferMissionRepository;

public class OfferMissionViewModel extends AndroidViewModel {

    private OfferMissionRepository mRepository;
    private LiveData<OfferMission> mAllOfferMissions;

    public OfferMissionViewModel (Application application){
        super(application);
        mRepository = new OfferMissionRepository(application);
        mAllOfferMissions = mRepository.getAllOfferMissions();
    }

    LiveData<OfferMission> getAllOfferMissions(){
        return mAllOfferMissions;
    }

    public void insert(OfferMission offerMission){
        mRepository.insert(offerMission);
    }

}
