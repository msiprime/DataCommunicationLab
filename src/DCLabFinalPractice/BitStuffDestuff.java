package DCLabFinalPractice;//package DCLabFinalPractice;
 class BitStuffingDestuffing {
    public static void main(String[] args) {
        String data = "111111011111101111110111111";
        System.out.println("Original data: " + data);

        // Bit stuffing
        StringBuilder stuffedData = new StringBuilder();
        int count = 0;
        for (char bit : data.toCharArray()) {
            stuffedData.append(bit);
            if (bit == '1') {
                count++;
                if (count == 5) {
                    stuffedData.append('0');
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        System.out.println("Stuffed data: " + stuffedData.toString());

        // Bit destuffing
        StringBuilder destuffedData = new StringBuilder();
        count = 0;
        for (char bit : stuffedData.toString().toCharArray()) {
            if (bit == '1') {
                count++;
                destuffedData.append(bit);
                if (count == 5) {
                    // Skip the next '0' if it exists
                    if (stuffedData.length() > count && stuffedData.charAt(count) == '0') {
                        count++;
                    }
                    count = 0;
                }
            } else {
                count = 0;
                destuffedData.append(bit);
            }
        }
        System.out.println("Destuffed data: " + destuffedData.toString());
    }
}
