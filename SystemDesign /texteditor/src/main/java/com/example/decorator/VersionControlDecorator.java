package com.example.decorator;

import com.example.product.Document;

public class VersionControlDecorator extends DocumentDecorator {
    public VersionControlDecorator(Document document) {
        super(document);
    }

    @Override
    public void save() {
        System.out.println("Committing changes to version control");
        super.save();
    }
}