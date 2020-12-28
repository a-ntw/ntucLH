/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfsb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chand
 */
@Local
public interface CartLocal {

    void addItem(String item);

    void removeItem(String item);

    List<String> getItems();

    void remove();
    
}
