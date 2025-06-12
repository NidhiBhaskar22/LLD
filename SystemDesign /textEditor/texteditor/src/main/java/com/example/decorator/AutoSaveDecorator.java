package com.example.decorator;

import com.example.product.Document;

public class AutoSaveDecorator extends DocumentDecorator {
    public AutoSaveDecorator(Document document) {
        super(document);
    }

    @Override
    public void save() {
        System.out.println("Auto-saving document");
        super.save();
    }
}