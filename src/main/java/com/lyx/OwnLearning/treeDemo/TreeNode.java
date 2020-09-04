package com.lyx.OwnLearning.treeDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.lyx.utils.FastJsonUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/7/30
 */
public class TreeNode {

    @JSONField(serialize = false)
    private String parentName;

    private String name;

    private List<TreeNode> children;

    public TreeNode(String parentName, String name, List<TreeNode> children) {
        this.name = name;
        this.children = children;
        this.parentName = parentName;
    }

    public TreeNode(String parentName, String name) {
        this.parentName = parentName;
        this.name = name;
        // this.children = new ArrayList<>();
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public static Set<TreeNode> getTreeNode(Set<TreeNode> nodeList) {
        Set<TreeNode> rootTrees = new HashSet<>();
        for (TreeNode tree : nodeList) {
            if (tree.getParentName().equals("root")) {
                rootTrees.add(tree);
            }
            for (TreeNode t : nodeList) {
                if (t.getParentName() != null && t.getParentName().equals(tree.getName())) {
                    if (tree.getChildren() == null) {
                        List<TreeNode> childrenList = new ArrayList<>();
                        childrenList.add(t);
                        tree.setChildren(childrenList);
                    } else {
                        tree.getChildren().add(t);
                    }
                }
            }
        }
        // (TreeNode)rootTrees.toArray()[0];
        return rootTrees;
    }

    public static Set<TreeNode> convert2TreeList(List<String[]> input) {
        Set<TreeNode> nodeList = new HashSet<>();
        for (String[] strArr : input) {
            for (int i = 0; i < strArr.length - 1; i++) {
                if (i == 0) {
                    nodeList.add(new TreeNode("root", strArr[i]));
                }
                nodeList.add(new TreeNode(strArr[i], strArr[i + 1]));
            }
        }
        return nodeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return parentName.equals(treeNode.parentName) &&
                name.equals(treeNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentName, name);
    }

    public static void main(String[] args) {

        /**
         *
         * demo:
         * A1 B1 C1
         * A1 B1 C2
         * A1 B2 C3
         * A1 B2 C4
         * A1 B3 C5
         *
         *  === >
         *              C1
         *      B1
         *              C2
         *
         *              C3
         * A1   B2
         *              C4
         *
         *      B3      C5
         *
         * demo2:
         * String[] words = {"Fuel Consumption High","Trip","Vehicle speed"};
         * String[] words2 = {"Fuel Consumption High","Trip","GVW"};
         */
        Set<TreeNode> nodeList = new HashSet<>();

        nodeList.add(new TreeNode("root", "A1"));

        nodeList.add(new TreeNode("A1", "B1"));
        nodeList.add(new TreeNode("A1", "B2"));
        nodeList.add(new TreeNode("A1", "B3"));

        nodeList.add(new TreeNode("B1", "C1"));
        nodeList.add(new TreeNode("B1", "C2"));

        nodeList.add(new TreeNode("B2", "C3"));
        nodeList.add(new TreeNode("B3", "C4"));

        nodeList.add(new TreeNode("B3", "C4"));

        Set<TreeNode> treeNode = getTreeNode(nodeList);
        TreeNode root = (TreeNode) treeNode.toArray()[0];
        String jsonString = FastJsonUtils.toJSONString(root);
        // String jsonString = JSON.toJSONString(root);
        // System.out.println(jsonString);

        String[] words = {"Fuel Consumption High","Trip","Vehicle speed"};
        String[] words2 = {"Fuel Consumption High","Trip","GVW"};

        List<String[]> input = new ArrayList<>();
        input.add(words);
        input.add(words2);
        Set<TreeNode> treeNodes = convert2TreeList(input);
        Set<TreeNode> roots = getTreeNode(treeNodes);
        TreeNode root2 = (TreeNode) roots.toArray()[0];
        System.out.println(JSON.toJSONString(root2));
    }

}
