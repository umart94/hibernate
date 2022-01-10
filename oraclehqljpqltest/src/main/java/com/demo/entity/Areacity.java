package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AREACITY database table.
 * 
 */
@Entity
@NamedQuery(name="Areacity.findAll", query="SELECT a FROM Areacity a")
public class Areacity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long areaid;

	private String area;

	private String city;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="areacity", fetch=FetchType.EAGER)
	private List<Department> departments;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="areacity", fetch=FetchType.EAGER)
	private List<Job> jobs;

	//bi-directional many-to-one association to Shop
	@OneToMany(mappedBy="areacity", fetch=FetchType.EAGER)
	private List<Shop> shops;

	public Areacity() {
	}

	public long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(long areaid) {
		this.areaid = areaid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setAreacity(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setAreacity(null);

		return department;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setAreacity(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setAreacity(null);

		return job;
	}

	public List<Shop> getShops() {
		return this.shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public Shop addShop(Shop shop) {
		getShops().add(shop);
		shop.setAreacity(this);

		return shop;
	}

	public Shop removeShop(Shop shop) {
		getShops().remove(shop);
		shop.setAreacity(null);

		return shop;
	}

}