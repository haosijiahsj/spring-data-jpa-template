/*
 * @(#)ProductSale.java
 *
 * Copyright 2012 Xinhua Online, Inc. All rights reserved.
 */
package com.zzz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * description
 * @author QiuWei
 * @version 1.0
 * date 2014年6月26日 下午2:46:34
 */
@Entity
@Table(name = "rate_product_sale")
public class ProductSalePo implements Serializable{

	private static final long serialVersionUID = -2304080502155330094L;
	
	@Id
	private Long id;
	/**
	 * 商品名
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 产品id
	 */
	@Column(name = "productid")
	private Long productId;
	/**
	 * 外部id
	 */
	@Column(name = "sapcode")
	private String sapCode;
	/**
	 * 主数据系统商品id
	 */
	@Column(name = "merchid")
	private Long merchId;
	/**
	 * 销售定价
	 */
	@Column(name = "listprice")
	private BigDecimal listPrice;
	/**
	 * 基础价格
	 */
	@Column(name = "baiscprice")
	private BigDecimal baiscPrice;
	/**
	 * 进价价格
	 */
	@Column(name = "purchase")
	private BigDecimal purChase;
	/**
	 * MC分类
	 */
	@Column(name = "mccategory")
	private String mcCategory;
	
	/**
	 * 制造商
	 */
	@Column(name = "manufacturer")
	private String manufacturer;
	
	/**
	 * 供应商
	 */
	@JoinColumn(name = "vendor")
	private String vendor;
	/**
	 * 创建时间
	 */
	@Column(name = "createtime")
	private Date createtime;
	/**
	 * 更新时间
	 */
	@Column(name = "updatetime")
	private Date updatetime;
	
	/**
	 * 是否为套装书
	 */
	@Column
	private Integer complex;
	
	/**
	 * 子商品
	 */
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rate_product_complex",
            joinColumns = { @JoinColumn(name = "complex") },
            inverseJoinColumns = { @JoinColumn(name = "item") })
    private Set<ProductSalePo> complexItemList;
    
	/**
	 * 主商品
	 */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "rate_product_complex",
            joinColumns = { @JoinColumn(name = "item") },
            inverseJoinColumns = { @JoinColumn(name = "complex") })
    private Set<ProductSalePo> complexMasterList;

    public ProductSalePo() {
		super();
	}

	public ProductSalePo(Long id) {
		super();
		this.id = id;
	}
    
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the sapCode
	 */
	public String getSapCode() {
		return sapCode;
	}

	/**
	 * @param sapCode the sapCode to set
	 */
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	/**
	 * @return the merchId
	 */
	public Long getMerchId() {
		return merchId;
	}

	/**
	 * @param merchId the merchId to set
	 */
	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	/**
	 * @return the listPrice
	 */
	public BigDecimal getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the baiscPrice
	 */
	public BigDecimal getBaiscPrice() {
		return baiscPrice;
	}

	/**
	 * @param baiscPrice the baiscPrice to set
	 */
	public void setBaiscPrice(BigDecimal baiscPrice) {
		this.baiscPrice = baiscPrice;
	}

	/**
	 * @return the purChase
	 */
	public BigDecimal getPurChase() {
		return purChase;
	}

	/**
	 * @param purChase the purChase to set
	 */
	public void setPurChase(BigDecimal purChase) {
		this.purChase = purChase;
	}

	/**
	 * @return the mcCategory
	 */
	public String getMcCategory() {
		return mcCategory;
	}

	/**
	 * @param mcCategory the mcCategory to set
	 */
	public void setMcCategory(String mcCategory) {
		this.mcCategory = mcCategory;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getComplex() {
		return complex;
	}

	public void setComplex(Integer complex) {
		this.complex = complex;
	}

	public Set<ProductSalePo> getComplexItemList() {
		return complexItemList;
	}

	public void setComplexItemList(Set<ProductSalePo> complexItemList) {
		this.complexItemList = complexItemList;
	}

	public Set<ProductSalePo> getComplexMasterList() {
		return complexMasterList;
	}

	public void setComplexMasterList(Set<ProductSalePo> complexMasterList) {
		this.complexMasterList = complexMasterList;
	}

	/**
	 * @return 返回manufacturer
	 */
	
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 */
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return
	 */
			
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductSale [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", sapCode=");
		builder.append(sapCode);
		builder.append(", merchId=");
		builder.append(merchId);
		builder.append(", listPrice=");
		builder.append(listPrice);
		builder.append(", baiscPrice=");
		builder.append(baiscPrice);
		builder.append(", purChase=");
		builder.append(purChase);
		builder.append(", mcCategory=");
		builder.append(mcCategory);
		builder.append(", manufacturer=");
		builder.append(manufacturer);
		builder.append(", vendor=");
		builder.append(vendor);
		builder.append(", createtime=");
		builder.append(createtime);
		builder.append(", updatetime=");
		builder.append(updatetime);
		builder.append(", complex=");
		builder.append(complex);
		builder.append(", complexItemList=");
		builder.append(complexItemList);
		builder.append(", complexMasterList=");
		builder.append(complexMasterList);
		builder.append("]");
		return builder.toString();
	}

	public static ProductSalePo build(){
		return new ProductSalePo();
	}
}
