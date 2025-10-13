/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poepart2.MessageSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageTest {
    
    public MessageTest() {
    }

   
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        String expResult = "";
        String result = MessageSystem.generateMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageID = "";
        boolean expResult = false;
        boolean result = MessageSystem.checkMessageID(messageID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cellNumber = "";
        int expResult = 0;
        int result = MessageSystem.checkRecipientCell(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        String message = "";
        String expResult = "";
        String result = MessageSystem.createMessageHash(messageID, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        String messageID = "";
        String message = "";
        String expResult = "";
        String result = MessageSystem.SentMessage(messageID, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        String messageID = "";
        String message = "";
        MessageSystem.storeMessage(messageID, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String expResult = "";
        String result = MessageSystem.printMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = MessageSystem.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessageFlow method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testSendMessageFlow() {
        System.out.println("sendMessageFlow");
        String recipient = "";
        String message = "";
        MessageSystem.sendMessageFlow(recipient, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MessageSystem.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MessageSystem.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
