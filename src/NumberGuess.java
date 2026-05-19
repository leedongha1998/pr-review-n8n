import java.util.Scanner;

public class NumberGuess {

    static int answer;
    static int tryCount = 0;
    static int maxTry = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        answer = (int)(Math.random() * 100); // 0~99 (100 포함 안됨)

        System.out.println("1부터 100 사이 숫자를 맞춰보세요!");

        while (true) {

            System.out.print("숫자 입력: ");
            int guess = sc.nextInt();
            tryCount++;

            if (guess == answer) {
                System.out.println("정답!! " + tryCount + "번만에 맞췄습니다");
                break;
            }

            if (guess > answer) {
                System.out.println("너무 큽니다");
            }

            if (guess < answer) {
                System.out.println("너무 작습니다");
            }

            if (tryCount == maxTry) {
                System.out.println("기회를 모두 사용했습니다. 정답은 " + answer);
                break;
            }

            System.out.println("남은 기회: " + (maxTry - tryCount) + "번");
        }

        // 점수 계산
        int score = 100 - (tryCount * 10);
        System.out.println("점수: " + score + "점"); // tryCount 10이면 0점, 11이면 -10점

        if (score >= 90) {
            System.out.println("등급: S");
        }
        if (score >= 70) {
            System.out.println("등급: A");
        }
        if (score >= 50) {
            System.out.println("등급: B");
        }
        if (score < 50) {
            System.out.println("등급: C");
        }
    }
}
