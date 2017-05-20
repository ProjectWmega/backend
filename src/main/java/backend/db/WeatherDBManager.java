package backend.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import backend.data.Day;
import backend.data.Night;
import backend.data.TwoDays;
import backend.data.TwoDaysItem;
import backend.data.WeatherNow;
import backend.data.Week;
import backend.data.WeekItem;

public class WeatherDBManager {

	private static WeatherDBManager DB_MANAGER = new WeatherDBManager();
	
	public static WeatherDBManager getInstance(){
		return DB_MANAGER;
	}
	
	private WeatherDBManager(){
		
	}
	
	private IDatabase database = new MySqlDatabase();
	
	public void addNowWeather(WeatherNow now){
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
//		Statement stmt = null;
		
		String sql = "UPDATE Now SET time=?, wdir=?, wdsd=?, temp=?, humd=?, h_24r=? WHERE locationName=?";
//		String sql = "INSERT INTO Now (locationName, time, wdir, wdsd, temp, humd, h_24r) VALUES(?, ?, ?, ?, ?, ?, ?)";
//		String query = "SELECT * FROM Now WHERE locationName=?";
		try{
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, now.getLocationName());
			preStmt.setString(2, now.getTime());
			preStmt.setString(3, now.getWdir());
			preStmt.setDouble(4, now.getWdsd());
			preStmt.setDouble(5, now.getTemp());
			preStmt.setInt(6, now.getHumd());
			preStmt.setDouble(7, now.getH_24r());
			
			
			preStmt.executeUpdate();
			preStmt.close();
//			
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println("List all now weather: ");
//			while(rs.next()){
//				System.out.println("locationName: " + rs.getString("locationName")
//				 + ", time: " + rs.getString("time")
//				 + ", wdir: " + rs.getString("wdir")
//				 + ", wdsd: " + rs.getDouble("wdsd")
//				 + ", temp: " + rs.getDouble("temp")
//				 + ", humd: " + rs.getInt("humd")
//				 + ", h_24r:" + rs.getDouble("h_24r"));
//			}
//			stmt.close();
//			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WeatherNow getNowWeather(){
		WeatherNow now = new WeatherNow();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Now WHERE id = 1";
		PreparedStatement preStmt = null;
		
		try{
			preStmt = conn.prepareStatement(sql);
			ResultSet rs = preStmt.executeQuery(sql);
			if(rs.next()){
				String locationName =  rs.getString("locationName");
				String time = rs.getString("time");
				String wdir = rs.getString("wdir");
				Double wdsd = rs.getDouble("wdsd");
				Double temp = rs.getDouble("temp");
				int humd = rs.getInt("humd");
				Double h_24r = rs.getDouble("h_24r");
				
				now.setLocationName(locationName);
				now.setTemp(temp);
				now.setTime(time);
				now.setWdir(wdir);
				now.setWdsd(wdsd);
				now.setHumd(humd);
				now.setH_24r(h_24r);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return now;
	}
	
	public List<WeatherNow> listAllNowWeather(){
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Now";
		Statement stmt = null;
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String locationName =  rs.getString("locationName");
				String time = rs.getString("time");
				String wdir = rs.getString("wdir");
				Double wdsd = rs.getDouble("wdsd");
				Double temp = rs.getDouble("temp");
				int humd = rs.getInt("humd");
				Double h_24r = rs.getDouble("h_24r");
				
				WeatherNow now = new WeatherNow();
				now.setLocationName(locationName);
				now.setTemp(temp);
				now.setTime(time);
				now.setWdir(wdir);
				now.setWdsd(wdsd);
				now.setHumd(humd);
				now.setH_24r(h_24r);
				
				nows.add(now);
				
				System.out.println("locationName: " + rs.getString("locationName")
				 + ", time: " + rs.getString("time")
				 + ", wdir: " + rs.getString("wdir")
				 + ", wdsd: " + rs.getDouble("wdsd")
				 + ", temp: " + rs.getDouble("temp")
				 + ", humd: " + rs.getInt("humd")
				 + ", h_24r:" + rs.getDouble("h_24r"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nows;
	}
	
	public void addTwoDaysWeather(TwoDays twoDays){
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
//		Statement stmt = null;
		
		String sql = "UPDATE TwoDays SET "
				+ "1stTime=?, 1stTemp=?, 1stWx=?, 1stPop=?, "
				+ "2ndTime=?, 2ndTemp=?, 2ndWx=?, 2ndPop=?, "
				+ "3rdTime=?, 3rdTemp=?, 3rdWx=?, 3rdPop=?, "
				+ "4thTime=?, 4thTemp=?, 4thWx=?, 4thPop=?, "
				+ "5thTime=?, 5thTemp=?, 5thWx=?, 5thPop=?, "
				+ "6thTime=?, 6thTemp=?, 6thWx=?, 6thPop=?, "
				+ "7thTime=?, 7thTemp=?, 7thWx=?, 7thPop=?, "
				+ "8thTime=?, 8thTemp=?, 8thWx=?, 8thPop=?, "
				+ "9thTime=?, 9thTemp=?, 9thWx=?, 9thPop=?, "
				+ "10thTime=?, 10thTemp=?, 10thWx=?, 10thPop=?, "
				+ "11thTime=?, 11thTemp=?, 11thWx=?, 11thPop=?, "
				+ "12thTime=?, 12thTemp=?, 12thWx=?, 12thPop=?, "
				+ "13thTime=?, 13thTemp=?, 13thWx=?, 13thPop=?, "
				+ "14thTime=?, 14thTemp=?, 14thWx=?, 14thPop=?, "
				+ "15thTime=?, 15thTemp=?, 15thWx=?, 15thPop=?, "
				+ "16thTime=?, 16thTemp=?, 16thWx=?, 16thPop=?, "
				+ "17thTime=?, 17thTemp=?, 17thWx=?, 17thPop=? "
				+ "WHERE locationName=?";
//		String sql = "INSERT INTO TwoDays (locationName, 1stTime, 1stTemp, 1stWx, 1stPop, "
//				+ "2ndTime, 2ndTemp, 2ndWx, 2ndPop, "
//				+ "3rdTime, 3rdTemp, 3rdWx, 3rdPop, "
//				+ "4thTime, 4thTemp, 4thWx, 4thPop, "
//				+ "5thTime, 5thTemp, 5thWx, 5thPop, "
//				+ "6thTime, 6thTemp, 6thWx, 6thPop, "
//				+ "7thTime, 7thTemp, 7thWx, 7thPop, "
//				+ "8thTime, 8thTemp, 8thWx, 8thPop, "
//				+ "9thTime, 9thTemp, 9thWx, 9thPop, "
//				+ "10thTime, 10thTemp, 10thWx, 10thPop, "
//				+ "11thTime, 11thTemp, 11thWx, 11thPop, "
//				+ "12thTime, 12thTemp, 12thWx, 12thPop, "
//				+ "13thTime, 13thTemp, 13thWx, 13thPop, "
//				+ "14thTime, 14thTemp, 14thWx, 14thPop, "
//				+ "15thTime, 15thTemp, 15thWx, 15thPop, "
//				+ "16thTime, 16thTemp, 16thWx, 16thPop, "
//				+ "17thTime, 17thTemp, 17thWx, 17thPop) "
//				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
//				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		String query = "SELECT * FROM TwoDays";
		
		try{
			preStmt = conn.prepareStatement(sql);
			for(int i=0; i<twoDays.getItems().size(); i++){
				preStmt.setString((4*i)+1, twoDays.getItems().get(i).getTime());
				preStmt.setDouble((4*i)+2, twoDays.getItems().get(i).getTemp());
				preStmt.setString((4*i)+3, twoDays.getItems().get(i).getWx());
				preStmt.setDouble((4*i)+4, twoDays.getItems().get(i).getPop());
			}
			preStmt.setString(69, twoDays.getLocationName());
			
			preStmt.executeUpdate();
			preStmt.close();
			
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println("List all now weather: ");
//			while(rs.next()){
//				System.out.println("locationName: " + rs.getString("locationName")
//				 + ", time: " + rs.getString("time")
//				 + ", wdir: " + rs.getString("wdir")
//				 + ", wdsd: " + rs.getDouble("wdsd")
//				 + ", temp: " + rs.getDouble("temp")
//				 + ", humd: " + rs.getInt("humd")
//				 + ", h_24r:" + rs.getDouble("h_24r"));
//			}
//			stmt.close();
//			conn.commit();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public TwoDays getTwoDaysWeather(){
		TwoDays twoDays = new TwoDays();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM TwoDays WHERE id=1";
		Statement stmt = null;
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String locationName =  rs.getString("locationName");
				List<TwoDaysItem> items = new ArrayList<TwoDaysItem>();
				
				String time1 = rs.getString("1stTime");
				Double temp1 = rs.getDouble("1stTemp");
				String wx1 = rs.getString("1stWx");
				int pop1 = rs.getInt("1stPop");
				TwoDaysItem item1 = new TwoDaysItem();
				item1.setName(1);
				item1.setTime(time1);
				item1.setTemp(temp1.intValue());
				item1.setWx(wx1);
				item1.setPop(pop1);
				items.add(item1);
				
				String time2 = rs.getString("2ndTime");
				Double temp2 = rs.getDouble("2ndTemp");
				String wx2 = rs.getString("2ndWx");
				int pop2 = rs.getInt("2ndPop");
				TwoDaysItem item2 = new TwoDaysItem();
				item2.setName(2);
				item2.setTime(time2);
				item2.setTemp(temp2.intValue());
				item2.setWx(wx2);
				item2.setPop(pop2);
				items.add(item2);
				
				String time3 = rs.getString("3rdTime");
				Double temp3 = rs.getDouble("3rdTemp");
				String wx3 = rs.getString("3rdWx");
				int pop3 = rs.getInt("3rdPop");
				TwoDaysItem item3 = new TwoDaysItem();
				item3.setName(3);
				item3.setTime(time3);
				item3.setTemp(temp3.intValue());
				item3.setWx(wx3);
				item3.setPop(pop3);
				items.add(item3);
				
				String time4 = rs.getString("4thTime");
				Double temp4 = rs.getDouble("4thTemp");
				String wx4 = rs.getString("4thWx");
				int pop4 = rs.getInt("4thPop");
				TwoDaysItem item4 = new TwoDaysItem();
				item4.setName(4);
				item4.setTime(time4);
				item4.setTemp(temp4.intValue());
				item4.setWx(wx4);
				item4.setPop(pop4);
				items.add(item4);
				
				String time5 = rs.getString("5thTime");
				Double temp5 = rs.getDouble("5thTemp");
				String wx5 = rs.getString("5thWx");
				int pop5 = rs.getInt("5thPop");
				TwoDaysItem item5 = new TwoDaysItem();
				item5.setName(5);
				item5.setTime(time5);
				item5.setTemp(temp5.intValue());
				item5.setWx(wx5);
				item5.setPop(pop5);
				items.add(item5);
				
				String time6 = rs.getString("6thTime");
				Double temp6 = rs.getDouble("6thTemp");
				String wx6 = rs.getString("6thWx");
				int pop6 = rs.getInt("6thPop");
				TwoDaysItem item6 = new TwoDaysItem();
				item6.setName(6);
				item6.setTime(time6);
				item6.setTemp(temp6.intValue());
				item6.setWx(wx6);
				item6.setPop(pop6);
				items.add(item6);
				
				String time7 = rs.getString("7thTime");
				Double temp7 = rs.getDouble("7thTemp");
				String wx7 = rs.getString("7thWx");
				int pop7 = rs.getInt("7thPop");
				TwoDaysItem item7 = new TwoDaysItem();
				item7.setName(7);
				item7.setTime(time7);
				item7.setTemp(temp7.intValue());
				item7.setWx(wx7);
				item7.setPop(pop7);
				items.add(item7);
				
				String time8 = rs.getString("8thTime");
				Double temp8 = rs.getDouble("8thTemp");
				String wx8 = rs.getString("8thWx");
				int pop8 = rs.getInt("8thPop");
				TwoDaysItem item8 = new TwoDaysItem();
				item8.setName(8);
				item8.setTime(time8);
				item8.setTemp(temp8.intValue());
				item8.setWx(wx8);
				item8.setPop(pop8);
				items.add(item8);
				
				String time9 = rs.getString("9thTime");
				Double temp9 = rs.getDouble("9thTemp");
				String wx9 = rs.getString("9thWx");
				int pop9 = rs.getInt("9thPop");
				TwoDaysItem item9 = new TwoDaysItem();
				item9.setName(9);
				item9.setTime(time9);
				item9.setTemp(temp9.intValue());
				item9.setWx(wx9);
				item9.setPop(pop9);
				items.add(item9);
				
				String time10 = rs.getString("10thTime");
				Double temp10 = rs.getDouble("10thTemp");
				String wx10 = rs.getString("10thWx");
				int pop10 = rs.getInt("10thPop");
				TwoDaysItem item10 = new TwoDaysItem();
				item10.setName(10);
				item10.setTime(time10);
				item10.setTemp(temp10.intValue());
				item10.setWx(wx10);
				item10.setPop(pop10);
				items.add(item10);
				
				String time11 = rs.getString("11thTime");
				Double temp11 = rs.getDouble("11thTemp");
				String wx11 = rs.getString("11thWx");
				int pop11 = rs.getInt("11thPop");
				TwoDaysItem item11 = new TwoDaysItem();
				item11.setName(11);
				item11.setTime(time11);
				item11.setTemp(temp11.intValue());
				item11.setWx(wx11);
				item11.setPop(pop11);
				items.add(item11);
				
				String time12 = rs.getString("12thTime");
				Double temp12 = rs.getDouble("12thTemp");
				String wx12 = rs.getString("12thWx");
				int pop12 = rs.getInt("12thPop");
				TwoDaysItem item12 = new TwoDaysItem();
				item12.setName(12);
				item12.setTime(time12);
				item12.setTemp(temp12.intValue());
				item12.setWx(wx12);
				item12.setPop(pop12);
				items.add(item12);
				
				String time13 = rs.getString("13thTime");
				Double temp13 = rs.getDouble("13thTemp");
				String wx13 = rs.getString("13thWx");
				int pop13 = rs.getInt("13thPop");
				TwoDaysItem item13 = new TwoDaysItem();
				item13.setName(13);
				item13.setTime(time13);
				item13.setTemp(temp13.intValue());
				item13.setWx(wx13);
				item13.setPop(pop13);
				items.add(item13);
				
				String time14 = rs.getString("14thTime");
				Double temp14 = rs.getDouble("14thTemp");
				String wx14 = rs.getString("14thWx");
				int pop14 = rs.getInt("14thPop");
				TwoDaysItem item14 = new TwoDaysItem();
				item14.setName(14);
				item14.setTime(time14);
				item14.setTemp(temp14.intValue());
				item14.setWx(wx14);
				item14.setPop(pop14);
				items.add(item14);
				
				String time15 = rs.getString("15thTime");
				Double temp15 = rs.getDouble("15thTemp");
				String wx15 = rs.getString("15thWx");
				int pop15 = rs.getInt("15thPop");
				TwoDaysItem item15 = new TwoDaysItem();
				item15.setName(15);
				item15.setTime(time15);
				item15.setTemp(temp15.intValue());
				item15.setWx(wx15);
				item15.setPop(pop15);
				items.add(item15);
				
				String time16 = rs.getString("16thTime");
				Double temp16 = rs.getDouble("16thTemp");
				String wx16 = rs.getString("16thWx");
				int pop16 = rs.getInt("16thPop");
				TwoDaysItem item16 = new TwoDaysItem();
				item16.setName(16);
				item16.setTime(time16);
				item16.setTemp(temp16.intValue());
				item16.setWx(wx16);
				item16.setPop(pop16);
				items.add(item16);
				
				String time17 = rs.getString("17thTime");
				Double temp17 = rs.getDouble("17thTemp");
				String wx17 = rs.getString("17thWx");
				int pop17 = rs.getInt("17thPop");
				TwoDaysItem item17 = new TwoDaysItem();
				item17.setName(17);
				item17.setTime(time17);
				item17.setTemp(temp17.intValue());
				item17.setWx(wx17);
				item17.setPop(pop17);
				items.add(item17);
				
				twoDays.setLocationName(locationName);
				twoDays.setItems(items);
			}
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return twoDays;
	}
	
	public List<TwoDays> listAllTwoDaysWeather(){
		List<TwoDays> lsTwoDays = new ArrayList<TwoDays>();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM TwoDays";
		Statement stmt = null;
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TwoDays twoDays = new TwoDays();
				String locationName =  rs.getString("locationName");
				List<TwoDaysItem> items = new ArrayList<TwoDaysItem>();
				
				String time1 = rs.getString("1stTime");
				Double temp1 = rs.getDouble("1stTemp");
				String wx1 = rs.getString("1stWx");
				int pop1 = rs.getInt("1stPop");
				TwoDaysItem item1 = new TwoDaysItem();
				item1.setName(1);
				item1.setTime(time1);
				item1.setTemp(temp1.intValue());
				item1.setWx(wx1);
				item1.setPop(pop1);
				items.add(item1);
				
				String time2 = rs.getString("2ndTime");
				Double temp2 = rs.getDouble("2ndTemp");
				String wx2 = rs.getString("2ndWx");
				int pop2 = rs.getInt("2ndPop");
				TwoDaysItem item2 = new TwoDaysItem();
				item2.setName(2);
				item2.setTime(time2);
				item2.setTemp(temp2.intValue());
				item2.setWx(wx2);
				item2.setPop(pop2);
				items.add(item2);
				
				String time3 = rs.getString("3rdTime");
				Double temp3 = rs.getDouble("3rdTemp");
				String wx3 = rs.getString("3rdWx");
				int pop3 = rs.getInt("3rdPop");
				TwoDaysItem item3 = new TwoDaysItem();
				item3.setName(3);
				item3.setTime(time3);
				item3.setTemp(temp3.intValue());
				item3.setWx(wx3);
				item3.setPop(pop3);
				items.add(item3);
				
				String time4 = rs.getString("4thTime");
				Double temp4 = rs.getDouble("4thTemp");
				String wx4 = rs.getString("4thWx");
				int pop4 = rs.getInt("4thPop");
				TwoDaysItem item4 = new TwoDaysItem();
				item4.setName(4);
				item4.setTime(time4);
				item4.setTemp(temp4.intValue());
				item4.setWx(wx4);
				item4.setPop(pop4);
				items.add(item4);
				
				String time5 = rs.getString("5thTime");
				Double temp5 = rs.getDouble("5thTemp");
				String wx5 = rs.getString("5thWx");
				int pop5 = rs.getInt("5thPop");
				TwoDaysItem item5 = new TwoDaysItem();
				item5.setName(5);
				item5.setTime(time5);
				item5.setTemp(temp5.intValue());
				item5.setWx(wx5);
				item5.setPop(pop5);
				items.add(item5);
				
				String time6 = rs.getString("6thTime");
				Double temp6 = rs.getDouble("6thTemp");
				String wx6 = rs.getString("6thWx");
				int pop6 = rs.getInt("6thPop");
				TwoDaysItem item6 = new TwoDaysItem();
				item6.setName(6);
				item6.setTime(time6);
				item6.setTemp(temp6.intValue());
				item6.setWx(wx6);
				item6.setPop(pop6);
				items.add(item6);
				
				String time7 = rs.getString("7thTime");
				Double temp7 = rs.getDouble("7thTemp");
				String wx7 = rs.getString("7thWx");
				int pop7 = rs.getInt("7thPop");
				TwoDaysItem item7 = new TwoDaysItem();
				item7.setName(7);
				item7.setTime(time7);
				item7.setTemp(temp7.intValue());
				item7.setWx(wx7);
				item7.setPop(pop7);
				items.add(item7);
				
				String time8 = rs.getString("8thTime");
				Double temp8 = rs.getDouble("8thTemp");
				String wx8 = rs.getString("8thWx");
				int pop8 = rs.getInt("8thPop");
				TwoDaysItem item8 = new TwoDaysItem();
				item8.setName(8);
				item8.setTime(time8);
				item8.setTemp(temp8.intValue());
				item8.setWx(wx8);
				item8.setPop(pop8);
				items.add(item8);
				
				String time9 = rs.getString("9thTime");
				Double temp9 = rs.getDouble("9thTemp");
				String wx9 = rs.getString("9thWx");
				int pop9 = rs.getInt("9thPop");
				TwoDaysItem item9 = new TwoDaysItem();
				item9.setName(9);
				item9.setTime(time9);
				item9.setTemp(temp9.intValue());
				item9.setWx(wx9);
				item9.setPop(pop9);
				items.add(item9);
				
				String time10 = rs.getString("10thTime");
				Double temp10 = rs.getDouble("10thTemp");
				String wx10 = rs.getString("10thWx");
				int pop10 = rs.getInt("10thPop");
				TwoDaysItem item10 = new TwoDaysItem();
				item10.setName(10);
				item10.setTime(time10);
				item10.setTemp(temp10.intValue());
				item10.setWx(wx10);
				item10.setPop(pop10);
				items.add(item10);
				
				String time11 = rs.getString("11thTime");
				Double temp11 = rs.getDouble("11thTemp");
				String wx11 = rs.getString("11thWx");
				int pop11 = rs.getInt("11thPop");
				TwoDaysItem item11 = new TwoDaysItem();
				item11.setName(11);
				item11.setTime(time11);
				item11.setTemp(temp11.intValue());
				item11.setWx(wx11);
				item11.setPop(pop11);
				items.add(item11);
				
				String time12 = rs.getString("12thTime");
				Double temp12 = rs.getDouble("12thTemp");
				String wx12 = rs.getString("12thWx");
				int pop12 = rs.getInt("12thPop");
				TwoDaysItem item12 = new TwoDaysItem();
				item12.setName(12);
				item12.setTime(time12);
				item12.setTemp(temp12.intValue());
				item12.setWx(wx12);
				item12.setPop(pop12);
				items.add(item12);
				
				String time13 = rs.getString("13thTime");
				Double temp13 = rs.getDouble("13thTemp");
				String wx13 = rs.getString("13thWx");
				int pop13 = rs.getInt("13thPop");
				TwoDaysItem item13 = new TwoDaysItem();
				item13.setName(13);
				item13.setTime(time13);
				item13.setTemp(temp13.intValue());
				item13.setWx(wx13);
				item13.setPop(pop13);
				items.add(item13);
				
				String time14 = rs.getString("14thTime");
				Double temp14 = rs.getDouble("14thTemp");
				String wx14 = rs.getString("14thWx");
				int pop14 = rs.getInt("14thPop");
				TwoDaysItem item14 = new TwoDaysItem();
				item14.setName(14);
				item14.setTime(time14);
				item14.setTemp(temp14.intValue());
				item14.setWx(wx14);
				item14.setPop(pop14);
				items.add(item14);
				
				String time15 = rs.getString("15thTime");
				Double temp15 = rs.getDouble("15thTemp");
				String wx15 = rs.getString("15thWx");
				int pop15 = rs.getInt("15thPop");
				TwoDaysItem item15 = new TwoDaysItem();
				item15.setName(15);
				item15.setTime(time15);
				item15.setTemp(temp15.intValue());
				item15.setWx(wx15);
				item15.setPop(pop15);
				items.add(item15);
				
				String time16 = rs.getString("16thTime");
				Double temp16 = rs.getDouble("16thTemp");
				String wx16 = rs.getString("16thWx");
				int pop16 = rs.getInt("16thPop");
				TwoDaysItem item16 = new TwoDaysItem();
				item16.setName(16);
				item16.setTime(time16);
				item16.setTemp(temp16.intValue());
				item16.setWx(wx16);
				item16.setPop(pop16);
				items.add(item16);
				
				String time17 = rs.getString("17thTime");
				Double temp17 = rs.getDouble("17thTemp");
				String wx17 = rs.getString("17thWx");
				int pop17 = rs.getInt("17thPop");
				TwoDaysItem item17 = new TwoDaysItem();
				item17.setName(17);
				item17.setTime(time17);
				item17.setTemp(temp17.intValue());
				item17.setWx(wx17);
				item17.setPop(pop17);
				items.add(item17);
				
				twoDays.setLocationName(locationName);
				twoDays.setItems(items);
				
				lsTwoDays.add(twoDays);
			}
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lsTwoDays;
	}
	
	public void addWeekWeather(Week week){
		Connection conn = database.getConnection();
		PreparedStatement preStmt = null;
//		Statement stmt = null;
		
		String sql = "UPDATE Week SET 1stDayMaxT=?, 1stDayMinT=?, 1stDayWx=?, 1stDayPop=?, "
				+ "1stNightMaxT=?, 1stNightMinT=?, 1stNightWx=?, 1stNightPop=?, "
				+ "2ndDayMaxT=?, 2ndDayMinT=?, 2ndDayWx=?, 2ndDayPoP=?, "
				+ "2ndNightMaxT=?, 2ndNightMinT=?, 2ndNightWx=?, 2ndNightPoP=?, "
				+ "3rdDayMaxT=?, 3rdDayMinT=?, 3rdDayWx=?, 3rdDayPoP=?, "
				+ "3rdNightMaxT=?, 3rdNightMinT=?, 3rdNightWx=?, 3rdNightPoP=?, "
				+ "4thDayMaxT=?, 4thDayMinT=?, 4thDayWx=?, 4thDayPoP=?, "
				+ "4thNightMaxT=?, 4thNightMinT=?, 4thNightWx=?, 4thNightPoP=?, "
				+ "5thDayMaxT=?, 5thDayMinT=?, 5thDayWx=?, 5thDayPoP=?, "
				+ "5thNightMaxT=?, 5thNightMinT=?, 5thNightWx=?, 5thNightPoP=?, "
				+ "6thDayMaxT=?, 6thDayMinT=?, 6thDayWx=?, 6thDayPoP=?, "
				+ "6thNightMaxT=?, 6thNightMinT=?, 6thNightWx=?, 6thNightPoP=?, "
				+ "7thDayMaxT=?, 7thDayMinT=?, 7thDayWx=?, 7thDayPoP=?, "
				+ "7thNightMaxT=?, 7thNightMinT=?, 7thNightWx=?, 7thNightPoP=? WHERE locationName=?";
//		String sql = "INSERT INTO Week (locationName, 1stDayMaxT, 1stDayMinT, 1stDayWx, 1stDayPop, "
//		+ "1stNightMaxT, 1stNightMinT, 1stNightWx, 1stNightPop, "
//		+ "2ndDayMaxT, 2ndDayMinT, 2ndDayWx, 2ndDayPoP, "
//		+ "2ndNightMaxT, 2ndNightMinT, 2ndNightWx, 2ndNightPoP, "
//		+ "3rdDayMaxT, 3rdDayMinT, 3rdDayWx, 3rdDayPoP, "
//		+ "3rdNightMaxT, 3rdNightMinT, 3rdNightWx, 3rdNightPoP, "
//		+ "4thDayMaxT, 4thDayMinT, 4thDayWx, 4thDayPoP, "
//		+ "4thNightMaxT, 4thNightMinT, 4thNightWx, 4thNightPoP, "
//		+ "5thDayMaxT, 5thDayMinT, 5thDayWx, 5thDayPoP, "
//		+ "5thNightMaxT, 5thNightMinT, 5thNightWx, 5thNightPoP, "
//		+ "6thDayMaxT, 6thDayMinT, 6thDayWx, 6thDayPoP, "
//		+ "6thNightMaxT, 6thNightMinT, 6thNightWx, 6thNightPoP, "
//		+ "7thDayMaxT, 7thDayMinT, 7thDayWx, 7thDayPoP, "
//		+ "7thNightMaxT, 7thNightMinT, 7thNightWx, 7thNightPoP) "
//		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?, "
//		+ "?, ?, ?, ?, ?, ?, ?, ?)";
//		String query = "SELECT * FROM Week";
		try{
			preStmt = conn.prepareStatement(sql);
			for(int i=0; i<week.getItems().size(); i++){
				preStmt.setInt((8*i)+1, week.getItems().get(i).getDay().getMaxT());
				preStmt.setInt((8*i)+2, week.getItems().get(i).getDay().getMinT());
				preStmt.setString((8*i)+3, week.getItems().get(i).getDay().getWx());
				preStmt.setInt((8*i)+4, week.getItems().get(i).getDay().getPop());
				preStmt.setInt((8*i)+5, week.getItems().get(i).getNight().getMaxT());
				preStmt.setInt((8*i)+6, week.getItems().get(i).getNight().getMinT());
				preStmt.setString((8*i)+7, week.getItems().get(i).getNight().getWx());
				preStmt.setInt((8*i)+8, week.getItems().get(i).getNight().getPop());
			}
			preStmt.setString(57, week.getLocationName());
			
			preStmt.executeUpdate();
			preStmt.close();
//			
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println("List all now weather: ");
//			while(rs.next()){
//				System.out.println("locationName: " + rs.getString("locationName")
//				 + ", time: " + rs.getString("time")
//				 + ", wdir: " + rs.getString("wdir")
//				 + ", wdsd: " + rs.getDouble("wdsd")
//				 + ", temp: " + rs.getDouble("temp")
//				 + ", humd: " + rs.getInt("humd")
//				 + ", h_24r:" + rs.getDouble("h_24r"));
//			}
//			stmt.close();
//			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Week getWeekWeather(){
		Week week = new Week();
		List<WeekItem> items = new ArrayList<WeekItem>();
		
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Week WHERE id = 1";
		PreparedStatement preStmt = null;
		
		try{
			preStmt = conn.prepareStatement(sql);
			ResultSet rs = preStmt.executeQuery(sql);
			if(rs.next()){
				String locationName =  rs.getString("locationName");
				week.setLocationName(locationName);
				
				WeekItem item1 = new WeekItem();
				Day day1 = new Day();
				Night night1 = new Night();
				day1.setMaxT(rs.getInt("1stDayMaxT")); 
				day1.setMinT(rs.getInt("1stDayMinT")); 
				day1.setWx(rs.getString("1stDayWx")); 
				day1.setPop(rs.getInt("1stDayPop"));
				night1.setMaxT(rs.getInt("1stNightMaxT")); 
				night1.setMinT(rs.getInt("1stNightMinT"));
				night1.setWx(rs.getString("1stNightWx"));
				night1.setPop(rs.getInt("1stNightPop"));
				item1.setName(1);
				item1.setDay(day1);
				item1.setNight(night1);
				items.add(item1);
				
				WeekItem item2 = new WeekItem();
				Day day2 = new Day();
				Night night2 = new Night();
				day2.setMaxT(rs.getInt("2ndDayMaxT")); 
				day2.setMinT(rs.getInt("2ndDayMinT")); 
				day2.setWx(rs.getString("2ndDayWx")); 
				day2.setPop(rs.getInt("2ndDayPoP"));
				night2.setMaxT(rs.getInt("2ndNightMaxT")); 
				night2.setMinT(rs.getInt("2ndNightMinT"));
				night2.setWx(rs.getString("2ndNightWx"));
				night2.setPop(rs.getInt("2ndNightPoP"));
				item2.setName(2);
				item2.setDay(day2);
				item2.setNight(night2);
				items.add(item2);
				
				WeekItem item3 = new WeekItem();
				Day day3 = new Day();
				Night night3 = new Night();
				day3.setMaxT(rs.getInt("3rdDayMaxT")); 
				day3.setMinT(rs.getInt("3rdDayMinT")); 
				day3.setWx(rs.getString("3rdDayWx")); 
				day3.setPop(rs.getInt("3rdDayPoP"));
				night3.setMaxT(rs.getInt("3rdNightMaxT")); 
				night3.setMinT(rs.getInt("3rdNightMinT"));
				night3.setWx(rs.getString("3rdNightWx"));
				night3.setPop(rs.getInt("3rdNightPoP"));
				item3.setName(3);
				item3.setDay(day3);
				item3.setNight(night3);
				items.add(item3);
				
				WeekItem item4 = new WeekItem();
				Day day4 = new Day();
				Night night4 = new Night();
				day4.setMaxT(rs.getInt("4thDayMaxT")); 
				day4.setMinT(rs.getInt("4thDayMinT")); 
				day4.setWx(rs.getString("4thDayWx")); 
				day4.setPop(rs.getInt("4thDayPoP"));
				night4.setMaxT(rs.getInt("4thNightMaxT")); 
				night4.setMinT(rs.getInt("4thNightMinT"));
				night4.setWx(rs.getString("4thNightWx"));
				night4.setPop(rs.getInt("4thNightPoP"));
				item4.setName(4);
				item4.setDay(day4);
				item4.setNight(night4);
				items.add(item4);
				
				WeekItem item5 = new WeekItem();
				Day day5 = new Day();
				Night night5 = new Night();
				day5.setMaxT(rs.getInt("5thDayMaxT")); 
				day5.setMinT(rs.getInt("5thDayMinT")); 
				day5.setWx(rs.getString("5thDayWx")); 
				day5.setPop(rs.getInt("5thDayPoP"));
				night5.setMaxT(rs.getInt("5thNightMaxT")); 
				night5.setMinT(rs.getInt("5thNightMinT"));
				night5.setWx(rs.getString("5thNightWx"));
				night5.setPop(rs.getInt("5thNightPoP"));
				item5.setName(5);
				item5.setDay(day5);
				item5.setNight(night5);
				items.add(item5);
				
				WeekItem item6 = new WeekItem();
				Day day6 = new Day();
				Night night6 = new Night();
				day6.setMaxT(rs.getInt("6thDayMaxT")); 
				day6.setMinT(rs.getInt("6thDayMinT")); 
				day6.setWx(rs.getString("6thDayWx")); 
				day6.setPop(rs.getInt("6thDayPoP"));
				night6.setMaxT(rs.getInt("6thNightMaxT")); 
				night6.setMinT(rs.getInt("6thNightMinT"));
				night6.setWx(rs.getString("6thNightWx"));
				night6.setPop(rs.getInt("6thNightPoP"));
				item6.setName(6);
				item6.setDay(day6);
				item6.setNight(night6);
				items.add(item6);
				
				WeekItem item7 = new WeekItem();
				Day day7 = new Day();
				Night night7 = new Night();
				day7.setMaxT(rs.getInt("7thDayMaxT")); 
				day7.setMinT(rs.getInt("7thDayMinT")); 
				day7.setWx(rs.getString("7thDayWx")); 
				day7.setPop(rs.getInt("7thDayPoP"));
				night7.setMaxT(rs.getInt("7thNightMaxT")); 
				night7.setMinT(rs.getInt("7thNightMinT"));
				night7.setWx(rs.getString("7thNightWx"));
				night7.setPop(rs.getInt("7thNightPoP"));
				item7.setName(7);
				item7.setDay(day7);
				item7.setNight(night7);
				items.add(item7);
				
				week.setItems(items);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return week;
	}
	
	public List<Week> listWeekWeather(){
		List<Week> weeks = new ArrayList<Week>();
		Connection conn = database.getConnection();
		String sql = "SELECT * FROM Week";
		PreparedStatement preStmt = null;
		
		try{
			preStmt = conn.prepareStatement(sql);
			ResultSet rs = preStmt.executeQuery(sql);
			while(rs.next()){
				
				List<WeekItem> items = new ArrayList<WeekItem>();
				Week week = new Week();
				String locationName =  rs.getString("locationName");
				week.setLocationName(locationName);
				
				WeekItem item1 = new WeekItem();
				Day day1 = new Day();
				Night night1 = new Night();
				day1.setMaxT(rs.getInt("1stDayMaxT")); 
				day1.setMinT(rs.getInt("1stDayMinT")); 
				day1.setWx(rs.getString("1stDayWx")); 
				day1.setPop(rs.getInt("1stDayPop"));
				night1.setMaxT(rs.getInt("1stNightMaxT")); 
				night1.setMinT(rs.getInt("1stNightMinT"));
				night1.setWx(rs.getString("1stNightWx"));
				night1.setPop(rs.getInt("1stNightPop"));
				item1.setName(1);
				item1.setDay(day1);
				item1.setNight(night1);
				items.add(item1);
				
				WeekItem item2 = new WeekItem();
				Day day2 = new Day();
				Night night2 = new Night();
				day2.setMaxT(rs.getInt("2ndDayMaxT")); 
				day2.setMinT(rs.getInt("2ndDayMinT")); 
				day2.setWx(rs.getString("2ndDayWx")); 
				day2.setPop(rs.getInt("2ndDayPoP"));
				night2.setMaxT(rs.getInt("2ndNightMaxT")); 
				night2.setMinT(rs.getInt("2ndNightMinT"));
				night2.setWx(rs.getString("2ndNightWx"));
				night2.setPop(rs.getInt("2ndNightPoP"));
				item2.setName(2);
				item2.setDay(day2);
				item2.setNight(night2);
				items.add(item2);
				
				WeekItem item3 = new WeekItem();
				Day day3 = new Day();
				Night night3 = new Night();
				day3.setMaxT(rs.getInt("3rdDayMaxT")); 
				day3.setMinT(rs.getInt("3rdDayMinT")); 
				day3.setWx(rs.getString("3rdDayWx")); 
				day3.setPop(rs.getInt("3rdDayPoP"));
				night3.setMaxT(rs.getInt("3rdNightMaxT")); 
				night3.setMinT(rs.getInt("3rdNightMinT"));
				night3.setWx(rs.getString("3rdNightWx"));
				night3.setPop(rs.getInt("3rdNightPoP"));
				item3.setName(3);
				item3.setDay(day3);
				item3.setNight(night3);
				items.add(item3);
				
				WeekItem item4 = new WeekItem();
				Day day4 = new Day();
				Night night4 = new Night();
				day4.setMaxT(rs.getInt("4thDayMaxT")); 
				day4.setMinT(rs.getInt("4thDayMinT")); 
				day4.setWx(rs.getString("4thDayWx")); 
				day4.setPop(rs.getInt("4thDayPoP"));
				night4.setMaxT(rs.getInt("4thNightMaxT")); 
				night4.setMinT(rs.getInt("4thNightMinT"));
				night4.setWx(rs.getString("4thNightWx"));
				night4.setPop(rs.getInt("4thNightPoP"));
				item4.setName(4);
				item4.setDay(day4);
				item4.setNight(night4);
				items.add(item4);
				
				WeekItem item5 = new WeekItem();
				Day day5 = new Day();
				Night night5 = new Night();
				day5.setMaxT(rs.getInt("5thDayMaxT")); 
				day5.setMinT(rs.getInt("5thDayMinT")); 
				day5.setWx(rs.getString("5thDayWx")); 
				day5.setPop(rs.getInt("5thDayPoP"));
				night5.setMaxT(rs.getInt("5thNightMaxT")); 
				night5.setMinT(rs.getInt("5thNightMinT"));
				night5.setWx(rs.getString("5thNightWx"));
				night5.setPop(rs.getInt("5thNightPoP"));
				item5.setName(5);
				item5.setDay(day5);
				item5.setNight(night5);
				items.add(item5);
				
				WeekItem item6 = new WeekItem();
				Day day6 = new Day();
				Night night6 = new Night();
				day6.setMaxT(rs.getInt("6thDayMaxT")); 
				day6.setMinT(rs.getInt("6thDayMinT")); 
				day6.setWx(rs.getString("6thDayWx")); 
				day6.setPop(rs.getInt("6thDayPoP"));
				night6.setMaxT(rs.getInt("6thNightMaxT")); 
				night6.setMinT(rs.getInt("6thNightMinT"));
				night6.setWx(rs.getString("6thNightWx"));
				night6.setPop(rs.getInt("6thNightPoP"));
				item6.setName(6);
				item6.setDay(day6);
				item6.setNight(night6);
				items.add(item6);
				
				WeekItem item7 = new WeekItem();
				Day day7 = new Day();
				Night night7 = new Night();
				day7.setMaxT(rs.getInt("7thDayMaxT")); 
				day7.setMinT(rs.getInt("7thDayMinT")); 
				day7.setWx(rs.getString("7thDayWx")); 
				day7.setPop(rs.getInt("7thDayPoP"));
				night7.setMaxT(rs.getInt("7thNightMaxT")); 
				night7.setMinT(rs.getInt("7thNightMinT"));
				night7.setWx(rs.getString("7thNightWx"));
				night7.setPop(rs.getInt("7thNightPoP"));
				item7.setName(7);
				item7.setDay(day7);
				item7.setNight(night7);
				items.add(item7);
				
				week.setItems(items);
				weeks.add(week);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return weeks;
	}
}
