import java.util.ArrayList;

public class Student {

    public String name;
    public int age;
    public ArrayList<Integer> scores;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.scores = new ArrayList<Integer>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public double getAverage() {
        int total = 0;
        for (int i = 0; i < scores.size(); i++) {
            total = total + scores.get(i);
        }
        return total / scores.size(); // 버그: 빈 리스트면 ArithmeticException
    }

    public int getHighestScore() {
        int highest = 0;
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest; // 버그: 점수가 모두 음수면 0 반환
    }

    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("평균 점수: " + getAverage());
    }

    public static void main(String[] args) {
        Student s1 = new Student("홍길동", 20);
        s1.addScore(85);
        s1.addScore(90);
        s1.addScore(78);
        s1.printInfo();

        Student s2 = new Student("김철수", 22);
        s2.printInfo(); // 점수 없이 평균 호출 -> 예외 발생
    }
}
