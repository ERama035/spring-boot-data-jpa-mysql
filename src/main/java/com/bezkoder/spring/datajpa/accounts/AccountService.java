package com.bezkoder.spring.datajpa.accounts;

import java.util.*;

public class AccountService {

    public List<Account> filterAccount(List<Long> accountIdList, List<Account> accountList) {
        // List<Integer> duplicates = new ArrayList<>();
        Map<Integer, List<Account>> map = new HashMap<>(); // o(n)
        for(int id=0 ; id <accountIdList.size(); id++){
            if(!map.containsKey(id)){
                for(int account =0; account <= accountList.size(); account++ ){
                    map.put(id,accountList);
                }
            }
        }
        return map.get(accountList);
    }

}
