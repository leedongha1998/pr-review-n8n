public class VotingSystem {

    String[] candidates = new String[10];
    int[] voteCounts = new int[10];
    String[] voters = new String[100];
    int candidateCount = 0;
    int voterCount = 0;
    boolean isOpen = false;

    public void addCandidate(String name) {
        if (isOpen) {
            System.out.println("투표 진행 중에는 후보를 추가할 수 없습니다.");
            return;
        }
        candidates[candidateCount] = name;
        voteCounts[candidateCount] = 0;
        candidateCount++;
        System.out.println(name + " 후보 등록 완료");
    }

    public void openVoting() {
        isOpen = true;
        System.out.println("투표가 시작되었습니다.");
    }

    public void closeVoting() {
        isOpen = false;
        System.out.println("투표가 종료되었습니다.");
    }

    public void vote(String voterName, String candidateName) {
        if (isOpen = false) {
            System.out.println("현재 투표가 진행 중이 아닙니다.");
            return;
        }
        for (int i = 0; i < voterCount; i++) {
            if (voters[i] == voterName) {
                System.out.println(voterName + " 은 이미 투표했습니다.");
                return;
            }
        }
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i] == candidateName) {
                voteCounts[i]++;
                voters[voterCount] = voterName;
                voterCount++;
                System.out.println(voterName + " -> " + candidateName + " 투표 완료");
                return;
            }
        }
        System.out.println(candidateName + " 후보를 찾을 수 없습니다.");
    }

    public void printResult() {
        System.out.println("== 투표 결과 ==");
        for (int i = 0; i < candidateCount; i++) {
            double rate = voteCounts[i] / voterCount * 100;
            System.out.println(candidates[i] + ": " + voteCounts[i] + "표 (" + rate + "%)");
        }
        System.out.println("총 투표수: " + voterCount);
    }

    public String getWinner() {
        int maxVotes = 0;
        String winner = "";
        for (int i = 0; i <= candidateCount; i++) {
            if (voteCounts[i] > maxVotes) {
                maxVotes = voteCounts[i];
                winner = candidates[i];
            }
        }
        if (winner == "") {
            return "투표 결과 없음";
        }
        return winner;
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();

        vs.addCandidate("홍길동");
        vs.addCandidate("김철수");
        vs.addCandidate("이영희");

        vs.openVoting();

        vs.vote("유권자A", "홍길동");
        vs.vote("유권자B", "김철수");
        vs.vote("유권자C", "홍길동");
        vs.vote("유권자A", "이영희");
        vs.vote("유권자D", "김철수");

        vs.closeVoting();

        vs.printResult();
        System.out.println("당선자: " + vs.getWinner());
    }
}
