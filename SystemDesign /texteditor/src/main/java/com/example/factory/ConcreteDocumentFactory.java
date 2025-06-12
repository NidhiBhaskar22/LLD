package com.example.factory;

import com.example.product.Document;

public class ConcreteDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument(String type) {
        return DocumentFactory.super.createDocument(type);
    }

}

