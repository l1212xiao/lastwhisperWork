package com.lyx.lagouLearning.demo11_highIV.lc_336;

import java.util.HashMap;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname SolutionTrie
 * @description SolutionTrie
 * @date 2020/4/14
 */
public class SolutionTrie {

    public List<List<Integer>> palindromePairs(String[] words) {
        return null;
    }

    public class TrieNode {
        boolean isEnd;
        HashMap<Character, TrieNode> children;

        TrieNode(){
            isEnd = false;
            children = new HashMap<>();
        }
    }

}
