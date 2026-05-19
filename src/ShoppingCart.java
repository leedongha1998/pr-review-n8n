public class ShoppingCart {

    static String[] itemName = new String[10];
    static int[] itemPrice = new int[10];
    static int[] itemCount = new int[10];
    static int total = 0;
    static int size = 0;

    public static void addItem(String name, int price, int count) {
        itemName[size] = name;
        itemPrice[size] = price;
        itemCount[size] = count;
        size++;
        System.out.println(name + " 추가완료");
    }

    public static void removeItem(String name) {
        for (int i = 0; i < size; i++) {
            if (itemName[i] == name) {
                itemName[i] = null;
                itemPrice[i] = 0;
                itemCount[i] = 0;
                System.out.println(name + " 삭제완료");
            }
        }
    }

    public static void showCart() {
        System.out.println("====장바구니====");
        for (int i = 0; i < size; i++) {
            System.out.println(itemName[i] + " / " + itemPrice[i] + "원 / " + itemCount[i] + "개");
        }
    }

    public static void checkout() {
        total = 0;
        for (int i = 0; i < size; i++) {
            total = total + (itemPrice[i] * itemCount[i]);
        }

        System.out.println("총 금액: " + total + "원");

        if (total >= 50000) {
            int discount = total / 10;
            System.out.println("5만원 이상 10% 할인! -" + discount + "원");
            total = total - discount;
        }
        if (total >= 100000) {
            int discount2 = total / 5;
            System.out.println("10만원 이상 추가 20% 할인! -" + discount2 + "원");
            total = total - discount2;
        }

        System.out.println("최종 결제금액: " + total + "원");
    }

    public static void main(String[] args) {
        addItem("사과", 1500, 3);
        addItem("우유", 2800, 2);
        addItem("과자", 1200, 5);
        addItem("라면", 800, 10);

        showCart();

        removeItem("우유");

        showCart(); // null 항목 그대로 출력됨

        checkout();

        // 상품 11개 추가하면 배열 초과 오류
        addItem("a", 100, 1);
        addItem("b", 100, 1);
        addItem("c", 100, 1);
        addItem("d", 100, 1);
        addItem("e", 100, 1);
        addItem("f", 100, 1);
        addItem("g", 100, 1);
    }
}
