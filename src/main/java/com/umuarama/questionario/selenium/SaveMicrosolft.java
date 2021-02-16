package com.umuarama.questionario.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.umuarama.questionario.models.PesquisaMicrosolt;
import com.umuarama.questionario.repository.PesquisaMicrosoftRepository;

public class SaveMicrosolft {
	@Autowired
	PesquisaMicrosoftRepository microsoftRepository;
	public SaveMicrosolft(File pasta, List<String> pastaAnterior) throws IOException {
		// TODO Auto-generated constructor stub
		EntityManagerFactory entityManagerFactory 
        = Persistence.createEntityManagerFactory("Clientes-PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    entityManager.getTransaction().begin();
	  entityManager.createNativeQuery("TRUNCATE TABLE pesquisamicrosolt").executeUpdate();
   
    
		String arquivo = "";
		List<String> pastaPosterior = Arrays.asList(pasta.list());
		//String[] pastaPosterior = pastas.list();
		for( String pastaPosterio: pastaPosterior) {
         if(!pastaAnterior.contains(pastaPosterio)) {
        arquivo = pastaPosterio;	
        
         }
		}
		
		FileInputStream arquivopoi = new FileInputStream(new File("/home/lucas/Downloads/"+arquivo));

  XSSFWorkbook workbook = new XSSFWorkbook(arquivopoi);

  XSSFSheet sheetAlunos = workbook.getSheetAt(0);

  Iterator<Row> rowIterator = sheetAlunos.iterator();
		
		System.out.println(rowIterator);
	try {
		 while (rowIterator.hasNext()) {
             Row row = rowIterator.next();
             Iterator<Cell> cellIterator = row.cellIterator();
           
             PesquisaMicrosolt pesquisaMicrosolt = new PesquisaMicrosolt();
             DataFormatter formatter = new DataFormatter();
             while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println(cell.getRowIndex());
                    if(cell.getRowIndex() == 0 || cell.getColumnIndex() == 4) {
                    	continue;
                    }
                    switch (cell.getColumnIndex()) {
                    //id
                    case 0:
                    	System.out.println(cell.getNumericCellValue());
                    	pesquisaMicrosolt.setId((long) cell.getNumericCellValue());
                          break;
                          //horaInicio
                    case 1:
                    	 //Cell cell = sheet.getRow(i).getCell(0);
                    	System.out.println(cell.getDateCellValue());
                    	 pesquisaMicrosolt.setHorainicio(cell.getDateCellValue());
                          break;
                          //horaConclusão
                    case 2:
                    	pesquisaMicrosolt.setHoraconclusao(cell.getDateCellValue());
                    	System.out.println(formatter.formatCellValue(cell));
                          break;
                          //email
                    case 3:
                    	System.out.println(formatter.formatCellValue(cell));
                    	pesquisaMicrosolt.setEmail(cell.getStringCellValue());
                          break;
                          //nome
                    case 5:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setNome(cell.getStringCellValue());
                          break;
                          //veiculo
                    case 6:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setVeiculo(cell.getStringCellValue());
                          break;
                    case 7:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setConcessionaria(cell.getStringCellValue());
                          break;
                    case 8:
                    	System.out.println(cell.getDateCellValue());
                    	pesquisaMicrosolt.setData(cell.getDateCellValue());
                          break;
                    case 9:
                    	System.out.println(cell.getStringCellValue());
                    	//pesquisaMicrosolt.setOs(Long.parseLong(cell.getStringCellValue()));
                          break;
                    case 10:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setReclamacao(cell.getStringCellValue());
                          break;
                    case 11:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setConsultor(cell.getStringCellValue());
                          break;
                    case 12:
                    	System.out.println(cell.getStringCellValue());
                    	pesquisaMicrosolt.setTecnico(cell.getStringCellValue());
                          break;
                    case 13:
                    	System.out.println(cell.getStringCellValue());
                    	System.out.println(cell.getStringCellValue().replace(" ", "").equalsIgnoreCase("Sim")? true : false);
                    	pesquisaMicrosolt.setServicocorretamente(cell.getStringCellValue().equalsIgnoreCase("Sim")? true : false);
                          break;  
                    case 14:
                    	System.out.println(cell.getStringCellValue());
                    	System.out.println(cell.getStringCellValue().replace(" ", "").equalsIgnoreCase("Sim")? true : false);
                    	pesquisaMicrosolt.setPrazocombinado(cell.getStringCellValue().equalsIgnoreCase("Sim")? true : false);
                    	

                    	 // entityManager.createQuery("DELETE FROM pesquisamicrosolt").executeUpdate();
                    	  entityManager.persist(pesquisaMicrosolt);
                    	 
                          break;
                          default:
                        	  System.err.print("Valor não computado");
                    }
             }
	     
        	
        	
      }
	}catch (Exception e) {
		// TODO: handle exception
		System.err.println(e);
	}
		 arquivopoi.close();
		 entityManager.getTransaction().commit();
		 entityManager.close();
		    entityManagerFactory.close();
	}

}
