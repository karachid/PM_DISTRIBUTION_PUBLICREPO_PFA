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

public class CycloExcelFiletoDb {

	public static void main(String[] args) {
		
		
		/* DataBase connection info */
		String url="jdbc:mysql://localhost/pm_distribution";
		String login="root";
		String pasdword="";
		Connection cn=null;
		Statement st=null;
		StringBuilder sqlFields= new StringBuilder();
		StringBuilder sqlValues= new StringBuilder();
		String finalQuery;
		
		Workbook workbook = null;
		
		Cell annee=null;
		Cell assure=null;
		Cell causeNonOp=null;
		Cell couvertureProv=null;
		Cell dateAffectation=null;
		Cell dateCarteGrise=null;
		Cell datePremiereUtilisation=null;
		Cell numChassis=null;
		Cell numImmat=null;
		Cell numMoteur=null;
		Cell observation=null;
		Cell refPoliceAssurance=null;
		Cell statutCyclo=null;
		
		Cell marque=null;
		Cell modele=null;
		
		Integer idMarque=0, idModele=0;
		
		String dateAffectationSplitted[];
		String dateAffectationToInsert=null;
		
		String dateCarteGriseSplitted[];
		String dateCarteGriseToInsert=null;
		
		String datePremiereUtilisationSplitted[];
		String datePremiereUtilisationToInsert=null;
		
		int anneeToInsert=-1;
		
		boolean isEmpty=false;
		
		try {
			/* Récupération du classeur Excel (en lecture) */
			workbook = Workbook.getWorkbook(new File("E:\\ENIM S4\\Stage PFA\\PM\\data.xls"));
			
			/* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
			Sheet sheet = workbook.getSheet(3);
			
			for(int i=7;i<=139;i++) {
				numChassis = sheet.getCell(6,i);
				numMoteur = sheet.getCell(7,i);
				numImmat = sheet.getCell(8, i);
				dateCarteGrise = sheet.getCell(9, i);
				datePremiereUtilisation = sheet.getCell(10, i);
				annee = sheet.getCell(11, i);
				statutCyclo = sheet.getCell(12, i);
				causeNonOp = sheet.getCell(13, i);
				assure = sheet.getCell(15, i);
				couvertureProv = sheet.getCell(16, i);
				refPoliceAssurance = sheet.getCell(17, i);
				dateAffectation = sheet.getCell(21, i);
				observation = sheet.getCell(23, i);
				
				marque = sheet.getCell(4,i);
				if(marque.getContents().toLowerCase().equals("peugeot")) {
					idMarque=1;
				}else if(marque.getContents().toLowerCase().equals("mbk")) {
					idMarque=2;
				}else if(marque.getContents().toLowerCase().equals("yamaha")) {
					idMarque=3;
				}else if(marque.getContents().toLowerCase().equals("kymco")) {
					idMarque=4;
				}else {
					idMarque=null;
				}
				
				modele = sheet.getCell(5,i);
				if(modele.getContents().toUpperCase().equals("AV 881")) {
					idModele=1;
				}else if(modele.getContents().toUpperCase().equals("FOX")) {
					idModele=2;
				}else if(modele.getContents().toUpperCase().equals("E20020")) {
					idModele=3;
				}else if(modele.getContents().toUpperCase().equals("MBK 887")) {
					idModele=4;
				}else if(modele.getContents().toUpperCase().equals("AGILITY50")) {
					idModele=5;
				}else if(modele.getContents().toUpperCase().equals("KYMCO")) {
					idModele=6;
				}else {
					idModele=null;
				}
				
				if (annee.getContents().length()==5) {
					anneeToInsert=Integer.parseInt(annee.getContents().replaceAll(""+annee.getContents().charAt(1), ""));
				}else if(annee.getContents().length()==4) {
					anneeToInsert=Integer.parseInt(annee.getContents());
				}else if(annee.getContents().isEmpty()) {
					anneeToInsert=-1;
				}
				
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url, login, pasdword);
				st=cn.createStatement();
				sqlFields.append("INSERT INTO moyenlocomotion (annee, assure, causeSiNonOperationnel, couvertureProvisiore,");
				sqlValues.append(" VALUES ("+ anneeToInsert + ",'"
						+ assure.getContents() + "','" + causeNonOp.getContents() + "','" + couvertureProv.getContents()+"'");
			
				/*
				Début : Traitement de la date d'affectation
				*/
				dateAffectationSplitted=dateAffectation.getContents().split("/");
				if(dateAffectationSplitted.length==3) {
					dateAffectationToInsert = dateAffectation.getContents().split("/")[2]+"-"
											+dateAffectation.getContents().split("/")[1]+"-"
											+ dateAffectation.getContents().split("/")[0];
				}else {
					isEmpty=true;
				}
				if(!isEmpty) {
					sqlFields.append("dateAffectation,");
					sqlValues.append(",'"+dateAffectationToInsert+"'");
				}
				isEmpty=false;
				/*
				 Fin : Traitement de la date d'affectation
				 */
				
				/*
				Début : Traitement de la date de la carte grise
				*/
				dateCarteGriseSplitted=dateCarteGrise.getContents().split("/");
				if(dateCarteGriseSplitted.length==3) {
					dateCarteGriseToInsert = dateCarteGrise.getContents().split("/")[2]+"-"
											+ dateCarteGrise.getContents().split("/")[1]+"-"
											+dateCarteGrise.getContents().split("/")[0];
				}else {
					isEmpty=true;
				}
				if(!isEmpty) {
					sqlFields.append("dateCarteGrise,");
					sqlValues.append(",'"+dateCarteGriseToInsert+"'");
				}
				isEmpty=false;
				/*
				 Fin : Traitement de la date de la carte grise
				 */
				
				/*
				Début : Traitement de la date de première utilisation
				*/
				datePremiereUtilisationSplitted=datePremiereUtilisation.getContents().split("/");
				if(datePremiereUtilisationSplitted.length==3) {
					datePremiereUtilisationToInsert = datePremiereUtilisation.getContents().split("/")[2]+"-"
													+datePremiereUtilisation.getContents().split("/")[1]+"-"
													+ datePremiereUtilisation.getContents().split("/")[0];
				}else {
					isEmpty=true;
				}
				if(!isEmpty) {
					sqlFields.append("datePremiereUtilisation,");
					sqlValues.append(",'"+datePremiereUtilisationToInsert+"'");
				}
				isEmpty=false;
				/*
				 Fin : Traitement de la date de première utilisation
				 */
				
				sqlFields.append("numChassis, numImmatriculation, numMoteur, observation, refPoliceAssurance, statutCyclo, marque_idMrq, modele_idMrq)");
				sqlValues.append(",'"+numChassis.getContents()+"','"+numImmat.getContents()+"','"+numMoteur.getContents()+"','"+observation.getContents()+"','"
						  +refPoliceAssurance.getContents()+"','"+ statutCyclo.getContents()+"',"+idMarque+","+idModele+");");
					
				System.out.println("i = "+i);
				finalQuery=sqlFields.toString()+sqlValues.toString();
				st.executeUpdate(finalQuery);
				
				System.out.println(sqlFields.toString()+sqlValues.toString());
				sqlValues.delete(0, sqlValues.length());
				sqlFields.delete(0, sqlFields.length());
				
//				if(i==8)break;
				
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
