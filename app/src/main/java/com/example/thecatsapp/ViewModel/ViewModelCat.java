package com.example.thecatsapp.ViewModel;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.thecatsapp.Models.Cat;
import com.example.thecatsapp.data.ApiCats;

import java.util.List;

public class ViewModelCat extends AndroidViewModel {
    private MutableLiveData<List<Cat>> cats;
    private ApiCats apiCats;

    public ViewModelCat(@NonNull Application application) {
        super(application);
        apiCats = ApiCats.getInstance(application.getApplicationContext());
    }

    public LiveData<List<Cat>> getCats() {
        if (cats == null) {
            cats = new MutableLiveData<>();
            loadCats();
        }
        return cats;
    }

    private void loadCats() {
        apiCats.getCats(new ApiCats.VolleyResponseListener() {
            @Override
            public void onResponse(List<Cat> catList) {
                cats.setValue(catList);
            }

            @Override
            public void onError(String message) {
                // Handle error
            }
        });
    }
}
