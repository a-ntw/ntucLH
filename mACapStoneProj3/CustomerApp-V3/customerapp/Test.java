/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

/**
 *
 * @author chand
 */
public class Test {
    
    @Override 
    public String toString() {
        return "Default toString () methods ";
    }
    
    public String toStringv1() {
        return "Default toStringv1 () methods ";
    }
    

    
    public static void main(String [] args){
    

        Test t = new Test();
        
        System.out.println(t);
        
        System.out.println(t.toStringv1());
        
    }
    
}
