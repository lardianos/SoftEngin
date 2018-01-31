package infotests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.junit.jupiter.api.Test;

import database.MySQL;
import AdminGUI.AdminGUI;

class JunitInfokiosk {

	@Test
	void test() {
		MySQL db = new MySQL();
		db.dbconnect();
		boolean ckeck = db.check_login("admin","1234");
		assertEquals(ckeck,true);
	}
	@Test
	void test2() {
		MySQL db = new MySQL();
		db.dbconnect();
		boolean ckeck = db.check_login("admin","1111");
		assertEquals(ckeck,false);
	}
	@Test
	void test3() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox =  new JComboBox();
		int ckeck = db.select_query_categories(comboBox);
		assertEquals(ckeck,0);
	}
	@Test
	void test4() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox =  new JComboBox();
		int ckeck = db.select_query_categories(comboBox);
		assertEquals(ckeck,0);
	}
	@Test
	void test5() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox = null;
		int ckeck = db.select_query_points_of_category(comboBox);
		assertEquals(ckeck,0);
	}
	@Test
	void test6() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox = new JComboBox();
		int ckeck = db.select_query_points_of_category(comboBox);
		assertEquals(ckeck,0);
	}	
	@Test
	void test7() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox = new JComboBox();
		JTextField editPointTextField=new JTextField();
		JTextField editAreaTextField = new JTextField();
		JTextPane editDescriptionTextPane = new JTextPane();
		int ckeck = db.select_query_data_of_point("Museum", editPointTextField, editAreaTextField, comboBox, editDescriptionTextPane);
		assertEquals(ckeck,0);
	}	
	@Test
	void test8() {
		MySQL db = new MySQL();
		db.dbconnect();
		JComboBox comboBox = null;
		JTextField editPointTextField=null;
		JTextField editAreaTextField = null;
		JTextPane editDescriptionTextPane = null;
		int ckeck = db.select_query_data_of_point("Museum", editPointTextField, editAreaTextField, comboBox, editDescriptionTextPane);
		assertEquals(ckeck,0);
	}
	@Test
	void test9() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_category_query("New");
		assertEquals(ckeck,0);
	}
	@Test
	void test10() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_category_query("");
		assertEquals(ckeck,0);
	}
	@Test
	void test11() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_category_query(null);
		assertEquals(ckeck,0);
	}
	@Test
	void test12() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_point_query("New Point", "New Area", "Museum", "New Description");
		assertEquals(ckeck,0);
	}
	@Test
	void test13() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_point_query("", "", "", "");
		assertEquals(ckeck,0);
	}
	@Test
	void test14() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.add_point_query(null, null,null,null);
		assertEquals(ckeck,0);
	}
	@Test
	void test15() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.get_category_id("Lake");
		assertEquals(ckeck,6);
	}
	@Test
	void test16() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.get_category_id(null);
		assertEquals(ckeck,0);
	}
	@Test
	void test17() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_category_query("New");
		assertEquals(ckeck,0);
	}
	@Test
	void test18() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_category_query("");
		assertEquals(ckeck,0);
	}
	@Test
	void test19() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_category_query(null);
		assertEquals(ckeck,0);
	}
	@Test
	void test20() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_point_query("New Point");
		assertEquals(ckeck,0);
	}
	@Test
	void test21() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_point_query("");
		assertEquals(ckeck,0);
	}
	@Test
	void test22() {
		MySQL db = new MySQL();
		db.dbconnect();
		int ckeck = db.delete_point_query(null);
		assertEquals(ckeck,0);
	}
	@Test
	void test23() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_point_query("masta", "masta", "abudabi", "Lake", "limni kerkinis");
	}
	@Test
	void test24() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_point_query("", "", "", "", "");
	}
	@Test
	void test25() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_point_query(null, null, null, null, null);
	}
	@Test
	void test26() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_category_query("castle", "castle");
	}
	@Test
	void test27() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_category_query("", "");
	}
	@Test
	void test28() {
		MySQL db = new MySQL();
		db.dbconnect();
		db.edit_category_query(null, null);
	}
	@Test
	void test29() {
		AdminGUI gui = new AdminGUI();
		
	}
	
	
	
}
