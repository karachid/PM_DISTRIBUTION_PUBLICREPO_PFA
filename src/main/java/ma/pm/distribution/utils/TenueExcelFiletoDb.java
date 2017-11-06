package ma.pm.distribution.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class TenueExcelFiletoDb {

	public static void main(String[] args) {
		
		/* DataBase connection info */
		String url="jdbc:mysql://localhost/pm_distribution";
		String login="root";
		String pasdword="";
		Connection cn=null;
		Statement st=null;
		String sqlQuery=null;
		
		Workbook workbook = null;
		
		Cell observation=null;
		Cell tailleCardigan=null;
		Cell tailleCasquette=null;
		Cell tailleChemiseMC=null;
		Cell tailleChemiseML=null;
		Cell tailleGilet=null;
		Cell taillePantalon=null;
		Cell tailleParka=null;
		Cell taillePullOver=null;
		Cell tailleVeste=null;
		Cell typeTenue=null;
		
		
		try {
			workbook = Workbook.getWorkbook(new File("E:\\ENIM S4\\Stage PFA\\PM\\data.xls"));
			Sheet sheet = workbook.getSheet(4);
			
			for(int i=6;i<=143;i++) {
				observation=sheet.getCell(17, i);
				tailleCardigan=sheet.getCell(14, i);
				tailleCasquette=sheet.getCell(16, i);
				tailleChemiseMC=sheet.getCell(11, i);
				tailleChemiseML=sheet.getCell(10, i);
				tailleGilet=sheet.getCell(12, i);
				taillePantalon=sheet.getCell(9, i);
				tailleParka=sheet.getCell(13, i);
				taillePullOver=sheet.getCell(15, i);
				tailleVeste=sheet.getCell(8, i);
				typeTenue=sheet.getCell(7, i);
				
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, login, pasdword);
				st=cn.createStatement();
				
				if(!typeTenue.getContents().equals("NA") && typeTenue.getContents().length()!=0) {
					sqlQuery="INSERT INTO tenue (observation,tailleCardigan, tailleCasquette, tailleChemiseMC, tailleChemiseML, tailleGilet,"
							+ "taillePantalon, tailleParka, taillePullOver, tailleVeste, typeTenue) VALUES ("
							+ "'"+observation.getContents()+"',"
							+ "'"+tailleCardigan.getContents()+"',"
							+ Integer.parseInt(tailleCasquette.getContents())+","
							+ Integer.parseInt(tailleChemiseMC.getContents())+","
							+ Integer.parseInt(tailleChemiseML.getContents())+","
							+ "'" + tailleGilet.getContents() + "',"
							+ Integer.parseInt(taillePantalon.getContents())+","
							+ "'" + tailleParka.getContents() + "',"
							+ "'" + taillePullOver.getContents() + "',"
							+ Integer.parseInt(tailleVeste.getContents())+","
							+ "'" + typeTenue.getContents() + "'"
							+ ")";
					st.executeUpdate(sqlQuery);
					//System.out.println("i = " + i + " => " +sqlQuery);
				}
			}
			System.out.println("FIN .....");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
