package com.sapient.day3.factory;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;    
class GenerateBill{  
    public static void main(String args[])throws IOException{  
    	Logger logger = LoggerFactory.getLogger(GenerateBill.class);
      GetPlanFactory planFactory = new GetPlanFactory();  
        
      logger.info("Enter the name of plan for which the bill will be generated: ");  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
      String planName=br.readLine();  
      System.out.print("Enter the number of units for bill will be calculated: ");  
      int units=0;
	try {
		units = Integer.parseInt(br.readLine());
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.error("Must be a integer");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  
      Plan p = planFactory.getPlan(planName);  
      //call getRate() method and calculateBill()method of DomesticPaln.  
  
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units);  
            }  
    }//end of GenerateBill class.  

