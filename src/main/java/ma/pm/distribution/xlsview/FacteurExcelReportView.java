package ma.pm.distribution.xlsview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import ma.pm.distribution.entities.Facteur;

public class FacteurExcelReportView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=\"facteurs.xls\"");
		List<Facteur> listFacts = (List<Facteur>) model.get("facteurs");
		System.out.println(listFacts.get(0).toString());
		Sheet sheet = workbook.createSheet("Liste des facteurs");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Matricule");
		header.createCell(1).setCellValue("Nom");
		header.createCell(2).setCellValue("Prenom");
		header.createCell(3).setCellValue("Sexe");
		header.createCell(4).setCellValue("Date de naissance");
		header.createCell(5).setCellValue("Date de recrutement");
		header.createCell(6).setCellValue("Observation facteur");
		header.createCell(7).setCellValue("Tenue");
		header.createCell(8).setCellValue("Type tenue");
		header.createCell(9).setCellValue("Taille veste");
		header.createCell(10).setCellValue("Taille pantalon");
		header.createCell(11).setCellValue("Taille chemise ML");
		header.createCell(12).setCellValue("Taille chemise MC");
		header.createCell(13).setCellValue("Taille gilet");
		header.createCell(14).setCellValue("Taille parka");
		header.createCell(15).setCellValue("Taille cardigan");
		header.createCell(16).setCellValue("Taille Pull Over");
		header.createCell(17).setCellValue("Taille casquette");
		header.createCell(18).setCellValue("Observation tenue");
		
		
		 int rowNum = 1;
		 for(Facteur f:listFacts){
		 Row row = sheet.createRow(rowNum++);
		 row.createCell(0).setCellValue(f.getMatricule());
		 row.createCell(1).setCellValue(f.getNom());
		 row.createCell(2).setCellValue(f.getPrenom());
		 row.createCell(3).setCellValue(f.getSexe());
		 row.createCell(4).setCellValue(f.getDateNaissance());
		 row.createCell(5).setCellValue(f.getDateRecrutement());
		 row.createCell(6).setCellValue(f.getObservationFacteur());
		 if(f.getTenue()!=null) {
			 row.createCell(7).setCellValue("OUI");
			 row.createCell(8).setCellValue(f.getTenue().getTypeTenue());
			 row.createCell(9).setCellValue(f.getTenue().getTailleVeste());
			 row.createCell(10).setCellValue(f.getTenue().getTaillePantalon());
			 row.createCell(11).setCellValue(f.getTenue().getTailleChemiseML());
			 row.createCell(12).setCellValue(f.getTenue().getTailleChemiseMC());
			 row.createCell(13).setCellValue(f.getTenue().getTailleGilet());
			 row.createCell(14).setCellValue(f.getTenue().getTailleParka());
			 row.createCell(15).setCellValue(f.getTenue().getTailleCardigan());
			 row.createCell(16).setCellValue(f.getTenue().getTaillePullOver());
			 row.createCell(17).setCellValue(f.getTenue().getTailleCasquette());
			 row.createCell(18).setCellValue(f.getTenue().getObservationTenue());
		 }else {
			 row.createCell(7).setCellValue("NON");
		 }
		 
		 }
		
	}

}
