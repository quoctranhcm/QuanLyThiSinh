package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QLThiSinhModel{
	private ArrayList<ThiSinh> dsThiSinh;

	public QLThiSinhModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		
	}

	public QLThiSinhModel(ArrayList<ThiSinh> dsThiSinh) {

		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public void add(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}

	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}

	public void update(ThiSinh thiSinh) {
		for (ThiSinh ts : this.dsThiSinh) {
			if (ts.getMaThiSinh() == thiSinh.getMaThiSinh()) {
				ts.setMaThiSinh(thiSinh.getMaThiSinh());
				ts.setTenThiSinh(thiSinh.getTenThiSinh());
				ts.setQueQuan(thiSinh.getQueQuan());
				ts.setNgaySinh(thiSinh.getNgaySinh());
				ts.setGioiTinh(thiSinh.isGioiTinh());
				ts.setDiemMon1(thiSinh.getDiemMon1());
				ts.setDiemMon2(thiSinh.getDiemMon2());
				ts.setDiemMon3(thiSinh.getDiemMon3());
				ts.setDiemTB(thiSinh.getDiemTB());
				break;
			}

		}
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if (thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
				return true;
			}

		}
		return false;
	}

	public void inDanhSachThiSinh() {
		for (ThiSinh ts : dsThiSinh) {
			System.out.println(ts.toString());
			System.out.println();
		}
	}

}
