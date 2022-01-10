package com.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long empid;

	private String address;

	private String empemailaddress;

	private String empname;

	private String emppassword;

	private BigDecimal empsalary;

	private String empusername;

	@Temporal(TemporalType.DATE)
	private Date hiredate;

	private String mobilenumber;

	private String telephonenumber;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DNO")
	private Department department;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOBID")
	private Job job;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="SHOPID")
	private Shop shop;

	public Employee() {
	}

	public long getEmpid() {
		return this.empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmpemailaddress() {
		return this.empemailaddress;
	}

	public void setEmpemailaddress(String empemailaddress) {
		this.empemailaddress = empemailaddress;
	}

	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmppassword() {
		return this.emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}

	public BigDecimal getEmpsalary() {
		return this.empsalary;
	}

	public void setEmpsalary(BigDecimal empsalary) {
		this.empsalary = empsalary;
	}

	public String getEmpusername() {
		return this.empusername;
	}

	public void setEmpusername(String empusername) {
		this.empusername = empusername;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getTelephonenumber() {
		return this.telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}