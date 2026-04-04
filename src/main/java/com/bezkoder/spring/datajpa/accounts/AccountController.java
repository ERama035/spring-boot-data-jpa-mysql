package com.bezkoder.spring.datajpa.accounts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Account")
public class AccountController {

    @GetMapping("/get/{id}")
    public ResponseEntity<Account> GetAccountDetails( @RequestBody Long id){
        Account accounts = new Account();

        if(id != null) return ResponseEntity.ok(accounts);


        // service layer -- > exception
        // loggers

        return ResponseEntity.ok(accounts);
    }



    @GetMapping("/getData/{ids}")
    public ResponseEntity<Account> getDetails(){
        Account accounts1 = new Account();

        return ResponseEntity.ok(accounts1);
    }

}
