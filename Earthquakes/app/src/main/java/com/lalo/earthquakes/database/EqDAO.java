package com.lalo.earthquakes.database;

import androidx.room.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lalo.earthquakes.Earthquake;
import java.util.List;

@Dao
public class EqDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Earthquake> eqList) {

    }

    @Query("SELECT * FROM earthquakes")
    LiveData<List<Earthquake>> getEarthquakes() {
        return null;
    }

    @Query("SELECT * FROM earthquakes WHERE magnitude > :mag")
    LiveData<List<Earthquake>> getEarthquakesWithMagnitudeAbove(double mag) {
        return null;
    }

    @Delete
    void deleteEarthquake(Earthquake earthquake) {

    }

    @Update
    void updateEarthquake(Earthquake earthquake) {

    }
}
