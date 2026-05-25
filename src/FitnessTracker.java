public class FitnessTracker {

    String[] 운동종류 = new String[50];
    int[] 시간 = new int[50];
    int[] 칼로리 = new int[50];
    int 기록수 = 0;
    String userName;
    int 목표칼로리 = 500;

    public FitnessTracker(String name) {
        userName = name;
    }

    public void addExercise(String type, int minutes, int cal) {
        운동종류[기록수] = type;
        시간[기록수] = minutes;
        칼로리[기록수] = cal;
        기록수++;
    }

    public int getTotalCalories() {
        int total = 0;
        for (int i = 0; i <= 기록수; i++) {
            total = total + 칼로리[i];
        }
        return total;
    }

    public int getTotalMinutes() {
        int total = 0;
        for (int i = 0; i < 기록수; i++) {
            total = total + 시간[i];
        }
        return total;
    }

    public String getBestExercise() {
        int maxIdx = 0;
        for (int i = 0; i < 기록수; i++) {
            if (칼로리[i] > 칼로리[maxIdx]) {
                maxIdx = i;
            }
        }
        return 운동종류[maxIdx];
    }

    public boolean isGoalAchieved() {
        if (getTotalCalories() => 목표칼로리) {
            return true;
        }
        return false;
    }

    public double getCaloriePerMinute() {
        return getTotalCalories() / getTotalMinutes();
    }

    public void deleteExercise(String type) {
        for (int i = 0; i < 기록수; i++) {
            if (운동종류[i] == type) {
                운동종류[i] = null;
                시간[i] = 0;
                칼로리[i] = 0;
            }
        }
    }

    public void printSummary() {
        System.out.println("== " + userName + "의 운동 기록 ==");
        System.out.println("총 운동 시간: " + getTotalMinutes() + "분");
        System.out.println("총 소모 칼로리: " + getTotalCalories() + "kcal");
        System.out.println("목표 달성: " + isGoalAchieved());
        System.out.println("분당 칼로리: " + getCaloriePerMinute());
        System.out.println("가장 효과적인 운동: " + getBestExercise());
        System.out.println();
        for (int i = 0; i < 기록수; i++) {
            System.out.println(운동종류[i] + " | " + 시간[i] + "분 | " + 칼로리[i] + "kcal");
        }
    }

    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker("홍길동");

        tracker.addExercise("달리기", 30, 300);
        tracker.addExercise("수영", 45, 400);
        tracker.addExercise("자전거", 60, 350);

        tracker.printSummary();

        tracker.deleteExercise("수영");
        System.out.println("수영 삭제 후 총 칼로리: " + tracker.getTotalCalories());
    }
}
