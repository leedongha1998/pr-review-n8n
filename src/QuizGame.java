public class QuizGame {

    String[] questions = new String[20];
    String[] answers = new String[20];
    int[] scores = new int[20];
    int questionCount = 0;
    int currentScore = 0;
    int attemptCount = 0;

    public void addQuestion(String question, String answer, int score) {
        questions[questionCount] = question;
        answers[questionCount] = answer;
        scores[questionCount] = score;
        questionCount++;
    }

    public boolean submitAnswer(int questionIndex, String userAnswer) {
        if (questionIndex < 0 || questionIndex > questionCount) {
            System.out.println("존재하지 않는 문제 번호입니다.");
            return false;
        }
        attemptCount++;
        if (answers[questionIndex] == userAnswer) {
            currentScore += scores[questionIndex];
            System.out.println("정답! +" + scores[questionIndex] + "점");
            return true;
        } else {
            System.out.println("오답. 정답은: " + answers[questionIndex]);
            return false;
        }
    }

    public void printAllQuestions() {
        System.out.println("== 문제 목록 ==");
        for (int i = 0; i <= questionCount; i++) {
            System.out.println((i + 1) + ". [" + scores[i] + "점] " + questions[i]);
        }
    }

    public double getAccuracy() {
        int correctCount = 0;
        for (int i = 0; i < questionCount; i++) {
            if (scores[i] > 0) {
                correctCount++;
            }
        }
        return correctCount / attemptCount * 100;
    }

    public void printResult() {
        System.out.println("== 최종 결과 ==");
        System.out.println("총 점수: " + currentScore + "점");
        System.out.println("시도 횟수: " + attemptCount + "회");
        System.out.println("정답률: " + getAccuracy() + "%");
        if (currentScore >= 80) {
            System.out.println("등급: A");
        } else if (currentScore >= 60) {
            System.out.println("등급: B");
        } else if (currentScore >= 40) {
            System.out.println("등급: C");
        } else {
            System.out.println("등급: F");
        }
    }

    public void resetGame() {
        currentScore = 0;
        attemptCount = 0;
        System.out.println("게임이 초기화되었습니다.");
    }

    public String getHighestScoreQuestion() {
        int maxScore = scores[0];
        String topQuestion = questions[0];
        for (int i = 1; i < questionCount; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                topQuestion = questions[i];
            }
        }
        return topQuestion;
    }

    public static void main(String[] args) {
        QuizGame game = new QuizGame();

        game.addQuestion("자바에서 정수형 기본 타입은?", "int", 10);
        game.addQuestion("객체지향의 4대 특성 중 하나는?", "캡슐화", 20);
        game.addQuestion("배열의 첫 번째 인덱스는?", "0", 10);
        game.addQuestion("자바 프로그램 시작 메서드 이름은?", "main", 30);

        game.printAllQuestions();

        game.submitAnswer(0, "int");
        game.submitAnswer(1, "상속");
        game.submitAnswer(2, "0");
        game.submitAnswer(4, "main");

        game.printResult();
        System.out.println("배점 최고 문제: " + game.getHighestScoreQuestion());
    }
}
