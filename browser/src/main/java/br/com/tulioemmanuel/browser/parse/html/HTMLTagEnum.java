package br.com.tulioemmanuel.browser.parse.html;

public enum HTMLTagEnum {
    HTML("HTML"),
    BODY("BODY"),
    H1("H1");

    private String tagName;

    HTMLTagEnum(String tagName){
        this.tagName = tagName;
    }

    public String getTagName(){
        return this.tagName;
    }

}
