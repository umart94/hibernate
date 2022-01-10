package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUBCATEGORIES database table.
 * 
 */
@Entity
@Table(name="SUBCATEGORIES")
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long subcategoryid;

	private String subcategory;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subcategory", fetch=FetchType.EAGER)
	private List<Product> products;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	private Category category;

	public Subcategory() {
	}

	public long getSubcategoryid() {
		return this.subcategoryid;
	}

	public void setSubcategoryid(long subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubcategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubcategory(null);

		return product;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}