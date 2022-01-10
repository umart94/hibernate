package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the BILL database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long billid;

	private BigDecimal billamount;

	private String billdate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="SHOPID")
	private Shop shop;

	//bi-directional many-to-one association to Productsbought
	@OneToMany(mappedBy="bill", fetch=FetchType.EAGER)
	private List<Productsbought> productsboughts;

	public Bill() {
	}

	public long getBillid() {
		return this.billid;
	}

	public void setBillid(long billid) {
		this.billid = billid;
	}

	public BigDecimal getBillamount() {
		return this.billamount;
	}

	public void setBillamount(BigDecimal billamount) {
		this.billamount = billamount;
	}

	public String getBilldate() {
		return this.billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Productsbought> getProductsboughts() {
		return this.productsboughts;
	}

	public void setProductsboughts(List<Productsbought> productsboughts) {
		this.productsboughts = productsboughts;
	}

	public Productsbought addProductsbought(Productsbought productsbought) {
		getProductsboughts().add(productsbought);
		productsbought.setBill(this);

		return productsbought;
	}

	public Productsbought removeProductsbought(Productsbought productsbought) {
		getProductsboughts().remove(productsbought);
		productsbought.setBill(null);

		return productsbought;
	}

}