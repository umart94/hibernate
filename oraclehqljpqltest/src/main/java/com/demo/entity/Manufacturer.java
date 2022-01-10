package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MANUFACTURERS database table.
 * 
 */
@Entity
@Table(name="MANUFACTURERS")
@NamedQuery(name="Manufacturer.findAll", query="SELECT m FROM Manufacturer m")
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long manufacturerid;

	private String manufactureraddress;

	private String manufactureremailaddress;

	private String manufacturermobilenumber;

	private String manufacturername;

	private String manufacturertelephonenumber;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="manufacturer", fetch=FetchType.EAGER)
	private List<Product> products;

	public Manufacturer() {
	}

	public long getManufacturerid() {
		return this.manufacturerid;
	}

	public void setManufacturerid(long manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

	public String getManufactureraddress() {
		return this.manufactureraddress;
	}

	public void setManufactureraddress(String manufactureraddress) {
		this.manufactureraddress = manufactureraddress;
	}

	public String getManufactureremailaddress() {
		return this.manufactureremailaddress;
	}

	public void setManufactureremailaddress(String manufactureremailaddress) {
		this.manufactureremailaddress = manufactureremailaddress;
	}

	public String getManufacturermobilenumber() {
		return this.manufacturermobilenumber;
	}

	public void setManufacturermobilenumber(String manufacturermobilenumber) {
		this.manufacturermobilenumber = manufacturermobilenumber;
	}

	public String getManufacturername() {
		return this.manufacturername;
	}

	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}

	public String getManufacturertelephonenumber() {
		return this.manufacturertelephonenumber;
	}

	public void setManufacturertelephonenumber(String manufacturertelephonenumber) {
		this.manufacturertelephonenumber = manufacturertelephonenumber;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setManufacturer(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setManufacturer(null);

		return product;
	}

}