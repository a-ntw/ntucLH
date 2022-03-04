
public class javaSe1A {

    public static void main(String args[]) {
        
        StringBuilder sb01 = new StringBuilder();
        sb01.append(" World");

        byte b = 40;
        short s1 = 8;
        int s2a = b + s1;
        char s2b = (char) (b + s1);
        System.out.println("s2a= " + s2a + ", s2b= " + s2b);
        s2b = '\u0041';
        System.out.println("s2b= " + s2b);
        
        int i = 9;
        long y = 92L, j;
        
        j = (long) i + 1_000_000_000;
        System.out.println("j=" + j);
        
        j = i + 1_000_000_000L;
        System.out.println("j=" + j);
        
        j = i + 1_000_000_000 * 1L;
        System.out.println("j=" + j);
        
        double d = 1232.31;
        //casting --> (TargetDataType) value
        float f = (float) 123.12;
        
        // Converting a String to an int
        int myInt1 = Integer.parseInt("111");
        
        // Converting a String to a double
        double myDbl = Double.parseDouble("11.1F");

        // Converting a String to boolean
        boolean myBool = Boolean.valueOf("FALSE");
        
        System.out.println("myInt1="+ myInt1+", myDbl="+ myDbl+ ", myBool=" + myBool);
        
        // Program Flow When an Exception Is Caught
        javaSe1A theUtils = new javaSe1A();
        theUtils.doThis();
        System.out.println("Back to main method");
        
    }
    
    public void doThis() {
        try {
            doThat();
        } catch (Exception e) {
            System.out.println("doThis -  " + e.getMessage());
        }
    }
    public void doThat() throws Exception {
        System.out.println("doThat: Throwing exception");
        throw new Exception("Exception caught:  Ouch!");
    }
}

/* OUTPUT
s2a= 48, s2b= 0
s2b= A
j=1000000009
j=1000000009
j=1000000009
myInt1=111, myDbl=11.1, myBool=false
doThat: Throwing exception
doThis -  Exception caught:  Ouch!
Back to main method
*/