package ma.pm.distribution.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class FacteurFileToDataBase {

	public static void main(String[] args) {
		/* DataBase connection info */
		String url="jdbc:mysql://localhost/pm_distribution";
		String login="root";
		String pasdword="";
		Connection cn=null;
		Statement st=null;
		String sqlquery=null;
		
		Workbook workbook = null;
		
		Cell anneeNaissance=null;
		Cell anneeRecrutement=null;
		Cell matricule=null;
		Cell nom=null;
		Cell observation=null;
		Cell prenom=null;
		Cell sexe=null;
		
		try {
			
			
			/* Récupération du classeur Excel (en lecture) */
			workbook = Workbook.getWorkbook(new File("E:\\ENIM S4\\Stage PFA\\PM\\data.xls"));
			
			/* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
			Sheet sheet = workbook.getSheet(6);
			
			for(int i=126;i<=132;i++) {
				anneeNaissance=sheet.getCell(7, i);
				anneeRecrutement=sheet.getCell(8, i);
				matricule=sheet.getCell(4, i);
				nom=sheet.getCell(5, i);
				observation=sheet.getCell(19, i);
				prenom=sheet.getCell(3, i);
				sexe=sheet.getCell(6, i);
				
				
				
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, login, pasdword);
				st=cn.createStatement();
				
				
				
				if(!anneeNaissance.getContents().equals("*")) {
					if(!anneeRecrutement.getContents().equals("*")) {
						sqlquery= "INSERT INTO facteur (dateNaissance, dateRecrutement, matricule,nom, observation, prenom, sexe)"
								+ " values ("
								+ "'" + anneeNaissance.getContents().split("/")[2]+"-"+anneeNaissance.getContents().split("/")[1]+"-"+anneeNaissance.getContents().split("/")[0]+"',"
								+ "'" + anneeRecrutement.getContents().split("/")[2]+"-"+anneeRecrutement.getContents().split("/")[1]+"-"+anneeRecrutement.getContents().split("/")[0]+"',"
								+ Integer.parseInt(matricule.getContents())+","
								+ "'"+nom.getContents()+"',"
								+ "'"+observation.getContents()+"',"
								+ "'"+prenom.getContents()+"',"
								+ "'"+sexe.getContents()+"'"
								+ ")";
					}
					else {
						sqlquery= "INSERT INTO facteur (dateNaissance, matricule,nom, observation, prenom, sexe)"
								+ " values ("
								+ "'" + anneeNaissance.getContents().split("/")[2]+"-"+anneeNaissance.getContents().split("/")[1]+"-"+anneeNaissance.getContents().split("/")[0]+"',"
								+ Integer.parseInt(matricule.getContents())+","
								+ "'"+nom.getContents()+"',"
								+ "'"+observation.getContents()+"',"
								+ "'"+prenom.getContents()+"',"
								+ "'"+sexe.getContents()+"'"
								+ ")";
					}
					System.out.println("i = " + i);
					System.out.println(sqlquery);
					st.executeUpdate(sqlquery);
				}
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
