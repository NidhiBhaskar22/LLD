package com.example.decorator;

import com.example.product.Document;

public abstract class DocumentDecorator extends Document {
    protected Document document;

    public DocumentDecorator(Document document) {
        super(document.getType());
        this.document = document;
    }

    @Override
    public void open() {
        document.open();
    }

    @Override
    public void save() {
        document.save();
    }

    @Override
    public void close() {
        document.close();
    }

    @Override
    public String getContent() {
        return document.getContent();
    }

    @Override
    public void setContent(String content) {
        document.setContent(content);
    }
} 