package br.com.tulioemmanuel.browser.ui;

import javax.swing.JPanel;

import br.com.tulioemmanuel.browser.datastructures.tree.TreeNode;
import br.com.tulioemmanuel.browser.html.HTMLElement;
import br.com.tulioemmanuel.browser.parse.html.HTMLDomTree;

import java.awt.Graphics;

public class BrowserUIMainPanel extends JPanel {

    HTMLDomTree domTree;

    BrowserUIMainPanel(HTMLDomTree domTree) {
        this.domTree = domTree;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        TreeNode currentNode = domTree.rootNode;
        for (TreeNode node : currentNode.children) {
            if (node.value != null) {
                g.drawRect(((HTMLElement) node.value).offsetX, ((HTMLElement) node.value).offsetY,
                        this.getWidth() - 1, 50);
                g.drawString(node.value.getClass().toGenericString(), ((HTMLElement) node.value).offsetX, ((HTMLElement) node.value).offsetY + 25);
            }
        }
    }

}
