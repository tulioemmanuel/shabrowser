package br.com.tulioemmanuel.browser.html;

import java.util.List;

public abstract class HTMLElement {
    public String tagName;
    public String textContent;
    public List<HTMLElement> children;
    public Integer offsetX = 0;
    public Integer offsetY = 0;
}
