package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.star.Star;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Dao
public interface StarDao {

    @Query("SELECT * FROM star WHERE id in (:eventIds)")
    LiveData<List<Star>> loadByIdSync(List<Long> starredId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Star> stars);

    @Delete()
    void delete(List<Star> stars);
}
