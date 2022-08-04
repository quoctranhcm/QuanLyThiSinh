package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ThiSinh;
import model.Tinh;

public class ThiSinhDao implements DAOInterface<ThiSinh>{

	
	public static ThiSinhDao getInstance() {
		return new ThiSinhDao();
	}
	@Override
	public int insert(ThiSinh t) {
		int ketQua = 0;

		try {
//			bước 1
			Connection con = JDBCUtil.getConnection();

//			bước 2
			Statement st = con.createStatement();

//			bước 3
			String sql = "INSERT INTO thisinh (maThiSinh, tenThiSinh, ngaySinh, tenTinh, gioiTinh, diemMon1, diemMon2, diemMon3, diemTB)"+
						"VALUES(" + t.getMaThiSinh() +", '" + t.getTenThiSinh() +"' , '" + t.getNgaySinh() +"', '" + t.getQueQuan().getTenTinh()+"',"+
						+ (t.isGioiTinh() ? 1: 0) +", "+ t.getDiemMon1() +", " + t.getDiemMon2() +", " + t.getDiemMon3() +", " + t.getDiemTB() +")";
			ketQua = st.executeUpdate(sql);

//			bước 4
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

//			bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(ThiSinh t) {
		int ketQua = 0;

		try {
//			bước 1
			Connection con = JDBCUtil.getConnection();

//			bước 2
			Statement st = con.createStatement();

//			bước 3
			String sql = "UPDATE thisinh "+   " SET " +// nhớ có dấu cách 
					" tenThiSinh = '" + t.getTenThiSinh() +"'" + 
					",ngaySinh ='" + t.getNgaySinh() +"'" +
					",tenTinh ='" + t.getQueQuan().getTenTinh() +"'"+
					",gioiTinh =" + ((t.isGioiTinh() ? 1: 0)) +
					",diemMon1 = " + t.getDiemMon1() +
					",diemMon2 = " + t.getDiemMon2() +
					",diemMon3 = " + t.getDiemMon3() +
					",diemTB = " + t.getDiemTB() +
					"WHERE " + " maThiSinh =" + t.getMaThiSinh();
			ketQua = st.executeUpdate(sql);

//			bước 4
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

//			bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(ThiSinh t) {
		int ketQua = 0;

		try {
//			bước 1
			Connection con = JDBCUtil.getConnection();

//			bước 2
			Statement st = con.createStatement();

//			bước 3
			String sql = "DELETE FROM thisinh WHERE maThiSinh = " + t.getMaThiSinh();

			ketQua = st.executeUpdate(sql);

//			bước 4
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

//			bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<ThiSinh> selectAll() {
		ArrayList<ThiSinh> ketQua = new ArrayList<ThiSinh>();

		try {
//			bước 1
			Connection con = JDBCUtil.getConnection();

//			bước 2
			Statement st = con.createStatement();

//			bước 3
			String sql = "SELECT * FROM thisinh";
			ResultSet rs = st.executeQuery(sql);

//			bước 4
			System.out.println("Bạn đã thực thi: " + sql);
			while (rs.next()) {
				int maThiSinh = rs.getInt("maThiSinh");
				String tenThiSinh = rs.getString("tenThiSinh");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tenTinh = rs.getString("tenTinh");
				Tinh tinh = Tinh.getTinhByTen(tenTinh);
				int sex = rs.getInt("gioiTinh");
				boolean gioiTinh = sex>0 ? true :false;
				float diemMon1 = rs.getFloat("diemMon1");
				float diemMon2 = rs.getFloat("diemMon2");
				float diemMon3 = rs.getFloat("diemMon3");
				float diemTB = rs.getFloat("diemTB");
				ThiSinh thiSinh = new ThiSinh(maThiSinh, tenThiSinh, ngaySinh, tinh, gioiTinh, diemMon1, diemMon2, diemMon3, diemTB);
				ketQua.add(thiSinh);
			}

//			bước 5
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ThiSinh selectById(ThiSinh t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ThiSinh> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
