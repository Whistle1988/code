package bag;

import java.util.*;

/**
 * DBFS
 * @author YoSaukit
 * @date 2019/9/28 15:22
 */
public class No127_WordLadder {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        No127_WordLadder no127_wordLadder = new No127_WordLadder();
        System.out.println(no127_wordLadder.ladderLength(beginWord,endWord,wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        return search(beginSet,endSet,dict,1);

    }
    public int search(Set<String> beginSet,Set<String> endSet,Set<String>dict,int cnt){
        if (beginSet.isEmpty()||endSet.isEmpty()) return 0;
        cnt++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for (String str :
                beginSet) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                for (char j ='a';j<='z';j++){
                    chs[i]= j;
                    String tmp = new String(chs);
                    if (!dict.contains(tmp))continue;
                    if (endSet.contains(tmp))return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size()>endSet.size()?search(endSet,nextSet,dict,cnt):search(nextSet,endSet,dict,cnt);
    }
}
