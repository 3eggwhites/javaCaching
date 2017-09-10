package com.caching.demo.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Country implements Serializable {

	private static final long serialVersionUID = 3565082776529661583L;

	private Integer countryId;

	private String countryCd;

	private String countryName;

	private String statusInd;

	private Date lastModifiedDate;

	private Integer modifyPersonNum;

	public Country(Integer countryId, String countryCd, String countryName, String statusInd, Date lastModifiedDate,
			Integer modifyPersonNum) {
		super();
		this.countryId = countryId;
		this.countryCd = countryCd;
		this.countryName = countryName;
		this.statusInd = statusInd;
		this.lastModifiedDate = lastModifiedDate;
		this.modifyPersonNum = modifyPersonNum;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStatusInd() {
		return statusInd;
	}

	public void setStatusInd(String statusInd) {
		this.statusInd = statusInd;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getModifyPersonNum() {
		return modifyPersonNum;
	}

	public void setModifyPersonNum(Integer modifyPersonNum) {
		this.modifyPersonNum = modifyPersonNum;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:MM:ss");
		String date = sdf.format(lastModifiedDate);
		return countryId.toString().concat(countryCd).concat(countryName).concat(statusInd).concat(date)
				.concat(modifyPersonNum.toString());

	}

}
