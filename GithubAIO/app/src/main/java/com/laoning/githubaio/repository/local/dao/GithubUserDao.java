package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.laoning.githubaio.repository.entity.GithubUser;

import java.util.List;

/**
 * Created by laoning on 01/02/2018.
 */

@Dao
public interface GithubUserDao {
    @Query("SELECT * FROM github_user")
    LiveData<List<GithubUser>> loadUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(GithubUser account);

    @Delete()
    void deleteUser(GithubUser account);

    @Query("SELECT * FROM github_user WHERE login = :login")
    LiveData<GithubUser> findByLogin(String login);
}
