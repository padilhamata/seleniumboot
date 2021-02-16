package com.umuarama.questionario.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.umuarama.questionario.accounts.Accounts;
import com.umuarama.questionario.repository.PesquisaMicrosoftRepository;

public class Principal {

	@Autowired
	static
	PesquisaMicrosoftRepository microsoftRepository;

	

	public static void main (String[]args) throws InterruptedException, IOException {


		File pasta = new File("/home/lucas/Downloads");
	
		List<String> pastaAnterior = Arrays.asList(pasta.list());
		//ArrayList<String> pastaAnterior = pasta.list();
	
		
		baixarMicrosolt();
		new SaveMicrosolft(pasta, pastaAnterior);
		//baixarGoogle();
		
		
	}

	
	/*
	private static void SaveMicrosolft(File pasta, List<String> pastaAnterior) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub

		
		
		String arquivo = "";
		List<String> pastaPosterior = Arrays.asList(pasta.list());
		//String[] pastaPosterior = pastas.list();
		for( String pastaPosterio: pastaPosterior) {
         if(!pastaAnterior.contains(pastaPosterio)) {
        arquivo = pastaPosterio;	
        
         }
		}
		
		FileInputStream arquivopoi = new FileInputStream(new File("/home/lucas/Downloads/teste.xlsx"));

  XSSFWorkbook workbook = new XSSFWorkbook(arquivopoi);

  XSSFSheet sheetAlunos = workbook.getSheetAt(0);

  Iterator<Row> rowIterator = sheetAlunos.iterator();
		
		System.out.println(rowIterator);
	
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
                    	 pesquisaMicrosolt.setHoraInicio(cell.getDateCellValue());
                          break;
                          //horaConclusão
                    case 2:
                    	pesquisaMicrosolt.setHoraConclusao(cell.getDateCellValue());
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
                    	pesquisaMicrosolt.setOs(Long.parseLong(cell.getStringCellValue()));
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
                    	pesquisaMicrosolt.setServicoCorretamente(cell.getStringCellValue().equalsIgnoreCase("Sim")? true : false);
                          break;  
                    case 14:
                    	System.out.println(cell.getStringCellValue());
                    	System.out.println(cell.getStringCellValue().replace(" ", "").equalsIgnoreCase("Sim")? true : false);
                    	pesquisaMicrosolt.setPrazoCombinado(cell.getStringCellValue().equalsIgnoreCase("Sim")? true : false);
                    	microsoftRepository.save(pesquisaMicrosolt);
                          break;
                          default:
                        	  System.err.print("Valor não computado");
                    }
             }
             
        	
        	
      }
		 arquivopoi.close();


	}

*/

	private static void baixarMicrosolt() throws InterruptedException {
		// TODO Auto-generated method stub
		Accounts acconts = new Accounts();
		// TODO Auto-generated method stub
		//System.setProperty(“webdriver.chrome.driver”, “C:/chromedriver.exe”);
		System.setProperty("webdriver.chrome.driver", "/home/lucas/Documentos/Estudos/chromedriver"); 
		//System.setProperty("webdriver.chrome.driver", "\\home\\lucas\\Documentos\\Estudos\\chromedriver"); 
/*
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
	*/	
		WebDriver driver = new ChromeDriver();

        driver.get("https://www.office.com/launch/forms?auth=1");
        driver.findElement(By.cssSelector(".form-control.ltr_override.input.ext-input.text-box.ext-text-box")).sendKeys(acconts.getLogin());
        driver.findElement(By.cssSelector(".button.ext-button.primary.ext-primary")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".form-control.input.ext-input.text-box.ext-text-box")).sendKeys(acconts.getSenha());
        driver.findElement(By.cssSelector(".button.ext-button.primary.ext-primary")).click();
        Thread.sleep(5000);
        	driver.get("https://forms.office.com/Pages/DesignPage.aspx?lang=pt-BR&origin=OfficeDotCom&route=Start&fromAR=1#Analysis=true&FormId=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAZ__rf9h-JURjFISVNVTTY4QldCQVVMUjROUlkzRlJWTi4u");
        	Thread.sleep(5000);	
        	driver.findElement(By.cssSelector(".analyze-view-export-button-label")).click();
        	Thread.sleep(5000);	
       driver.close();
	}





}
