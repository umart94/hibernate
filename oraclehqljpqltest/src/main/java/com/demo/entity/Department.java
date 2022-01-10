package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long dno;

	private String dname;

	//bi-directional many-to-one association to Areacity
	@ManyToOne
	@JoinColumn(name="AREAID")
	private Areacity areacity;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="SHOPID")
	private Shop shop;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department", fetch=FetchType.EAGER)
	private List<Employee> employees;

	public Department() {
	}

	public long getDno() {
		return this.dno;
	}

	public void setDno(long dno) {
		this.dno = dno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Areacity getAreacity() {
		return this.areacity;
	}

	public void setAreacity(Areacity areacity) {
		this.areacity = areacity;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

}