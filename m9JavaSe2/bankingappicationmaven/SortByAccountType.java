
package com.mycompany.bankingappicationmaven;

import java.util.Comparator;

public class SortByAccountType implements Comparator<ITransaction> {

    @Override
    public int compare(ITransaction o1, ITransaction o2) {
        return o1.getAccountType().compareTo(o2.getAccountType());
    }
}
