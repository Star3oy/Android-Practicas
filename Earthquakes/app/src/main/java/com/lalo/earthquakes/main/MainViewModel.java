package com.lalo.earthquakes.main;


import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lalo.earthquakes.Earthquake;
import com.lalo.earthquakes.api.RequestStatus;
import com.lalo.earthquakes.api.StatusWithDescription;
import com.lalo.earthquakes.database.EqDatabase;


import java.util.List;
public class MainViewModel extends AndroidViewModel {

    public final MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        EqDatabase database = EqDatabase.getDatabase(application);
        repository = new MainRepository(database);
    }

    public LiveData<List<Earthquake>> getEqList(){
        return repository.getEqList();
    }

    public void downloadEarthquakes() {
        statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.LOADING,""));
        repository.downloadAndSaveEarthquakes(new MainRepository.DownloadStatusListener() {
            @Override
            public void downloadSuccess() {
                statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.DONE,""));
            }
            @Override
            public void downloadError(String message) {
                statusMutableLiveData.setValue(new StatusWithDescription(RequestStatus.LOADING, message));
            }
        });
    }

    private MutableLiveData<StatusWithDescription> statusMutableLiveData = new
            MutableLiveData<>();

    public LiveData<StatusWithDescription> getStatusMutableLiveData(){
        return statusMutableLiveData;
    }


}
