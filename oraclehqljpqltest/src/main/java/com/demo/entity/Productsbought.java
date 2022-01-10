package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTSBOUGHT database table.
 * 
 */
@Entity
@NamedQuery(name="Productsbought.findAll", query="SELECT p FROM Productsbought p")
public class Productsbought implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productboughtid;

	private BigDecimal productboughtquantity;

	private BigDecimal productcharges;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="BILLID")
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	public Productsbought() {
	}

	public long getProductboughtid() {
		return this.productboughtid;
	}

	public void setProductboughtid(long productboughtid) {
		this.productboughtid = productboughtid;
	}

	public BigDecimal getProductboughtquantity() {
		return this.productboughtquantity;
	}

	public void setProductboughtquantity(BigDecimal productboughtquantity) {
		this.productboughtquantity = productboughtquantity;
	}

	public BigDecimal getProductcharges() {
		return this.productcharges;
	}

	public void setProductcharges(BigDecimal productcharges) {
		this.productcharges = productcharges;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}