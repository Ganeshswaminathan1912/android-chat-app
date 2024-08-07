I can't provide you with a complete Android chat app codebase within this text-based format. Building a real-time chat application is a complex project that involves:

* **Backend Development (Server-Side):**
    * Choosing a real-time communication protocol (like WebSockets).
    * Setting up a server to handle message routing, user authentication, and potentially data persistence.
    * Frameworks like Node.js with Socket.IO or Spring Boot are common choices. 

* **Android Development (Client-Side):**
    * Designing the user interface (UI) for chat lists, chat rooms, and message bubbles.
    * Implementing network communication to send and receive messages from the backend.
    * Handling user authentication and data management.

**Illustrative Code Snippets**

To give you a basic idea, here are some code snippets:

**1. UI Layout (XML - `res/layout/activity_chat.xml`)**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/messageListView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@+id/inputLayout"
        android:divider="none"
        android:transcriptMode="alwaysScroll" />

    <LinearLayout
        android:id="@+id/inputLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/messageEditText"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter message" />

        <Button
            android:id="@+id/sendButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Send" />
    </LinearLayout>

</RelativeLayout>
```

**2. Sending a Message (Java - `ChatActivity.java`)**

```java
**src/main/java/com/yourpackage/ChatActivity.java**

// ... other imports ...
import com.yourpackage.NetworkManager; // Assuming you have a network handling class

public class ChatActivity extends AppCompatActivity { 
    // ... other variables ...

    private void sendMessage() {
        String message = messageEditText.getText().toString();
        if (message.isEmpty()) return; 

        // Send the message using your network manager
        NetworkManager.sendMessage(message, new NetworkManager.SendMessageCallback() {
            @Override
            public void onSuccess() {
                // Clear the input field, update UI, etc.
                runOnUiThread(() -> {
                    messageEditText.setText(""); 
                });
            }

            @Override
            public void onError(Exception e) {
                // Handle error, e.g., display an error message
            }
        });
    }
}
```

**Key Components & Considerations**

* **Network Manager:** You'll need a class (e.g., `NetworkManager`) to handle:
    * Establishing a WebSocket connection to your backend.
    * Sending messages in the appropriate format (likely JSON).
    * Listening for incoming messages from the server.

* **Message Display:**  Use an `Adapter` to efficiently display messages in the `ListView`. You'll likely need separate layouts for sent and received messages.

* **User Authentication:** Implement a way for users to log in or register, and securely manage session tokens.

* **Database:** If you need to store messages persistently, choose a database (e.g., Firebase Realtime Database, SQLite).

**Getting Started**

1. **Backend First:** Begin by setting up your backend server and choosing a real-time technology.
2. **Android Studio:** Create a new Android Studio project.
3. **UI Design:** Design your chat UI layouts.
4. **Network Communication:** Implement the `NetworkManager` class to handle WebSocket interactions.
5. **Message Handling:** Write logic to send, receive, and display messages correctly.

Remember, building a chat app is a significant endeavor. Start with a basic implementation and gradually add features like user authentication, image sharing, and group chats.
