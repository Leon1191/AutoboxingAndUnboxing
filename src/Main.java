public class Main {

    public static void main(String[] args) {
        Bank alfaBank = new Bank();
        alfaBank.addBranch("office#1");
        alfaBank.addBranch("office#2");
        alfaBank.addBranch("office#3");
        alfaBank.getBranch().get(1).addTransaction(11.1);
        alfaBank.addCustomer("office#1","VASYA",25.3);
        alfaBank.addCustomer("office#1","VASYA1",25.3);
        alfaBank.addCustomer("office#1", "VASYA2", 25.3);
        alfaBank.addCustomer("office#1","VASYA3",25.3);
        alfaBank.addTransactionForCustomer("office#1","VASYA",24.3);


//        System.out.println(alfaBank.getBranch().get(0).getCustomer().get(0).getTransactions());
//        System.out.println(alfaBank.getBranch().get(1).getTransactions().get(0).doubleValue());
//        System.out.println(alfaBank.getBranch());

//        alfaBank.getBranch().get(1).showListOfBranchTransactions();
//        alfaBank.getBranch().get(0).showListOfCustomerTransactions("VASYA");
//        alfaBank.showListOfBranches();
        alfaBank.showListOfCustomers("office#1",false);

    }
}
