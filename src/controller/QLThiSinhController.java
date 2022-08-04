package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLThiSinhView;

public class QLThiSinhController implements ActionListener {
	private QLThiSinhView qlThiSinhView;

	public QLThiSinhController(QLThiSinhView qlThiSinhView) {

		this.qlThiSinhView = qlThiSinhView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

//		JOptionPane.showMessageDialog(qlThiSinhView, "Bạn vừa nhấn vào: "+ command);

		if (command.equals("Thêm")) {
			this.qlThiSinhView.xoaForm();
			

		} else if (command.equals("Cập Nhật")) {
			this.qlThiSinhView.hienThiThongTinSinhVienDaChon();

		} else if (command.equals("Xóa")) {
			this.qlThiSinhView.thucHienXoa();

		} else if (command.equals("Lưu")) {

			try {
				this.qlThiSinhView.thucHienThemThiSinh();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (command.equals("Hủy bỏ")) {
			this.qlThiSinhView.xoaForm();

		} else if (command.equals("Tìm")) {
			this.qlThiSinhView.thucHienTim();
		} else if (command.equals("Hủy Tìm")) {
			this.qlThiSinhView.thucHienTaiLaiDuLieu();

		} else if (command.equals("About Me")) {
			
			this.qlThiSinhView.thucHienAboutMe();

		} else if (command.equals("Exit")) {
			this.qlThiSinhView.thucHienExit();

		} else if (command.equals("Tên A-Z")) {
			this.qlThiSinhView.thucHienSapXepTen();

		} else if (command.equals("Mã TS >>")) {
			this.qlThiSinhView.thucHienXapXepMaThiSinh();

		} else if (command.equals("Điểm TB Cao Nhất")) {
			this.qlThiSinhView.thucHienXapXepDiem();
		}

	}

}
