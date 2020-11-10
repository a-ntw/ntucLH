
package com.mycompany.bankingappicationmaven;

import java.util.Comparator;

public class SortByAccountName implements Comparator<ITransaction> {

    @Override
    public int compare(ITransaction o1, ITransaction o2) {
        return o1.getAccountName().compareTo(o2.getAccountName());
//        if (o1.getAccountNo() < o2.getAccountNo()) { return -1;
//        } else if (o1.getAccountNo() > o2.getAccountNo()) { return 1;
//        } else { return 0;
//        }

    }

}
