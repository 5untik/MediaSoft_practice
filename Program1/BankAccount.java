package Program1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private String number;
    
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
        this.number = generateAccountNumber();
    }
    
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    
    public boolean deposit(int amount) {
        if (isBlocked) {
            System.out.println("Счет заблокирован. Операция невозможна.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Сумма пополнения должна быть положительной.");
            return false;
        }
        balance += amount;
        System.out.println("Счет пополнен на " + amount + ". Текущий баланс: " + balance);
        return true;
    }
    
    public boolean withdraw(int amount) {
        if (isBlocked) {
            System.out.println("Счет заблокирован. Операция невозможна.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Сумма снятия должна быть положительной.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Недостаточно средств на счете. Баланс: " + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Со счета снято " + amount + ". Текущий баланс: " + balance);
        return true;
    }
    
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (isBlocked) {
            System.out.println("Ваш счет заблокирован. Операция невозможна.");
            return false;
        }
        if (otherAccount.isBlocked) {
            System.out.println("Счет получателя заблокирован. Операция невозможна.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Сумма перевода должна быть положительной.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Недостаточно средств для перевода. Баланс: " + balance);
            return false;
        }
        
        balance -= amount;
        otherAccount.balance += amount;
        
        System.out.println("Переведено " + amount + " на счет " + otherAccount.number + 
                          ". Ваш баланс: " + balance);
        return true;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "BankAccount{" +
                "номер='" + number + '\'' +
                ", владелец='" + ownerName + '\'' +
                ", баланс=" + balance +
                ", дата открытия=" + openingDate.format(formatter) +
                ", заблокирован=" + (isBlocked ? "Да" : "Нет") +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return Objects.equals(number, that.number) && 
               Objects.equals(ownerName, that.ownerName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(number, ownerName);
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public LocalDateTime getOpeningDate() {
        return openingDate;
    }
    
    public boolean isBlocked() {
        return isBlocked;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
        System.out.println("Счет " + number + (blocked ? " заблокирован" : " разблокирован"));
    }
}