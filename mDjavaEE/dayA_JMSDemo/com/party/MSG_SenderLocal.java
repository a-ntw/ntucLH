
package com.party;

import javax.ejb.Local;

/**
 *
 * @author antw
 */
@Local
public interface MSG_SenderLocal {

    int sendMsg(String msg);

}
