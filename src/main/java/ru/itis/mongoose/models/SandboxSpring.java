package ru.itis.mongoose.models;

public class SandboxSpring {
    private String _id;
    private String htmlCode;
    private String jsCode;
    private String cssCode;

    public SandboxSpring(String _id, String htmlCode, String jsCode, String cssCode) {
        this(htmlCode, jsCode, cssCode);
        this._id = _id;
    }

    public SandboxSpring(String htmlCode, String jsCode, String cssCode) {
        this.htmlCode = htmlCode;
        this.jsCode = jsCode;
        this.cssCode = cssCode;
    }

    public SandboxSpring() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public String getCssCode() {
        return cssCode;
    }

    public void setCssCode(String cssCode) {
        this.cssCode = cssCode;
    }
}
