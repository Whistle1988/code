package targetOffer;

/**
 * @author YoSaukit
 * @date 2020/3/13 17:58
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;
        if (target<array[0][0]||target>array[row-1][col-1])return false;
        for (int i = 0; i < row; i++) {
            if (target>=array[i][0]&&target<=array[i][col-1])
                return binary(target,array[i],0,col-1);
        }
        return false;
    }
    private boolean binary(int target, int[] array, int s, int e){
        if (s>e)return false;
        int mid = (e - s)/2+s;
        if (target==array[mid]){
            return true;
        }else if (target<array[mid])
            return binary(target,array,s,mid);
        else
            return binary(target,array,mid+1,e);
    }
}
