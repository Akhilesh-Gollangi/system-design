package com.usecase.practicesplitwise;

import com.usecase.practicesplitwise.typeofsplits.EqualExpense;
import com.usecase.practicesplitwise.typeofsplits.ExactExpense;
import com.usecase.practicesplitwise.typeofsplits.PercentageExpense;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SplitWise splitWise = new SplitWise();
        User akhil = splitWise.createUser("1","Akhilesh");
        User baji = splitWise.createUser("2","Baji");
        User eshu = splitWise.createUser("3","Eshu");

        Group group1 = splitWise.createGroup("G1","FieldTrip");
        group1.addUser(akhil);
        group1.addUser(baji);
        group1.addUser(eshu);

        Expense expense = new EqualExpense("1","CAB",akhil, 1000);
        group1.addExpense(expense, List.of(baji,eshu),null);
        System.out.println(group1.toString());
        System.out.println(group1.getUserBalance(baji));

        Expense expense2 = new PercentageExpense("2","HOTEL",eshu, 5000);
        group1.addExpense(expense2, List.of(akhil,baji), Arrays.asList(80.0,20.0));
        System.out.println(group1.toString());
        System.out.println(group1.getUserBalance(akhil));


        Expense expense3 = new ExactExpense("3","HOTEL",baji, 1000);
        group1.addExpense(expense3, List.of(akhil,eshu), Arrays.asList(200.0,800.0));
        System.out.println(group1.toString());
        System.out.println(group1.getUserBalance(eshu));





    }
}
