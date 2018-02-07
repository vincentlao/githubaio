package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.repository.Repository;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Dao
public interface RepositoryDao {

    @Query("SELECT * FROM repository")
    LiveData<List<Repository>> load();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Repository repo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Repository> repos);

    @Delete()
    void delete(Repository repo);
}
