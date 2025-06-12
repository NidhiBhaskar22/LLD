package com.example.decorator;

import com.example.product.Document;

public class GrammarCheckDecorator extends DocumentDecorator {
    public GrammarCheckDecorator(Document document) {
        super(document);
    }

    @Override
    public void save() {
        System.out.println("Running grammar check before saving");
        super.save();
    }
}