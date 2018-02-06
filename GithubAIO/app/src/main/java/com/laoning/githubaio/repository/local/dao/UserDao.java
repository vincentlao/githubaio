package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.laoning.githubaio.repository.entity.user.User;

import java.util.List;

/**
 * Created by laoning on 01/02/2018.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> loadUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User account);

    @Delete()
    void deleteUser(User account);

    @Query("SELECT * FROM user WHERE login = :login")
    LiveData<User> findByLogin(String login);
}
