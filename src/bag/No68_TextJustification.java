package bag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/12/30 13:39
 */
public class No68_TextJustification {
    public static void main(String[] args) {
        No68_TextJustification justification = new No68_TextJustification();
        String[] words = {"acknowledgment", "shall", "be"};
        int maxWidth = 16;
        System.out.println(justification.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        int tempLen = 0,index = 0,wordsLen = 0,spaces = 0;
        while (index < words.length) {
            if ((tempLen + words[index].length()) <= maxWidth){
                tempLen += words[index].length()+1;
                tempList.add(words[index++]);
            }else{
                StringBuilder sb = new StringBuilder();
                wordsLen = tempLen - tempList.size();
                spaces = maxWidth-wordsLen;
                if (tempList.size() == 1) {
                    sb.append(tempList.get(0));
                    for (int i = 0; i < spaces; i++) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                }else if (tempList.size() > 1){
                    int distance = spaces / (tempList.size()-1);
                    int reminder = spaces % (tempList.size()-1);
                    for (int i = 0; i < tempList.size() - 1; i++) {
                        sb.append(tempList.get(i));
                        if (reminder > 0){
                            sb.append(" ");
                            reminder--;
                        }
                        for (int j = 0; j < distance; j++) {
                            sb.append(" ");
                        }

                    }
                    sb.append(tempList.get(tempList.size()-1));
                    ans.add(sb.toString());
                }
                tempList.clear();
                tempLen = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tempList.size()-1; i++) {
            sb.append(tempList.get(i));
            sb.append(" ");
        }
        sb.append(tempList.get(tempList.size()-1));
        for (int i = 0; i < maxWidth - (tempLen - 1); i++) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }
}
