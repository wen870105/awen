package com.wen.mongo.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "baggage")
public class Baggage {
    @Id
    private String  id;

    /**
     * 航司
     */
    @Field
    private String  carrier;

    /**
     * 起飞机场三字码
     */
    @Field(value = "dep_airport_code")
    private String  depAirportCode;

    /**
     * 起飞机场
     */
    @Field(value = "dep_airport")
    private String  depAirport;

    /**
     * 到达机场三字码
     */
    @Field(value = "arr_airport_code")
    private String  arrAirportCode;

    /**
     * 到达机场
     */
    @Field(value = "arr_airport")
    private String  arrAirport;

    /**
     * 打包规格:单位KG
     */
    @Field(value = "package_size")
    private Integer packageSize;

    /**
     * 行李规格:单位KG
     */
    @Field
    private Integer size;

    /**
     * 件数限制:单位件,默认值1
     */
    @Field
    private Integer pieces;

    /**
     * 是否所有行李重量,默认为false
     */
    @Field(value = "all_weight")
    private Boolean allWeight;

    /**
     * SSRcode
     */
    @Field(value = "ssr_code")
    private String  ssRcode;

    /**
     * 价格
     */
    @Field
    private Double  price;

    /**
     * 币种
     */
    @Field
    private String  currency;

    /**
     * 购买时效:单位小时,默认值-1,表示永久
     */
    @Field(value = "lastest_of_hour")
    private Integer lastestOfHour;

    /**
     * 销售类型:1售中,2售后
     */
    @Field(value = "sale_type")
    private Integer saleType;

    /**
     * 是否可用:true为可用,false为不可用
     */
    @Field
    private Boolean available;

    /**
     * 数据来源:gw,spider,admin
     */
    @Field(value = "from_source")
    private String  fromSource;

    /**
     * 是否可退 true 可以，false不可以
     */
    @Field(value = "can_refund")
    private Boolean canRefund;
    
    /**
     * 是否可单独退 true可以，false不可以 当canRefund =true时此节点必传
     */
    @Field(value = "can_refund_independent")
    private Boolean canRefundIndependent;
    
    /**
     * 退规则,最多允许200个字符
     */
    @Field(value = "refund_rule")
    private String  refundRule;
    
    /**
     * 是否可改 true 可以，false不可以
     */
    @Field(value = "can_modify")
    private Boolean canModify;
    
    /**
     * 是否可单独改 true可以，false不可以 当canModify =true时此节点必传
     */
    @Field(value = "can_modify_independent")
    private Boolean canModifyIndependent;
    
    /**
     * 改规则,最多允许200个字符
     */
    @Field(value = "modify_rule")
    private String  modifyRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDepAirportCode() {
        return depAirportCode;
    }

    public void setDepAirportCode(String depAirportCode) {
        this.depAirportCode = depAirportCode;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirportCode() {
        return arrAirportCode;
    }

    public void setArrAirportCode(String arrAirportCode) {
        this.arrAirportCode = arrAirportCode;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public Integer getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(Integer packageSize) {
        this.packageSize = packageSize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Boolean getAllWeight() {
        return allWeight;
    }

    public void setAllWeight(Boolean allWeight) {
        this.allWeight = allWeight;
    }

    public String getSsRcode() {
        return ssRcode;
    }

    public void setSsRcode(String ssRcode) {
        this.ssRcode = ssRcode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getLastestOfHour() {
        return lastestOfHour;
    }

    public void setLastestOfHour(Integer lastestOfHour) {
        this.lastestOfHour = lastestOfHour;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
