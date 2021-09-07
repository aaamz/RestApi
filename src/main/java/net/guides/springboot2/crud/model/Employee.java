package net.guides.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private long weight;
	private long noOfTruck;
	private String comment;
	private long shipperId;
	private String date;

	public Employee() {

	}

	public Employee(String loadingPoint, String unloadingPoint, String productType, String truckType, long weight,
			long noOfTruck, String comment, long shipperId, String date) {

		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.weight = weight;
		this.noOfTruck = noOfTruck;
		this.comment = comment;
		this.shipperId = shipperId;
		this.date = date;

	}

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "loadingpoint", nullable = false)
	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	@Column(name = "unloadingpoint", nullable = false)
	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	@Column(name = "producttype", nullable = false)
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "trucktype", nullable = false)
	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	@Column(name = "weight", nullable = false)
	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Column(name = "nooftrucks", nullable = false)
	public long getNoOfTruck() {
		return noOfTruck;
	}

	public void setNoOfTruck(long noOfTruck) {
		this.noOfTruck = noOfTruck;
	}

	@Column(name = "comment", nullable = false)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "shipperid", nullable = false)
	public long getShipperId() {
		return shipperId;
	}

	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}

	@Column(name = "date", nullable = false)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ",loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint
				+ ", productType=" + productType + ", truckType=" + truckType + ", weight=" + weight + ", noOfTruck="
				+ noOfTruck + ", comment=" + comment + ", shipperId=" + shipperId + ", date=" + date + "]";
	}

}