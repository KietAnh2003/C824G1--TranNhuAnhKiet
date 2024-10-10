package ss1_java;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số cần đọc: ");
        number = sc.nextInt();
        if (number >= 0 && number < 10) {
            switch (number) {
                case 0 -> System.out.println("zero"); // Switch expression có thể thay cho switch case thông thường
                case 1 -> System.out.println("one"); // và bỏ qua break; vì nhánh chỉ thực hiện 1 lần
                case 2 -> System.out.println("two");
                case 3 -> System.out.println("three");
                case 4 -> System.out.println("four");
                case 5 -> System.out.println("five");
                case 6 -> System.out.println("six");
                case 7 -> System.out.println("seven");
                case 8 -> System.out.println("eight");
                case 9 -> System.out.println("nine");
            }
        }else if ( number >= 10 && number < 20){
            switch (number) {
                case 10: System.out.println("ten");break;
                case 11: System.out.println("eleven");break;
                case 12: System.out.println("twelve");break;
                case 13: System.out.println("thirteen");break;
                case 14: System.out.println("fourteen");break;
                case 15: System.out.println("fifteen");break;
                case 16: System.out.println("sixteen");break;
                case 17: System.out.println("seventeen");break;
                case 18: System.out.println("eighteen");break;
                case 19: System.out.println("nineteen");
            }
        }else if ( number >= 20 && number < 100 ){
            int tens = number / 10;
            int ones = number % 10;
            String tensStr = " ";
            String onesStr = " ";

            switch(tens) {
                case 2: tensStr = "twenty"; break;
                case 3: tensStr = "thirty"; break;
                case 4: tensStr = "fourty"; break;
                case 5: tensStr = "fifty"; break;
                case 6: tensStr = "sixty"; break;
                case 7: tensStr = "seventy"; break;
                case 8: tensStr = "eightty"; break;
                case 9: tensStr = "ninety"; break;
            }
            switch(ones) {
                case 0: onesStr = " "; break;
                case 1: onesStr = "one"; break;
                case 2: onesStr = "two"; break;
                case 3: onesStr = "three"; break;
                case 4: onesStr = "four"; break;
                case 5: onesStr = "five"; break;
                case 6: onesStr = "six"; break;
                case 7: onesStr = "seven"; break;
                case 8: onesStr = "eight"; break;
                case 9: onesStr = " nine"; break;
            }
            System.out.println(tensStr + " " + onesStr);
        }else if (number >= 100 && number < 1000 ){
            int hundreds = number / 100;
            int tens = number / 10 % 10;
            int ones = number % 10;
            String hundredsStr = " ";
            String tensStr = " ";
            String onesStr = " ";
            switch (hundreds){
                case 1: hundredsStr = "one hundred"; break;
                case 2: hundredsStr = "two hundred"; break;
                case 3: hundredsStr = "three hundred"; break;
                case 4: hundredsStr = "four hundred"; break;
                case 5: hundredsStr = "five hundred"; break;
                case 6: hundredsStr = "six hundred"; break;
                case 7: hundredsStr = "seven hundred"; break;
                case 8: hundredsStr = "eight hundred"; break;
                case 9: hundredsStr = "nine hundred"; break;
            }
            switch(tens) {
                case 2: tensStr = "twenty"; break;
                case 3: tensStr = "thirty"; break;
                case 4: tensStr = "fourty"; break;
                case 5: tensStr = "fifty"; break;
                case 6: tensStr = "sixty"; break;
                case 7: tensStr = "seventy"; break;
                case 8: tensStr = "eightty"; break;
                case 9: tensStr = "ninety"; break;
            }
            switch(ones) {
                case 0: onesStr = " "; break;
                case 1: onesStr = "one"; break;
                case 2: onesStr = "two"; break;
                case 3: onesStr = "three"; break;
                case 4: onesStr = "four"; break;
                case 5: onesStr = "five"; break;
                case 6: onesStr = "six"; break;
                case 7: onesStr = "seven"; break;
                case 8: onesStr = "eight"; break;
                case 9: onesStr = " nine"; break;
            }
            System.out.println(hundredsStr + " and " + tensStr + " " + onesStr);
        }else {
            System.out.println("Hãy nhập số nguyên từ O đến 999!");
        }
    }
}

