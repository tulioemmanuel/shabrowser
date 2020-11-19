package br.com.tulioemmanuel.browser.datastructures.tree;

import java.util.Iterator;

public class TreeIterator implements Iterator {

    private Tree tree;
    private TreeNode currentTreeNode;
    /* TODO(tulio) - Terminar implemetanção */
    TreeIterator(Tree tree) {
        this.tree = tree;
        this.currentTreeNode = this.tree.rootNode;
    }

    @Override
    public boolean hasNext() {
        if (this.currentTreeNode.children.size() == 0)
            return false;
        else 
            return true;
    }

    @Override
    public Object next() {
        
        return null;
    }

}
