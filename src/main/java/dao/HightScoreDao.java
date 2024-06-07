package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class HightScoreDao implements DaoInterface<HightScoreB>{

	public static HightScoreDao getInstance() {
		return new HightScoreDao();
	}

	@Override
	public int insert(HightScoreB hs) {
		int kq = 0;
		Connection c = null;
//		Statement st ;
		try {
			c = JDBCUtil.getConnection();
			String sql = "INSERT INTO table2D(Name_Player, Time, map) VALUES(?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, hs.getNamePlayer());
			ps.setString(2, hs.getTime());
			ps.setString(3, hs.getmap());

			kq= ps.executeUpdate();
			System.out.println("Ban da thuc thi :" + sql);
			System.out.println(hs.getNamePlayer());
			System.out.println("Co " + kq +" dong bi thay doi");
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(c);
		}
		return kq;
	}

	@Override
	public int update(HightScoreB ds) {
		return 0;
	}

	@Override
	public int delete(HightScoreB hs) {
			return 0;
	}


	@Override
	public ArrayList<HightScoreB> selectAll(String mappp) {
		return selectByMap(mappp);  // Default to map1 if no specific map is provided
	}

	public ArrayList<HightScoreB> selectByMap(String map) {
		ArrayList<HightScoreB> ketqua = new ArrayList<>();
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "SELECT * FROM table2D WHERE map = ? ORDER BY Time";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, map);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String namePlayer = rs.getString("Name_Player");
				String playTime = rs.getString("Time");

				HightScoreB hs = new HightScoreB(namePlayer, playTime,map);
				ketqua.add(hs);
			}
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}


	@Override
	public HightScoreB selectById(HightScoreB t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HightScoreB> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
