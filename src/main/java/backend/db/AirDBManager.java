package backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backend.data.AQI;
import backend.data.AqiValues;
import backend.data.UVI;

public class AirDBManager {

	private static AirDBManager DB_MANAGER = new AirDBManager();
	
	public static AirDBManager	getInstance() {
		return DB_MANAGER;
	}
	
	private AirDBManager() {
		
	}
	
	private IDatabase database = new MySqlDatabase();
	
	public void addAqi(AQI aqi) {
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
		
//		String sql = "INSERT INTO Aqi (county, siteName, time, aqi, pollutant, status, so2, co, o3, pm10, pm25, no2, nox, no) "
//				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sql = "UPDATE Aqi SET county=?, time=?, aqi=?, pollutant=?, status=?, so2=?, co=?, o3=?, pm10=?, pm25=?, no2=?, nox=?, no=? WHERE siteName=?";
		
		try {
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, aqi.getCounty());
			preStmt.setString(2, aqi.getValues().getTime());
			preStmt.setInt(3, aqi.getValues().getAqi());
			preStmt.setString(4, aqi.getValues().getPollutant());
			preStmt.setString(5, aqi.getValues().getStatus());
			preStmt.setDouble(6, aqi.getValues().getSo2());
			preStmt.setDouble(7, aqi.getValues().getCo());
			preStmt.setDouble(8, aqi.getValues().getO3());
			preStmt.setInt(9, aqi.getValues().getPm10());
			preStmt.setInt(10, aqi.getValues().getPm25());
			preStmt.setDouble(11, aqi.getValues().getNo2());
			preStmt.setDouble(12, aqi.getValues().getNox());
			preStmt.setDouble(13, aqi.getValues().getNo());
			preStmt.setString(14, aqi.getSiteName());
			
			preStmt.executeUpdate();
			preStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public AQI getAqi() {
		AQI aqi = new AQI();
		AqiValues values = new AqiValues();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Aqi WHERE id = 1";
		PreparedStatement preStmt = null;
		
		try {
			preStmt = conn.prepareStatement(sql);
//			preStmt.setInt(1, 1);
			
			ResultSet rs = preStmt.executeQuery(sql);
			if(rs.next()) {
				String county = rs.getString("county");
				String siteName = rs.getString("siteName");
				String time = rs.getString("time");
				int aqiValue = rs.getInt("aqi");
				String pollutant = rs.getString("pollutant");
				String status = rs.getString("status");
				Double so2 = rs.getDouble("so2");
				Double co = rs.getDouble("co");
				Double o3 = rs.getDouble("o3");
				int pm10 = rs.getInt("pm10");
				int pm25= rs.getInt("pm25");
				Double no2 = rs.getDouble("no2");
				Double nox = rs.getDouble("nox");
				Double no = rs.getDouble("no");
				
				aqi.setCounty(county);
				aqi.setSiteName(siteName);
				values.setTime(time);
				values.setAqi(aqiValue);
				values.setPollutant(pollutant);
				values.setStatus(status);
				values.setSo2(so2);
				values.setCo(co);
				values.setO3(o3);
				values.setPm10(pm10);
				values.setPm25(pm25);
				values.setNo2(no2);
				values.setNox(nox);
				values.setNo(no);
				
				aqi.setValues(values);
			}
			preStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aqi;
	}
	
	public List<AQI> listAqi() {
		List<AQI> aqis = new ArrayList<AQI>();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Aqi";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String county = rs.getString("county");
				String siteName = rs.getString("siteName");
				String time = rs.getString("time");
				int aqiValue = rs.getInt("aqi");
				String pollutant = rs.getString("pollutant");
				String status = rs.getString("status");
				Double so2 = rs.getDouble("so2");
				Double co = rs.getDouble("co");
				Double o3 = rs.getDouble("o3");
				int pm10 = rs.getInt("pm10");
				int pm25= rs.getInt("pm25");
				Double no2 = rs.getDouble("no2");
				Double nox = rs.getDouble("nox");
				Double no = rs.getDouble("no");
				
				AQI aqi = new AQI();
				AqiValues values = new AqiValues();
				aqi.setCounty(county);
				aqi.setSiteName(siteName);
				values.setTime(time);
				values.setAqi(aqiValue);
				values.setPollutant(pollutant);
				values.setStatus(status);
				values.setSo2(so2);
				values.setCo(co);
				values.setO3(o3);
				values.setPm10(pm10);
				values.setPm25(pm25);
				values.setNo2(no2);
				values.setNox(nox);
				values.setNo(no);
				
				aqi.setValues(values);
				aqis.add(aqi);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return aqis;
	}
	
	public void addUvi(UVI uvi) {
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
		
//		String sql = "INSERT INTO Uvi (county, siteName, time, uvi) VALUES(?, ?, ?, ?)";
		String sql = "UPDATE Uvi SET county=?, time=?, uvi=? WHERE siteName=?";
		
		try {
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, uvi.getCounty());
			preStmt.setString(2, uvi.getTime());
			preStmt.setInt(3, uvi.getValue());
			preStmt.setString(4, uvi.getSiteName());
			
			preStmt.executeUpdate();
			preStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UVI getUvi() {
		UVI uvi = new UVI();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Uvi WHERE id = 1";
		PreparedStatement preStmt = null;
		
		try {
			preStmt = conn.prepareStatement(sql);
//			preStmt.setInt(1, 1);
			
			ResultSet rs = preStmt.executeQuery(sql);
			if(rs.next()) {
				String county = rs.getString("county");
				String siteName = rs.getString("siteName");
				String time = rs.getString("time");
				int uviValue = rs.getInt("uvi");
				
				uvi.setCounty(county);
				uvi.setSiteName(siteName);
				uvi.setTime(time);
				uvi.setValue(uviValue);
			}
			preStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return uvi;
	}
	
	public List<UVI> listUvi () {
		List<UVI> uvis = new ArrayList<UVI>();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Uvi";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String county = rs.getString("county");
				String siteName = rs.getString("siteName");
				String time = rs.getString("time");
				int uviValue = rs.getInt("uvi");
				
				UVI uvi = new UVI();
				uvi.setCounty(county);
				uvi.setSiteName(siteName);
				uvi.setTime(time);
				uvi.setValue(uviValue);
				
				uvis.add(uvi);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return uvis;
	}
}
