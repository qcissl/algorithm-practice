package com.qc.algo.trainingCamp.kmp;

/**
 * description
 *
 * @author qinc 2020/11/18 13:47
 */
public class KMP {

    public static int indexOf(String original, String match) {
        if (original == null || match == null || match.length() < 1 || original.length() < match.length()) {
            return -1;
        }
        char[] originals = original.toCharArray();
        char[] matches = match.toCharArray();
        int[] next = getNext(matches);

        int oIndex = 0;
        int mIndex = 0;
        while (oIndex < originals.length && mIndex < matches.length) {
            if (originals[oIndex] == matches[mIndex]) {
                oIndex++;
                mIndex++;
            } else if (mIndex == 0) {
                oIndex++;
            } else {
                mIndex = next[mIndex];
            }
        }
        return mIndex == matches.length ? oIndex - mIndex : -1;
    }

    private static int[] getNext(char[] matches) {
        int[] next = new int[matches.length];
        if (matches.length >= 1) {
            next[0] = -1;
        }
        if (matches.length >= 2) {
            next[1] = 0;
        }
        int index = 2;
        int cn = 0;
        while (index < matches.length) {
            if (matches[index - 1] == matches[cn]) {
                next[index++] = ++cn;
            } else if (cn == 0) {
                next[index++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }

    public static void main(String[] args) {
//        String str = getRandomString(10,10);
//        System.out.println(str);
//        System.out.println(Arrays.toString(getNext(str.toCharArray())));
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (indexOf(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }
}
