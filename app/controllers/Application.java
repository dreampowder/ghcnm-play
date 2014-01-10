package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void getJson(){
    	Logger.info("Getting geoloc Json");
    	List<TempSummary> tempSummaries = 
    			GeoTempData.find(""
    					+ "select new models.TempSummary("
    					+ "inv.geoId,"
    					+ "inv.name,"
    					+ "inv.latitude, "
    					+ "inv.longitude,"
    					+ "avg(dat.temp1),"
    					+ "avg(dat.temp2),"
    					+ "avg(dat.temp3),"
    					+ "avg(dat.temp4),"
    					+ "avg(dat.temp5),"
    					+ "avg(dat.temp6),"
    					+ "avg(dat.temp7),"
    					+ "avg(dat.temp8),"
    					+ "avg(dat.temp9),"
    					+ "avg(dat.temp10),"
    					+ "avg(dat.temp11),"
    					+ "avg(dat.temp12)) "
    					+ "from GeoTempData as dat "
    					+ "inner join "
    					+ "dat.inventory as inv "
//    					+ "on (inv=dat.inventory) "
    					+ "group by inv.geoId").fetch();
    	renderJSON(tempSummaries);
    }

}