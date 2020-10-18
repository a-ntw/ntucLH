
public class argsFor {

    public static void main(String args[]) throws Exception {
        System.out.println(" CLA : " + args.length);
        /* for(int i = 0; i < args.length; i++){  
            System.out.println(" args[" + i + "] = " + args[i]);
        }*/

        for (String arg : args) {
            System.out.println(" CLA's " + arg);
        }
        
        int i = 10;
        int j = 10;

        System.out.println("\n i:" + i 
                + "\n i++ " + i++ +"\n ++i " +  ++i 
                + "\n *= j "  ) ;

    }
}
/*
antw@Mac-mini m3w1cp2Java % java argsFor qwed qweqwe qweqwe qweqwe
 CLA : 4
 CLA's qwed
 CLA's qweqwe
 CLA's qweqwe
 CLA's qweqwe

 i:10
 i++ 10
 ++i 12
 *= j 
antw@Mac-mini m3w1cp2Java % 
*/