package br.com.tulioemmanuel.browser.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public Object value;
    public List<TreeNode> children;
    public TreeNode(){
        this.children = new ArrayList<TreeNode>();
    }
}
