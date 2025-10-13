package com.mycompany.poepart2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageSystem {
    private String id;
    private String recipentNumber;
    private String content;
    private String messageHash;
    private String status;
    private static int totalMessages = 0;
    private static List<String> sentMessages = new ArrayList<>();
    private static HashMap<String, String> storedMessages = new HashMap<>();

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
            System.out.println("Please enter a message of less than 50 characters.");
            return;
        }

        String hash = createMessageHash(messageID, message);
        System.out.println("Generated Message Hash: " + hash);
        System.out.println(SentMessage(messageID, message));
    }

    public static void main(String[] args) {
        sendMessageFlow("0821234567", "Hi there, thanks!");
        System.out.println("Total messages sent: " + returnTotalMessages());
        System.out.println("Sent messages:\n" + printMessages());
    }
}

    

