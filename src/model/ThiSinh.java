package model;


import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Objects;
import java.util.logging.SimpleFormatter;

public class ThiSinh implements Serializable{
		private int maThiSinh;
		private String tenThiSinh;
		private Date ngaySinh;
		private Tinh queQuan;
		boolean gioiTinh;
		private float diemMon1, diemMon2, diemMon3;
		private float diemTB;
				
		

		public ThiSinh() {
			
		}


		public ThiSinh(int maThiSinh, String tenThiSinh, Date ngaySinh, Tinh queQuan, boolean gioiTinh, float diemMon1,
				float diemMon2, float diemMon3, float diemTB) {
			super();
			this.maThiSinh = maThiSinh;
			this.tenThiSinh = tenThiSinh;
			this.ngaySinh = ngaySinh;
			this.queQuan = queQuan;
			this.gioiTinh = gioiTinh;
			this.diemMon1 = diemMon1;
			this.diemMon2 = diemMon2;
			this.diemMon3 = diemMon3;
			this.diemTB = diemTB;
		}


		public boolean isGioiTinh() {
			return gioiTinh;
		}


		public void setGioiTinh(boolean gioiTinh) {
			this.gioiTinh = gioiTinh;
		}


		public int getMaThiSinh() {
			return maThiSinh;
		}


		public void setMaThiSinh(int maThiSinh) {
			this.maThiSinh = maThiSinh;
		}


		public String getTenThiSinh() {
			return tenThiSinh;
		}


		public void setTenThiSinh(String tenThiSinh) {
			this.tenThiSinh = tenThiSinh;
		}


		public Date getNgaySinh() {
			return ngaySinh;
		}


		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}


		public Tinh getQueQuan() {
			return queQuan;
		}


		public void setQueQuan(Tinh queQuan) {
			this.queQuan = queQuan;
		}


		public float getDiemMon1() {
			return diemMon1;
		}


		public void setDiemMon1(float diemMon1) {
			this.diemMon1 = diemMon1;
			
		}


		public float getDiemMon2() {
			return diemMon2;
		}


		public void setDiemMon2(float diemMon2) {
			this.diemMon2 = diemMon2;
		}


		public float getDiemMon3() {
			return diemMon3;
		}


		public void setDiemMon3(float diemMon3) {
			this.diemMon3 = diemMon3;
		}
		
		public float getDiemTB() {
			return diemTB;
		}

		public void setDiemTB(float diemTB) {
			this.diemTB = diemTB;
		}

		@Override
		public String toString() {
			return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", ngaySinh=" + new SimpleDateFormat().format(ngaySinh)
					+ ", queQuan=" + queQuan.getTenTinh() + ", diemMon1=" + diemMon1 + ", diemMon2=" + diemMon2 + ", diemMon3="
					+ diemMon3 + "]";
		}


		@Override
		public int hashCode() {
			return Objects.hash(diemMon1, diemMon2, diemMon3, maThiSinh, ngaySinh, queQuan, tenThiSinh);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ThiSinh other = (ThiSinh) obj;
//			tenThiSinh.compareTo(other.tenThiSinh);
			return  Objects.equals(tenThiSinh, other.tenThiSinh);
		}

		
		
		public String getTen() {
			String s = this.getTenThiSinh().trim();
			if(s.indexOf(" ") > 0) {
				int vt = s.lastIndexOf(" ");
				return s.substring(vt);
			}else {
				return s;
			}
		}
		
		
		
}
