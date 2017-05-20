package test;

import org.junit.Assert;
import org.junit.Test;

import backend.data.WeatherNow;
import backend.db.WeatherDBManager;

public class TestDb {
	WeatherDBManager wdb = WeatherDBManager.getInstance();
	
	WeatherNow now = new WeatherNow();
	
	@Test
	public void test(){
		now.setLocationName("�O��");
		now.setTime("2017");
		now.setWdir("�F�n");
		now.setWdsd(1.5);
		now.setHumd(20);
		now.setH_24r(0.5);
		
		wdb.addNowWeather(now);
	}
}
