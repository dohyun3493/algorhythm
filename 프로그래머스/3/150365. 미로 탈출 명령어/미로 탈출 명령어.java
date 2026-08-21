import java.util.*;

class Solution {
    int[][] direction = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    char[] dirChar = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int curR = x - 1;
        int curC = y - 1;
        int er = r - 1;
        int ec = c - 1;

        int dist = Math.abs(curR - er) + Math.abs(curC - ec);

        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }

        StringBuilder answer = new StringBuilder();

        while (k > 0) {
            for (int i = 0; i < 4; i++) {
                int nr = curR + direction[i][0];
                int nc = curC + direction[i][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int remainDist = Math.abs(nr - er) + Math.abs(nc - ec);

                if (remainDist <= k - 1) {
                    answer.append(dirChar[i]);
                    curR = nr;
                    curC = nc;
                    k--;
                    break;
                }
            }
        }

        return answer.toString();
    }
}