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
    					+ "sum(dat.temp1)/count(*),"
    					+ "sum(dat.temp2)/count(*),"
    					+ "sum(dat.temp3)/count(*),"
    					+ "sum(dat.temp4)/count(*),"
    					+ "sum(dat.temp5)/count(*),"
    					+ "sum(dat.temp6)/count(*),"
    					+ "sum(dat.temp7)/count(*),"
    					+ "sum(dat.temp8)/count(*),"
    					+ "sum(dat.temp9)/count(*),"
    					+ "sum(dat.temp10)/count(*),"
    					+ "sum(dat.temp11)/count(*),"
    					+ "sum(dat.temp12)/count(*)) "
    					+ "from GeoTempData as dat "
    					+ "inner join "
    					+ "dat.inventory as inv "
//    					+ "on (inv=dat.inventory) "
    					+ "group by inv.name").fetch();
    	renderJSON(tempSummaries);
    }

}