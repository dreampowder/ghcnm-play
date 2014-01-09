package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.Logger;
import play.db.jpa.Model;

@Entity
public class GeoTempData extends Model {

	@OneToOne
	public GeoInventory inventory;
	
	public Long year;
	
	public Double temp1;
	public Double temp2;
	public Double temp3;
	public Double temp4;
	public Double temp5;
	public Double temp6;
	public Double temp7;
	public Double temp8;
	public Double temp9;
	public Double temp10;
	public Double temp11;
	public Double temp12;
	
	
	
	public GeoTempData(){
		super();
	}
	
	public GeoTempData(String dataLine){
		String inventoryCode = dataLine.substring(0,11);
		this.inventory = GeoInventory.find("byGeoId",Long.valueOf(inventoryCode)).first();
		this.year = Long.valueOf(dataLine.substring(11,15));
		this.temp1 = Double.valueOf(dataLine.substring(20, 25).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp2 = Double.valueOf(dataLine.substring(28, 33).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp3 = Double.valueOf(dataLine.substring(36, 41).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp4 = Double.valueOf(dataLine.substring(44, 49).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp5 = Double.valueOf(dataLine.substring(52, 57).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp6 = Double.valueOf(dataLine.substring(60, 65).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp7 = Double.valueOf(dataLine.substring(68, 73).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp8 = Double.valueOf(dataLine.substring(76, 81).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp9 = Double.valueOf(dataLine.substring(84, 89).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp10 = Double.valueOf(dataLine.substring(92,97 ).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp11 = Double.valueOf(dataLine.substring(100, 105).replaceAll("[a-zA-Z]+", ""))/100;
		this.temp12 = Double.valueOf(dataLine.substring(108, 113).replaceAll("[a-zA-Z]+", ""))/100;
	}
	
}
