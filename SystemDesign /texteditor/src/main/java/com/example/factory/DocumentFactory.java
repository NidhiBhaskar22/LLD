package com.example.factory;

import com.example.product.Document;
import com.example.product.PDFDocument;
import com.example.product.WordDocument;
import com.example.product.TextDocument;
import com.example.product.MarkdownDocument;

public interface DocumentFactory {
    default Document createDocument(String type) {
        return switch(type.toLowerCase()){
            case "pdf" -> new PDFDocument();
            case "word" -> new WordDocument();
            case "text" -> new TextDocument();
            case "markdown" -> new MarkdownDocument();
            default -> throw new IllegalArgumentException("Unknown document type: " + type);
        };
    }
    
}
 