package com.example.product;

public abstract class Document {
    protected String type;
    protected String content;

    public Document(String type) {
        this.type = type;
        this.content = "";
    }

    public void open() {
        System.out.println("Opening " + type + " document");
    }

    public void save() {
        System.out.println("Saving " + type + " document");
    }

    public void close() {
        System.out.println("Closing " + type + " document");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}