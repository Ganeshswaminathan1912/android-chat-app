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