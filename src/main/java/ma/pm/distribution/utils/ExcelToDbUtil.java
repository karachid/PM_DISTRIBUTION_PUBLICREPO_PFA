package ma.pm.distribution.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		ResultSet rs;
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
		
		StringBuilder sqlFields = new StringBuilder();
		StringBuilder sqlValues = new StringBuilder();
		String finalQuery;
		
		String dateCreationSplitted[];
		String dateCreationToInsert = null;
		String dateMajSplitted[];
		String dateMajToInsert = null;
		
		boolean isEmpty=false;
		
		Integer trajetTotalToInsert;
		Integer montantMensuelToInsert;
		Integer frequencePrJourToInsert;
		Integer capacitePicToInsert;
		Integer capaciteHorsPicToInsert;
		Integer numTourneeToInsert;
		
		int codePostalSecteur, idS;
		String secteurQuery;
		
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
				
				/*
				 Début : Traitement numéro tournée
				 */
				if(numTournee.getContents().split("-").length==2) {
					numTourneeToInsert= Integer.parseInt(numTournee.getContents().split("-")[1]);
					codePostalSecteur=Integer.parseInt(numTournee.getContents().split("-")[0]);
				}
				else {
					numTourneeToInsert=-1;
					codePostalSecteur=50;
				}
				/*
				 Fin : Traitement numéro tournée
				 */
				
				
				/*
				 Début : Extraire le id du secteur auquel apprtient la tournée
				 */
				if(codePostalSecteur!=50) {
					Class.forName("com.mysql.jdbc.Driver");
					cn = DriverManager.getConnection(url, login, pasdword);
					st=cn.createStatement();
					secteurQuery ="SELECT idS FROM secteur where codePostal="+codePostalSecteur+";";
					rs = st.executeQuery(secteurQuery);
					rs.next();
					idS=rs.getInt("idS");
				}
				else {
					idS=codePostalSecteur;
				}
				//System.out.println("idS  = " + idS );
				/*
				 Fin :  Extraire le id du secteur auquel apprtient la tournée
				 */
				
				
				/*
				 Début : Traitement Trajet Total
				 */
				if(trajetTotal.getContents().length()==0) {
					trajetTotalToInsert=null;
				}
				else {
					trajetTotalToInsert=Integer.parseInt(trajetTotal.getContents());
				}
				/*
				 Fin : Traitement Trajet Total
				 */
				
				/*
				 Début : Traitement montant Mensuel
				 */
				if(montantMensuel.getContents().length()==0) {
					montantMensuelToInsert=null;
				}
				else {
					montantMensuelToInsert=Integer.parseInt(montantMensuel.getContents());
				}
				/*
				 Fin : Traitement montant Mensuel
				 */
				
				/*
				 Début : Traitement fréquence par jour 
				 */
				if(frequencePrJour.getContents().length()==0) {
					frequencePrJourToInsert=null;
				}
				else {
					frequencePrJourToInsert= Integer.parseInt(frequencePrJour.getContents().split("/")[0]);
				}
				/*
				 Fin : Traitement fréquence par jour 
				 */
				
				
				/*
				 Début : Traitement capacite pic 
				 */
				if(capacitePic.getContents().length()==0) {
					capacitePicToInsert=null;
				}
				else {
					capacitePicToInsert=Integer.parseInt(capacitePic.getContents());
				}
				/*
				 Fin : Traitement capacite pic 
				 */
				
				/*
				 Début : Traitement capacite hors pic 
				 */
				if(capaciteHorsPic.getContents().length()==0) {
					capaciteHorsPicToInsert=null;
				}
				else {
					capaciteHorsPicToInsert=Integer.parseInt(capaciteHorsPic.getContents());
				}
				/*
				 Fin : Traitement capacite hors pic 
				 */
				
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, login, pasdword);
				st=cn.createStatement();
				
				sqlFields.append("INSERT INTO tournee (capaciteDistributionHorsPIC, capaciteDistributionPIC,");
				sqlValues.append("VALUES ( " + capaciteHorsPicToInsert + "," + capacitePicToInsert);
				
				/*
				 Début : Traitement date de création
				 */
				dateCreationSplitted = dateCreation.getContents().split("/");
				if(dateCreationSplitted.length==3) {
					dateCreationToInsert=dateCreation.getContents().split("/")[2]+"-"+dateCreation.getContents().split("/")[1]+"-"+dateCreation.getContents().split("/")[0];
				}else if(dateCreation.getContents().length()==2) {
					dateCreationToInsert=null;
				}else if(dateCreation.getContents().length()==4) {
					dateCreationToInsert=dateCreation.getContents()+"-01-01";
				}
				else {
					isEmpty=true;
				}
				if(dateCreationToInsert==null) {
					sqlFields.append(" dateCreationTournee, ");
					sqlValues.append(","+dateCreationToInsert);
				}
				else {
					sqlFields.append(" dateCreationTournee, ");
					sqlValues.append(",'"+dateCreationToInsert+"'");
				}
				
				isEmpty=false;
				/*
				 Fin : Traitement date de création
				 */
				
				/*
				 Début : Traitement date de MAJ
				 */
				dateMajSplitted = dateMaj.getContents().split("/");
				if(dateMajSplitted.length==3) {
					dateMajToInsert=dateMaj.getContents().split("/")[2]+"-"+dateMaj.getContents().split("/")[1]+"-"+dateMaj.getContents().split("/")[0];
				}else if(dateMajSplitted.length==1) {
					dateMajToInsert=dateMaj.getContents().split("/")[2]+"-01-01";
				}else {
					isEmpty=true;
				}
				if(!isEmpty) {
					sqlFields.append("dateMaj,");
					sqlValues.append(",'"+dateMajToInsert+"',");
				}
				isEmpty=false;
				/*
				 Fin : Traitement date de MAJ
				 */
				
				sqlFields.append("frequenceDistributionHebdomadaire, frequenceDistributionJour, 	montantMensuelIndemniteKm,"
						+ "typeMoyenLocomotion, natureTournee, numTournee, observation, statutTournee," + 
						"trajetTotal, typeHabitatDominant, typeTournee, typeZone, 	secteur_idS)");
				sqlValues.append( Integer.parseInt(frequenceHebdo.getContents().split("/")[0]) + ","
						+ frequencePrJourToInsert + "," + montantMensuelToInsert + ",'"
						+ moyenLoco.getContents() + "','" + natureTournee.getContents() + "'," + numTourneeToInsert + ",'"
						+ observation.getContents() + "','" + statutTournee.getContents() + "'," + trajetTotalToInsert + ",'"
						+ typeHabitatDominant.getContents() + "','" + typeTournee.getContents() + "','" + zone.getContents() + "',"+idS+")");				
				
				finalQuery=sqlFields.toString()+sqlValues.toString();
				
				System.out.println("i = "+ i);
				st.executeUpdate(finalQuery);
				
				//System.out.println("i = " + (i+1) + "=>" + finalQuery);
				
				sqlValues.delete(0, sqlValues.length());
				sqlFields.delete(0, sqlFields.length());
				
			}
			

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
