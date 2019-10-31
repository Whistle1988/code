package bag;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YoSaukit
 * @date 2019/10/31 16:50
 */
public class No36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    String b = "("+board[i][j]+")";
                    if (!seen.add(b+i)||!seen.add(j+b)||!seen.add(i/3+b+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
