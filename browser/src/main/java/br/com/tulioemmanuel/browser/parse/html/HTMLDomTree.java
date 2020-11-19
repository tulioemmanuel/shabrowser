package br.com.tulioemmanuel.browser.parse.html;

import java.util.Iterator;
import java.util.Stack;

import br.com.tulioemmanuel.browser.datastructures.tree.Tree;
import br.com.tulioemmanuel.browser.datastructures.tree.TreeNode;
import br.com.tulioemmanuel.browser.html.HTMLBodyElement;
import br.com.tulioemmanuel.browser.html.HTMLElement;
import br.com.tulioemmanuel.browser.html.HTMLRootElement;
import br.com.tulioemmanuel.browser.html.HTMLHeadingElement;

public class HTMLDomTree extends Tree {

    Stack<String> htmlStack;
    Tree htmlDOMTree;

    public HTMLDomTree(Stack<String> parsedHTMLStack) {
        this.htmlStack = parsedHTMLStack;
        this.generateDOMTree();
    }

    private void generateDOMTree() {
        this.htmlDOMTree = new Tree();
        Iterator<String> stackIt = this.htmlStack.iterator();
        while(stackIt.hasNext()){
            if(this.htmlDOMTree.rootNode == null){
                this.rootNode = new TreeNode();
                htmlDOMTree.rootNode = this.rootNode;
                htmlDOMTree.rootNode.value = this.getHTMLElement(stackIt.next());
            }
            else{
                TreeNode treeNode = new TreeNode();
                treeNode.value = this.getHTMLElement(stackIt.next());
                htmlDOMTree.rootNode.children.add(treeNode);
            }
        }
    }

    private HTMLElement getHTMLElement(String tag) {
        // MELHORAR ISSO
        String tagUppercase = tag.toUpperCase();

        if (tagUppercase.equals(HTMLTagEnum.HTML.name())) {
            return new HTMLRootElement();
        } 
        else if (tagUppercase.equals(HTMLTagEnum.BODY.name())) {
            return new HTMLBodyElement();
        }
        else if (tagUppercase.equals(HTMLTagEnum.H1.name())) {
            return new HTMLHeadingElement();
        }
        return null;
    }

}
