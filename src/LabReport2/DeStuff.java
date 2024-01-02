package LabReport2;

public class DeStuff {


    public String correctErrors(String receivedData) {
        int[] receivedArray = stringToIntArray(receivedData);
        int r = calculateRedundantBits(receivedData.length());

        int[] syndrome = new int[r];
        for (int i = 0; i < r; i++) {
            syndrome[i] = receivedArray[0];
            for (int j = 1; j < receivedArray.length; j++) {
                if (j != Math.pow(2, i)) {
                    syndrome[i] = syndrome[i] ^ receivedArray[j];
                }
            }
        }

        int errorPosition = 0;
        for (int i = 0; i < syndrome.length; i++) {
            errorPosition += (int) (syndrome[i] * Math.pow(2, i));
        }

        if (errorPosition != 0) {
            receivedArray[errorPosition] = receivedArray[errorPosition] ^ 1;
        }

        return removeRedundantBits(receivedArray, r);
    }


    private int[] stringToIntArray(String str) {
        int[] intArray = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            intArray[i] = Character.getNumericValue(str.charAt(i));
        }
        return intArray;
    }

    private int calculateRedundantBits(int length) {
        int r = 0;
        while (Math.pow(2, r) < length) {
            r++;
        }
        return r;
    }

    private String removeRedundantBits(int[] array, int r) {
        StringBuilder correctedData = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (Math.ceil(Math.log(i + 1) / Math.log(2)) == Math.floor(Math.log(i + 1) / Math.log(2))) {
                continue;
            }
            correctedData.append(array[i]);
        }
        return correctedData.toString();
    }
}
