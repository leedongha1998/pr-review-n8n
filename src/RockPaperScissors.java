import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int 내점수 = 0;
        int 컴퓨터점수 = 0;

        System.out.println("가위바위보 게임 시작!");
        System.out.println("몇 판 할까요?");
        int 판수 = sc.nextInt();

        for (int i = 0; i < 판수; i++) {

            System.out.println((i+1) + "판: 가위, 바위, 보 중에 입력하세요");
            String 입력 = sc.next();

            int 컴퓨터 = r.nextInt(3);
            String 컴퓨터선택 = "";

            if (컴퓨터 == 0) {
                컴퓨터선택 = "가위";
            }
            if (컴퓨터 == 1) {
                컴퓨터선택 = "바위";
            }
            if (컴퓨터 == 2) {
                컴퓨터선택 = "보";
            }

            System.out.println("컴퓨터: " + 컴퓨터선택);

            // 승패 판정
            if (입력 == "가위" && 컴퓨터선택 == "보") {
                System.out.println("이겼다!");
                내점수++;
            }
            if (입력 == "바위" && 컴퓨터선택 == "가위") {
                System.out.println("이겼다!");
                내점수++;
            }
            if (입력 == "보" && 컴퓨터선택 == "바위") {
                System.out.println("이겼다!");
                내점수++;
            }
            if (입력 == 컴퓨터선택) {
                System.out.println("비겼다!");
            }
            if (입력 == "가위" && 컴퓨터선택 == "바위") {
                System.out.println("졌다ㅠ");
                컴퓨터점수++;
            }
            if (입력 == "바위" && 컴퓨터선택 == "보") {
                System.out.println("졌다ㅠ");
                컴퓨터점수++;
            }
            if (입력 == "보" && 컴퓨터선택 == "가위") {
                System.out.println("졌다ㅠ");
                컴퓨터점수++;
            }
        }

        System.out.println("==== 결과 ====");
        System.out.println("나: " + 내점수 + "점");
        System.out.println("컴퓨터: " + 컴퓨터점수 + "점");

        if (내점수 > 컴퓨터점수) {
            System.out.println("최종 승리!!");
        }
        if (내점수 < 컴퓨터점수) {
            System.out.println("최종 패배..");
        }
        if (내점수 == 컴퓨터점수) {
            System.out.println("무승부");
        }
    }
}
