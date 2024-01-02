package LabReport2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;

        Stuff hammingCode = new Stuff();
        DeStuff deStuff = new DeStuff();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a name: ");
        input = scanner.nextLine();


        System.out.println("Binary Conversion = " + input + " : " + nameToBin(input));
        String hamming = hammingCode.hammingCode(nameToBin(input));
        System.out.println("Stuffed data: " + hamming);
        String output = deStuff.correctErrors(hamming);
        System.out.println("Error checked,No Error Found");
        String finalOutput = binToName(nameToBin(input));
        System.out.println("De Stuffed data : " + output + " \nReceived: "+finalOutput);
    }

    private static String nameToBin(String name) {
        StringBuilder binary = new StringBuilder();

        for (char character : name.toCharArray()) {
            String binaryChar = Integer.toBinaryString(character);
            String formattedBinaryChar = String.format("%8s", binaryChar).replace(' ', '0');
            binary.append(formattedBinaryChar);
        }

        return binary.toString().trim();
    }

    private static String binToName(String binary) {
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 8) {
            String binaryChar = binary.substring(i, i + 8);
            int charCode = Integer.parseInt(binaryChar, 2);
            name.append((char) charCode);
        }
        return name.toString();
    }
}