package mavenexecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonMethods {

	
public static ArrayList<String> GetExcelData(String Tcname) throws IOException	{
		

		// String	 Tcname = "Login name valid";
		 
		ArrayList<String> al= new ArrayList();
		   
	//"C:\Users\marri\OneDrive\Desktop\AUTOMATION_TESTING\Book22.xlsx";
		
		String Testdatapath= System.getProperty("user.dir")+"\\Resources\\Book22.xlsx";
		
	    FileInputStream fis =new FileInputStream(Testdatapath);
			
		XSSFWorkbook wrbook = new 	XSSFWorkbook(fis);
		
		XSSFSheet wrsheet = wrbook.getSheet("Registration");
		
		Iterator<Row> rows =wrsheet.iterator();
		
		while(rows.hasNext())
					
				{
				      Row specificrow =	rows.next();
				      
				    String Tcnameruntime =  specificrow.getCell(0).getStringCellValue();
				    
			     if(Tcnameruntime.equalsIgnoreCase(Tcname)) 
				     
				    //  if (specificrow.getCell(0).getStringCellValue().equalsIgnoreCase(Tcname));

				    {
				   Iterator<Cell> cells = specificrow.iterator();
				   
				    while(cells.hasNext())
				   {
					  Cell specificcell = cells.next();
					  
					String str=  specificcell.getStringCellValue();
					
					al.add(str);
					System.out.println(str);
					
				   }
				    }
				   
				    
				   for(String str : al)
				    {
				    	System.out.println(str);
				    }
				    
				}
				wrbook.close();
				return al;
				
				

        }


			}


				
			



			
		
		
		



