package ss1;

import java.util.Scanner;

public class doc_so_thanh_chu {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số cần đọc: ");
        number = sc.nextInt();
        if (number >= 0 && number < 10) {
            switch (number) {
                case 0 -> System.out.println("zero"); // Switch expression sử dụng thay cho switch case thông thường
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
            String tensstr = " ";
            String onesstr = " ";

            switch(tens) {
                case 2: tensstr = "twenty"; break;
                case 3: tensstr = "thirty"; break;
                case 4: tensstr = "fourty"; break;
                case 5: tensstr = "fifty"; break;
                case 6: tensstr = "sixty"; break;
                case 7: tensstr = "seventy"; break;
                case 8: tensstr = "eightty"; break;
                case 9: tensstr = "ninety"; break;
            }
            switch(ones) {
                case 0: onesstr = " "; break;
                case 1: onesstr = "one"; break;
                case 2: onesstr = "two"; break;
                case 3: onesstr = "three"; break;
                case 4: onesstr = "four"; break;
                case 5: onesstr = "five"; break;
                case 6: onesstr = "six"; break;
                case 7: onesstr = "seven"; break;
                case 8: onesstr = "eight"; break;
                case 9: onesstr = " nine"; break;
            }
            System.out.println(tensstr + " " + onesstr);
        }else if (number >= 100 && number < 1000 ){
            int hundreds = number / 100;
            int tens = number / 10 % 10;
            int ones = number % 10;
            String hundredsstr = " ";
            String tensstr = " ";
            String onesstr = " ";
            switch (hundreds){
                case 1: hundredsstr = "one hundred"; break;
                case 2: hundredsstr = "two hundred"; break;
                case 3: hundredsstr = "three hundred"; break;
                case 4: hundredsstr = "four hundred"; break;
                case 5: hundredsstr = "five hundred"; break;
                case 6: hundredsstr = "six hundred"; break;
                case 7: hundredsstr = "seven hundred"; break;
                case 8: hundredsstr = "eight hundred"; break;
                case 9: hundredsstr = "nine hundred"; break;
            }
            switch(tens) {
                case 2: tensstr = "twenty"; break;
                case 3: tensstr = "thirty"; break;
                case 4: tensstr = "fourty"; break;
                case 5: tensstr = "fifty"; break;
                case 6: tensstr = "sixty"; break;
                case 7: tensstr = "seventy"; break;
                case 8: tensstr = "eightty"; break;
                case 9: tensstr = "ninety"; break;
            }
            switch(ones) {
                case 0: onesstr = " "; break;
                case 1: onesstr = "one"; break;
                case 2: onesstr = "two"; break;
                case 3: onesstr = "three"; break;
                case 4: onesstr = "four"; break;
                case 5: onesstr = "five"; break;
                case 6: onesstr = "six"; break;
                case 7: onesstr = "seven"; break;
                case 8: onesstr = "eight"; break;
                case 9: onesstr = " nine"; break;
            }
            System.out.println(hundredsstr + " and " + tensstr + " " + onesstr);
        }else {
            System.out.println("Hãy nhập số nguyên từ O đến 999!");
        }
    }
}

