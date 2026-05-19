public class AttendanceBook {

    String[] names = new String[30];
    boolean[] attended = new boolean[30];
    int studentCount = 0;

    public void addStudent(String name) {
        names[studentCount] = name;
        attended[studentCount] = false;
        studentCount++;
    }

    public void checkAttendance(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (names[i] == name) {
                attended[i] = true;
                System.out.println(name + " 출석 완료");
            }
        }
        System.out.println(name + " 는 명단에 없습니다");
    }

    public void printAttendance() {
        int 출석수 = 0;
        System.out.println("== 출석부 ==");
        for (int i = 0; i < studentCount; i++) {
            if (attended[i] = true) {
                System.out.println(names[i] + ": 출석");
                출석수++;
            } else {
                System.out.println(names[i] + ": 결석");
            }
        }
        System.out.println("출석: " + 출석수 + "명 / 전체: " + studentCount + "명");
    }

    public double getAttendanceRate() {
        int 출석수 = 0;
        for (int i = 0; i < studentCount; i++) {
            if (attended[i] == true) {
                출석수++;
            }
        }
        return 출석수 / studentCount * 100;
    }

    public static void main(String[] args) {
        AttendanceBook book = new AttendanceBook();

        book.addStudent("홍길동");
        book.addStudent("김철수");
        book.addStudent("이영희");
        book.addStudent("박민준");

        book.checkAttendance("홍길동");
        book.checkAttendance("이영희");

        book.printAttendance();

        System.out.println("출석률: " + book.getAttendanceRate() + "%");
    }
}
