package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import play.db.jpa.Model;

@Entity
public class GeoInventory extends Model{

	
	public Long geoId;
	
	public Double latitude;
	
	public Double longitude;
	
	public String name;
	
	public GeoInventory(){
		super();
	}
	
	public GeoInventory(String dataLine){
		super();
		this.geoId = Long.valueOf(dataLine.substring(0,11));
		this.latitude = Double.valueOf(dataLine.substring(13, 20));
		this.longitude = Double.valueOf(dataLine.substring(23, 30));
		this.name = dataLine.substring(38, 67);
	}
	
}
