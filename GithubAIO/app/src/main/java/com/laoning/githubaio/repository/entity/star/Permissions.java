
package com.laoning.githubaio.repository.entity.star;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permissions {

    @SerializedName("admin")
    @ColumnInfo(name = "admin")
    private Boolean admin;

    @SerializedName("push")
    @ColumnInfo(name = "push")
    private Boolean push;


    @SerializedName("pull")
    @ColumnInfo(name = "pull")
    private Boolean pull;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getPush() {
        return push;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

    public Boolean getPull() {
        return pull;
    }

    public void setPull(Boolean pull) {
        this.pull = pull;
    }

}
