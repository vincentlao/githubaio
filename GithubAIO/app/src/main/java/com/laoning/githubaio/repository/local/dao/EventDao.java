package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.laoning.githubaio.repository.entity.EventForUser;
import com.laoning.githubaio.repository.entity.event.Event;
import com.laoning.githubaio.repository.entity.user.User;

import java.util.List;

/**
 * Created by laoning on 06/02/2018.
 */

@Dao
public interface EventDao {

    @Query("SELECT * FROM event_for_user WHERE user_and_page = :userAndPage")
    LiveData<EventForUser> loadEventIdsByUserAndPage(String userAndPage);

    @Query("SELECT * FROM event_for_user WHERE user_and_page = :userAndPage")
    EventForUser loadEventIdsByUserAndPageSync(String userAndPage);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EventForUser events);


    @Query("SELECT * FROM event WHERE id in (:eventIds)")
    LiveData<List<Event>> loadById(List<Integer> eventIds);

    @Query("SELECT * FROM event WHERE id in (:eventIds)")
    List<Event> loadByIdSync(List<Long> eventIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Event event);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEvents(List<Event> events);

    @Delete()
    void delete(Event event);
}
