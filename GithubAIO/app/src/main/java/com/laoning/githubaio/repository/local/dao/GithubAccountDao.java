package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.laoning.githubaio.repository.entity.GithubAccount;

import java.util.List;

/**
 * Created by laoning on 01/02/2018.
 */

@Dao
public interface GithubAccountDao {

    @Query("SELECT * FROM github_account LIMIT 1")
    LiveData<GithubAccount> getFirstAccount();

    @Query("SELECT * FROM github_account")
    LiveData<List<GithubAccount>> loadAccounts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAccount(GithubAccount account);

    @Delete()
    void deleteAccount(GithubAccount account);
}
