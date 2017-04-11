package backend.data;

public class WeatherNow {
	
	private String locationName;
	
	private String time;
	
	private String wdir; //���V�A���:��
	
	private Double wdsd; //���t�Am/s
	
	private Double temp; //�ūסAC
	
	private int humd; //��סA%
	
	private Double h_24r; //��ֿn�B�q�A�@��

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWdir() {
		return wdir;
	}

	public void setWdir(String wdir) {
		this.wdir = wdir;
	}

	public Double getWdsd() {
		return wdsd;
	}

	public void setWdsd(Double wdsd) {
		this.wdsd = wdsd;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public int getHumd() {
		return humd;
	}

	public void setHumd(int humd) {
		this.humd = humd;
	}

	public Double getH_24r() {
		return h_24r;
	}

	public void setH_24r(Double h_24r) {
		this.h_24r = h_24r;
	}
	
	public String wdirToString(Double value){
		String wind = "";
		if(((value>=0) && (value<=11.25)) || ((value>348.75) && value<=360)){ //0
			wind = "�_";
		}
		else if((value>0) && (value>11.25) && (value<=33.75)){ //22.5
			wind = "�_�_�F";
		}
		else if((value>0) && (value>33.75) && (value<=56.25)){ //45
			wind = "�F�_";
		}
		else if((value>0) && (value>56.25) && (value<=78.75)){ //67.5
			wind = "�F�_�F";
		}
		else if((value>0) && (value>78.75) && (value<=101.25)){ //90
			wind = "�F";
		}
		else if((value>0) && (value>101.25) && (value<=123.75)){ //112.5
			wind = "�F�n�F";
		}
		else if((value>0) && (value>123.75) && (value<=146.25)){ //135
			wind = "�F�n";
		}
		else if((value>0) && (value>146.25) && (value<=168.75)){ //157.5
			wind = "�n�n�F";
		}
		else if((value>0) && (value>168.75) && (value<=191.25)){ //180
			wind = "�n";
		}
		else if((value>0) && (value>191.25) && (value<=213.75)){ //205.5
			wind = "�n�n��";
		}
		else if((value>0) && (value>213.75) && (value<=236.25)){ //225
			wind = "��n";
		}
		else if((value>0) && (value>236.25) && (value<=258.75)){ //247.5
			wind = "��n��";
		}
		else if((value>0) && (value>258.75) && (value<=281.25)){ //270
			wind = "��";
		}
		else if((value>0) && (value>281.25) && (value<=303.75)){ //292.5
			wind = "��_��";
		}
		else if((value>0) && (value>303.75) && (value<=326.25)){ //315
			wind = "��_";
		}
		else if((value>0) && (value>326.25) && (value<=348.75)){ //337.5
			wind = "�_�_��";
		}
		else{
			wind="���~";
		}
		
		return wind;
	}
}
