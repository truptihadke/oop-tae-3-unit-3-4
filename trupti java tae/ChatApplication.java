/*Chat Application
Create a class ChatApplication. Create threads for sending and
receiving messages. Demonstrate thread lifecycle.
Output: Sending and receiving messages. */

import java.time.LocalTime;
import java.util.*;

// Message class to hold message data
class Message {
    private String sender;
    private String content;
    private LocalTime timestamp;
    
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalTime.now();
    }
    
    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}

// ChatRoom class for managing message exchange
class ChatRoom {
    private Queue<Message> messageQueue = new LinkedList<>();
    private static final int MAX_MESSAGES = 5;
    
    // Send message to chat room (synchronized for thread safety)
    synchronized void sendMessage(Message message) {
        while (messageQueue.size() >= MAX_MESSAGES) {
            try {
                wait(); // Wait if queue is full
            } catch (InterruptedException e) {
                System.out.println("Send interrupted: " + e.getMessage());
            }
        }
        messageQueue.add(message);
        System.out.println("✓ SENT: " + message);
        notifyAll(); // Notify waiting receivers
    }
    
    // Receive message from chat room
    synchronized Message receiveMessage() {
        while (messageQueue.isEmpty()) {
            try {
                wait(); // Wait if no messages
            } catch (InterruptedException e) {
                System.out.println("Receive interrupted: " + e.getMessage());
            }
        }
        Message message = messageQueue.poll();
        notifyAll(); // Notify waiting senders
        return message;
    }
}

// Sender thread class
class Sender extends Thread {
    private ChatRoom chatRoom;
    private String senderName;
    private String[] messages;
    
    public Sender(ChatRoom chatRoom, String senderName, String[] messages) {
        this.chatRoom = chatRoom;
        this.senderName = senderName;
        this.messages = messages;
        setName(senderName); // Set thread name
    }
    
    @Override
    public void run() {
        System.out.println("\n[THREAD LIFECYCLE] " + getName() + " - Thread State: RUNNING");
        
        for (String msg : messages) {
            try {
                Message message = new Message(senderName, msg);
                chatRoom.sendMessage(message);
                Thread.sleep(500); // Simulate processing time
            } catch (InterruptedException e) {
                System.out.println("[THREAD LIFECYCLE] " + getName() + " - Interrupted: " + e.getMessage());
                break;
            }
        }
        
        System.out.println("[THREAD LIFECYCLE] " + getName() + " - Thread State: TERMINATED\n");
    }
}

// Receiver thread class
class Receiver extends Thread {
    private ChatRoom chatRoom;
    private String receiverName;
    private int messageCount;
    
    public Receiver(ChatRoom chatRoom, String receiverName, int messageCount) {
        this.chatRoom = chatRoom;
        this.receiverName = receiverName;
        this.messageCount = messageCount;
        setName(receiverName); // Set thread name
    }
    
    @Override
    public void run() {
        System.out.println("\n[THREAD LIFECYCLE] " + getName() + " - Thread State: RUNNING");
        
        for (int i = 0; i < messageCount; i++) {
            try {
                Message message = chatRoom.receiveMessage();
                System.out.println("✓ RECEIVED by " + receiverName + ": " + message.toString().split(": ")[1]);
                Thread.sleep(800); // Simulate processing time
            } catch (InterruptedException e) {
                System.out.println("[THREAD LIFECYCLE] " + getName() + " - Interrupted: " + e.getMessage());
                break;
            }
        }
        
        System.out.println("[THREAD LIFECYCLE] " + getName() + " - Thread State: TERMINATED\n");
    }
}

// Main ChatApplication class
public class ChatApplication {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     CHAT APPLICATION - THREAD DEMO     ");
        System.out.println("========================================\n");
        
        ChatRoom chatRoom = new ChatRoom();
        
        // Create sender threads with messages
        String[] alice_messages = {"Hello!", "How are you?", "Long time no see!"};
        String[] bob_messages = {"Hi Alice!", "I'm doing great!", "Yes, it's been a while!"};
        
        // Create threads (NEW State)
        System.out.println("[THREAD LIFECYCLE] Creating Sender and Receiver threads...");
        
        Sender aliceSender = new Sender(chatRoom, "Alice", alice_messages);
        Sender bobSender = new Sender(chatRoom, "Bob", bob_messages);
        
        Receiver aliceReceiver = new Receiver(chatRoom, "Alice-Receiver", 3);
        Receiver bobReceiver = new Receiver(chatRoom, "Bob-Receiver", 3);
        
        System.out.println("[THREAD LIFECYCLE] Alice-Sender - State: NEW (created, not started)");
        System.out.println("[THREAD LIFECYCLE] Bob-Sender - State: NEW (created, not started)");
        System.out.println("[THREAD LIFECYCLE] Alice-Receiver - State: NEW (created, not started)");
        System.out.println("[THREAD LIFECYCLE] Bob-Receiver - State: NEW (created, not started)");
        
        // Start threads (RUNNABLE/RUNNING State)
        System.out.println("\n[THREAD LIFECYCLE] Starting all threads...");
        aliceSender.start();
        bobSender.start();
        aliceReceiver.start();
        bobReceiver.start();
        
        // Wait for all threads to complete (TERMINATED State)
        try {
            aliceSender.join();
            bobSender.join();
            aliceReceiver.join();
            bobReceiver.join();
            
            System.out.println("\n========================================");
            System.out.println("   ALL THREADS TERMINATED SUCCESSFULLY   ");
            System.out.println("========================================");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
    }
}

