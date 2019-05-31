package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Job;
import repository.JobRepository;

public class JobViewModel extends AndroidViewModel {

    private JobRepository mRepository;
    private LiveData<Job> mAllJobs;

    public JobViewModel (Application application){
        super(application);
        mRepository = new JobRepository(application);
        mAllJobs = mRepository.getAllJobs();
    }

    LiveData<Job> getAllJobs(){
        return mAllJobs;
    }

    public void insert(Job job){
        mRepository.insert(job);
    }
}


