package converted_to_java;

import java.util.Arrays;
import java.util.Scanner;

public class BitStuffingAndDeStuffing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int[] originalArray = new int[100];
        Arrays.fill(originalArray, 9);

        System.out.print("Enter bits: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            originalArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
            count++;
        }
        bitDeStuffing(bitStuffing(count, originalArray));
    }

    static int[] bitStuffing(int N, int[] originalArray) {

        int[] stuffedArray = new int[100];
        Arrays.fill(stuffedArray, 9);

        int i, j, k;
        i = 0;
        j = 0;
        int totalCount = 0;
        while (i < N) {

            if (originalArray[i] == 1) {
                totalCount++;
                int count = 1;
                stuffedArray[j] = originalArray[i];

                for (k = i + 1; k < N && originalArray[k] == 1 && count < 5; k++) {
                    j++;
                    stuffedArray[j] = originalArray[k];
                    count++;
                    totalCount++;
                    if (count == 5) {
                        j++;
                        stuffedArray[j] = 0;
                        totalCount++;
                    }
                    i = k;
                }
            } else {
                stuffedArray[j] = originalArray[i];
                totalCount++;
            }
            i++;
            j++;
        }

        int[] arrayToReturn = new int[totalCount];
        System.out.print("Stuffed Array is: ");
        // Print Answer
        for (i = 0; i < j; i++) {
            System.out.printf("%d", stuffedArray[i]);
            arrayToReturn[i] = stuffedArray[i];
        }
        return arrayToReturn;
    }

    static void bitDeStuffing(int[] originalArray) {
        int[] stuffedArray = new int[100];
        int i, j, k;
        i = 0;
        j = 0;

        int count = 1;

        while (i < originalArray.length) {

            if (originalArray[i] == 1) {
                stuffedArray[j] = originalArray[i];
                for (k = i + 1; k < originalArray.length && originalArray[k] == 1 && count < 5; k++) {
                    j++;
                    stuffedArray[j] = originalArray[k];
                    count++;
                    if (count == 5) {
                        k++;
                    }
                    i = k;
                }
            } else {
                stuffedArray[j] = originalArray[i];
            }
            i++;
            j++;
        }

        System.out.print("\nDeStuffed Array is: ");
        for (i = 0; i < j; i++)
            System.out.printf("%d", stuffedArray[i]);
    }
}

