package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import entities.Offer;
import repository.OfferRepository;

public class OfferViewModel extends AndroidViewModel {

    private OfferRepository mRepository;
    private LiveData<List<Offer>> mAllOffers;

    public OfferViewModel (Application application){
        super(application);
        mRepository = new OfferRepository(application);
        mAllOffers = mRepository.getAllOffers();
    }

    LiveData<List<Offer>> getAllOffers(){
        return mAllOffers;
    }

    public void insert(Offer offer){
        mRepository.insert(offer);
    }
}
