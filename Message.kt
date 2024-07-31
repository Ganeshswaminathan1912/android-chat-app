package com.yourpackage.chatapp

data class Message(
    val senderId: String = "",
    val text: String = "",
    val timestamp: Long = System.currentTimeMillis() // Optional timestamp
)