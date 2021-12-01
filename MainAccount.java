import java.util.*;

public class MainAccount {

    // Since order is not important in Account list, datastructe Set is use to create list of account 
    // and most importanly Set is prevent duplicate account created.
    private static Set<Account> listAccount;

    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account();
        Account acc3 = new Account();
        acc1.setId(1);
        acc1.deposit(100.00);

        acc2.setId(2);
        acc2.deposit(100.00);

        listAccount = new HashSet<>();
        
        listAccount.add(acc1);
        listAccount.add(acc2);
        listAccount.add(acc3);

        DevAccount dev = new DevAccount();
        //Transfer to Acc 1
        dev.transfToOtherAcc(1, 200.00);

        
        System.out.println("acc1 balance " + acc1.balance);

        System.out.println("acc2 balance " + acc2.balance);

        System.out.println("acc3 balance " + acc3.balance);

        // Withdraw Acc 1

        acc1.withdraw(50.00);
        System.out.println("acc1 balance after withdraw " + acc1.balance);

    }

    public static Set<Account> getListAccount() {
        return listAccount;
    }
}

class Account {
    protected Integer id;
    protected String name;
    protected Double balance = 0.0;

    public void deposit(Double amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(Double amount) {
        this.balance = this.balance - amount;
    }

    public void setId(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Account [balance=" + balance + ", id=" + id + ", name=" + name + "]";
    }

}

class DevAccount extends Account {

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void transfToOtherAcc(Integer id, Double ammount) {
        for (Account acc : MainAccount.getListAccount()) {
            if (acc.getId() == id) {
                acc.deposit(ammount);
            } 
        }
    }
}
