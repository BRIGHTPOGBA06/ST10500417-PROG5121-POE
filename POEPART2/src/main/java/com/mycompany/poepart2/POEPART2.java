/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class POEPART2 {
    private static int totalMessages = 0;
    private static List<String> sentMessages = new ArrayList<>();
    private static Map<String, String> storedMessages = new HashMap<>();

    // Generates a unique 10-digit message ID
    public static String generateMessageID() {
        return String.format("%010d", new Random().nextInt(1_000_000_000));
    }

    // Checks if message ID is valid (<= 10 characters)
    public static boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    // Checks recipient cell number validity
    public static int checkRecipientCell(String cellNumber) {
        if (cellNumber.length() > 10 || !Character.isDigit(cellNumber.charAt(0)) || cellNumber.charAt(0) >= '5') {
            return -1; // Invalid
        }
        return 1; // Valid
    }

    // Creates a message hash in ALL CAPS
    public static String createMessageHash(String messageID, String message) {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        String hash = messageID.substring(0, 2) + ":" + totalMessages + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // Handles user decision after composing a message
    public static String SentMessage(String messageID, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:\n1. Send Message\n2. Disregard Message\n3. Store Message to send later");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                sentMessages.add(message);
                totalMessages++;
                return "Message sent";
            case 2:
                return "Message disregarded";
            case 3:
                storeMessage(messageID, message);
                return "Message stored";
            default:
                return "Invalid choice";
        }
    }

    // Stores message in a map (simulating JSON storage)
    public static void storeMessage(String messageID, String message) {
        storedMessages.put(messageID, message);
    }

    // Returns all sent messages
    public static String printMessages() {
        return String.join("\n", sentMessages);
    }

    // Returns total number of messages sent
    public static int returnTotalMessages() {
        return totalMessages;
    }

    // Validates and sends a message
    public static void sendMessageFlow(String recipient, String message) {
        String messageID = generateMessageID();

        if (!checkMessageID(messageID)) {
            System.out.println("Invalid Message ID.");
            return;
        }

        if (checkRecipientCell(recipient) == -1) {
            System.out.println("Invalid recipient cell number.");
            return;
        }

        if (message.length() > 250) {
            System.out.println("Please enter a message of less than 250 characters.");
            return;
        }

        String hash = createMessageHash(messageID, message);
        System.out.println("Generated Message Hash: " + hash);
        System.out.println(SentMessage(messageID, message));
    }

    // Main method with while loop and if statement
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSending = true;

        while (continueSending) {
            System.out.println("Enter recipient cell number:");
            String recipient = scanner.nextLine();

            System.out.println("Enter your message:");
            String message = scanner.nextLine();

            sendMessageFlow(recipient, message);

            System.out.println("\nDo you want to send another message? (yes/no):");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("no")) {
                continueSending = false;
                System.out.println("\nExiting message system...");
            } else if (!answer.equals("yes")) {
                System.out.println("Invalid input. Exiting by default.");
                continueSending = false;
            }

            System.out.println();
        }

        System.out.println("Total messages sent: " + returnTotalMessages());
        System.out.println("Sent messages:\n" + printMessages());
    }
}

    

