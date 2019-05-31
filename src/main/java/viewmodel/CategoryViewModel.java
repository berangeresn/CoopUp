package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import entities.Category;
import repository.CategoryRepository;

public class CategoryViewModel extends AndroidViewModel {

    private CategoryRepository mRepository;
    private LiveData<Category> mAllCategories;

    public CategoryViewModel(Application application){
        super(application);
        mRepository = new CategoryRepository(application);
        mAllCategories = mRepository.getAllCategories();
    }

    LiveData<Category> getAllCategories() {
        return mAllCategories;
    }

    public void insert (Category category) {
        mRepository.insert(category);
    }
}
