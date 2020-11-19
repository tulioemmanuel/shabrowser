package br.com.tulioemmanuel.browser.ui;

import javax.swing.JFrame;

import br.com.tulioemmanuel.browser.parse.html.HTMLDomTree;

public class BrowserWindow extends JFrame {

    BrowserUIMainPanel mainPanel;

    public BrowserWindow(HTMLDomTree domTree){
        /* Init JFrame Properties */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(BrowserUIOptions.BROWSER_WINDOW_WIDTH, BrowserUIOptions.BROWSER_WINDOW_HEIGHT);
        /* Init JFrame Events */
        this.addKeyListener(new BrowserUIKeyboardListener(this));
        /* Init JFrame Components */
        this.mainPanel = new BrowserUIMainPanel(domTree);
        this.add(this.mainPanel);
    }

}
