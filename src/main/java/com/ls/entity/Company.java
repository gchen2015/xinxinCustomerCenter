package com.ls.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ls_company")
public class Company implements Serializable {

	private static final long serialVersionUID = -6868385772290273229L;

	@Id
	@GeneratedValue
	protected Integer id;
	protected String name;
	protected String contactor;
	protected String email;
	protected String emailSrc;
	protected String resouceType;
	protected String phone;
	protected String phoneSrc;
	protected String mobilePhone;
	protected String mobilePhoneSrc;
	protected Boolean isTracked;
	protected String address;
	protected Integer star;
	protected String area;
	protected String fEurl;
	protected String phoneImgSrc;
	protected Integer cityId;
	protected Integer provinceId;
	protected String employeeCount;
	protected String description;
	protected String grabDate;
	protected Boolean active;
	protected Integer status;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ls_company_problem", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "problem_id") )
	protected List<Problem> problems;
	
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(name = "ls_company_step", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "step_id") )
	protected List<Step> steps;

	@Transient
	protected String publishDate;
	
	
	public String getResouceType() {
		return resouceType;
	}

	public void setResouceType(String resouceType) {
		this.resouceType = resouceType;
	}

	public String getPhoneImgSrc() {
		return phoneImgSrc;
	}

	public void setPhoneImgSrc(String phoneImgSrc) {
		this.phoneImgSrc = phoneImgSrc;
	}

	public String getfEurl() {
		return fEurl;
	}

	public void setfEurl(String fEurl) {
		this.fEurl = fEurl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactor() {
		return contactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSrc() {
		return emailSrc;
	}

	public void setEmailSrc(String emailSrc) {
		this.emailSrc = emailSrc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneSrc() {
		return phoneSrc;
	}

	public void setPhoneSrc(String phoneSrc) {
		this.phoneSrc = phoneSrc;
	}

	public Boolean getIsTracked() {
		return isTracked;
	}

	public void setIsTracked(Boolean isTracked) {
		this.isTracked = isTracked;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	
	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String distinct) {
		this.area = distinct;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhoneSrc() {
		return mobilePhoneSrc;
	}

	public void setMobilePhoneSrc(String mobilePhoneSrc) {
		this.mobilePhoneSrc = mobilePhoneSrc;
	}

	public String getGrabDate() {
		return grabDate;
	}

	public void setGrabDate(String grabDate) {
		this.grabDate = grabDate;
	}
//
//	public SourceType getSourceType() {
//		return sourceType;
//	}
//
//	public void setSourceType(SourceType sourceType) {
//		this.sourceType = sourceType;
//	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}