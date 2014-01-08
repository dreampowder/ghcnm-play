package models;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class TempSummary {

	public Long cityId;
	
	public String cityName;
	
	public Double longitude;
	
	public Double latitude;
	
	public  HashMap<String,Double> temperatures;

	public TempSummary(Long cityId,String city, Double lon, Double lat, 
			Double t1,Double t2,Double t3,Double t4,Double t5,Double t6,
			Double t7,Double t8,Double t9,Double t10,Double t11,Double t12) {
		super();
		this.cityId = cityId;
		this.cityName = city.trim();
		this.longitude = lon;
		this.latitude= lat;
		DecimalFormat df = new DecimalFormat("#.##"); 
		temperatures = new HashMap<>();
		temperatures.put("month1", Double.valueOf(df.format(t1)));
		temperatures.put("month2", Double.valueOf(df.format(t2)));
		temperatures.put("month3", Double.valueOf(df.format(t3)));
		temperatures.put("month4", Double.valueOf(df.format(t4)));
		temperatures.put("month5", Double.valueOf(df.format(t5)));
		temperatures.put("month6", Double.valueOf(df.format(t6)));
		temperatures.put("month7", Double.valueOf(df.format(t7)));
		temperatures.put("month8", Double.valueOf(df.format(t8)));
		temperatures.put("month9", Double.valueOf(df.format(t9)));
		temperatures.put("month10", Double.valueOf(df.format(t10)));
		temperatures.put("month11", Double.valueOf(df.format(t11)));
		temperatures.put("month12", Double.valueOf(df.format(t12)));
	}
	
	
	
}
