package bag;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author YoSaukit
 * @date 2019/12/13 11:09
 */
public class No46_Permutations {
    public static void main(String[] args) {
        No46_Permutations permutations = new No46_Permutations();
        int[] nums = {1,2,3};
        permutations.permute(nums);
    }
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        _permute(list, new ArrayList<>(),nums);
//        return list;
//    }
//    public void _permute(List<List<Integer>>list,List<Integer> tmp,int[] nums){
//        if (tmp.size() == nums.length) {
//            list.add(new ArrayList<>(tmp));
//        }else{
//            for (int i = 0; i < nums.length; i++) {
//                if (tmp.contains(nums[i]))continue;
//                tmp.add(nums[i]);
//                _permute(list,tmp,nums);
//                tmp.remove(tmp.size()-1);
//            }
//        }
//    }
    //方法二
//    public List<List<Integer>> permute(int[] nums){
//        List<List<Integer>> ret = new ArrayList<>();
//        dfs(ret,new LinkedHashSet<>(),nums);
//        return ret;
//    }
//    private void dfs(List<List<Integer>> ret, Set<Integer> path,int[] nums){
//        if (path.size() == nums.length){
//            ret.add(new ArrayList<>(path));
//        }
//        for (int num : nums){
//            if (path.add(num)){
//                dfs(ret,path,nums);
//                path.remove(num);
//            }
//        }
//    }

    //方法三
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)return ans;
        _permute(ans,nums,0);
        return ans;
    }
    private void _permute(List<List<Integer>> ans,int[] nums,int index){
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tmp.add(nums[i]);
            }
            ans.add(tmp);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums,i,index);
            _permute(ans,nums,index+1);
            swap(nums,i,index);
        }

    }
    private void swap(int[] nums,int i,int j){
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }










}
