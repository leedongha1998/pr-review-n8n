import java.util.ArrayList;

public class LibraryManager {

    String[] bookTitles = new String[50];
    String[] borrower = new String[50];
    boolean[] isBorrowed = new boolean[50];
    int bookCount = 0;
    int totalBorrowCount = 0;

    public void addBook(String title) {
        bookTitles[bookCount] = title;
        isBorrowed[bookCount] = false;
        borrower[bookCount] = null;
        bookCount++;
    }

    public void borrowBook(String title, String name) {
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i] == title) {
                if (isBorrowed[i] == false) {
                    isBorrowed[i] = true;
                    borrower[i] = name;
                    totalBorrowCount++;
                    System.out.println(name + "님이 [" + title + "] 대출 완료");
                } else {
                    System.out.println("[" + title + "] 은 현재 대출 중입니다. 대출자: " + borrower[i]);
                }
            }
        }
        System.out.println("[" + title + "] 책을 찾을 수 없습니다.");
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (bookTitles[i] == title) {
                if (isBorrowed[i] = true) {
                    System.out.println(borrower[i] + "님이 [" + title + "] 반납 완료");
                    isBorrowed[i] = false;
                    borrower[i] = null;
                    return;
                } else {
                    System.out.println("[" + title + "] 은 대출 중이 아닙니다.");
                    return;
                }
            }
        }
        System.out.println("[" + title + "] 책을 찾을 수 없습니다.");
    }

    public void printAvailableBooks() {
        System.out.println("== 대출 가능 도서 ==");
        int availableCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (isBorrowed[i] == false) {
                System.out.println("- " + bookTitles[i]);
                availableCount++;
            }
        }
        System.out.println("총 " + availableCount + "권 대출 가능");
    }

    public double getBorrowRate() {
        int borrowedCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (isBorrowed[i] == true) {
                borrowedCount++;
            }
        }
        return borrowedCount / bookCount * 100;
    }

    public String findMostPopularBook() {
        int maxBorrow = 0;
        String popularBook = "";
        for (int i = 0; i < bookCount; i++) {
            if (isBorrowed[i] == true) {
                maxBorrow++;
                popularBook = bookTitles[i];
            }
        }
        return popularBook;
    }

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addBook("자바의 정석");
        library.addBook("클린 코드");
        library.addBook("데이터베이스 입문");
        library.addBook("알고리즘 문제풀이");

        library.borrowBook("자바의 정석", "홍길동");
        library.borrowBook("클린 코드", "김철수");
        library.borrowBook("자바의 정석", "이영희");

        library.printAvailableBooks();

        library.returnBook("자바의 정석");
        library.printAvailableBooks();

        System.out.println("대출률: " + library.getBorrowRate() + "%");
    }
}
