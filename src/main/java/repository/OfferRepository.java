package repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import dao.OfferDao;
import database.CoopUpRoomDatabase;
import entities.Offer;


public class OfferRepository {

    private OfferDao mOfferDao;
    private LiveData<List<Offer>> mAllOffers;

    public OfferRepository(Application application){
        CoopUpRoomDatabase db = CoopUpRoomDatabase.getDatabase(application);
        mOfferDao = db.offerDao();
        mAllOffers = mOfferDao.getAllOffers(application);
    }

    public LiveData<List<Offer>> getAllOffers(){
        return mAllOffers;
    }

    public void insert (Offer offer){
        new insertAsyncTask(mOfferDao).execute(offer);
    }

    private static class insertAsyncTask extends AsyncTask<Offer, Void, Void>{

        private OfferDao mAsyncTaskDao;

        insertAsyncTask(OfferDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Offer... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }
}
