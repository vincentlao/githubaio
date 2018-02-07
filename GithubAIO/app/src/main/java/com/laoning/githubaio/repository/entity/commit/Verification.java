
package com.laoning.githubaio.repository.entity.commit;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verification {

    @ColumnInfo(name = "verified")
    private Boolean verified;
    @ColumnInfo(name = "reason")
    private String reason;
    @ColumnInfo(name = "signature")
    private Object signature;
    @ColumnInfo(name = "payload")
    private Object payload;

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getSignature() {
        return signature;
    }

    public void setSignature(Object signature) {
        this.signature = signature;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

}
