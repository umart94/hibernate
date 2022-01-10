package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOP database table.
 * 
 */
@Entity
@NamedQuery(name="Shop.findAll", query="SELECT s FROM Shop s")
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long shopid;

	private String address;

	private String shopemailaddress;

	private String shopmobilenumber;

	private String shopname;

	private String shoptelephonenumber;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Bill> bills;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Customer> customers;

	//bi-directional many-to-one association to Department
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Department> departments;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Employee> employees;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Job> jobs;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="shop", fetch=FetchType.EAGER)
	private List<Product> products;

	//bi-directional many-to-one association to Areacity
	@ManyToOne
	@JoinColumn(name="AREAID")
	private Areacity areacity;

	public Shop() {
	}

	public long getShopid() {
		return this.shopid;
	}

	public void setShopid(long shopid) {
		this.shopid = shopid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShopemailaddress() {
		return this.shopemailaddress;
	}

	public void setShopemailaddress(String shopemailaddress) {
		this.shopemailaddress = shopemailaddress;
	}

	public String getShopmobilenumber() {
		return this.shopmobilenumber;
	}

	public void setShopmobilenumber(String shopmobilenumber) {
		this.shopmobilenumber = shopmobilenumber;
	}

	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShoptelephonenumber() {
		return this.shoptelephonenumber;
	}

	public void setShoptelephonenumber(String shoptelephonenumber) {
		this.shoptelephonenumber = shoptelephonenumber;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setShop(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setShop(null);

		return bill;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setShop(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setShop(null);

		return customer;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setShop(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setShop(null);

		return department;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setShop(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setShop(null);

		return employee;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setShop(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setShop(null);

		return job;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setShop(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setShop(null);

		return product;
	}

	public Areacity getAreacity() {
		return this.areacity;
	}

	public void setAreacity(Areacity areacity) {
		this.areacity = areacity;
	}

}