package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.net.UnknownServiceException;
import java.util.List;

import entities.User;
import repository.UserRepository;

public class UserViewModel extends AndroidViewModel {


    private UserRepository mRepository;
    private LiveData<List<User>> mAllUsers;

    public UserViewModel (Application application){
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getmAllUsers(){
        return mAllUsers;
    }

    public void insert(User user){
        mRepository.insert(user);
    }
}
