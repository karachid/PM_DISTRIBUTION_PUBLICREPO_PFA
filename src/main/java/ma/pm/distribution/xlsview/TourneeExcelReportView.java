package ma.pm.distribution.xlsview;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import ma.pm.distribution.entities.Tournee;

public class TourneeExcelReportView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"tournees.xls\"");
		List<Tournee> listTour = (List<Tournee>) model.get("tournees");
		Sheet sheet = workbook.createSheet("Liste des tournees");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Numéro de tournée");
		header.createCell(1).setCellValue("Code postal du secteur");
		header.createCell(2).setCellValue("Type de la zone");
		header.createCell(3).setCellValue("Type de la tournée");
		header.createCell(4).setCellValue("Date de création");
		header.createCell(5).setCellValue("Moyen de locomotion");
		header.createCell(6).setCellValue("Trajet total");
		header.createCell(7).setCellValue("Nature Tournee");
		header.createCell(8).setCellValue("Montant mensuel Indemnité en Km");
		header.createCell(9).setCellValue("Fréquence de distribution hebdomadaire");
		header.createCell(10).setCellValue("Fréquence de distribution par jour");
		header.createCell(11).setCellValue("Type d'habitat dominant");
		header.createCell(12).setCellValue("Capacité distribution PIC");
		header.createCell(13).setCellValue("Capacité distribution hors PIC");
		header.createCell(14).setCellValue("Date de mise à jour");
		header.createCell(15).setCellValue("Observation tournée");
		 int rowNum = 1;
		 for(Tournee t:listTour){
		 Row row = sheet.createRow(rowNum++);
		 row.createCell(0).setCellValue(t.getNumTournee());
		 row.createCell(1).setCellValue(t.getSecteur().getCodePostal());
		 row.createCell(2).setCellValue(t.getTypeZone());
		 row.createCell(3).setCellValue(t.getTypeTournee());
		 row.createCell(4).setCellValue(t.getDateCreationTournee());
		 row.createCell(5).setCellValue(t.getMoyenLocomotion());
		 row.createCell(6).setCellValue(t.getTrajetTotal());
		 row.createCell(7).setCellValue(t.getNatureTournee());
		 row.createCell(8).setCellValue(t.getMontantMensuelIndemniteKm());
		 row.createCell(9).setCellValue(t.getFrequenceDistributionHebdomadaire());
		 row.createCell(10).setCellValue(t.getFrequenceDistributionJour());
		 row.createCell(11).setCellValue(t.getTypeHabitatDominant());
		 row.createCell(12).setCellValue(t.getCapaciteDistributionPIC());
		 row.createCell(13).setCellValue(t.getCapaciteDistributionHorsPIC());
		 row.createCell(14).setCellValue(t.getDateMaj());
		 row.createCell(15).setCellValue(t.getObservationTournee());
		 }
		 
	}

}
