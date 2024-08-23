package com.example.springrest;

public class Product {

	private int id;
	private String pname;
	private String batchno;
	private double price;
	private int numprod; 
	
	public Product() {
		
	}

	/**
	 * @param id
	 * @param pname
	 * @param batchno
	 * @param price
	 * @param numprod
	 */
	public Product(int id, String pname, String batchno, double price, int numprod) {
		super();
		this.id = id;
		this.pname = pname;
		this.batchno = batchno;
		this.price = price;
		this.numprod = numprod;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the batchno
	 */
	public String getBatchno() {
		return batchno;
	}

	/**
	 * @param batchno the batchno to set
	 */
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the numprod
	 */
	public int getNumprod() {
		return numprod;
	}

	/**
	 * @param numprod the numprod to set
	 */
	public void setNumprod(int numprod) {
		this.numprod = numprod;
	}
	
	
	
}
