package ma.pm.distribution.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SecteurFileToDataBase {

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
			br = new BufferedReader(new FileReader(new File("E:\\ENIM S4\\Stage PFA\\PM\\new 18.txt")));
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, pasdword);
			while ((line = br.readLine()) != null) {
				lineItems=line.split("\\s+");
				st=cn.createStatement();
				sql="INSERT INTO secteur (codePostal, site_idSite) VALUES("+lineItems[1]+","+lineItems[0]+")";
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
