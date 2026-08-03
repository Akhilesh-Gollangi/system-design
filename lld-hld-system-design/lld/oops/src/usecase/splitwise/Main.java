package usecase.splitwise;

import usecase.splitwise.typesofexpenses.EqualsExpense;
import usecase.splitwise.typesofexpenses.ExactAmountExpense;
import usecase.splitwise.typesofexpenses.PercentageExpense;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();

        User akhil = splitwise.createUser("u1","AKHILESH");
        User baji = splitwise.createUser("u2","BAJI");
        User boku = splitwise.createUser("u3","ESHU");
        User pidel = splitwise.createUser("u4","SANDEEP");

        // equal expense
        Group trip1 = splitwise.createGroup("g1","Hackers");
        trip1.addMember(akhil);
        trip1.addMember(baji);
        trip1.addMember(boku);
        trip1.addMember(pidel);

        Expense expense = new EqualsExpense("Weekend",5000,akhil,"e1");
//        expense.calculateSplit() but we cannot do this, we are doing split and we have add to group
        // this calculatesplit, adding it to that group splits
        // this functionalities should be implemented group
        // as user from UI we give amount and userPaid
        // but app has to done the split -> this is done in Group as
        // we add money in group, group has to split so this is funcationlity belongs to group
        trip1.addExpense(expense,List.of(baji,boku,pidel),null);

        Expense bike = new PercentageExpense("Bike",10000,boku,"e1");
        trip1.addExpense(bike,List.of(baji,akhil,pidel),List.of(30.0,40.0,30.0));

        System.out.println("_________________________________________________________________________");

        //percentage expense
        Group trip2 = splitwise.createGroup("g2","GOA");
        trip2.addMember(akhil);
        trip2.addMember(baji);
        trip2.addMember(boku);
        trip2.addMember(pidel);

        Expense goaExpense = new PercentageExpense("GOA",10000,boku,"e1");
        trip2.addExpense(goaExpense,List.of(baji,akhil,pidel),List.of(30.0,40.0,30.0));

        System.out.println("_________________________________________________________________________");

        //exact amount expense
        Group trip3 = new Group("g3","Travelling");
        trip3.addMember(baji);
        trip3.addMember(akhil);
        trip3.addMember(boku);

        Expense travellingExpense = new ExactAmountExpense("travelling charges",2000, baji, "id");

        trip3.addExpense(travellingExpense,List.of(akhil,boku),List.of(200.0,1800.0));


        for (User user:trip1.getMembers()) {
            System.out.println("Name :"+ user.getName()+ " balance " +trip1.getUserBalance(user.getId()));
            System.out.println("Name :"+ user.getName()+ " overall balance " +splitwise.getOverallBalanceofUser(user.getId()));
        }

    }
}
