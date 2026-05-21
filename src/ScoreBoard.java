public class ScoreBoard {

    String[] playerNames = new String[20];
    int[] scores = new int[20];
    int playerCount = 0;

    public void addPlayer(String name) {
        playerNames[playerCount] = name;
        scores[playerCount] = 0;
        playerCount++;
    }

    public void addScore(String name, int point) {
        for (int i = 0; i <= playerCount; i++) {
            if (playerNames[i] == name) {
                scores[i] = scores[i] + point;
                System.out.println(name + " 에게 " + point + "점 추가. 현재 점수: " + scores[i]);
                return;
            }
        }
        System.out.println(name + " 선수를 찾을 수 없습니다.");
    }

    public void printRanking() {
        System.out.println("== 점수판 ==");
        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < playerCount - i; j++) {
                if (scores[j] < scores[j + 1]) {
                    int tmpScore = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tmpScore;

                    String tmpName = playerNames[j];
                    playerNames[j] = playerNames[j + 1];
                    playerNames[j + 1] = tmpName;
                }
            }
        }
        for (int i = 0; i < playerCount; i++) {
            System.out.println((i + 1) + "위: " + playerNames[i] + " - " + scores[i] + "점");
        }
    }

    public String getTopPlayer() {
        String top = playerNames[0];
        int maxScore = scores[0];
        for (int i = 0; i < playerCount; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                top = playerNames[i];
            }
        }
        return top;
    }

    public double getAverageScore() {
        int total = 0;
        for (int i = 0; i < playerCount; i++) {
            total = total + scores[i];
        }
        return total / playerCount;
    }

    public void resetScores() {
        for (int i = 0; i < playerCount; i++) {
            scores[i] = 0;
            System.out.println(playerNames[i] + " 점수 초기화");
        }
        System.out.println("모든 점수가 초기화되었습니다.");
    }

    public static void main(String[] args) {
        ScoreBoard board = new ScoreBoard();

        board.addPlayer("홍길동");
        board.addPlayer("김철수");
        board.addPlayer("이영희");
        board.addPlayer("박민준");

        board.addScore("홍길동", 30);
        board.addScore("김철수", 50);
        board.addScore("이영희", 20);
        board.addScore("박민준", 45);
        board.addScore("홍길동", 25);

        board.printRanking();

        System.out.println("1등: " + board.getTopPlayer());
        System.out.println("평균 점수: " + board.getAverageScore() + "점");

        board.resetScores();
    }
}
