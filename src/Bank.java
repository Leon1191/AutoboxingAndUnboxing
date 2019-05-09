import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branch = new ArrayList<Branch>();

    public ArrayList<Branch> getBranch() {
        return branch;
    }

    public void addBranch(String name) {
        this.branch.add(new Branch(name));
    }

    public void addCustomer(String nameOfBranch, String nameOfCustomer, double firstTransaction) {
        if (findIndexOfBrahch(nameOfBranch) < 0) {
            System.out.println("Customer didn't make");
        } else {
            branch.get(findIndexOfBrahch(nameOfBranch)).addCustomer(nameOfCustomer, firstTransaction);
        }
    }

    public void addTransactionForCustomer(String nameOfBranch, String nameOfCustomer, double transaction) {

        if (findIndexOfBrahch(nameOfBranch) < 0) {
            System.out.println("Transaction didn't make");
        } else {
            branch.get(findIndexOfBrahch(nameOfBranch)).addTransactionForCustomer(nameOfCustomer, transaction);
        }
    }

    public int findIndexOfBrahch(String nameOfBranch) {
        for (int i = 0; i < branch.size(); i++) {
            if (getBranch().get(i).getName().equals(nameOfBranch)) {
                return i;
            }
        }
        System.out.println("This branch isn't exist");
        return -1;
    }
    public void showListOfBranches(){
        System.out.println("Bank have that branches:");
        for(int i = 0; i < branch.size(); i++){
            System.out.println(branch.get(i).getName());
        }
    }
    public void showListOfCustomers(String nameOfBranch, boolean needToShowHisTransactions){
        if (findIndexOfBrahch(nameOfBranch) < 0){
            System.out.println("List of customers isn't exist");
        }
        else{
            branch.get(findIndexOfBrahch(nameOfBranch)).showListOfCustomers(needToShowHisTransactions);
        }
    }
}
 class Branch {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();
    private ArrayList<Customer> customer = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
    }

    public void addTransaction(double transaction) {
        this.transactions.add(Double.valueOf(transaction));
    }

    public void addCustomer(String name, double firstTransaction) {
        this.customer.add(new Customer(name, firstTransaction));
    }

    public void addTransactionForCustomer(String nameOfCustomer, double transaction) {

        if (findIndexOfCustomer(nameOfCustomer) < 0) {
            System.out.println("Transaction didn't make");
        } else {
            getCustomer().get(findIndexOfCustomer(nameOfCustomer)).addTransaction(transaction);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public int findIndexOfCustomer(String nameOfCustomer) {
        for (int i = 0; i < customer.size(); i++) {
            if (getCustomer().get(i).getName().equals(nameOfCustomer)) {
                return i;
            }
        }
        System.out.println("This customer isn't exist");
        return -1;
    }

    public void showListOfCustomers(boolean needToShowHisTransactions) {
//        if (needToShowHisTransactions) {
            for (int i = 0; i < customer.size(); i++) {
//                System.out.println(customer.get(i).getName());
//                showListOfCustomerTransactions(customer.get(i).getName());
            }
//        } else {
            for (int i = 0; i < customer.size(); i++) {
                System.out.println(customer.get(i).getName());
                if (needToShowHisTransactions){showListOfCustomerTransactions(customer.get(i).getName());}
            }
//        }
    }

    public void showListOfBranchTransactions() {
        System.out.println("Branch " + name + " have that transactions:");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).doubleValue());
        }

    }


    public void showListOfCustomerTransactions(String nameOfCustomer){
        if(findIndexOfCustomer(nameOfCustomer) < 0){
            System.out.println("List isn't exist");
        }
else{
    customer.get(findIndexOfCustomer(nameOfCustomer)).showListOfTransactions();
}
    }
}

    class Customer {
        private String name;
        private ArrayList<Double> transactions = new ArrayList<Double>();

        public Customer(String name, double firstTransaction) {
            this.name = name;
            this.transactions.add(Double.valueOf(firstTransaction));
        }

        public void addTransaction(double transaction) {
            this.transactions.add(Double.valueOf(transaction));
        }

        public String getName() {
            return name;
        }

        public ArrayList<Double> getTransactions() {
            return transactions;
        }

        public void showListOfTransactions() {
            System.out.println("Customer " + name + " have that transactions:");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(transactions.get(i).doubleValue());
            }
        }
    }
