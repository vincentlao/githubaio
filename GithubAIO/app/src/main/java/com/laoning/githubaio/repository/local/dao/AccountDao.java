package com.laoning.githubaio.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.laoning.githubaio.repository.entity.Account;

import java.util.List;

/**
 * Created by laoning on 01/02/2018.
 */

@Dao
public interface AccountDao {

    @Query("SELECT * FROM account LIMIT 1")
    LiveData<Account> getFirstAccount();

    @Query("SELECT * FROM account")
    LiveData<List<Account>> loadAccounts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAccount(Account account);

    @Delete()
    void deleteAccount(Account account);
}
