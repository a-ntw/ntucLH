/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.party;

import javax.ejb.Local;

/**
 *
 * @author chand
 */
@Local
public interface MSG_SenderLocal {

    int sendMsg(String msg);
    
}
