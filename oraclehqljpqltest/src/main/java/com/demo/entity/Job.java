package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@Table(name="JOBS")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long jobid;

	private BigDecimal dno;

	private String empjob;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="job", fetch=FetchType.EAGER)
	private List<Employee> employees;

	//bi-directional many-to-one association to Areacity
	@ManyToOne
	@JoinColumn(name="AREAID")
	private Areacity areacity;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="SHOPID")
	private Shop shop;

	public Job() {
	}

	public long getJobid() {
		return this.jobid;
	}

	public void setJobid(long jobid) {
		this.jobid = jobid;
	}

	public BigDecimal getDno() {
		return this.dno;
	}

	public void setDno(BigDecimal dno) {
		this.dno = dno;
	}

	public String getEmpjob() {
		return this.empjob;
	}

	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
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

}