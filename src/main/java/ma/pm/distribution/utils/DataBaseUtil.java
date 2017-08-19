package ma.pm.distribution.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DataBaseUtil {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost/pm_distribution";
		String login="root";
		String pasdword="";
		Connection cn=null;
		Statement st=null;
		
		BufferedReader br = null;
		String line=null;
		String [] lineItems;
		String sql=null;
		int cpt=0;
		try {
			br = new BufferedReader(new FileReader(new File("E:\\ENIM S4\\Stage PFA\\PM\\sitesmekes.txt")));
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, pasdword);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				lineItems=line.split("-");
				System.out.println(lineItems[0]+"||"+lineItems[1]);
				st=cn.createStatement();
				sql="INSERT INTO site (type_site, nomSite, region_idR) VALUES('"+lineItems[1]+"','"+lineItems[0]+"',2)";
				st.executeUpdate(sql);
				cpt++;
				}
				br.close();
				System.out.println(cpt + " lignes ont été souvgardées");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
