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
		Logger.info("GeoId: %s", inventoryCode);
		this.inventory = GeoInventory.find("byGeoId",Long.valueOf(inventoryCode)).first();
		this.year = Long.valueOf(dataLine.substring(11,15));
		this.temp1 = Double.valueOf(dataLine.substring(20, 24))/100;
		this.temp2 = Double.valueOf(dataLine.substring(28, 32))/100;
		this.temp3 = Double.valueOf(dataLine.substring(36, 40))/100;
		this.temp4 = Double.valueOf(dataLine.substring(44, 48))/100;
		this.temp5 = Double.valueOf(dataLine.substring(52, 56))/100;
		this.temp6 = Double.valueOf(dataLine.substring(60, 64))/100;
		this.temp7 = Double.valueOf(dataLine.substring(68, 72))/100;
		this.temp8 = Double.valueOf(dataLine.substring(76, 80))/100;
		this.temp9 = Double.valueOf(dataLine.substring(84, 88))/100;
		this.temp10 = Double.valueOf(dataLine.substring(92,96 ))/100;
		this.temp11 = Double.valueOf(dataLine.substring(100, 104))/100;
		this.temp12 = Double.valueOf(dataLine.substring(108, 112))/100;
	}
	
}
