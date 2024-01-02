package LabReport2;

class Stuff {

    public String hammingCode(String bin) {
        int M = bin.length();
        int r = 1;

        while (Math.pow(2, r) < (M + r + 1)) {
            r++;
        }
        int[] ar = generateCode(bin, M, r);

        return getString(calculation(ar, r));
    }


    static String getString(int[] ar) {
        StringBuilder ham = new StringBuilder();
        for (int i = 1; i < ar.length; i++) {
            ham.append(ar[i]);
        }
        return ham.toString();
    }

    static int[] calculation(int[] ar, int r) {
        for (int i = 0; i < r; i++) {
            int x = (int) Math.pow(2, i);
            for (int j = 1; j < ar.length; j++) {
                if (((j >> i) & 1) == 1) {
                    if (x != j) ar[x] = ar[x] ^ ar[j];
                }
            }
        }
        return ar;
    }

    static int[] generateCode(String str, int M, int r) {
        int[] ar = new int[r + M + 1];
        int j = 0;
        for (int i = 1; i < ar.length; i++) {
            double a = Math.log(i) / Math.log(2);
            if ((Math.ceil(a) - Math.floor(a)) == 0) {
                ar[i] = 0;
            } else {

                ar[i] = str.charAt(j) - '0';
                j++;
            }
        }
        return ar;
    }
}
