package com.example.app;

import com.example.product.*;
import com.example.factory.*;
import com.example.decorator.*;

import java.util.Scanner;

public class DocumentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = new ConcreteDocumentFactory();

        System.out.println("=== Welcome to the Document Processor ===");

        System.out.println("Choose document type (pdf, word, text, markdown): ");
        String type = scanner.nextLine().trim().toLowerCase();

        Document document = factory.createDocument(type);
        if (document == null) {
            System.out.println("Unsupported document type. Exiting.");
            return;
        }

        System.out.println("\nEnter the content for your " + type + " document:");
        String content = scanner.nextLine();
        document.setContent(content);

        System.out.println("\nChoose enhancements to apply (type numbers separated by space):");
        System.out.println("1. Spell Check");
        System.out.println("2. Grammar Check");
        System.out.println("3. Auto Save");
        System.out.println("4. Version Control");
        System.out.print("Your choices: ");
        String[] choices = scanner.nextLine().split(" ");

        for (String choice : choices) {
            switch (choice.trim()) {
                case "1":
                    document = new SpellCheckDecorator(document);
                    break;
                case "2":
                    document = new GrammarCheckDecorator(document);
                    break;
                case "3":
                    document = new AutoSaveDecorator(document);
                    break;
                case "4":
                    document = new VersionControlDecorator(document);
                    break;
                default:
                    System.out.println("Unknown option: " + choice);
            }
        }

        System.out.println("\n=== Summary ===");
        System.out.println("Document Type: " + document.getType());
        System.out.println("Enhancements Applied: ");
        for (String choice : choices) {
            switch (choice.trim()) {
                case "1":
                    System.out.println("- Spell Check");
                    break;
                case "2":
                    System.out.println("- Grammar Check");
                    break;
                case "3":
                    System.out.println("- Auto Save");
                    break;
                case "4":
                    System.out.println("- Version Control");
                    break;
            }
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Open");
            System.out.println("2. Save");
            System.out.println("3. View Content");
            System.out.println("4. Modify Content");
            System.out.println("5. Close");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    document.open();
                    break;
                case "2":
                    document.save();
                    break;
                case "3":
                    System.out.println("Current Content: " + document.getContent());
                    break;
                case "4":
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    document.setContent(newContent);
                    System.out.println("Content updated.");
                    break;
                case "5":
                    document.close();
                    break;
                case "6":
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
