package com.bezkoder.spring.datajpa.leetcode_revisiono1;

import jakarta.transaction.Transaction;

import java.util.Arrays;
import java.util.List;

public class transation {
    List<Transaction> transactions = Arrays.asList(
            new Transaction("2022-01-01", 100),
            new Transaction("2022-01-01", 200),
            new Transaction("2022-01-02", 300),
            new Transaction("2022-01-02", 400),
            new Transaction("2022-01-03", 500));
    //find the sum of transaction amounts for each day using Java streams
    transactions.streams(s -> Math.sum(s.sum)).toList();


}
