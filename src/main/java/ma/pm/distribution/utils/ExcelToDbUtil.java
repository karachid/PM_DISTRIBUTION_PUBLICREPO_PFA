package ma.pm.distribution.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelToDbUtil {
	
	public static void main(String[] args) {
		
		/* DataBase connection info */
		String url="jdbc:mysql://localhost/pm_distribution";
		String login="root";
		String pasdword="";
		Connection cn=null;
		Statement st=null;
		String sql=null;
		
		Workbook workbook = null;
		
		Cell zone=null;
		Cell numTournee=null;
		Cell dateCreation=null;
		Cell typeTournee=null;
		Cell moyenLoco=null;
		Cell trajetTotal=null;
		Cell montantMensuel=null;
		Cell frequenceHebdo=null;
		Cell frequencePrJour=null;
		Cell natureTournee=null;
		Cell typeHabitatDominant=null;
		Cell statutTournee=null;
		Cell capacitePic=null;
		Cell capaciteHorsPic=null;
		Cell dateMaj=null;
		Cell observation=null;
		
		try {
			/* Récupération du classeur Excel (en lecture) */
			workbook = Workbook.getWorkbook(new File("E:\\ENIM S4\\Stage PFA\\PM\\data.xls"));
			
			/* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
			Sheet sheet = workbook.getSheet(1);
			
			/*
			On peut également le faire avec getCell(nomCellule)
			Cell c5 = sheet.getCell("E13");
			*/
			
			for(int i=7;i<=137;i++) {
				zone = sheet.getCell(6,i);
				numTournee = sheet.getCell(7,i);
				dateCreation = sheet.getCell(10, i);
				typeTournee = sheet.getCell(12, i);
				moyenLoco = sheet.getCell(13, i);
				trajetTotal = sheet.getCell(15, i);
				montantMensuel = sheet.getCell(16, i);
				frequenceHebdo = sheet.getCell(17, i);
				frequencePrJour = sheet.getCell(18, i);
				natureTournee = sheet.getCell(19, i);
				typeHabitatDominant = sheet.getCell(20, i);
				statutTournee = sheet.getCell(21, i);
				capacitePic = sheet.getCell(22, i);
				capaciteHorsPic = sheet.getCell(23, i);
				dateMaj = sheet.getCell(24, i);
				observation = sheet.getCell(25, i);
				
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, login, pasdword);
				st=cn.createStatement();
				sql="INSERT INTO tournee (capaciteDistributionHorsPIC, capaciteDistributionPIC, dateCreationTournee, "
						+ "dateMaj, frequenceDistributionHebdomadaire, frequenceDistributionJour, 	montantMensuelIndemniteKm,"
						+ "moyenLocomotion, natureTournee, numTournee, observation, statutTournee, "
						+ "trajetTotal, typeHabitatDominant, typeTournee, typeZone) VALUES ("
						+ Integer.parseInt(capaciteHorsPic.getContents()) + "," + Integer.parseInt(capacitePic.getContents())
						+ "," + dateCreation.getContents().split("/")[2]+ ":" +dateCreation.getContents().split("/")[1]+ ":" 
						+ dateCreation.getContents().split("/")[0] + "," + dateMaj.getContents().split("/")[2] + ":"
						+ dateMaj.getContents().split("/")[1] + ":" + dateMaj.getContents().split("/")[0] + "," + Integer.parseInt(frequenceHebdo.getContents()) + ","
						+ Integer.parseInt(frequencePrJour.getContents()) + "," + Integer.parseInt(montantMensuel.getContents()) + ",'"
						+ moyenLoco.getContents() + "','" + natureTournee.getContents() + "'," + Integer.parseInt(numTournee.getContents()) + ",'"
						+ observation.getContents() + "','" + statutTournee.getContents() + "'," + Integer.parseInt(trajetTotal.getContents()) + ",'"
						+ typeHabitatDominant.getContents() + "','" + typeTournee.getContents() + "','" + zone.getContents() + "')" ;
				st.executeUpdate(sql);
				/*
				String contenuZone = zone.getContents();
				System.out.print(contenuZone+"#");
				
				String contenuNumTournee = numTournee.getContents();
				System.out.print(contenuNumTournee+"#");
				
				String contenuDateCreation = dateCreation.getContents();
				System.out.print(contenuDateCreation+"#");
				
				String contenuTypeTournee = typeTournee.getContents();
				System.out.print(contenuTypeTournee+"#");
				
				String contenuMoyenLoco = moyenLoco.getContents();
				System.out.print(contenuMoyenLoco+"#");
				
				String contenuTrajetTotal = trajetTotal.getContents();
				System.out.print(contenuTrajetTotal+"#");
				
				String contenuMontantMensuel = montantMensuel.getContents();
				System.out.print(contenuMontantMensuel+"#");
				
				String contenuFrequenceHebdo = frequenceHebdo.getContents();
				System.out.print(contenuFrequenceHebdo+"#");
				
				String contenuFrequencePrJour = frequencePrJour.getContents();
				System.out.print(contenuFrequencePrJour+"#");
				
				String contenuNatureTournee = natureTournee.getContents();
				System.out.print(contenuNatureTournee+"#");
				
				String contenuTypeHabitatDominant = typeHabitatDominant.getContents();
				System.out.print(contenuTypeHabitatDominant+"#");
				
				String contenuStatutTournee = statutTournee.getContents();
				System.out.print(contenuStatutTournee+"#");
				
				String contenuCapacitePic = capacitePic.getContents();
				System.out.print(contenuCapacitePic+"#");
				
				String contenuCapaciteHorsPic = capaciteHorsPic.getContents();
				System.out.print(contenuCapaciteHorsPic+"#");
				
				String contenuDateMaj = dateMaj.getContents();
				System.out.print(contenuDateMaj+"#");
				
				String contenuObservation = observation.getContents();
				System.out.print(contenuObservation);
				
				System.out.println("");
				*/
				
			}
			
			/* On peut récupérer le contenu d'une cellule en utilisant la méthode getContents() */
			

		} 
		catch (BiffException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(workbook!=null){
				/* On ferme le worbook pour libérer la mémoire */
				workbook.close(); 
			}
		}
	}
}
