package summary;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法（深度优先遍历+状态重置+剪枝）
 *
 * 时间复杂度O(N*N!)
 * 空间复杂度O(N*N!) 递归树深度logN 全排列个数N!
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * @author YoSaukit
 * @date 2020/4/9 15:20
 */
public class BackTrack {
    //  求一个数组可能的全排列
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        //状态
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }

    }

    //括号生成 深度优先遍历+剪枝
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)return list;
        _generateParenthesis("",n,n,list);
        return list;
    }
    private void _generateParenthesis(String str,int left,int right,List<String> list){
        if (left == 0 &&right == 0){
            list.add(str);
            return;
        }
        //剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝）
        if (left > right)return;
        if (left > 0) {
            _generateParenthesis(str+"(",left-1,right,list);
        }
        if (right > 0){
            _generateParenthesis(str+")",left,right-1,list);
        }
    }
    //N皇后问题
    List<List<String>> lists = new ArrayList<>();//返回集合
    List<String> ans = new ArrayList<>();//n皇后的解
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){//......
            sb.append(".");
        }
        //列的大小为n,主对角线和次对角线的大小为2n-1
        queens(n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], sb,0);
        return lists;
    }
    void queens(int n,boolean[] y,boolean[] w,boolean[] wc,StringBuilder sb,int i){
        if(ans.size() == n){//递归结束条件，即n皇后已放置所有的行中
            lists.add(new ArrayList<>(ans));
            return;
        }
        for(int j = 0; j < n; j++){
            //判断当前位置是否可用，即列、主对角线、次对角线是否被使用
            if(y[j] || w[n - 1 - i + j] || wc[i + j]) continue;
            //如果可用，先标记该列、主对角线、次对角线已被使用
            y[j] = true;
            w[n - 1 - i + j] = true;
            wc[i + j] = true;
            ans.add(new StringBuilder(sb).replace(j,j+1,"Q").toString());
            //递归下一行是否可以放置皇后，直到所有皇后都放到对应的位置或者该行无法放置皇后则结束
            queens(n,y,w,wc,sb,i+1);
            //递归完成之后，恢复现场
            ans.remove(i);
            y[j] = false;
            wc[i + j] = false;
            w[n - 1 - i + j] = false;
        }
    }
}
