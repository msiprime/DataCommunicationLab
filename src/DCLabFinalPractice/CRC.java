package DCLabFinalPractice;

import java.util.Scanner;

public class CRC {
    public static void main(String[] args) {
//parity checking
        // 1011101  = parity 1
        // 11011101 ...
        String newResult;

        Scanner sc = new Scanner(System.in);
        String result;
        String input = sc.nextLine();
        // input[0] = 1
        // input[1] = 0
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println("count = " + count);
        if (count % 2 == 0) {
            System.out.println("Even 1s, so parity bit: 0");
            result = "0" + input;
        } else {
            System.out.println("Odd 1s, so parity bit: 1");
            result = "1".concat(input);
        }
        System.out.printf(result);
        newResult = result;
        count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println("count = " + count);
        if (count % 2 == 1) {
            System.out.println("even parity added");
            newResult = result.replaceFirst(String.valueOf(result.charAt(0)), "");
        }

        System.out.println(newResult);

    }
}
