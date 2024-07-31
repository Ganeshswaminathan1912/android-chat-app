// ... (Inside ChatAppUI composable)

// Listen for new messages
LaunchedEffect(Unit) {
    val messagesRef = database.getReference("messages")
    messagesRef.addChildEventListener(object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val message = snapshot.getValue(Message::class.java)
            message?.let { messages.add(it) }
        }

        // ... (Implement other ChildEventListener methods - onChildChanged, onChildRemoved, etc.)
    })
}uper.onCreate(savedInstanceState)
        setContent {
            ChatAppUI()
        }
    }
}

@Composable
fun ChatAppUI() {
    val database = FirebaseDatabase.getInstance() // Get Firebase instance
    var messageText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Message>() }

    // Fetch messages from Firebase (demonstration only, replace with real-time updates)
    LaunchedEffect(Unit) {
        val messagesRef = database.getReference("messages")
        messagesRef.get().addOnSuccessListener { snapshot ->
            snapshot.children.forEach { childSnapshot ->
                val message = childSnapshot.getValue(Message::class.java)
                message?.let { messages.add(it) }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        // Message List (Implement this Composable to display messages)
        MessageList(messages)

        // Message Input Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Enter message...") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                if (messageText.isNotBlank()) {
                    // Push message to Firebase (replace with your logic)
                    val messageRef = database.getReference("messages").push()
                    messageRef.setValue(Message(text = messageText))
                    messageText = ""
                }
            }) {
                Text("Send")
            }
        }
    }
}

// Composable for displaying the list of messages
@Composable
fun MessageList(messages: List<Message>) {
    // Implement how messages should be displayed (e.g., using LazyColumn)
}