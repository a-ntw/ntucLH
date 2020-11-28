/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtableview;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author antw
 */
public class alist {

    private int custID;
    private String custName;

    public alist(int custID, String custName) {
        this.custID = custID;
        this.custName = custName;
    }

    @Override
    public String toString() {
        return custID + ", " + custName;
    }
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public static ObservableList<alist> oRows() {
        ObservableList<alist> sr = FXCollections.observableArrayList();
        sr.add(new alist(11, "Eleven"));
        sr.add(new alist(12, "Twelve"));
        sr.add(new alist(13, "Thirteen"));
        sr.add(new alist(20, "Twenty"));
        sr.add(new alist(10, "Ten"));
        sr.add(new alist(0, "Zero"));
        return sr;
    }

    public static List<alist> rows() {
        List<alist> r = new ArrayList<>();
        r.add(new alist(11, "Eleven"));
        r.add(new alist(12, "Twelve"));
        r.add(new alist(13, "Thirteen"));
        r.add(new alist(0, "Zero"));
        return r;
    }

    public static void main(String[] args) {
        rows().forEach(ea -> {
            System.out.println(ea);
        });
    }

}
