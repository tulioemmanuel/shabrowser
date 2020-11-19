package br.com.tulioemmanuel.browser.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class BrowserUIKeyboardListener implements KeyListener {

    BrowserWindow browserWindow;

    BrowserUIKeyboardListener(BrowserWindow browserWindow){
        this.browserWindow = browserWindow;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.browserWindow.dispatchEvent(new WindowEvent(this.browserWindow,WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    
}
