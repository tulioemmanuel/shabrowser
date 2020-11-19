package br.com.tulioemmanuel.browser;

import java.io.File;
import java.nio.file.Path;
import java.util.Stack;

import javax.swing.JFrame;

import br.com.tulioemmanuel.browser.parse.html.HTMLDomTree;
import br.com.tulioemmanuel.browser.parse.html.HtmlParser;
import br.com.tulioemmanuel.browser.ui.BrowserWindow;
import br.com.tulioemmanuel.browser.utils.Constants;

public class App {
    public static void main(String[] args) {
        try{
            File htmlFile = new File(Constants.DATA_PATH + "\\index.html");
            Stack<String> htmlStack = HtmlParser.getHTMLStackFromFile(htmlFile);
            HTMLDomTree htmlDomTree = new HTMLDomTree(htmlStack);
            BrowserWindow window = new BrowserWindow(htmlDomTree);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
