package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLThiSinhModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import controller.QLThiSinhController;
import dao.ThiSinhDao;

import java.awt.Color;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QLThiSinhView extends JFrame {

	private JPanel contentPane;
	public QLThiSinhModel qlThiSinhModel;
	private JTextField jtextfiel_MaThiSinhSearch;
	private JTable table1;
	private JTextField textField_MaThiSinh;
	private JTextField textField_HoTen;
	private JTextField textField_NgaySinh;
	private JTextField textField_Diem1;
	private JTextField textField_Diem2;
	private JTextField textField_Diem3;
	private ButtonGroup buttonGroup_GioiTinh;
	private JComboBox comboBox_QueQuan;
	private JComboBox comboBox_QueQuan_Search;
	private JRadioButton jradiobutton_Nam;
	private JRadioButton jradiobutton_Nu;
	private JButton jbutton_SortTen;
	private JButton jbutton_SortDiemTB;
	private JComboBox comboBox_DiemTB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLThiSinhView frame = new QLThiSinhView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLThiSinhView() {
		this.qlThiSinhModel = new QLThiSinhModel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 684);
		this.setLocationRelativeTo(null);

		QLThiSinhController qlThiSinhController = new QLThiSinhController(this);

		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		JMenu menu_File = new JMenu("File");
		menu_File.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar_1.add(menu_File);

		JMenuItem jmenuItem_Open = new JMenuItem("Open");
		jmenuItem_Open.setFont(new Font("Dialog", Font.PLAIN, 20));
		menu_File.add(jmenuItem_Open);
		jmenuItem_Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLThiSinhView.class.getResource("Folder-document-open-icon.png"))));
		jmenuItem_Open.addActionListener(qlThiSinhController);

		JSeparator separator_2 = new JSeparator();
		menu_File.add(separator_2);

		JMenuItem jmenuItem_Save = new JMenuItem("Save");
		jmenuItem_Save.setFont(new Font("Dialog", Font.PLAIN, 20));
		menu_File.add(jmenuItem_Save);
		jmenuItem_Save.addActionListener(qlThiSinhController);
		jmenuItem_Save.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("Save-icon.png"))));
		JSeparator separator = new JSeparator();
		menu_File.add(separator);

		JMenuItem jmenuItem_Exit = new JMenuItem("Exit");
		jmenuItem_Exit.setFont(new Font("Dialog", Font.PLAIN, 20));
		menu_File.add(jmenuItem_Exit);
		jmenuItem_Exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLThiSinhView.class.getResource("Apps-Dialog-Logout-icon.png"))));
		jmenuItem_Exit.addActionListener(qlThiSinhController);

		JMenu menu_About = new JMenu("About");
		menu_About.setFont(new Font("Dialog", Font.BOLD, 20));
		menuBar_1.add(menu_About);

		JMenuItem mntmNewMenuItem = new JMenuItem("About Me");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menu_About.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mntmNewMenuItem.addActionListener(qlThiSinhController);

		JLabel jlabel_QueQuanSearch = new JLabel("Quê Quán");
		jlabel_QueQuanSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_QueQuanSearch.setBounds(18, 11, 99, 38);
		contentPane.add(jlabel_QueQuanSearch);

		JLabel lblMaThiSinh = new JLabel("Mã Thí Sinh");
		lblMaThiSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaThiSinh.setBounds(367, 11, 117, 38);
		contentPane.add(lblMaThiSinh);

		comboBox_QueQuan_Search = new JComboBox();

		ArrayList<Tinh> danhSachtinh = Tinh.getDSTinh();
		for (Tinh tinh : danhSachtinh) {
			comboBox_QueQuan_Search.addItem(tinh.getTenTinh());;
		}

		comboBox_QueQuan_Search.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_QueQuan_Search.setBounds(127, 10, 216, 38);
		contentPane.add(comboBox_QueQuan_Search);

		jtextfiel_MaThiSinhSearch = new JTextField();
		jtextfiel_MaThiSinhSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtextfiel_MaThiSinhSearch.setBounds(489, 11, 197, 38);
		contentPane.add(jtextfiel_MaThiSinhSearch);
		jtextfiel_MaThiSinhSearch.setColumns(10);

		JButton jbutton_Tim = new JButton("Tìm");
		jbutton_Tim.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_Tim.setBounds(707, 9, 99, 40);
		contentPane.add(jbutton_Tim);
		jbutton_Tim.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("search-icon.png"))));
		jbutton_Tim.addActionListener(qlThiSinhController);

		JButton jbutton_HuyTim = new JButton("Hủy Tìm");
		jbutton_HuyTim.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_HuyTim.setBounds(818, 11, 155, 38);
		contentPane.add(jbutton_HuyTim);
		jbutton_HuyTim.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("refresh-icon.png"))));
		jbutton_HuyTim.addActionListener(qlThiSinhController);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 60, 963, 1);
		contentPane.add(separator_1);

		table1 = new JTable();
		table1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ma\u0303 Thi\u0301 Sinh", "Ho\u0323 T\u00EAn", "Qu\u00EA Qua\u0301n", "Nga\u0300y Sinh",
						"Gi\u01A1\u0301i Ti\u0301nh", "M\u00F4n 1", "M\u00F4n 2", "M\u00F4n 3", "Điểm TB" }));
		table1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table1.getColumnModel().getColumn(1).setPreferredWidth(150);
		table1.getColumnModel().getColumn(2).setPreferredWidth(120);
		table1.getColumnModel().getColumn(4).setPreferredWidth(30);
		table1.getColumnModel().getColumn(5).setPreferredWidth(30);
		table1.getColumnModel().getColumn(6).setPreferredWidth(30);
		table1.getColumnModel().getColumn(7).setPreferredWidth(30);
		table1.setBounds(28, 129, 945, 226);
		table1.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(18, 124, 963, 189);
		contentPane.add(scrollPane);

		JLabel lblDanhSachThi = new JLabel("Danh Sách Thí Sinh");
		lblDanhSachThi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSachThi.setBounds(20, 72, 216, 41);
		contentPane.add(lblDanhSachThi);

		JLabel jlabel_MaThiSinh = new JLabel("Mã Thi Sinh");
		jlabel_MaThiSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_MaThiSinh.setBounds(26, 356, 117, 38);
		contentPane.add(jlabel_MaThiSinh);

		JLabel lbl_ThongTinThiSinh = new JLabel("Thông tin thí sinh");
		lbl_ThongTinThiSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_ThongTinThiSinh.setBounds(20, 324, 193, 25);
		contentPane.add(lbl_ThongTinThiSinh);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 547, 963, 1);
		contentPane.add(separator_1_1);

		textField_MaThiSinh = new JTextField();
		textField_MaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_MaThiSinh.setColumns(10);
		textField_MaThiSinh.setBounds(150, 356, 240, 38);
		contentPane.add(textField_MaThiSinh);

		JLabel jlabel_HoTen = new JLabel("Họ Tên");
		jlabel_HoTen.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_HoTen.setBounds(28, 405, 99, 39);
		contentPane.add(jlabel_HoTen);

		textField_HoTen = new JTextField();
		textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(150, 406, 240, 38);
		contentPane.add(textField_HoTen);

		JLabel jlabel_QueQuan = new JLabel("Quê Quán");
		jlabel_QueQuan.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_QueQuan.setBounds(28, 455, 115, 38);
		contentPane.add(jlabel_QueQuan);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(150, 504, 240, 38);
		contentPane.add(textField_NgaySinh);

		JLabel jlabel_NgaySinh = new JLabel("Ngày Sinh");
		jlabel_NgaySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_NgaySinh.setBounds(28, 504, 115, 40);
		contentPane.add(jlabel_NgaySinh);

		JButton jbutton_Them = new JButton("Thêm");
		jbutton_Them.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_Them.setBounds(150, 559, 127, 45);
		jbutton_Them.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("Apps-Dialog-Add-icon.png"))));
		contentPane.add(jbutton_Them);

		jbutton_Them.addActionListener(qlThiSinhController);

		JLabel jlabel_Diem1 = new JLabel("Điểm môn 1");
		jlabel_Diem1.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_Diem1.setBounds(457, 405, 122, 39);
		contentPane.add(jlabel_Diem1);

		textField_Diem1 = new JTextField();
		textField_Diem1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Diem1.setColumns(10);
		textField_Diem1.setBounds(586, 406, 240, 38);
		contentPane.add(textField_Diem1);

		JLabel jlabel_Diem2 = new JLabel("Điểm môn 2");
		jlabel_Diem2.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_Diem2.setBounds(457, 455, 122, 33);
		contentPane.add(jlabel_Diem2);

		textField_Diem2 = new JTextField();
		textField_Diem2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Diem2.setColumns(10);
		textField_Diem2.setBounds(586, 449, 240, 38);
		contentPane.add(textField_Diem2);

		JLabel jlabel_Diem3 = new JLabel("Điểm môn 3");
		jlabel_Diem3.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_Diem3.setBounds(457, 499, 122, 37);
		contentPane.add(jlabel_Diem3);

		textField_Diem3 = new JTextField();
		textField_Diem3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Diem3.setColumns(10);
		textField_Diem3.setBounds(586, 498, 240, 38);
		contentPane.add(textField_Diem3);

		JButton jbutton_CapNhat = new JButton("Cập Nhật");
		jbutton_CapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_CapNhat.setBounds(404, 559, 151, 45);
		contentPane.add(jbutton_CapNhat);
		jbutton_CapNhat.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("edit-icon.png"))));
		jbutton_CapNhat.addActionListener(qlThiSinhController);

		JButton jbutton_Xoa = new JButton("Xóa");
		jbutton_Xoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_Xoa.setBounds(283, 559, 111, 45);
		contentPane.add(jbutton_Xoa);
		jbutton_Xoa.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("trash-icon.png"))));
		jbutton_Xoa.addActionListener(qlThiSinhController);

		JButton jbutton_Luu = new JButton("Lưu");
		jbutton_Luu.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_Luu.setBounds(565, 559, 121, 45);
		contentPane.add(jbutton_Luu);
		jbutton_Luu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLThiSinhView.class.getResource("Apps-Dialog-Apply-icon.png"))));
		jbutton_Luu.addActionListener(qlThiSinhController);

		JButton jbutton_HuyBo = new JButton("Hủy bỏ");
		jbutton_HuyBo.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_HuyBo.setBounds(696, 559, 130, 45);
		contentPane.add(jbutton_HuyBo);
		jbutton_HuyBo.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLThiSinhView.class.getResource("arrow-undo-icon.png"))));
		jbutton_HuyBo.addActionListener(qlThiSinhController);

		JLabel jlabel_GioiTinh = new JLabel("Giới tính");
		jlabel_GioiTinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlabel_GioiTinh.setBounds(457, 356, 99, 25);
		contentPane.add(jlabel_GioiTinh);

		jradiobutton_Nam = new JRadioButton("Nam");
		jradiobutton_Nam.setFont(new Font("Tahoma", Font.BOLD, 20));
		jradiobutton_Nam.setBounds(586, 357, 111, 23);
		contentPane.add(jradiobutton_Nam);

		jradiobutton_Nu = new JRadioButton("Nữ");
		jradiobutton_Nu.setFont(new Font("Tahoma", Font.BOLD, 20));
		jradiobutton_Nu.setBounds(715, 357, 111, 23);
		contentPane.add(jradiobutton_Nu);

		buttonGroup_GioiTinh = new ButtonGroup();
		buttonGroup_GioiTinh.add(jradiobutton_Nam);
		buttonGroup_GioiTinh.add(jradiobutton_Nu);
		textField_NgaySinh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (textField_MaThiSinh.getText().equals("")) {
					JOptionPane.showMessageDialog(textField_MaThiSinh, "Mã sinh viên không được để trống");
				}
			}
		});

		comboBox_QueQuan = new JComboBox();
		for (Tinh tinh : danhSachtinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_QueQuan.setBounds(150, 455, 240, 38);
		contentPane.add(comboBox_QueQuan);

		jbutton_SortTen = new JButton("Tên A-Z");
		jbutton_SortTen.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_SortTen.setBounds(246, 73, 127, 40);
		contentPane.add(jbutton_SortTen);
		jbutton_SortTen.addActionListener(qlThiSinhController);

		jbutton_SortDiemTB = new JButton("Điểm TB Cao Nhất");
		jbutton_SortDiemTB.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_SortDiemTB.setBounds(520, 72, 214, 40);
		contentPane.add(jbutton_SortDiemTB);
		jbutton_SortDiemTB.addActionListener(qlThiSinhController);

		String[] ThangDiemTB = { "", "Dưới 5.0", "5<=diem<7.5", "từ 7.5" };
		comboBox_DiemTB = new JComboBox();
		comboBox_DiemTB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_DiemTB.setBounds(744, 72, 168, 38);
		for (String x : ThangDiemTB) {
			comboBox_DiemTB.addItem(x);
		}
		contentPane.add(comboBox_DiemTB);

		JButton jbutton_SortMaThiSinh = new JButton("Mã TS >>");
		jbutton_SortMaThiSinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		jbutton_SortMaThiSinh.setBounds(383, 73, 127, 40);
		contentPane.add(jbutton_SortMaThiSinh);
		jbutton_SortMaThiSinh.addActionListener(qlThiSinhController);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 121, 22);
		this.setVisible(true);
		this.layDuLieuTuDatabase();
	}

	public void xoaForm() {
		this.textField_MaThiSinh.setText("");
		this.textField_HoTen.setText("");
		this.comboBox_QueQuan.setSelectedIndex(-1);
		this.textField_NgaySinh.setText("");
		this.buttonGroup_GioiTinh.clearSelection();
		this.textField_Diem1.setText("");
		this.textField_Diem2.setText("");
		this.textField_Diem3.setText("");

	}

	public void thucHienThemThiSinh() {
		int maThiSinh = Integer.valueOf(this.textField_MaThiSinh.getText());
		String tenThiSinh = this.textField_HoTen.getText();
		Date ngaySinh = Date.valueOf(textField_NgaySinh.getText());
		int QueQuan = this.comboBox_QueQuan.getSelectedIndex();
		System.out.println(QueQuan);
		Tinh tinh = Tinh.getTinhById(QueQuan);
		boolean gioiTinh = true;
		if (this.jradiobutton_Nam.isSelected()) {
			gioiTinh = true;
		} else if (this.jradiobutton_Nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Diem1.getText());
		float diemMon2 = Float.valueOf(this.textField_Diem2.getText());
		float diemMon3 = Float.valueOf(this.textField_Diem3.getText());
		float diemTB = (diemMon1 + diemMon2 + diemMon3) / 3;
		diemTB = (float) Math.round(diemTB * 1000) / 1000;

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, ngaySinh, tinh, gioiTinh, diemMon1, diemMon2, diemMon3, diemTB);
		this.themHoacCapNhatSinhVien(ts);

	}

	public void themHoacCapNhatSinhVien(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();

		if (!this.qlThiSinhModel.kiemTraTonTai(ts)) {
			this.qlThiSinhModel.add(ts);
			ThiSinhDao.getInstance().insert(ts);
			this.themThiSinhVaoTable(ts);
			

		} else {
			this.qlThiSinhModel.update(ts);
			ThiSinhDao.getInstance().update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh(), i, 0);
					model_table.setValueAt(ts.getTenThiSinh(), i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh(), i, 2);
					model_table.setValueAt(ts.getNgaySinh(), i, 3);
					model_table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					model_table.setValueAt(ts.getDiemMon1(), i, 5);
					model_table.setValueAt(ts.getDiemMon2(), i, 6);
					model_table.setValueAt(ts.getDiemMon3(), i, 7);
					model_table.setValueAt(ts.getDiemTB(), i, 8);
				
				}
			}
