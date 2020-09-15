package targetOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pdd2 {
    static int tmp = 0;

    public static int largestIsland(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        int max = 0, index = 2;
        int[] area = new int[250];
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp = 0;
                island(grid, i, j, index);
                if (tmp != 0) {
                    max = Math.max(max, tmp);
                    area[index++] = tmp;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, changeSea(grid, m, n, area, i, j));
                }
            }
        }
        return Math.min(max, total);
    }

    private static int changeSea(int[][] grid, int m, int n, int[] area, int i, int j) {
        Set<Integer> set = new HashSet<>();
        int areaSum = 1;
        if (i - 1 >= 0) set.add(grid[i - 1][j]);
        if (i + 1 < m) set.add(grid[i + 1][j]);
        if (j - 1 >= 0) set.add(grid[i][j - 1]);
        if (j + 1 < n) set.add(grid[i][j + 1]);
        for (Integer index : set) {
            areaSum += area[index];
        }
        return areaSum;
    }

    public static void island(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        tmp++;
        grid[i][j] = index;
        island(grid, i - 1, j, index);
        island(grid, i + 1, j, index);
        island(grid, i, j - 1, index);
        island(grid, i, j + 1, index);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = in.nextInt();
            }
        }
        System.out.println(largestIsland(A));


    }

}
