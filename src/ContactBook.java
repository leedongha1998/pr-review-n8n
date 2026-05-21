public class ContactBook {

    String[] names = new String[50];
    String[] phones = new String[50];
    String[] emails = new String[50];
    int contactCount = 0;

    public void addContact(String name, String phone, String email) {
        names[contactCount] = name;
        phones[contactCount] = phone;
        emails[contactCount] = email;
        contactCount++;
        System.out.println(name + " 연락처 추가 완료");
    }

    public void searchByName(String name) {
        for (int i = 0; i < contactCount; i++) {
            if (names[i] == name) {
                System.out.println("이름: " + names[i]);
                System.out.println("전화: " + phones[i]);
                System.out.println("이메일: " + emails[i]);
                return;
            }
        }
        System.out.println(name + " 연락처를 찾을 수 없습니다.");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contactCount; i++) {
            if (names[i] == name) {
                for (int j = i; j < contactCount; j++) {
                    names[j] = names[j + 1];
                    phones[j] = phones[j + 1];
                    emails[j] = emails[j + 1];
                }
                contactCount--;
                System.out.println(name + " 연락처 삭제 완료");
                return;
            }
        }
        System.out.println(name + " 연락처를 찾을 수 없습니다.");
    }

    public void updatePhone(String name, String newPhone) {
        for (int i = 0; i < contactCount; i++) {
            if (names[i] == name) {
                phones[i] = newPhone;
                System.out.println(name + " 전화번호 변경 완료: " + newPhone);
            }
        }
        System.out.println(name + " 연락처를 찾을 수 없습니다.");
    }

    public void printAll() {
        if (contactCount = 0) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        }
        System.out.println("== 전체 연락처 (" + contactCount + "명) ==");
        for (int i = 0; i < contactCount; i++) {
            System.out.println((i + 1) + ". " + names[i] + " | " + phones[i] + " | " + emails[i]);
        }
    }

    public boolean isDuplicatePhone(String phone) {
        for (int i = 0; i < contactCount; i++) {
            if (phones[i] == phone) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContactBook book = new ContactBook();

        book.addContact("홍길동", "010-1234-5678", "hong@example.com");
        book.addContact("김철수", "010-9876-5432", "kim@example.com");
        book.addContact("이영희", "010-5555-7777", "lee@example.com");

        book.searchByName("김철수");
        book.updatePhone("홍길동", "010-0000-1111");
        book.deleteContact("이영희");

        book.printAll();

        System.out.println("중복 번호 여부: " + book.isDuplicatePhone("010-1234-5678"));
    }
}
