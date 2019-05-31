package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Profile;
import repository.ProfileRepository;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository mRepository;
    private LiveData<Profile> mAllProfiles;

    public ProfileViewModel (Application application){
        super(application);
        mRepository = new ProfileRepository(application);
        mAllProfiles = mRepository.getAllProfiles();
    }

    LiveData<Profile> getAllProfiles(){
        return mAllProfiles;
    }

    public void insert(Profile profile){
        mRepository.insert(profile);
    }
}
