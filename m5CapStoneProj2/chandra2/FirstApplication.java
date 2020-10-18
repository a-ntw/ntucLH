package com.ntuc;

public class FirstApplication {

    public static String geoLocation ;
   
    public String loginMethod;
    
    static{ // Instance Initializer 
      
       System.out.println(" Static Init");
    }

    static { // Static Initializer 
      
       System.out.println(" Static Init");
    }
    
    public FirstApplication() {
        System.out.println(" Zero - Arg Constructor ");
    }
    
    public FirstApplication(int i) {
        
        System.out.println(" One - Arg Constructor ");
    }
    
    { // Instance Initializer 
      
        if(geoLocation.equals("SG")){
            //login using SG Gov DB 
            loginMethod = "SG_GOV_DB1";
        }
    }

    { // Instance Initializer 
      
        if(geoLocation.equals("MY")){
            //login using MY  Gov DB 
            loginMethod = "MY_GOV";
        }
    }
}

class SecondApplication {

    public static void main(String[] args) {

     FirstApplication.geoLocation = "SG";
     FirstApplication sgFA = new FirstApplication();
     System.out.println(" SG Specific Logic " + sgFA.loginMethod);
        
     FirstApplication.geoLocation = "MY";  
     FirstApplication myFA = new FirstApplication();
     System.out.println(" MY Specific Logic " + myFA.loginMethod);
    }
}
