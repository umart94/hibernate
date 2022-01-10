package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productid;

	private String productcolor;

	private String productdescription;

	private String productname;

	private String productnumber;

	private String productsize;

	private String productwarranty;

	private BigDecimal quantityinstock;

	private BigDecimal unitprice;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	private Category category;

	//bi-directional many-to-one association to Manufacturer
	@ManyToOne
	@JoinColumn(name="MANUFACTURERID")
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="SHOPID")
	private Shop shop;

	//bi-directional many-to-one association to Subcategory
	@ManyToOne
	@JoinColumn(name="SUBCATEGORYID")
	private Subcategory subcategory;

	//bi-directional many-to-one association to Productsbought
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<Productsbought> productsboughts;

	public Product() {
	}

	public long getProductid() {
		return this.productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getProductcolor() {
		return this.productcolor;
	}

	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}

	public String getProductdescription() {
		return this.productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductnumber() {
		return this.productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getProductsize() {
		return this.productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}

	public String getProductwarranty() {
		return this.productwarranty;
	}

	public void setProductwarranty(String productwarranty) {
		this.productwarranty = productwarranty;
	}

	public BigDecimal getQuantityinstock() {
		return this.quantityinstock;
	}

	public void setQuantityinstock(BigDecimal quantityinstock) {
		this.quantityinstock = quantityinstock;
	}

	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public List<Productsbought> getProductsboughts() {
		return this.productsboughts;
	}

	public void setProductsboughts(List<Productsbought> productsboughts) {
		this.productsboughts = productsboughts;
	}

	public Productsbought addProductsbought(Productsbought productsbought) {
		getProductsboughts().add(productsbought);
		productsbought.setProduct(this);

		return productsbought;
	}

	public Productsbought removeProductsbought(Productsbought productsbought) {
		getProductsboughts().remove(productsbought);
		productsbought.setProduct(null);

		return productsbought;
	}

}