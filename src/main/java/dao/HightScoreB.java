package dao;

import java.io.Serializable;

public class HightScoreB  implements Serializable {
	private String namePlayer;
	private String time;
	private String map;
	public HightScoreB( String namePlayer, String time, String map) {
		this.namePlayer = namePlayer;
		this.time = time;
		this.map = map;
	}
	public String getmap() {
		return map;
	}
	public void setmap(String map) {
		this.map = map;
	}
	public String getNamePlayer() {
		return namePlayer;
	}
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
