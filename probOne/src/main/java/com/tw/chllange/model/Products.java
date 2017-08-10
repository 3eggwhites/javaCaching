package com.tw.chllange.model;

import java.io.Serializable;
import java.util.Date;

public class Products implements Serializable {

	private static final long serialVersionUID = -6261072398587701355L;

	private int price;

	private String prodName;

	private Date endDate;

	private Date startDate;

	private String category;


	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Products [prodPrice=" + price + ", prodName=" + ((prodName == null) ? "null" : prodName)
				+ ", endDate=" + ((endDate == null) ? "null" : endDate) + ", startDate="
				+ ((startDate == null) ? "null" : startDate) + ", category=" + category + "]";
	}

}
