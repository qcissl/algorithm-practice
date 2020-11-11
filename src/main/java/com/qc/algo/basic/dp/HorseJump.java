package com.qc.algo.basic.dp;

/**
 * description
 *
 * @author qinc 2020/11/11 13:59
 */
public class HorseJump {

    public static int ways(int a, int b, int step) {
        return process(0, 0, step, a, b);
    }

    public static int process(int startX, int startY, int step, int targetX, int targetY) {
        if (startX > 8 || startX < 0 || startY > 9 || startY < 0) {
            return 0;
        }
        if (step == 0) {
            return (startX == targetX && startY == targetY) ? 1 : 0;
        }
        int sum = 0;
        sum += process(startX - 2, startY + 1, step - 1, targetX, targetY);
        sum += process(startX - 2, startY - 1, step - 1, targetX, targetY);
        sum += process(startX - 1, startY + 2, step - 1, targetX, targetY);
        sum += process(startX - 1, startY - 2, step - 1, targetX, targetY);
        sum += process(startX + 2, startY + 1, step - 1, targetX, targetY);
        sum += process(startX + 2, startY - 1, step - 1, targetX, targetY);
        sum += process(startX + 1, startY + 2, step - 1, targetX, targetY);
        sum += process(startX + 1, startY - 2, step - 1, targetX, targetY);
        return sum;
    }

    public static int waysdp(int targetX, int targetY, int step) {
        int[][][] dp = new int[step + 1][9][10];
        dp[0][targetX][targetY] = 1;

        for (int s = 1; s <= step; s++) {
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 10; y++) {
                    dp[s][x][y] = getValue(dp, s - 1, x - 2, y + 1)
                            + getValue(dp, s - 1, x - 2, y - 1)
                            + getValue(dp, s - 1, x - 1, y + 2)
                            + getValue(dp, s - 1, x - 1, y - 2)
                            + getValue(dp, s - 1, x + 2, y + 1)
                            + getValue(dp, s - 1, x + 2, y - 1)
                            + getValue(dp, s - 1, x + 1, y + 2)
                            + getValue(dp, s - 1, x + 1, y - 2);
                }
            }
        }
        return dp[step][0][0];
    }

    private static int getValue(int[][][] dp, int s, int x, int y) {
        if (x > 8 || x < 0 || y > 9 || y < 0) {
            return 0;
        }
        return dp[s][x][y];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(ways(x, y, step));
        System.out.println(waysdp(x, y, step));
    }
}
