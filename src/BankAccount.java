public class BankAccount {

    String owner;
    int money;
    String password;

    public BankAccount(String owner, String password) {
        this.owner = owner;
        this.money = 0;
        this.password = password;
    }

    public void deposit(int amount) {
        money = money + amount;
        System.out.println(amount + "원 입금 완료");
        System.out.println("잔액: " + money);
    }

    public void withdraw(int amount, String pw) {
        if (pw == password) {
            if (money >= amount) {
                money = money - amount;
                System.out.println(amount + "원 출금 완료");
                System.out.println("잔액: " + money);
            } else {
                System.out.println("잔액 부족");
            }
        } else {
            System.out.println("비밀번호 틀림");
        }
    }

    public void transfer(BankAccount to, int amount, String pw) {
        if (pw == password) {
            money = money - amount;
            to.money = to.money + amount;
            System.out.println(to.owner + "님께 " + amount + "원 이체 완료");
        } else {
            System.out.println("비밀번호 틀림");
        }
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("홍길동", "1234");
        BankAccount b = new BankAccount("김철수", "5678");

        a.deposit(100000);
        a.withdraw(30000, "1234");
        a.transfer(b, 20000, "1234");

        System.out.println("홍길동 잔액: " + a.money);
        System.out.println("김철수 잔액: " + b.money);

        // 마이너스 입금해도 됨
        a.deposit(-999999);
        System.out.println("홍길동 최종 잔액: " + a.money);
    }
}
