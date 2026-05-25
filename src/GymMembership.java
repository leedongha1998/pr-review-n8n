public class GymMembership {

    String[] memberNames = new String[50];
    String[] memberIds = new String[50];
    int[] remainingDays = new int[50];
    boolean[] isActive = new boolean[50];
    int memberCount = 0;
    int monthlyFee = 50000;

    public void registerMember(String name, String id, int days) {
        memberNames[memberCount] = name;
        memberIds[memberCount] = id;
        remainingDays[memberCount] = days;
        isActive[memberCount] = true;
        memberCount++;
        System.out.println(name + " 회원 등록 완료 (이용 기간: " + days + "일)");
    }

    public void extendMembership(String id, int days) {
        for (int i = 0; i < memberCount; i++) {
            if (memberIds[i] == id) {
                remainingDays[i] = remainingDays[i] + days;
                System.out.println(memberNames[i] + " 회원권 " + days + "일 연장. 남은 기간: " + remainingDays[i] + "일");
                return;
            }
        }
        System.out.println("회원을 찾을 수 없습니다. ID: " + id);
    }

    public void useMembership(String id) {
        for (int i = 0; i < memberCount; i++) {
            if (memberIds[i] == id) {
                if (remainingDays[i] > 0) {
                    remainingDays[i]--;
                    System.out.println(memberNames[i] + " 출입 완료. 남은 기간: " + remainingDays[i] + "일");
                } else {
                    isActive[i] = false;
                    System.out.println(memberNames[i] + " 회원권이 만료되었습니다.");
                }
            }
        }
        System.out.println("회원을 찾을 수 없습니다. ID: " + id);
    }

    public void printAllMembers() {
        System.out.println("== 전체 회원 현황 ==");
        for (int i = 0; i <= memberCount; i++) {
            String status = isActive[i] ? "활성" : "만료";
            System.out.println(memberNames[i] + " | ID: " + memberIds[i]
                    + " | 남은 기간: " + remainingDays[i] + "일"
                    + " | 상태: " + status);
        }
        System.out.println("총 회원 수: " + memberCount);
    }

    public int calculateMonthlyRevenue() {
        int activeCount = 0;
        for (int i = 0; i < memberCount; i++) {
            if (isActive[i] = true) {
                activeCount++;
            }
        }
        return activeCount * monthlyFee;
    }

    public double getActiveRate() {
        int activeCount = 0;
        for (int i = 0; i < memberCount; i++) {
            if (isActive[i]) {
                activeCount++;
            }
        }
        return activeCount / memberCount * 100;
    }

    public static void main(String[] args) {
        GymMembership gym = new GymMembership();

        gym.registerMember("홍길동", "M001", 30);
        gym.registerMember("김철수", "M002", 60);
        gym.registerMember("이영희", "M003", 0);

        gym.useMembership("M001");
        gym.useMembership("M003");
        gym.extendMembership("M002", 30);

        gym.printAllMembers();

        System.out.println("월 예상 수익: " + gym.calculateMonthlyRevenue() + "원");
        System.out.println("활성 회원 비율: " + gym.getActiveRate() + "%");
    }
}
