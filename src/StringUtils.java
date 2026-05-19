public class StringUtils {

    public static boolean isPalindrome(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i); // 비효율: 문자열 연결 대신 StringBuilder 사용 권장
        }
        return str == reversed; // 버그: == 는 참조 비교, equals() 사용해야 함
    }

    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return count; // 대문자 모음 미처리
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result = result + words[i];
            if (i != 0) {
                result = result + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // false 출력 (버그)
        System.out.println(isPalindrome("hello"));

        System.out.println("모음 개수: " + countVowels("Hello World")); // 대문자 o, e 미포함

        System.out.println(reverseWords("안녕 세상 자바")); // 자바 세상 안녕
    }
}
