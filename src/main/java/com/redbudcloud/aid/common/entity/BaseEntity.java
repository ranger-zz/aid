package com.redbudcloud.aid.common.entity;

import com.redbudcloud.aid.common.utils.Constants;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    //创建时间只能插入，不能更新
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false, updatable = false)
    protected Date createTime;
    //最进一次更新时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_time", nullable = false)
    protected Date lastUpdateTime;
    //删除时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delete_time", nullable = true)
    protected Date deleteTime;
    //信息状态 1:代表删除 0:default 未删除
    // logic_state = 1 if deleted
    @Column(name = "logic_state", nullable = false)
    protected Short logicState = Constants.ACTIVE_STATE;

    public BaseEntity() {
        Date now = new Date();
        createTime = now;
        lastUpdateTime = now;
        deleteTime = new Date(now.getTime() + 36500);
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdateTime = new Date();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Short getLogicState() {
        return logicState;
    }

    public void setLogicState(Short logicState) {
        this.logicState = logicState;
    }
}
