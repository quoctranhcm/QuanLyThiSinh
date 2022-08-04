package test;

import java.util.ArrayList;

import javax.swing.UIManager;

import database.JDBCUtil;
import model.Tinh;
import view.QLThiSinhView;

public class Test {
		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				new QLThiSinhView();
				System.out.println(Tinh.getDSTinh().toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
}
