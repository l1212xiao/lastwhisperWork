package com.lyx.OwnLearning.treeDemo;

/**
 * @author lvyunxiao
 * @date 2020/7/30
 */

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrieTree2 {
    class TreeNode {
        public String name;
        public List<TreeNode> children;
        public String parentName;

        public TreeNode() {
        }

        public TreeNode(String name) {
            this.name = name;
            children = Lists.newArrayList();
        }

        public TreeNode(String name, List<TreeNode> children) {
            this.name = name;
            this.children = children;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }
    }

    private TreeNode root;

    public TrieTree2() {
        root = new TreeNode();
    }

    public void insert(String[] words) {
        if (words == null || words.length == 0) {
            return;
        }
        TreeNode node = root;
        for (int i = 0; i < words.length; i++) {

        }
    }

    /**
     *
     * demo:
     * A1 B1 C1
     * A1 B1 C2
     * A1 B2 C3
     * A1 B2 C4
     * A1 B3 C5
     *              C1
     *      B1
     *              C2
     *
     *              C3
     * A1   B2
     *              C4
     *
     *      B3      C5
     */
    public TreeNode getRootNode(List<List<String>> lists) {
        TreeNode root = null;
        if (lists.get(0).get(0) != null) {
            root = new TreeNode(lists.get(0).get(0));
        }
        TreeNode cur = root;
        Set<String> set;

        for (int i = 0; i < lists.size(); i++) {
            List<String> fields = lists.get(i);
            for (int j = 1; j < fields.size(); j++) {

            }
        }
        return null;
    }
}

