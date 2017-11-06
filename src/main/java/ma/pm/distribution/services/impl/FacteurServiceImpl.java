package ma.pm.distribution.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ma.pm.distribution.dao.IFacteurDAO;
import ma.pm.distribution.entities.Facteur;
import ma.pm.distribution.services.IFacteurService;

@Transactional
public class FacteurServiceImpl implements IFacteurService {
	
	private IFacteurDAO dao;

	public void setDao(IFacteurDAO dao) {
		this.dao = dao;
	}

	@Override
	public Facteur save(Facteur entity) {
		return dao.save(entity);
	}

	@Override
	public Facteur update(Facteur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Facteur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Facteur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public List<Facteur> facteurImportXls(MultipartFile file) throws Exception {
		List<Facteur> lstFacts = new ArrayList<>();
			int i = 1;
			// Creates a workbook object from the uploaded excelfile
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			// Creates a worksheet object representing the first sheet
			HSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				Facteur user = new Facteur();
				// Creates an object representing a single row in excel
				HSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				user.setMatricule((int)row.getCell(0).getNumericCellValue());
				user.setNom(row.getCell(1).getStringCellValue());
				user.setPrenom(row.getCell(2).getStringCellValue());
				System.out.println(user.toString());
				// persist data into database in here
				lstFacts.add(user);
			}			
			workbook.close();
			for(Facteur l : lstFacts) System.out.println(l.getMatricule() + " || " + l.getNom() + " || " + l.getPrenom()); 
		
		return lstFacts;
	}

	@Override
	public List<Facteur> facteurImportXlsx(MultipartFile file) throws Exception {
		List<Facteur> lstFacts = new ArrayList<>();
			int i = 1;
			// Creates a workbook object from the uploaded excelfile
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			// Creates a worksheet object representing the first sheet
			HSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				Facteur user = new Facteur();
				// Creates an object representing a single row in excel
				HSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				user.setMatricule((int)row.getCell(0).getNumericCellValue());
				user.setNom(row.getCell(1).getStringCellValue());
				user.setPrenom(row.getCell(2).getStringCellValue());
				// persist data into database in here
				lstFacts.add(user);
			}			
			workbook.close();
		return lstFacts;
	}

}
