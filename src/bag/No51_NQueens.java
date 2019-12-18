package bag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/12/17 16:55
 */
public class No51_NQueens {
    public static void main(String[] args) {
        No51_NQueens queens = new No51_NQueens();
        System.out.println(queens.solveNQueens(4).toString());
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] chs = new char[n][n];
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chs[i][j] = '.';
            }
        }
        solve(list,chs,new ArrayList<>(),1);
        return list;
    }
    public void solve(List<List<String>>list,char[][] chs,List<Integer> indice,int cnt){
        if (indice.size() == chs.length||cnt==chs.length-1||cnt==0) {
            return;
        }else{
            if (indice.size()==0){
                indice.add(cnt);
                chs[cnt-1][cnt] = 'Q';
            }else{
                List<String> tmp = new ArrayList<>();
                for (int i = 0; i < chs.length; i++) {
                    for (int j = 0; j < chs[i].length; j++) {
                        if ((i==0&&j==0)||(i==0&&j==chs.length-1)
                                ||(j==0&&i==chs.length-1)||(i==chs.length-1&&j==chs.length-1)){
                            continue;
                        }
                        if (indice.size()-1>=i&&indice.get(i)!=j){
                            indice.add(j);
                            chs[i][j] = 'Q';
                        }
                    }
                    tmp.add(String.valueOf(chs[i]));
                }
                list.add(tmp);
                indice = new ArrayList<>();
                cnt++;
            }
        }
        solve(list,chs,indice,cnt);
    }
}
