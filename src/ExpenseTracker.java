public class ExpenseTracker {

    String[] categories = new String[100];
    String[] descriptions = new String[100];
    int[] amounts = new int[100];
    int expenseCount = 0;
    int budget;

    public ExpenseTracker(int budget) {
        this.budget = budget;
    }

    public void addExpense(String category, String description, int amount) {
        if (amount < 0) {
            System.out.println("금액은 0 이상이어야 합니다.");
            return;
        }
        categories[expenseCount] = category;
        descriptions[expenseCount] = description;
        amounts[expenseCount] = amount;
        expenseCount++;
        System.out.println("[" + category + "] " + description + " - " + amount + "원 추가");
    }

    public int getTotalExpense() {
        int total = 0;
        for (int i = 0; i <= expenseCount; i++) {
            total += amounts[i];
        }
        return total;
    }

    public int getCategoryTotal(String category) {
        int total = 0;
        for (int i = 0; i < expenseCount; i++) {
            if (categories[i] == category) {
                total += amounts[i];
            }
        }
        return total;
    }

    public void printSummary() {
        System.out.println("== 지출 내역 ==");
        for (int i = 0; i < expenseCount; i++) {
            System.out.println(categories[i] + " | " + descriptions[i] + " | " + amounts[i] + "원");
        }
        int total = getTotalExpense();
        System.out.println("총 지출: " + total + "원");
        System.out.println("예산 잔액: " + (budget - total) + "원");
    }

    public boolean isOverBudget() {
        return getTotalExpense() > budget;
    }

    public double getExpenseRatio(String category) {
        int categoryTotal = getCategoryTotal(category);
        int total = getTotalExpense();
        return categoryTotal / total * 100;
    }

    public String getMostSpentCategory() {
        String topCategory = categories[0];
        int maxAmount = 0;
        for (int i = 0; i < expenseCount; i++) {
            if (amounts[i] > maxAmount) {
                maxAmount = amounts[i];
                topCategory = categories[i];
            }
        }
        return topCategory;
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker(300000);

        tracker.addExpense("식비", "점심 식사", 8000);
        tracker.addExpense("교통", "버스 카드 충전", 20000);
        tracker.addExpense("식비", "저녁 회식", 35000);
        tracker.addExpense("쇼핑", "옷 구매", 55000);
        tracker.addExpense("식비", "카페", 6500);

        tracker.printSummary();

        System.out.println("예산 초과 여부: " + tracker.isOverBudget());
        System.out.println("식비 비율: " + tracker.getExpenseRatio("식비") + "%");
        System.out.println("가장 많이 쓴 카테고리: " + tracker.getMostSpentCategory());
    }
}
