package com.example.decorator;

import com.example.product.Document;

public class SpellCheckDecorator extends DocumentDecorator {
    public SpellCheckDecorator(Document document) {
        super(document);
    }

    @Override
    public void save() {
        System.out.println("Running spell check before saving");
        super.save();
    }
}