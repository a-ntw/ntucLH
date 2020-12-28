/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfsb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author chand
 */
@Stateful
public class Cart implements CartLocal {

    List <String> items;
    
    public Cart() {
        items = new ArrayList<>();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public void removeItem(String item) {
        items.remove(item);
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Remove
    public void remove() {
        items = null;
    }
    
    
}
