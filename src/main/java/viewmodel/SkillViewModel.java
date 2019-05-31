package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Skill;
import repository.SkillRepository;

public class SkillViewModel extends AndroidViewModel {

    private SkillRepository mRepository;
    private LiveData<Skill> mAllSkills;

    public SkillViewModel (Application application){
        super(application);
        mRepository = new SkillRepository(application);
        mAllSkills = mRepository.getAllSkills();
    }

    LiveData<Skill> getAllSkills(){
        return mAllSkills;
    }

    public void insert(Skill skill){
        mRepository.insert(skill);
    }
}
