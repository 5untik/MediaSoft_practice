package Program1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование класса BankAccount ===\n");
        
        BankAccount account1 = new BankAccount("Иван Петров");
        BankAccount account2 = new BankAccount("Мария Сидорова");
        
        System.out.println("Созданы счета:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println();
        
        System.out.println("=== Тестирование пополнения ===");
        account1.deposit(1000);
        account1.deposit(-100); 
        account2.deposit(500);
        System.out.println();
        
        System.out.println("=== Тестирование снятия ===");
        account1.withdraw(200);
        account1.withdraw(2000);
        account2.withdraw(100);
        System.out.println();

        System.out.println("=== Тестирование перевода ===");
        account1.transfer(account2, 300);
        account1.transfer(account2, 1000);
        System.out.println();
        
        System.out.println("=== Состояние счетов после операций ===");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println();
        
        System.out.println("=== Тестирование блокировки ===");
        account1.setBlocked(true);
        account1.deposit(100);
        account1.withdraw(50);
        account2.transfer(account1, 100);
        System.out.println();
        
        account1.setBlocked(false);
        account1.deposit(100);
        System.out.println();
        
        System.out.println("=== Тестирование equals ===");
        BankAccount account3 = new BankAccount("Иван Петров");
        System.out.println("account1.equals(account2): " + account1.equals(account2));
        System.out.println("account1.equals(account3): " + account1.equals(account3));
        System.out.println("account1.equals(account1): " + account1.equals(account1));
        System.out.println();
        
        System.out.println("=== Финальное состояние счетов ===");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}
