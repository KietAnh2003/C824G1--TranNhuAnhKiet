package ss1_ss11.ss11_stack_queue.count_word;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

    public class CountWord {
        public static void main(String[] args) {
            TreeMap<String, Integer> wordMap = new TreeMap<>();

            Scanner sc = new Scanner(System.in);
            System.out.println("Hãy nhập một chuỗi:");
            String input = sc.nextLine();

            String[] words = input.toLowerCase().split(" ");

            for (String word : words) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word) + 1);
                } else {
                    wordMap.put(word, 1);
                }
            }
            System.out.println("Số lần xuất hiện của các từ trong một chuỗi:");
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

