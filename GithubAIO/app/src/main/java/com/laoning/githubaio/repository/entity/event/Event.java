
package com.laoning.githubaio.repository.entity.event;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import com.laoning.githubaio.repository.local.base.DateConverter;

import java.util.Date;

@Entity(tableName = "event")
@TypeConverters(DateConverter.class)
public class Event {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "type")
    private String type;

    @Embedded(prefix = "actor_")
    private Actor actor;

    @Embedded(prefix = "repo_")
    private Repo repo;

    @Embedded(prefix = "playload_")
    private Payload payload;

    @ColumnInfo(name = "public")
    private boolean _public;

    @ColumnInfo(name = "created_at")
    private String createdAt;

    @Embedded(prefix = "org_")
    private Org org;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public boolean getPublic() {
        return _public;
    }

    public void setPublic(boolean _public) {
        this._public = _public;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

}
