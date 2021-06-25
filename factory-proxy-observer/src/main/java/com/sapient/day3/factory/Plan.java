package com.sapient.day3.factory;

import java.io.*;      
abstract class Plan{  
         protected double rate;  
         abstract void getRate();  
   
         public void calculateBill(int units){  
              System.out.println(units*rate);  
          }  
}//end of Plan class
class  DomesticPlan extends Plan{  
    //@override  
     public void getRate(){  
         rate=3.50;              
    }  
}//end of DomesticPlan class.  
class  CommercialPlan extends Plan{  
//@override   
public void getRate(){   
    rate=7.50;  
}     
}
class  InstitutionalPlan extends Plan{  
//@override  
public void getRate(){   
    rate=5.50;  
}  
}

