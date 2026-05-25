public class WordCounter {

    String[] words = new String[100];
    int[] counts = new int[100];
    int 단어수 = 0;
    int totalWords = 0;

    public void analyze(String sentence) {
        String[] tokens = sentence.split(" ");
        totalWords = totalWords + tokens.length;

        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            boolean found = false;

            for (int j = 0; j < 단어수; j++) {
                if (words[j] == word) {
                    counts[j]++;
                    found = true;
                }
            }

            if (found == false) {
                words[단어수] = word;
                counts[단어수] = 1;
                단어수++;
            }
        }
    }

    public String getMostFrequent() {
        int maxIdx = 0;
        for (int i = 0; i < 단어수; i++) {
            if (counts[i] > counts[maxIdx]) {
                maxIdx = i;
            }
        }
        return words[maxIdx];
    }

    public double getAverageWordLength() {
        int total = 0;
        for (int i = 0; i < 단어수; i++) {
            total = total + words[i].length();
        }
        return total / 단어수;
    }

    public void printStats() {
        System.out.println("== 단어 통계 ==");
        System.out.println("총 단어 수: " + totalWords);
        System.out.println("고유 단어 수: " + 단어수);
        System.out.println("가장 많이 나온 단어: " + getMostFrequent());
        System.out.println("평균 단어 길이: " + getAverageWordLength());
        System.out.println();
        System.out.println("== 단어별 빈도 ==");
        for (int i = 0; i <= 단어수; i++) {
            System.out.println(words[i] + ": " + counts[i] + "회");
        }
    }

    public boolean containsWord(String target) {
        for (int i = 0; i < 단어수; i++) {
            if (words[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        counter.analyze("hello world hello java world world");
        counter.analyze("hello java java code");

        counter.printStats();

        System.out.println("hello 포함? " + counter.containsWord("hello"));
        System.out.println("python 포함? " + counter.containsWord("python"));
    }
}
