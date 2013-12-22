package Jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import models.GeoInventory;
import models.GeoTempData;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {


	@Override
	public void doJob() throws Exception {
		Logger.info("Starting App Reading inventory file!");
		super.doJob();
		if(GeoInventory.count()==0)
			saveInventory();
		if(GeoTempData.count()==0)
			saveData();
	}
	
	public void saveData() throws HibernateException, IOException{
		File temperatureFile = new File("ghcnm.dat");
		BufferedReader br2 = new BufferedReader(new FileReader(temperatureFile));
		int counter = 0;
		String line;
		org.hibernate.Session session = 
				(org.hibernate.Session)GeoTempData.em().getDelegate(); 
		StatelessSession stateless = session.getSessionFactory().openStatelessSession();
		try {
			stateless.connection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		org.hibernate.Transaction tx = stateless.beginTransaction();

		counter=0;
		while ((line = br2.readLine()) != null) {
			counter++;
			GeoTempData data = new GeoTempData(line);
			stateless.insert(data);
			if(counter%1000==0){
				tx.commit();
				tx = stateless.beginTransaction();
				Logger.info("Data Saved: %s", counter);
			}
		}
		br2.close();
		stateless.close();
		session.clear();
		
		

		GeoTempData.em().flush();
		GeoTempData.em().clear();
		Logger.info("Geoloc Data save complete!");
	}

	public void saveInventory() throws HibernateException, IOException{
		File inventoryFile = new File("ghcnm.inv");
		BufferedReader br = new BufferedReader(new FileReader(inventoryFile));
		String line;

		org.hibernate.Session session = 
				(org.hibernate.Session)GeoInventory.em().getDelegate(); 
		StatelessSession stateless = session.getSessionFactory().openStatelessSession();
		try {
			stateless.connection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		org.hibernate.Transaction tx = stateless.beginTransaction();

		int counter=0;
		while ((line = br.readLine()) != null) {
			counter++;
			GeoInventory inv = new GeoInventory(line);
			stateless.insert(inv);
			if(counter%1000==0){
				tx.commit();
				tx = stateless.beginTransaction();
				Logger.info("Data Saved: %s", counter);
			}
		}
		tx.commit();
		br.close();
		stateless.close();
		session.clear();
		Logger.info("Geoloc Inventory save complete!");
	}
}
