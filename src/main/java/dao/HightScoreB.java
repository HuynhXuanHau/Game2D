package dao;

public class HightScoreB  {
	private String namePlayer;
	private String time;
	public HightScoreB( String namePlayer, String time) {
		this.namePlayer = namePlayer;
		this.time = time;
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
