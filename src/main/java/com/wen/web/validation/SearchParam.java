package com.wen.web.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



/**
 * Created by zl48518 on 2017/7/12.
 */
public class SearchParam {
    @NotNull
    @Valid
    private User user;
    /**
     * 1 优选 2 特惠
     */
    @NotEmpty
    private String productType;
    /**
     * 行程类型，1：单程；2：往返
     */
    private String tripType;
    /**
     * 出发地城市 IATA 三字码代码
     */
    private String fromCity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
   
}
