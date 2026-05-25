public class DeliveryOrder {

    String[] orderIds = new String[30];
    String[] customerNames = new String[30];
    String[] menuItems = new String[30];
    int[] quantities = new int[30];
    int[] prices = new int[30];
    String[] statuses = new String[30];
    int orderCount = 0;

    public void placeOrder(String orderId, String customerName, String menu, int quantity, int price) {
        if (quantity <= 0) {
            System.out.println("수량은 1 이상이어야 합니다.");
            return;
        }
        orderIds[orderCount] = orderId;
        customerNames[orderCount] = customerName;
        menuItems[orderCount] = menu;
        quantities[orderCount] = quantity;
        prices[orderCount] = price;
        statuses[orderCount] = "접수";
        orderCount++;
        System.out.println("[" + orderId + "] " + customerName + "님 주문 완료: "
                + menu + " x" + quantity + " / " + (price * quantity) + "원");
    }

    public void updateStatus(String orderId, String newStatus) {
        for (int i = 0; i < orderCount; i++) {
            if (orderIds[i] == orderId) {
                statuses[i] = newStatus;
                System.out.println("[" + orderId + "] 상태 변경: " + newStatus);
                return;
            }
        }
        System.out.println("주문을 찾을 수 없습니다. ID: " + orderId);
    }

    public void printOrder(String orderId) {
        for (int i = 0; i <= orderCount; i++) {
            if (orderIds[i] == orderId) {
                System.out.println("== 주문 상세 ==");
                System.out.println("주문번호: " + orderIds[i]);
                System.out.println("고객명: " + customerNames[i]);
                System.out.println("메뉴: " + menuItems[i] + " x" + quantities[i]);
                System.out.println("금액: " + (prices[i] * quantities[i]) + "원");
                System.out.println("상태: " + statuses[i]);
                return;
            }
        }
        System.out.println("주문을 찾을 수 없습니다.");
    }

    public void printAllOrders() {
        System.out.println("== 전체 주문 현황 ==");
        for (int i = 0; i < orderCount; i++) {
            System.out.println("[" + orderIds[i] + "] " + customerNames[i]
                    + " | " + menuItems[i] + " x" + quantities[i]
                    + " | " + statuses[i]);
        }
    }

    public int getTotalRevenue() {
        int total = 0;
        for (int i = 0; i < orderCount; i++) {
            if (statuses[i] == "배달완료") {
                total += prices[i] * quantities[i];
            }
        }
        return total;
    }

    public double getCompletionRate() {
        int completedCount = 0;
        for (int i = 0; i < orderCount; i++) {
            if (statuses[i] == "배달완료") {
                completedCount++;
            }
        }
        return completedCount / orderCount * 100;
    }

    public static void main(String[] args) {
        DeliveryOrder delivery = new DeliveryOrder();

        delivery.placeOrder("ORD001", "홍길동", "짜장면", 2, 8000);
        delivery.placeOrder("ORD002", "김철수", "치킨", 1, 20000);
        delivery.placeOrder("ORD003", "이영희", "피자", 1, 25000);
        delivery.placeOrder("ORD004", "박민준", "떡볶이", 0, 7000);

        delivery.updateStatus("ORD001", "조리중");
        delivery.updateStatus("ORD001", "배달중");
        delivery.updateStatus("ORD001", "배달완료");
        delivery.updateStatus("ORD002", "배달완료");

        delivery.printOrder("ORD003");
        delivery.printAllOrders();

        System.out.println("총 매출: " + delivery.getTotalRevenue() + "원");
        System.out.println("완료율: " + delivery.getCompletionRate() + "%");
    }
}
