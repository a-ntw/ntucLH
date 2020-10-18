
public class enumSimple {

    enum CountryCodes {
        SINGAPORE("SG", 500f, "+65"),
        MALAYSIA("MY", 650f, "+60"),
        INDONESIA("ID", 750f, "+61"),
        THAILAND("TH", 250f, "+62"),
        CHINA("CN", 350f, "+85"),
        INDIA("IN", 950f, "+91"),
        SRILANKA("SL", 7150f, "+92");

        String cCode;
        float bal;
        String idd;

        CountryCodes(String code, float ba, String IDDC) {
            cCode = code;
            this.bal = ba;
            idd = IDDC;
        }

        public String getCountryCode() {
            return this.cCode;
        }

        public String getIDDCode() {
            return this.idd;
        }

        public float getBalance() {
            return this.bal;
        }
    }

    public static void main(String[] args) {

        System.out.println(" Country Codes ");

        for (CountryCodes cName : CountryCodes.values()) {
            System.out.println(cName + "\t  ::  " + cName.getCountryCode()
                    + "  ::  " + cName.getIDDCode()
                    + "  ::  " + cName.getBalance());
        }

        CountryCodes cn = CountryCodes.valueOf("MALAYSIA");
        
        System.out.println(cn + "\t == " + cn.getCountryCode()
                + "  ==  " + cn.getIDDCode()
                + "  ==  " + cn.getBalance());
    }
}

/*
antw@Mac-mini cp2Java % javac enumSimple.java
antw@Mac-mini cp2Java % java enumSimple      
 Country Codes 
SINGAPORE	  ::  SG  ::  +65  ::  500.0
MALAYSIA	  ::  MY  ::  +60  ::  650.0
INDONESIA	  ::  ID  ::  +61  ::  750.0
THAILAND	  ::  TH  ::  +62  ::  250.0
CHINA	  ::  CN  ::  +85  ::  350.0
INDIA	  ::  IN  ::  +91  ::  950.0
SRILANKA	  ::  SL  ::  +92  ::  7150.0
MALAYSIA	 == MY  ==  +60  ==  650.0
antw@Mac-mini cp2Java % 
*/
