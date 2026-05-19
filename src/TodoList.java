public class TodoList {

    static String[] todos = new String[100];
    static int count = 0;

    public static void addTodo(String todo) {
        todos[count] = todo;
        count++;
        System.out.println("추가됨: " + todo);
    }

    public static void removeTodo(int index) {
        todos[index] = null;
        System.out.println(index + "번 삭제됨");
    }

    public static void printAll() {
        System.out.println("== 할일 목록 ==");
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " + todos[i]);
        }
    }

    public static boolean findTodo(String keyword) {
        for (int i = 0; i < count; i++) {
            if (todos[i] == keyword) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        addTodo("자바 공부하기");
        addTodo("운동하기");
        addTodo("밥먹기");

        printAll(); // null 항목도 전부 출력됨

        removeTodo(1);
        printAll();

        System.out.println(findTodo("자바 공부하기")); // false 출력 (== 버그)

        // 101개 추가하면 배열 초과
    }
}
