package DCLabFinalPractice;

import java.util.Scanner;

public class IpCovert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an IP Address: ");
        String ip = scanner.nextLine();
        String[] octets = ip.split("\\.");
        for (
                String octet : octets) {
            int decimal = Integer.parseInt(octet);
            String binary = Integer.toBinaryString(decimal);
            System.out.println(binary);
        }
        scanner.close();
    }

}