//			this.qlThiSinhModel.inDanhSachThiSinh();
		}

	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh(), ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh(), (ts.isGioiTinh() ? "Nam" : "Nữ"),
				ts.getDiemMon1(), ts.getDiemMon2(), ts.getDiemMon3(), ts.getDiemTB(),

		});

	}

	public void hienThiThongTinSinhVienDaChon() {
		ThiSinh ts = this.getThiSinhDangChon();

		this.textField_MaThiSinh.setText(ts.getMaThiSinh() + "");
		this.textField_HoTen.setText(ts.getTenThiSinh());
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		this.textField_NgaySinh.setText(new SimpleDateFormat("yyyy-MM-dd").format(ts.getNgaySinh()));

		if (ts.isGioiTinh() == true) {
			this.jradiobutton_Nam.setSelected(true);
		} else {
			this.jradiobutton_Nu.setSelected(true);
		}
		this.textField_Diem1.setText(ts.getDiemMon1() + "");
		this.textField_Diem2.setText(ts.getDiemMon2() + "");
		this.textField_Diem3.setText(ts.getDiemMon3() + "");

	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		int row_i = table1.getSelectedRow();
		int maThiSinh = Integer.valueOf(model_table.getValueAt(row_i, 0) + "");
		String tenThiSinh = model_table.getValueAt(row_i, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(row_i, 2) + "");
		Date ngaySinh = Date.valueOf(model_table.getValueAt(row_i, 3) + "");
		String text_gioiTinh = model_table.getValueAt(row_i, 4) + "";
		boolean gioiTinh = text_gioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(row_i, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(row_i, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(row_i, 7) + "");
		float diemTB = Float.valueOf(model_table.getValueAt(row_i, 8) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, ngaySinh, tinh, gioiTinh, diemMon1, diemMon2, diemMon3, diemTB);
		return ts;
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		int i_row = table1.getSelectedRow();
		if(i_row >=0) {
			
			int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn?");
			if (luaChon == JOptionPane.YES_OPTION) {
				ThiSinh ts = this.getThiSinhDangChon();
				this.qlThiSinhModel.delete(ts);
				model_table.removeRow(i_row);
				ThiSinhDao.getInstance().delete(ts);
			}
		}
		
	}

	public void thucHienSapXepTen() {
		Collections.sort(this.qlThiSinhModel.getDsThiSinh(), new Comparator<ThiSinh>() {

			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				String ten_o1 = o1.getTen();
				String ten_o2 = o2.getTen();
				ten_o1 = ten_o1.replaceAll("ư", "u");
				if (ten_o1.contains("Đ") && !ten_o2.contains("D")) {
					ten_o1 = ten_o1.replace("Đ", "D");

				}
				if (ten_o2.contains("Đ") && !ten_o1.contains("D")) {
					ten_o2 = ten_o2.replace("Đ", "D");

				}

				return ten_o1.compareTo(ten_o2);
			}
		});
		this.thucHienTaiLaiDuLieu();

	}

	public void thucHienXapXepDiem() {
		Collections.sort(this.qlThiSinhModel.getDsThiSinh(), new Comparator<ThiSinh>() {

			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				if (o1.getDiemTB() < o2.getDiemTB()) {
					return 1;
				}
				return -1;
			}
		});
		this.thucHienTaiLaiDuLieu();

	}

	public void thucHienXapXepMaThiSinh() {
		Collections.sort(this.qlThiSinhModel.getDsThiSinh(), new Comparator<ThiSinh>() {

			@Override
			public int compare(ThiSinh o1, ThiSinh o2) {
				if (o1.getMaThiSinh() > o2.getMaThiSinh()) {
					return 1;
				}
				return -1;
			}
		});
		this.thucHienTaiLaiDuLieu();

	}

	public void thucHienTim() {
		this.thucHienTaiLaiDuLieu();
		String ThangDiem = this.comboBox_DiemTB.getSelectedItem() + "";
//		System.out.println(ThangDiem);
		int queQuan = this.comboBox_QueQuan_Search.getSelectedIndex();
		String maThiSinhTimKiem = this.jtextfiel_MaThiSinhSearch.getText();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		int soluongDong = model_table.getRowCount();

		if (queQuan > 0) {
			Tinh tinh = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soluongDong; i++) {
				String tinhTable = model_table.getValueAt(i, 2) + "";
				if (!tinhTable.equals(tinh.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));
				}
			}
		}

		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soluongDong; i++) {
				String maThiSinhTable = model_table.getValueAt(i, 0) + "";
				if (!maThiSinhTable.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(maThiSinhTable));
				}

			}
		}
		if (maThiSinhTimKiem.length() == 0 && queQuan == 0 && ThangDiem.equals("")) {
			Tinh tinh = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soluongDong; i++) {
				String tinhTable = model_table.getValueAt(i, 2) + "";
				if (!tinhTable.equals(tinh.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));
				}
			}
		}
		switch (ThangDiem) {
		case "Dưới 5.0":
			for (int i = 0; i < soluongDong; i++) {
				float diemTB = Float.valueOf(model_table.getValueAt(i, 8) + "");
				if (!(diemTB < 5)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));
				}
			}
			break;

		case "5<=diem<7.5":
			for (int i = 0; i < soluongDong; i++) {
				float diemTB = Float.valueOf(model_table.getValueAt(i, 8) + "");
				if (!(diemTB >= 5 && diemTB < 7.5)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));
				}
			}
			break;

		case "từ 7.5":
			for (int i = 0; i < soluongDong; i++) {
				float diemTB = Float.valueOf(model_table.getValueAt(i, 8) + "");
				if (!(diemTB > 7.5)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(model_table.getValueAt(i, 0) + ""));
				}
			}
			break;

		default:
			break;

		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soluongDong = model_table.getRowCount();
			for (int i = 0; i < soluongDong; i++) {
				if ((model_table.getValueAt(i, 0) + "").equals(idCanXoa.toString())) {
					model_table.removeRow(i);
					break;

				}
			}
		}

	}

	public void thucHienTaiLaiDuLieu() {

		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		model_table.getDataVector().removeAllElements();
		for (ThiSinh ts : this.qlThiSinhModel.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}

	}
	public void layDuLieuTuDatabase() {

		this.qlThiSinhModel.setDsThiSinh(ThiSinhDao.getInstance().selectAll());
		for (ThiSinh ts : this.qlThiSinhModel.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}

	}
	public void thucHienAboutMe() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh do tác giả Mon ú viết");

	}

	
	public void thucHienExit() {
		System.exit(0);

	}

}
