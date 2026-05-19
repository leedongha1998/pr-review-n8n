import java.util.Scanner;

public class GradeCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();

        String grade = "";

        if (score == 100) {
            grade = "A+";
        }
        if (score >= 90) {
            grade = "A";
        }
        if (score >= 80) {
            grade = "B";
        }
        if (score >= 70) {
            grade = "C";
        }
        if (score >= 60) {
            grade = "D";
        }
        if (score < 60) {
            grade = "F";
        }

        System.out.println("학점은 " + grade + " 입니다");

        // 합격 여부
        if (grade == "F") {
            System.out.println("불합격");
        } else {
            System.out.println("합격");
        }
    }
}
