package com.andyadc.marketing.infrastructure.persistence.marketing.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class RaffleActivitySku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 商品sku - 把每一个组合当做一个商品
     */
    private Integer sku;
    /**
     * 活动ID
     */
    private Integer activityId;
    /**
     * 活动个人参与次数ID
     */
    private Integer activityCountId;
    /**
     * 商品库存
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityCountId() {
        return activityCountId;
    }

    public void setActivityCountId(Integer activityCountId) {
        this.activityCountId = activityCountId;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockCountSurplus() {
        return stockCountSurplus;
    }

    public void setStockCountSurplus(Integer stockCountSurplus) {
        this.stockCountSurplus = stockCountSurplus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
